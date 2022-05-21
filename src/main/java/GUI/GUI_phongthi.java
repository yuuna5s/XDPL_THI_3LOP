/*
 * Created by JFormDesigner on Mon Jan 03 17:24:52 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.*;
import DAL.DAL_sobaodanh;
import DAL.DAL_thisinh;
import ENTITY.phongthi;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_phongthi extends JPanel {
    public GUI_phongthi() {
        initComponents();
        BLL_phongthi bll_phongthi = new BLL_phongthi();
        table1.setModel(bll_phongthi.getAll_Table(bll_phongthi.getAll()));
        BLL_khoathi bll_khoathi = new BLL_khoathi();
        khoathi.setModel(bll_khoathi.getAll_ComboBox());
        BLL_trinhdo bll_trinhdo = new BLL_trinhdo();
        trinhdo.setModel(bll_trinhdo.getAll_ComboBox());
        BLL_cathi bll_cathi = new BLL_cathi();
        cathi.setModel(bll_cathi.getAll_ComboBox());
        buttonmanager(bll_phongthi);
    }

    public void buttonmanager(BLL_phongthi bll_phongthi) {
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(bll_phongthi.getAll_Table(bll_phongthi.getAll()));
            }
        });
        
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<phongthi> list = bll_phongthi.getAll();
                String idtrinhdo = trinhdo.getSelectedItem().toString();
                String idkhoathi = khoathi.getSelectedItem().toString();
                String idcathi = cathi.getSelectedItem().toString();
                String tenphongthi="";
                int idphongthi_num=0;
                String idphongthi = "";
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                            String currentid = list.get(i).getIdphongthi();
                            int currentid_num = Integer.parseInt(currentid.substring(currentid.length() - 3));
                            idphongthi_num = currentid_num + 1;
                            tenphongthi = idtrinhdo + "P" + String.format("%03d", idphongthi_num);
                            idphongthi = "P" + String.format("%03d", idphongthi_num);
                    }
                }
                else{
                    idphongthi_num = 1;
                    tenphongthi = idtrinhdo + "P" + String.format("%03d", idphongthi_num);
                    idphongthi = "P" + String.format("%03d", idphongthi_num);
                }
                if (bll_phongthi.them(idphongthi, tenphongthi, idtrinhdo, idkhoathi, idcathi)) {
                    table1.setModel(bll_phongthi.getAll_Table(bll_phongthi.getAll()));
                    bll_phongthi.xepphongthi(idphongthi, idtrinhdo, idkhoathi);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            }
        });

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String idphongthi = table1.getValueAt(table1.getSelectedRow(), 0).toString();
                String tenphongthi = table1.getValueAt(table1.getSelectedRow(), 1).toString();
                String idtrinhdo = table1.getValueAt(table1.getSelectedRow(), 2).toString();
                String idkhoathi = table1.getValueAt(table1.getSelectedRow(), 3).toString();
                String idcathi = table1.getValueAt(table1.getSelectedRow(), 4).toString();
                GUI_chitietphongthi gui_chitietphongthi = new GUI_chitietphongthi(idphongthi, tenphongthi,idtrinhdo, idkhoathi, idcathi);
                gui_chitietphongthi.setVisible(true);
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
        trinhdo = new JComboBox();
        label4 = new JLabel();
        khoathi = new JComboBox();
        label2 = new JLabel();
        label5 = new JLabel();
        cathi = new JComboBox();
        them = new JButton();
        reload = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(938, 708));
        setMaximumSize(new Dimension(938, 708));
        setMinimumSize(new Dimension(938, 708));
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd ph\u00f2ng thi");
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
                "$lgap, $glue, 3*($lgap), 2*(default, $lgap)"));

            //---- trinhdo ----
            trinhdo.setBackground(new Color(204, 204, 204));
            trinhdo.setForeground(Color.black);
            panel1.add(trinhdo, CC.xy(7, 2));

            //---- label4 ----
            label4.setText("Tr\u00ecnh \u0111\u1ed9");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label4.setLabelFor(trinhdo);
            panel1.add(label4, new CellConstraints(5, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 40, 0, 0)));

            //---- khoathi ----
            khoathi.setBackground(new Color(204, 204, 204));
            khoathi.setForeground(Color.black);
            panel1.add(khoathi, CC.xy(3, 2));

            //---- label2 ----
            label2.setText("Kh\u00f3a thi");
            label2.setForeground(new Color(51, 51, 51));
            label2.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label2.setLabelFor(khoathi);
            panel1.add(label2, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 40, 0, 0)));

            //---- label5 ----
            label5.setText("Ca thi");
            label5.setForeground(new Color(51, 51, 51));
            label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label5.setLabelFor(trinhdo);
            panel1.add(label5, new CellConstraints(9, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 40, 0, 0)));

            //---- cathi ----
            cathi.setBackground(new Color(204, 204, 204));
            cathi.setForeground(Color.black);
            panel1.add(cathi, CC.xy(11, 2));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(5, 8));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(7, 8));
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
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JComboBox trinhdo;
    private JLabel label4;
    private JComboBox khoathi;
    private JLabel label2;
    private JLabel label5;
    private JComboBox cathi;
    private JButton them;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
