/*
 * Created by JFormDesigner on Mon Jan 03 03:22:38 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.BLL_cathi;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_cathi extends JPanel {
    public GUI_cathi() {
        initComponents();
        BLL_cathi bll_cathi = new BLL_cathi();
        table1.setModel(bll_cathi.getALL_Table(bll_cathi.getALL()));
        buttonmanager(bll_cathi);
    }

    public void buttonmanager(BLL_cathi bll_cathi){
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(bll_cathi.getALL_Table(bll_cathi.getALL()));
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idcathi = jtextidcathi.getText();
                String giothi = jtextgiothi.getText();
                if (idcathi.equals("") || giothi.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else if (!bll_cathi.checkID(idcathi)) {
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại");
                }
                else {
                    bll_cathi.insert(idcathi, giothi);
                    table1.setModel(bll_cathi.getALL_Table(bll_cathi.getALL()));
                    jtextgiothi.setText("");
                    jtextidcathi.setText("");
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            }
        });

        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idcathi = jtextidcathi.getText();
                String giothi = jtextgiothi.getText();
                if (idcathi.equals("") || giothi.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else if (bll_cathi.checkID(idcathi)) {
                    JOptionPane.showMessageDialog(null, "ID không tồn tại");
                }
                else {
                    bll_cathi.update(idcathi, giothi);
                    table1.setModel(bll_cathi.getALL_Table(bll_cathi.getALL()));
                    jtextgiothi.setText("");
                    jtextidcathi.setText("");
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
            }
        });

        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idcathi = jtextidcathi.getText();
                bll_cathi.delete(idcathi);
                table1.setModel(bll_cathi.getALL_Table(bll_cathi.getALL()));
                jtextgiothi.setText("");
                jtextidcathi.setText("");
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        });
        
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = table1.getSelectedRow();
                String idcathi = table1.getValueAt(row, 0).toString();
                String giothi = table1.getValueAt(row, 1).toString();
                jtextidcathi.setText(idcathi);
                jtextgiothi.setText(giothi);
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
        jtextidcathi = new JTextField();
        label4 = new JLabel();
        jtextgiothi = new JTextField();
        them = new JButton();
        sua = new JButton();
        xoa = new JButton();
        reload = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(938, 708));
        setMaximumSize(new Dimension(938, 708));
        setMinimumSize(new Dimension(938, 708));
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd ca thi");
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
            label3.setText("M\u00e3 ID ca thi");
            label3.setForeground(new Color(51, 51, 51));
            label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label3.setLabelFor(jtextidcathi);
            panel1.add(label3, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextidcathi ----
            jtextidcathi.setBackground(new Color(204, 204, 204));
            jtextidcathi.setForeground(Color.black);
            panel1.add(jtextidcathi, CC.xywh(3, 2, 3, 1));

            //---- label4 ----
            label4.setText("Gi\u1edd thi");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label4.setLabelFor(jtextgiothi);
            panel1.add(label4, new CellConstraints(7, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextgiothi ----
            jtextgiothi.setBackground(new Color(204, 204, 204));
            jtextgiothi.setForeground(Color.black);
            panel1.add(jtextgiothi, CC.xywh(9, 2, 3, 1));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(3, 5));

            //---- sua ----
            sua.setText("C\u1eadp nh\u1eadt");
            sua.setForeground(new Color(51, 51, 51));
            panel1.add(sua, CC.xy(5, 5));

            //---- xoa ----
            xoa.setText("X\u00f3a");
            xoa.setForeground(new Color(51, 51, 51));
            panel1.add(xoa, CC.xy(7, 5));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(9, 5));
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
    private JTextField jtextidcathi;
    private JLabel label4;
    private JTextField jtextgiothi;
    private JButton them;
    private JButton sua;
    private JButton xoa;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
