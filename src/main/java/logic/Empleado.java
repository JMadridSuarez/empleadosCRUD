
package logic;

import gui.VerDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistence.Conexion;


public class Empleado {
    //Instancia de la clase Conexion
    Conexion conexion = new Conexion();
    
    int id;
    String nombre;
    String apellido;
    int venta_id;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, int venta_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.venta_id = venta_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }
    
    //Metodo Insertar Registro
    public void crearRegistro(JTextField txtNombre,JTextField txtApellido, JTextField txtVenta){
        setNombre(txtNombre.getText());
        setApellido(txtApellido.getText());
        setVenta_id(Integer.parseInt(String.valueOf(txtVenta.getText())));
        
        String sql = "Insert INTO info_empleados(nombre,apellido,venta_id) VALUES(?,?,?)";
        PreparedStatement pst= null;
        try {
            pst = conexion.establecerConexion().prepareStatement(sql);
            pst.setString(1, getNombre());
            pst.setString(2, getApellido());
            pst.setInt(3, getVenta_id());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Registro ingresado con exito");
            limpiarCampos(txtNombre, txtApellido, txtVenta);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido");
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            conexion.cerrarConexion();
        }
        
    }
    //Metodo Mostrar Registro
    public void mostrarRegistros(DefaultTableModel modeloTabla){
        PreparedStatement pst = null;
        String sql ="SELECT * FROM info_empleados";
        try {
            pst = conexion.establecerConexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int ventaId = rs.getInt("venta_id");
                
                Object[] fila = {id,nombre,apellido,ventaId};
                
                modeloTabla.addRow(fila);
                //rs.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar la informacion");
        } finally {
            
            conexion.cerrarConexion();
            try {
                pst.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    //Metodo Modificar Registro
    public void modificarRegistro(JTextField txtNombre, JTextField txtApellido, JTextField txtVenta, int idFila){
        setNombre(txtNombre.getText());
        setApellido(txtApellido.getText());
        setVenta_id(Integer.parseInt(txtVenta.getText()));
        
        PreparedStatement pst = null;
        String sql = "UPDATE info_empleados SET nombre = ?, apellido = ?, venta_id = ? WHERE id = ?";
        try {
            pst = conexion.establecerConexion().prepareStatement(sql);
            pst.setString(1, getNombre());
            pst.setString(2, getApellido());
            pst.setInt(3, getVenta_id());
            pst.setInt(4, idFila);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro modificado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        } finally {
            try {
                conexion.cerrarConexion();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    //Metodo Borrar Registro
    public void borrarRegistro(int idFila) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM info_empleados WHERE id = ?";
        
        try {
            pst = conexion.establecerConexion().prepareStatement(sql);
            pst.setInt(1, idFila);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
            VerDatos ver = new VerDatos();
            ver.setVisible(true);
            ver.setLocationRelativeTo(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible elimianr registro");
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.cerrarConexion();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Metodo Limpiar registros
    public void limpiarCampos(JTextField txtNombre,JTextField txtApellido, JTextField txtVenta){
        txtNombre.setText("");
        txtApellido.setText("");
        txtVenta.setText("");
    }

    

    
    
}
