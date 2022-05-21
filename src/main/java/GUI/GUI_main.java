/*
 * Created by JFormDesigner on Sun Jan 02 19:15:29 ICT 2022
 */

package GUI;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Trieu Bich Khai
 */
public class GUI_main extends JFrame {
    public GUI_main() {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        initComponents();
        setTitle("Trung tâm thi ngoại ngữ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        buttonmanager();
        thisinh.doClick();
    }

    public void buttonmanager(){
        thisinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setContentPane(new GUI_thisinh());
                internalFrame1.setVisible(true);
            }
        });

        trinhdo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setContentPane(new GUI_trinhdo());
                internalFrame1.setVisible(true);
            }
        });

        khoathi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setContentPane(new GUI_khoathi());
                internalFrame1.setVisible(true);
            }
        });

        cathi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setContentPane(new GUI_cathi());
                internalFrame1.setVisible(true);
            }
        });

        diemthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    internalFrame1.setContentPane(new GUI_diem());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                internalFrame1.setVisible(true);
            }
        });

        phongthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setContentPane(new GUI_phongthi());
                internalFrame1.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        GUI_main main = new GUI_main();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
        bg = new JPanel();
        menu = new JPanel();
        title = new JLabel();
        trinhdo = new JButton();
        thisinh = new JButton();
        phongthi = new JButton();
        khoathi = new JButton();
        cathi = new JButton();
        diemthi = new JButton();
        thongke = new JButton();
        internalFrame1 = new JInternalFrame();

        //======== this ========
        var contentPane = getContentPane();

        //======== bg ========
        {
            bg.setBackground(Color.white);
            bg.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,bg. getBorder( )) ); bg. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== menu ========
            {
                menu.setBackground(new Color(51, 51, 51));

                //---- title ----
                title.setText("TRUNG T\u00c2M THI NGO\u1ea0I NG\u1eee");
                title.setFont(new Font("Segoe UI", Font.BOLD, 16));
                title.setHorizontalAlignment(SwingConstants.CENTER);
                title.setForeground(new Color(110, 110, 190));

                //---- trinhdo ----
                trinhdo.setText("Tr\u00ecnh \u0111\u1ed9 ch\u1ee9ng ch\u1ec9");
                trinhdo.setBackground(new Color(51, 51, 51));
                trinhdo.setForeground(new Color(0, 153, 102));
                trinhdo.setFont(new Font("Segoe UI", Font.BOLD, 14));
                trinhdo.setHorizontalAlignment(SwingConstants.LEFT);
                trinhdo.setMargin(new Insets(0, 50, 0, 0));
                trinhdo.setRolloverEnabled(true);

                //---- thisinh ----
                thisinh.setText("Qu\u1ea3n l\u00fd th\u00ed sinh");
                thisinh.setBackground(new Color(51, 51, 51));
                thisinh.setForeground(new Color(0, 153, 102));
                thisinh.setFont(new Font("Segoe UI", Font.BOLD, 14));
                thisinh.setHorizontalAlignment(SwingConstants.LEFT);
                thisinh.setMargin(new Insets(0, 50, 0, 0));
                thisinh.setRolloverEnabled(true);

                //---- phongthi ----
                phongthi.setText("Qu\u1ea3n l\u00fd ph\u00f2ng thi");
                phongthi.setBackground(new Color(51, 51, 51));
                phongthi.setForeground(new Color(0, 153, 102));
                phongthi.setFont(new Font("Segoe UI", Font.BOLD, 14));
                phongthi.setHorizontalAlignment(SwingConstants.LEFT);
                phongthi.setMargin(new Insets(0, 50, 0, 0));
                phongthi.setRolloverEnabled(true);

                //---- khoathi ----
                khoathi.setText("Qu\u1ea3n l\u00fd kh\u00f3a thi");
                khoathi.setBackground(new Color(51, 51, 51));
                khoathi.setForeground(new Color(0, 153, 102));
                khoathi.setFont(new Font("Segoe UI", Font.BOLD, 14));
                khoathi.setHorizontalAlignment(SwingConstants.LEFT);
                khoathi.setMargin(new Insets(0, 50, 0, 0));
                khoathi.setRolloverEnabled(true);

                //---- cathi ----
                cathi.setText("Qu\u1ea3n l\u00fd ca thi");
                cathi.setBackground(new Color(51, 51, 51));
                cathi.setForeground(new Color(0, 153, 102));
                cathi.setFont(new Font("Segoe UI", Font.BOLD, 14));
                cathi.setHorizontalAlignment(SwingConstants.LEFT);
                cathi.setMargin(new Insets(0, 50, 0, 0));
                cathi.setRolloverEnabled(true);

                //---- diemthi ----
                diemthi.setText("Qu\u1ea3n l\u00fd \u0111i\u1ec3m thi");
                diemthi.setBackground(new Color(51, 51, 51));
                diemthi.setForeground(new Color(0, 153, 102));
                diemthi.setFont(new Font("Segoe UI", Font.BOLD, 14));
                diemthi.setHorizontalAlignment(SwingConstants.LEFT);
                diemthi.setMargin(new Insets(0, 50, 0, 0));
                diemthi.setRolloverEnabled(true);

                //---- thongke ----
                thongke.setText("Th\u1ed1ng k\u00ea");
                thongke.setBackground(new Color(51, 51, 51));
                thongke.setForeground(new Color(0, 153, 102));
                thongke.setFont(new Font("Segoe UI", Font.BOLD, 14));
                thongke.setHorizontalAlignment(SwingConstants.LEFT);
                thongke.setMargin(new Insets(0, 50, 0, 0));
                thongke.setRolloverEnabled(true);

                GroupLayout menuLayout = new GroupLayout(menu);
                menu.setLayout(menuLayout);
                menuLayout.setHorizontalGroup(
                    menuLayout.createParallelGroup()
                        .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trinhdo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(menuLayout.createSequentialGroup()
                            .addGroup(menuLayout.createParallelGroup()
                                .addComponent(thisinh, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phongthi, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addComponent(khoathi, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cathi, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addComponent(diemthi, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                .addComponent(thongke, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                menuLayout.setVerticalGroup(
                    menuLayout.createParallelGroup()
                        .addGroup(menuLayout.createSequentialGroup()
                            .addComponent(title, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(trinhdo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(thisinh, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phongthi, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(khoathi, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cathi, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(diemthi, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(thongke, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 125, Short.MAX_VALUE))
                );
            }

            GroupLayout bgLayout = new GroupLayout(bg);
            bg.setLayout(bgLayout);
            bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup()
                    .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup()
                    .addComponent(menu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }

        //======== internalFrame1 ========
        {
            internalFrame1.setVisible(true);
            internalFrame1.setFrameIcon(null);
            var internalFrame1ContentPane = internalFrame1.getContentPane();

            GroupLayout internalFrame1ContentPaneLayout = new GroupLayout(internalFrame1ContentPane);
            internalFrame1ContentPane.setLayout(internalFrame1ContentPaneLayout);
            internalFrame1ContentPaneLayout.setHorizontalGroup(
                internalFrame1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 938, Short.MAX_VALUE)
            );
            internalFrame1ContentPaneLayout.setVerticalGroup(
                internalFrame1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 690, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(bg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(internalFrame1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(internalFrame1)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Trieu Bich Khai
    private JPanel bg;
    private JPanel menu;
    private JLabel title;
    private JButton trinhdo;
    private JButton thisinh;
    private JButton phongthi;
    private JButton khoathi;
    private JButton cathi;
    private JButton diemthi;
    private JButton thongke;
    private JInternalFrame internalFrame1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
