
package ux;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;


public class Encabezado implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent jcomponent = null;
        if(value instanceof String){
            jcomponent = new JLabel((String)value);
            
            //Disenio de el encabezado
            ((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel)jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel)jcomponent).setPreferredSize(new Dimension(6,jcomponent.getWidth()));
            
            jcomponent.setBackground(Color.DARK_GRAY);
            jcomponent.setForeground(Color.WHITE);
            jcomponent.setOpaque(true);
            jcomponent.setBorder(BorderFactory.createMatteBorder(0,0,1,1,new Color(255,255,244)));
        }
        
        return jcomponent;
    }
    
}
