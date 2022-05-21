package BLL;

import DAL.DAL_diem;
import ENTITY.diem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class BLL_Diem {
    DAL_diem dal_diem;
    public BLL_Diem(){
        dal_diem = new DAL_diem();
    }

    public ArrayList<diem> getAll() throws SQLException {
        return dal_diem.getAll();
    }

    public DefaultTableModel getAll_Table(ArrayList<diem> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã thí sinh");
        model.addColumn("Tên thí sinh");
        model.addColumn("Mã khóa học");
        model.addColumn("Nghe");
        model.addColumn("Nói");
        model.addColumn("Đọc");
        model.addColumn("Viết");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                list.get(i).getIdthisinh(),
                list.get(i).getTenthisinh(),
                list.get(i).getIdkhoathi(),
                list.get(i).getNghe(),
                list.get(i).getNoi(),
                list.get(i).getDoc(),
                list.get(i).getViet()
            });
        }
        return model;
    }

    public DefaultComboBoxModel thisinh(ArrayList<diem> list) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < list.size(); i++) {
            String ts = list.get(i).getIdthisinh() + " - " + list.get(i).getTenthisinh();
            model.addElement(ts);
        }
        return model;
    }

    public DefaultComboBoxModel khoathi(ArrayList<diem> list) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String kt = list.get(i).getIdkhoathi();
            if (!list1.contains(kt)) {
                model.addElement(kt);
                list1.add(kt);
            }
            else {continue;}
        }
        return model;
    }

    public void add(String idthisinh, String idkhoathi, String tenthisinh, double nghe, double noi, double doc, double viet) throws SQLException {
        diem d = new diem(idthisinh, idkhoathi, tenthisinh, nghe, noi, doc, viet);
        dal_diem.insertDiem(d);
    }

    public void sua(String idthisinh, String idkhoathi, String tenthisinh, double nghe, double noi, double doc, double viet) throws SQLException {
        diem d = new diem(idthisinh, idkhoathi, tenthisinh, nghe, noi, doc, viet);
        dal_diem.updateDiem(d);
    }
}
