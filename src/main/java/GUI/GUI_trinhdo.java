/*
 * Created by JFormDesigner on Sun Jan 02 21:08:44 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.BLL_trinhdo;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_trinhdo extends JPanel {
    public GUI_trinhdo() {
        initComponents();
        setVisible(true);
        BLL_trinhdo trinhdo = new BLL_trinhdo();
        table1.setModel(trinhdo.getAll_Table(trinhdo.getAll()));
        buttonmanager(trinhdo);
    }

    public void buttonmanager(BLL_trinhdo trinhdo){
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtrinhdo = jtextidtrinhdo.getText();
                String tentrinhdo = jtexttenchungchi.getText();
                if (idtrinhdo.equals("") || tentrinhdo.equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else
                {
                    trinhdo.insert(idtrinhdo,tentrinhdo);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    table1.setModel(trinhdo.getAll_Table(trinhdo.getAll()));
                }
            }
        });

        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtextidtrinhdo.setText("");
                jtexttenchungchi.setText("");
                table1.setModel(trinhdo.getAll_Table(trinhdo.getAll()));
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        label3 = new JLabel();
        jtextidtrinhdo = new JTextField();
        label4 = new JLabel();
        jtexttenchungchi = new JTextField();
        them = new JButton();
        reload = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(938, 708));
        setMaximumSize(new Dimension(938, 708));
        setMinimumSize(new Dimension(938, 708));
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd tr\u00ecnh \u0111\u1ed9");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(51, 51, 51));

        //======== scrollPane1 ========
        {
            scrollPane1.setBackground(Color.white);
            scrollPane1.setViewportView(table1);
        }

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setLayout(new FormLayout(
                "5*(${growing-button}, $lcgap), ${growing-button}",
                "$lgap, $glue, 2*($lgap), $glue, $lgap"));

            //---- label3 ----
            label3.setText("M\u00e3 ID tr\u00ecnh \u0111\u1ed9");
            label3.setForeground(new Color(51, 51, 51));
            label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label3.setLabelFor(jtextidtrinhdo);
            panel1.add(label3, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextidtrinhdo ----
            jtextidtrinhdo.setBackground(new Color(204, 204, 204));
            jtextidtrinhdo.setForeground(Color.black);
            panel1.add(jtextidtrinhdo, CC.xywh(3, 2, 3, 1));

            //---- label4 ----
            label4.setText("T\u00ean ch\u1ee9ng ch\u1ec9");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label4.setLabelFor(jtexttenchungchi);
            panel1.add(label4, new CellConstraints(7, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtexttenchungchi ----
            jtexttenchungchi.setBackground(new Color(204, 204, 204));
            jtexttenchungchi.setForeground(Color.black);
            panel1.add(jtexttenchungchi, CC.xywh(9, 2, 3, 1));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(5, 5));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(7, 5));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label3;
    private JTextField jtextidtrinhdo;
    private JLabel label4;
    private JTextField jtexttenchungchi;
    private JButton them;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
