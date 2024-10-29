
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    
    Connection conexion =null;
    //Datos de la db
    String usuario = "root";
    String contrasenia = "";
    String ip = "localhost";
    String db = "empleados";
    int puerto = 3306;
    
    //String de conexion
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+db;
    
    //Metodo para iniciar la conexion a la db
    public Connection establecerConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion fallida");
        }
        return conexion;
    }
    
    //Metodo para cerrar la conexion de la db
    public void cerrarConexion(){
        try {
            if(conexion!=null && !conexion.isClosed()){
                conexion.close();
                //JOptionPane.showMessageDialog(null, "Conexion cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible cerrar la conexion");
        }
    }
}
