/*
 * Created by JFormDesigner on Mon Jan 03 17:44:50 ICT 2022
 */

package GUI;

import BLL.BLL_chitietphongthi;
import com.itextpdf.io.font.FontConstants;
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
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Trieu Bich Khai
 */
public class GUI_chitietphongthi extends JFrame {

    public GUI_chitietphongthi(String idphongthi, String tenphongthi ,String idtrinhdo, String idkhoathi, String idcathi) {
        initComponents();
        phongthi.setText(tenphongthi);
        trinhdo.setText(idtrinhdo);
        khoathi.setText(idkhoathi);
        cathi.setText(idcathi);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BLL_chitietphongthi bll_chitietphongthi = new BLL_chitietphongthi();
        table1.setModel(bll_chitietphongthi.getAll_Table(bll_chitietphongthi.getAll(idphongthi)));
        buttonmanager();
    }

    public void buttonmanager(){
        indachsachphongthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String FILE_NAME = "src/main/java/GUI/danhsachphongthi"+phongthi.getText()+".pdf";
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
                    Paragraph paragraph = new Paragraph("Danh sách phòng thi").setFont(font).setFontSize(20);
                    document.add(paragraph);
                    List list = new List().setSymbolIndent(12).setListSymbol("\u2022");
                    list.add("Phòng thi: " + phongthi.getText()).setFont(font2);
                    list.add("Trình độ: " + trinhdo.getText()).setFont(font2);
                    list.add("Khóa thi: " + khoathi.getText()).setFont(font2);
                    list.add("Ca thi: " + cathi.getText()).setFont(font2);
                    document.add(list);

                    Table table = new Table(3).useAllAvailableWidth();
                    table.addCell("Số báo danh").setFont(font);
                    table.addCell("Mã thí sinh").setFont(font);
                    table.addCell("Họ và tên").setFont(font);

                    for (int i = 0; i < table1.getRowCount(); i++) {
                        table.addCell(table1.getValueAt(i, 0).toString()).setFont(font2);
                        table.addCell(table1.getValueAt(i, 1).toString()).setFont(font2);
                        table.addCell(table1.getValueAt(i, 2).toString()).setFont(font2);
                    }
                    document.add(table);
                    document.close();
                    JOptionPane.showMessageDialog(null, "Xuất danh sách thành công");
                } catch (FileNotFoundException ex) {
                    System.err.println("File not found");
                    ex.printStackTrace();
                } catch (IOException ioException) {
                    System.err.println(ioException.getMessage());
                    ioException.printStackTrace();
                }
            }
        });

        inphieubaothi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mathisinh = table1.getValueAt(table1.getSelectedRow(), 1).toString();
                final String FILE_NAME = "src/main/java/phieubaothisinhvien"+mathisinh+".pdf";
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
                    Paragraph paragraph = new Paragraph("Phiếu báo thi").setFont(font).setFontSize(20);
                    document.add(paragraph);
                    List list = new List().setSymbolIndent(12).setListSymbol("\u2022");
                    list.add("Mã thí sinh: " + mathisinh).setFont(font2);
                    list.add("Họ và tên: " + table1.getValueAt(table1.getSelectedRow(), 2).toString()).setFont(font2);
                    list.add("Số báo danh: " + table1.getValueAt(table1.getSelectedRow(), 0).toString()).setFont(font2);
                    list.add("Phòng thi: " + phongthi.getText()).setFont(font2);
                    list.add("Trình độ: " + trinhdo.getText()).setFont(font2);
                    list.add("Khóa thi: " + khoathi.getText()).setFont(font2);
                    list.add("Ca thi: " + cathi.getText()).setFont(font2);
                    document.add(list);
                    document.close();
                    JOptionPane.showMessageDialog(null, "Xuất phiếu báo thi thành công");
                }
                catch (FileNotFoundException ex) {
                    System.err.println("File not found");
                }
                catch (IOException ioException) {
                    System.err.println(ioException.getMessage());
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
        contentPanel = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        phongthi = new JLabel();
        trinhdo = new JLabel();
        cathi = new JLabel();
        khoathi = new JLabel();
        indachsachphongthi = new JButton();
        inphieubaothi = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== contentPanel ========
        {
            contentPanel.setBackground(Color.white);
            contentPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,contentPanel. getBorder( )) ); contentPanel. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("Chi ti\u1ebft ph\u00f2ng thi");
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

                //---- label2 ----
                label2.setText("ID ph\u00f2ng thi:");
                label2.setForeground(new Color(51, 51, 51));
                label2.setFont(new Font("Segoe UI", Font.BOLD, 12));

                //---- label4 ----
                label4.setText("Tr\u00ecnh \u0111\u1ed9:");
                label4.setForeground(new Color(51, 51, 51));
                label4.setFont(new Font("Segoe UI", Font.BOLD, 12));

                //---- label5 ----
                label5.setText("Ca thi:");
                label5.setForeground(new Color(51, 51, 51));
                label5.setFont(new Font("Segoe UI", Font.BOLD, 12));

                //---- label6 ----
                label6.setText("Kh\u00f3a thi:");
                label6.setForeground(new Color(51, 51, 51));
                label6.setFont(new Font("Segoe UI", Font.BOLD, 12));

                //---- phongthi ----
                phongthi.setText("text");

                //---- trinhdo ----
                trinhdo.setText("text");

                //---- cathi ----
                cathi.setText("text");

                //---- khoathi ----
                khoathi.setText("text");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(trinhdo))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(phongthi)))
                            .addGap(121, 121, 121)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cathi))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(khoathi)))
                            .addContainerGap(293, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5)
                                        .addComponent(cathi))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6)
                                        .addComponent(khoathi)))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(phongthi))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4)
                                        .addComponent(trinhdo))))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            //---- indachsachphongthi ----
            indachsachphongthi.setText("In danh s\u00e1ch ph\u00f2ng thi");
            indachsachphongthi.setForeground(new Color(51, 51, 51));

            //---- inphieubaothi ----
            inphieubaothi.setText("In phi\u1ebfu b\u00e1o thi");
            inphieubaothi.setForeground(new Color(51, 51, 51));

            GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
            contentPanel.setLayout(contentPanelLayout);
            contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(0, 469, Short.MAX_VALUE)
                                        .addComponent(inphieubaothi, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(indachsachphongthi, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
            );
            contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup()
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(inphieubaothi)
                            .addComponent(indachsachphongthi))
                        .addContainerGap())
            );
        }
        contentPane.add(contentPanel, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
    private JPanel contentPanel;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel phongthi;
    private JLabel trinhdo;
    private JLabel cathi;
    private JLabel khoathi;
    private JButton indachsachphongthi;
    private JButton inphieubaothi;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
