/*
 * Created by JFormDesigner on Mon Jan 03 18:11:34 ICT 2022
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import BLL.BLL_Diem;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_diem extends JPanel {
    public GUI_diem() throws SQLException {
        initComponents();
        BLL_Diem bll_diem = new BLL_Diem();
        table1.setModel(bll_diem.getAll_Table(bll_diem.getAll()));
        thisinhcombo.setModel(bll_diem.thisinh(bll_diem.getAll()));
        khoathicombo.setModel(bll_diem.khoathi(bll_diem.getAll()));
        buttonmanager(bll_diem);
        them.setVisible(false);
    }

    public void buttonmanager(BLL_Diem bll_diem) throws SQLException {
        reload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table1.setModel(bll_diem.getAll_Table(bll_diem.getAll()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idkhoathi = khoathicombo.getSelectedItem().toString();
                String thisinh = thisinhcombo.getSelectedItem().toString();
                String idthisinh = thisinh.split("-")[0];
                String hoten = thisinh.split("-")[1];
                Double nghe = Double.parseDouble(nghetext.getText());
                Double noi = Double.parseDouble(noitext.getText());
                Double doc = Double.parseDouble(doctext.getText());
                Double viet = Double.parseDouble(viettext.getText());
                if (idkhoathi.equals("") || thisinh.equals("") || nghetext.getText().equals("") || noitext.getText().equals("") || doctext.getText().equals("") || viettext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else {
                    try {
                        bll_diem.add(idkhoathi, idthisinh, hoten, nghe, noi, doc, viet);
                        table1.setModel(bll_diem.getAll_Table(bll_diem.getAll()));
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } catch (SQLException throwables) {
                        System.err.println(throwables.getMessage());
                        throwables.printStackTrace();
                    }
                }
            }
        });
        
        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idkhoathi = khoathicombo.getSelectedItem().toString().trim();
                String thisinh = thisinhcombo.getSelectedItem().toString();
                String idthisinh = thisinh.split("-")[0];
                String hoten = thisinh.split("-")[1];
                Double nghe = Double.parseDouble(nghetext.getText());
                Double noi = Double.parseDouble(noitext.getText());
                Double doc = Double.parseDouble(doctext.getText());
                Double viet = Double.parseDouble(viettext.getText());
                if (idkhoathi.equals("") || thisinh.equals("") || nghetext.getText().equals("") || noitext.getText().equals("") || doctext.getText().equals("") || viettext.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                }
                else {
                    try {
                        bll_diem.sua(idkhoathi, idthisinh, hoten, nghe, noi, doc, viet);
                        table1.setModel(bll_diem.getAll_Table(bll_diem.getAll()));
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    } catch (SQLException throwables) {
                        System.err.println(throwables.getMessage());
                        throwables.printStackTrace();
                    }
                }
            }
        });

        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table1.getSelectedRow();
                String thisinh = table1.getValueAt(row, 0).toString() + " - " + table1.getValueAt(row, 1).toString();
                String idkhoathi = table1.getValueAt(row, 2).toString();
                Double nghe = Double.parseDouble(table1.getValueAt(row, 3).toString());
                Double noi = Double.parseDouble(table1.getValueAt(row, 4).toString());
                Double doc = Double.parseDouble(table1.getValueAt(row, 5).toString());
                Double viet = Double.parseDouble(table1.getValueAt(row, 6).toString());
                khoathicombo.setSelectedItem(idkhoathi);
                thisinhcombo.setSelectedItem(thisinh);
                nghetext.setText(nghe.toString());
                noitext.setText(noi.toString());
                doctext.setText(doc.toString());
                viettext.setText(viet.toString());
            }
        });

        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                String mathisinh = table1.getValueAt(row, 0).toString();
                String FILE_NAME = "src/main/java/phieubaodiem"+mathisinh+".pdf";
                File file = new File(FILE_NAME);
                file.getParentFile().mkdirs();
                try {
                    String fontPath = getClass().getResource("/vuArialBold.ttf").getPath();
                    FontProgram fontProgram = FontProgramFactory.createFont(fontPath);
                    PdfFont font = PdfFontFactory.createFont(fontProgram);
                    String fontPath1 = getClass().getResource("/vuArial.ttf").getPath();
                    FontProgram fontProgram1 = FontProgramFactory.createFont(fontPath1);
                    PdfFont font2 = PdfFontFactory.createFont(fontProgram1);
                    PdfWriter writer = new PdfWriter(FILE_NAME);
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf, PageSize.A4);
                    Paragraph paragraph = new Paragraph("Phiếu báo điểm").setFont(font).setFontSize(20).setHorizontalAlignment(HorizontalAlignment.CENTER);
                    document.add(paragraph);
                    List list = new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font2).setFontSize(12);
                    list.add("Họ tên: " + table1.getValueAt(row, 1).toString());
                    list.add("Mã thí sinh: " + table1.getValueAt(row, 0).toString());
                    list.add("Mã khoá thi: " + table1.getValueAt(row, 2).toString());
                    list.add("Nghe: " + table1.getValueAt(row, 3).toString());
                    list.add("Nói: " + table1.getValueAt(row, 4).toString());
                    list.add("Đọc: " + table1.getValueAt(row, 5).toString());
                    list.add("Viết: " + table1.getValueAt(row, 6).toString());
                    document.add(list);
                    document.close();
                    Desktop.getDesktop().open(file);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                } catch (IOException ioException) {
                    System.err.println(ioException.getMessage());
                    ioException.printStackTrace();
                }
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
        thisinhcombo = new JComboBox();
        label7 = new JLabel();
        khoathicombo = new JComboBox();
        label4 = new JLabel();
        nghetext = new JTextField();
        label6 = new JLabel();
        noitext = new JTextField();
        label3 = new JLabel();
        doctext = new JTextField();
        label5 = new JLabel();
        viettext = new JTextField();
        them = new JButton();
        sua = new JButton();
        in = new JButton();
        reload = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(938, 708));
        setMaximumSize(new Dimension(938, 708));
        setMinimumSize(new Dimension(938, 708));
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}})
        ;

        //---- label1 ----
        label1.setText("Qu\u1ea3n l\u00fd \u0111i\u1ec3m th\u00ed sinh");
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
                "$lgap, default, 3*($lgap), default, $lgap, default, $glue, 2*($lgap), $glue, $lgap"));

            //---- label2 ----
            label2.setText("Nh\u1eadp ID th\u00ed sinh");
            label2.setForeground(new Color(51, 51, 51));
            label2.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label2, new CellConstraints(1, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- thisinhcombo ----
            thisinhcombo.setBackground(new Color(204, 204, 204));
            thisinhcombo.setForeground(Color.black);
            panel1.add(thisinhcombo, CC.xywh(3, 2, 3, 1));

            //---- label7 ----
            label7.setText("Kh\u00f3a thi");
            label7.setForeground(new Color(51, 51, 51));
            label7.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label7, new CellConstraints(7, 2, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- khoathicombo ----
            khoathicombo.setBackground(new Color(204, 204, 204));
            khoathicombo.setForeground(Color.black);
            panel1.add(khoathicombo, CC.xy(9, 2));

            //---- label4 ----
            label4.setText("Nghe");
            label4.setForeground(new Color(51, 51, 51));
            label4.setFont(new Font("Segoe UI", Font.BOLD, 12));
            label4.setLabelFor(nghetext);
            panel1.add(label4, new CellConstraints(3, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- nghetext ----
            nghetext.setBackground(new Color(204, 204, 204));
            nghetext.setForeground(Color.black);
            panel1.add(nghetext, CC.xy(5, 6));

            //---- label6 ----
            label6.setText("N\u00f3i");
            label6.setLabelFor(doctext);
            label6.setForeground(new Color(51, 51, 51));
            label6.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label6, new CellConstraints(7, 6, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- noitext ----
            noitext.setBackground(new Color(204, 204, 204));
            noitext.setForeground(Color.black);
            panel1.add(noitext, CC.xy(9, 6));

            //---- label3 ----
            label3.setText("\u0110\u1ecdc");
            label3.setLabelFor(doctext);
            label3.setForeground(new Color(51, 51, 51));
            label3.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label3, new CellConstraints(3, 8, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- doctext ----
            doctext.setBackground(new Color(204, 204, 204));
            doctext.setForeground(Color.black);
            panel1.add(doctext, CC.xy(5, 8));

            //---- label5 ----
            label5.setText("Vi\u1ebft");
            label5.setLabelFor(viettext);
            label5.setForeground(new Color(51, 51, 51));
            label5.setFont(new Font("Segoe UI", Font.BOLD, 12));
            panel1.add(label5, new CellConstraints(7, 8, 1, 1, CC.DEFAULT, CC.DEFAULT, new Insets(0, 20, 0, 0)));

            //---- viettext ----
            viettext.setBackground(new Color(204, 204, 204));
            viettext.setForeground(Color.black);
            panel1.add(viettext, CC.xy(9, 8));

            //---- them ----
            them.setText("Th\u00eam");
            them.setForeground(new Color(51, 51, 51));
            panel1.add(them, CC.xy(3, 12));

            //---- sua ----
            sua.setText("C\u1eadp nh\u1eadt");
            sua.setForeground(new Color(51, 51, 51));
            panel1.add(sua, CC.xy(5, 12));

            //---- in ----
            in.setText("In \u0111i\u1ec3m");
            in.setForeground(new Color(51, 51, 51));
            panel1.add(in, CC.xy(7, 12));

            //---- reload ----
            reload.setText("Reload");
            reload.setForeground(new Color(51, 51, 51));
            panel1.add(reload, CC.xy(9, 12));
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label2;
    private JComboBox thisinhcombo;
    private JLabel label7;
    private JComboBox khoathicombo;
    private JLabel label4;
    private JTextField nghetext;
    private JLabel label6;
    private JTextField noitext;
    private JLabel label3;
    private JTextField doctext;
    private JLabel label5;
    private JTextField viettext;
    private JButton them;
    private JButton sua;
    private JButton in;
    private JButton reload;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
