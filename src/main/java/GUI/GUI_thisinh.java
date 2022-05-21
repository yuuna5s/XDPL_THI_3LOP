/*
 * Created by JFormDesigner on Sun Jan 02 19:38:25 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.BLL_thisinh;
import BLL.BLL_trinhdo;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_thisinh extends JPanel {
    public GUI_thisinh() {
        initComponents();
        setVisible(true);
        BLL_thisinh bll_thisinh = new BLL_thisinh();
        BLL_trinhdo bll_trinhdo = new BLL_trinhdo();
        table1.setModel(bll_thisinh.getAll_Table(bll_thisinh.getAll()));
        jcombotrinhdo.setModel(bll_trinhdo.getAll_ComboBox());
        buttonmanager(bll_thisinh);
    }

    public void buttonmanager(BLL_thisinh bll_thisinh){
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(bll_thisinh.getAll_Table(bll_thisinh.getAll()));
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String hoten = jtexthoten.getText();
                String diachi = jtextdiachi.getText();
                String sdt = jtextsdt.getText();
                String trinhdo = jcombotrinhdo.getSelectedItem().toString();
                String nextid="";
                for (int i = 0; i < bll_thisinh.getAll().size(); i++) {
                    String currentid = bll_thisinh.getAll().get(i).getIdthisinh();
                    String last4characters = currentid.substring(currentid.length() - 5);
                    int nextidnumber = Integer.parseInt(last4characters)+1;
                    nextid = "TS" + String.format("%05d", nextidnumber);
                }
                String gioitinh="";
                if (nam.isSelected())gioitinh="1";
                else if (nu.isSelected())gioitinh="0";
                if (hoten.equals("") || diachi.equals("") || sdt.equals("") || trinhdo.equals("") || gioitinh.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else {
                    bll_thisinh.them(nextid, hoten, gioitinh, diachi,sdt, trinhdo);
                    table1.setModel(bll_thisinh.getAll_Table(bll_thisinh.getAll()));
                    jtexthoten.setText("");
                    jtextdiachi.setText("");
                    jtextsdt.setText("");
                    jcombotrinhdo.setSelectedIndex(0);
                    nam.setSelected(false);
                    nu.setSelected(true);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            }
        });

        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoten = jtexthoten.getText();
                String diachi = jtextdiachi.getText();
                String sdt = jtextsdt.getText();
                String trinhdo = jcombotrinhdo.getSelectedItem().toString();
                String gioitinh="";
                if (nam.isSelected())gioitinh="1";
                else if (nu.isSelected())gioitinh="0";
                if (hoten.equals("") || diachi.equals("") || sdt.equals("") || trinhdo.equals("") || gioitinh.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else{
                    bll_thisinh.sua(hoten, gioitinh, diachi,sdt, trinhdo);
                    table1.setModel(bll_thisinh.getAll_Table(bll_thisinh.getAll()));
                    jtexthoten.setText("");
                    jtextdiachi.setText("");
                    jtextsdt.setText("");
                    jcombotrinhdo.setSelectedIndex(0);
                    nam.setSelected(false);
                    nu.setSelected(true);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
            }
        });

        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoten = jtexthoten.getText();
                bll_thisinh.xoa(hoten);
                table1.setModel(bll_thisinh.getAll_Table(bll_thisinh.getAll()));
                jtexthoten.setText("");
                jtextdiachi.setText("");
                jtextsdt.setText("");
                jcombotrinhdo.setSelectedIndex(0);
                nam.setSelected(false);
                nu.setSelected(true);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        });

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = table1.getSelectedRow();
                String id = table1.getValueAt(row,0).toString();
                String hoten = table1.getValueAt(row,1).toString();
                String gioitinh = table1.getValueAt(row,2).toString();
                String diachi = table1.getValueAt(row,3).toString();
                String sdt = table1.getValueAt(row,4).toString();
                String trinhdo = table1.getValueAt(row,5).toString();
                jtexthoten.setText(hoten);
                if (gioitinh.equals("1")){
                    nam.setSelected(true);
                    nu.setSelected(false);
                } else {
                    nam.setSelected(false);
                    nu.setSelected(true);
                }
                jtextdiachi.setText(diachi);
                jtextsdt.setText(sdt);
                jcombotrinhdo.setSelectedItem(trinhdo);
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
        label2 = new JLabel();
        jtexthoten = new JTextField();
        label6 = new JLabel();
        label4 = new JLabel();
        nam = new JRadioButton();
        nu = new JRadioButton();
        label5 = new JLabel();
        jtextsdt = new JTextField();
        label3 = new JLabel();
        jtextdiachi = new JTextField();
        jcombotrinhdo = new JComboBox();
        them = new JButton();
        sua = new JButton();
        xoa = new JButton();
        reload = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(938, 708));
        setMaximumSize(new Dimension(938, 708));
        setMinimumSize(new Dimension(938, 708));
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd th\u00ed sinh");
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
                "6*(${growing-button}, $lcgap)",
                "$lgap, $glue, 2*($lgap), $glue, 2*($lgap), $glue, 4*($lgap), $glue, $lgap"));

            //---- label2 ----
            label2.setText("H\u1ecd v\u00e0 t\u00ean th\u00ed sinh");
            label2.setLabelFor(jtexthoten);
            label2.setForeground(new Color(51, 51, 51));
            label2.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label2, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtexthoten ----
            jtexthoten.setBackground(new Color(204, 204, 204));
            jtexthoten.setForeground(Color.black);
            panel1.add(jtexthoten, CC.xywh(3, 2, 9, 1));

            //---- label6 ----
            label6.setText("Tr\u00ecnh \u0111\u1ed9");
            label6.setLabelFor(jtextdiachi);
            label6.setForeground(new Color(51, 51, 51));
            label6.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label6, new CellConstraints(7, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- label4 ----
            label4.setText("Gi\u1edbi t\u00ednh");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label4, new CellConstraints(1, 5, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- nam ----
            nam.setText("Nam");
            nam.setSelected(true);
            nam.setForeground(new Color(51, 51, 51));
            nam.setBackground(Color.white);
            panel1.add(nam, CC.xy(3, 5));

            //---- nu ----
            nu.setText("N\u1eef");
            nu.setForeground(new Color(51, 51, 51));
            nu.setBackground(Color.white);
            panel1.add(nu, CC.xy(5, 5));

            //---- label5 ----
            label5.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i");
            label5.setLabelFor(jtextsdt);
            label5.setForeground(new Color(51, 51, 51));
            label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label5, new CellConstraints(7, 8, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextsdt ----
            jtextsdt.setBackground(new Color(204, 204, 204));
            jtextsdt.setForeground(Color.black);
            panel1.add(jtextsdt, CC.xywh(9, 8, 3, 1));

            //---- label3 ----
            label3.setText("\u0110\u1ecba ch\u1ec9");
            label3.setLabelFor(jtextdiachi);
            label3.setForeground(new Color(51, 51, 51));
            label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label3, new CellConstraints(1, 8, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextdiachi ----
            jtextdiachi.setBackground(new Color(204, 204, 204));
            jtextdiachi.setForeground(Color.black);
            panel1.add(jtextdiachi, CC.xywh(3, 8, 3, 1));

            //---- jcombotrinhdo ----
            jcombotrinhdo.setBackground(new Color(204, 204, 204));
            jcombotrinhdo.setForeground(Color.black);
            panel1.add(jcombotrinhdo, CC.xy(9, 5));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(3, 13));

            //---- sua ----
            sua.setText("C\u1eadp nh\u1eadt");
            sua.setForeground(new Color(51, 51, 51));
            panel1.add(sua, CC.xy(5, 13));

            //---- xoa ----
            xoa.setText("X\u00f3a");
            xoa.setForeground(new Color(51, 51, 51));
            panel1.add(xoa, CC.xy(7, 13));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(9, 13));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))
                    .addContainerGap())
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

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(nam);
        buttonGroup1.add(nu);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField jtexthoten;
    private JLabel label6;
    private JLabel label4;
    private JRadioButton nam;
    private JRadioButton nu;
    private JLabel label5;
    private JTextField jtextsdt;
    private JLabel label3;
    private JTextField jtextdiachi;
    private JComboBox jcombotrinhdo;
    private JButton them;
    private JButton sua;
    private JButton xoa;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
