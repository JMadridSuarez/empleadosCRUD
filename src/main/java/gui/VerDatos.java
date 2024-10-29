
package gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import logic.Empleado;
import ux.Celda;
import ux.Encabezado;


public class VerDatos extends javax.swing.JFrame {

    //Empleado empleado = new Empleado();
    public VerDatos() {
        initComponents();
        
        //Aplicando el disenio al encabezado
        JTableHeader encabezado= tablaEmpleados.getTableHeader();
        encabezado.setDefaultRenderer(new Encabezado());
        encabezado.setReorderingAllowed(false);
        tablaEmpleados.setTableHeader(encabezado);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        btnEditarReistro = new javax.swing.JButton();
        btnBorrarRegistro = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        btnEditarReistro.setText("Editar Registro");
        btnEditarReistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarReistroActionPerformed(evt);
            }
        });

        btnBorrarRegistro.setText("Borrar Registro");
        btnBorrarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRegistroActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarReistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnEditarReistro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CargarInfo();
    }//GEN-LAST:event_formWindowOpened

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarReistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarReistroActionPerformed
        
        
        if(tablaEmpleados.getColumnCount() > 0){
            if(tablaEmpleados.getSelectedColumn()!= -1){
                int idFila = Integer.parseInt(String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0)));
                EditarDatos ventanaEditar = new EditarDatos(idFila);
                ventanaEditar.setVisible(true);
                ventanaEditar.setLocationRelativeTo(null);
                
            }else{
              JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");  
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay registros para modificar");
        }
    }//GEN-LAST:event_btnEditarReistroActionPerformed

    private void btnBorrarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRegistroActionPerformed
        Empleado empleado = new Empleado();
        if(tablaEmpleados.getColumnCount() > 0){
            if(tablaEmpleados.getSelectedColumn() != -1){
                int idFila = Integer.parseInt(String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0)));
                empleado.borrarRegistro(idFila);
            }
        }
    }//GEN-LAST:event_btnBorrarRegistroActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarRegistro;
    private javax.swing.JButton btnEditarReistro;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables

    //Este metodo crea el modelo de tabla e inserta los datos
    private void CargarInfo() {
        Empleado empleado = new Empleado();
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        String[] titulos = {"Id", "Nombre", "Apellido", "VentaId"};
        modeloTabla.setColumnIdentifiers(titulos);
        empleado.mostrarRegistros(modeloTabla);
        tablaEmpleados.setModel(modeloTabla);
        
        //Aplicando el disenio a las celdas
        Celda celda = new Celda();
        for(int i = 0; i< tablaEmpleados.getColumnModel().getColumnCount(); i++){
            tablaEmpleados.getColumnModel().getColumn(i).setCellRenderer(celda);
            TableColumn columna = tablaEmpleados.getColumnModel().getColumn(i);
            columna.setResizable(false);
        }
    }
}
