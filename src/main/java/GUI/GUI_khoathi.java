/*
 * Created by JFormDesigner on Mon Jan 03 03:26:49 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.BLL_khoathi;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * @author Trieu Bich Khai
 */
public class GUI_khoathi extends JPanel {
    public GUI_khoathi() {
        initComponents();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBackground(new Color(204, 204, 204));
        datePicker.setForeground(Color.black);
        panel1.add(datePicker, CC.xywh(9, 2, 3, 1));
        BLL_khoathi bll_khoathi = new BLL_khoathi();
        table1.setModel(bll_khoathi.getALl_Table(bll_khoathi.getAll()));
        buttonmanager(datePicker, bll_khoathi);
    }

    public void buttonmanager(JDatePickerImpl datePicker, BLL_khoathi bll_khoathi) {
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(bll_khoathi.getALl_Table(bll_khoathi.getAll()));
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idkhoathi = jtextidkhoathi.getText();
                String tenkhoathi = jtexttenkhoathi.getText();
                String ngaythi = datePicker.getJFormattedTextField().getText();
                if (idkhoathi.equals("") || tenkhoathi.equals("") || ngaythi.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else if (!bll_khoathi.checkID(idkhoathi)) {
                    JOptionPane.showMessageDialog(null, "Mã khóa thi đã tồn tại");
                }
                else{
                    bll_khoathi.insert(idkhoathi, tenkhoathi, ngaythi);
                    table1.setModel(bll_khoathi.getALl_Table(bll_khoathi.getAll()));
                    jtextidkhoathi.setText("");
                    jtexttenkhoathi.setText("");
                    datePicker.getJFormattedTextField().setText("");
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            }
        });

        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String idkhoathi = jtextidkhoathi.getText();
                String tenkhoathi = jtexttenkhoathi.getText();
                String ngaythi = datePicker.getJFormattedTextField().getText();
                if (idkhoathi.equals("") || tenkhoathi.equals("") || ngaythi.equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else if (bll_khoathi.checkID(idkhoathi)) {
                    JOptionPane.showMessageDialog(null, "Mã khóa thi không tồn tại");
                }
                else{
                    bll_khoathi.update(idkhoathi, tenkhoathi, ngaythi);
                    table1.setModel(bll_khoathi.getALl_Table(bll_khoathi.getAll()));
                    jtextidkhoathi.setText("");
                    jtexttenkhoathi.setText("");
                    datePicker.getJFormattedTextField().setText("");
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                }
            }
        });

        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idkhoathi = jtextidkhoathi.getText();
                bll_khoathi.delete(idkhoathi);
                table1.setModel(bll_khoathi.getALl_Table(bll_khoathi.getAll()));
                jtextidkhoathi.setText("");
                jtexttenkhoathi.setText("");
                datePicker.getJFormattedTextField().setText("");
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        });

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.getSelectedRow();
                jtextidkhoathi.setText(table1.getValueAt(row, 0).toString());
                jtexttenkhoathi.setText(table1.getValueAt(row, 1).toString());
                datePicker.getJFormattedTextField().setText(table1.getValueAt(row, 2).toString());
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
        jtextidkhoathi = new JTextField();
        label4 = new JLabel();
        jtexttenkhoathi = new JTextField();
        label5 = new JLabel();
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
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd kh\u00f3a thi");
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
                "$lgap, $glue, 3*($lgap), default, $lgap, default, $glue, 2*($lgap)"));

            //---- label3 ----
            label3.setText("M\u00e3 ID kh\u00f3a thi");
            label3.setForeground(new Color(51, 51, 51));
            label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label3.setLabelFor(jtextidkhoathi);
            panel1.add(label3, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtextidkhoathi ----
            jtextidkhoathi.setBackground(new Color(204, 204, 204));
            jtextidkhoathi.setForeground(Color.black);
            panel1.add(jtextidkhoathi, CC.xywh(3, 2, 3, 1));

            //---- label4 ----
            label4.setText("Ng\u00e0y thi");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label4, new CellConstraints(7, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- jtexttenkhoathi ----
            jtexttenkhoathi.setBackground(new Color(204, 204, 204));
            jtexttenkhoathi.setForeground(Color.black);
            panel1.add(jtexttenkhoathi, CC.xywh(3, 6, 9, 1));

            //---- label5 ----
            label5.setText("T\u00ean kh\u00f3a thi");
            label5.setForeground(new Color(51, 51, 51));
            label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label5.setLabelFor(jtexttenkhoathi);
            panel1.add(label5, new CellConstraints(1, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(3, 9));

            //---- sua ----
            sua.setText("C\u1eadp nh\u1eadt");
            sua.setForeground(new Color(51, 51, 51));
            panel1.add(sua, CC.xy(5, 9));

            //---- xoa ----
            xoa.setText("X\u00f3a");
            xoa.setForeground(new Color(51, 51, 51));
            panel1.add(xoa, CC.xy(7, 9));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(9, 9));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(8, Short.MAX_VALUE))
                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
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
    private JTextField jtextidkhoathi;
    private JLabel label4;
    private JTextField jtexttenkhoathi;
    private JLabel label5;
    private JButton them;
    private JButton sua;
    private JButton xoa;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
        return "";
    }

}
