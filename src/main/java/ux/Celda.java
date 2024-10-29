
package ux;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class Celda extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable tabalEmpleados, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        //Disenio de las celdas
        setHorizontalAlignment(SwingConstants.CENTER);
        return super.getTableCellRendererComponent(tabalEmpleados, value, isSelected, hasFocus, row, column);
    }
    
}
