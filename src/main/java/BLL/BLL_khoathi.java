package BLL;

import DAL.DAL_khoathi;
import ENTITY.khoathi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_khoathi {
    DAL_khoathi dal_khoathi;
    public BLL_khoathi(){
        dal_khoathi = new DAL_khoathi();
    }

    public ArrayList<khoathi> getAll(){
        String Where = "idkhoathi like '%%'";
        String Order = "idkhoathi ASC";
        return dal_khoathi.getAll(Where, Order);
    }

    public DefaultTableModel getALl_Table(ArrayList<khoathi> list){
        String[] cols = {"Mã khoa thi", "Tên khoa thi", "Ngày thi"};
        String[] rows = new String[3];
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (khoathi khoathi : list) {
            rows[0] = khoathi.getIdkhoathi();
            rows[1] = khoathi.getTenkhoathi();
            rows[2] = khoathi.getNgaythi();
            model.addRow(rows);
        }
        return model;
    }

    public boolean insert(String idkhoathi, String tenkhoathi, String ngaythi){
        khoathi khoathi = new khoathi(idkhoathi, tenkhoathi, ngaythi);
        return dal_khoathi.insertKhoathi(khoathi);
    }

    public boolean update(String idkhoathi, String tenkhoathi, String ngaythi){
        khoathi khoathi = new khoathi(idkhoathi, tenkhoathi, ngaythi);
        return dal_khoathi.updateKhoathi(khoathi);
    }

    public boolean delete(String idkhoathi){
        return dal_khoathi.deleteKhoathi(idkhoathi);
    }

    public boolean checkID(String idkhoathi){
        ArrayList<khoathi> list = getAll();
        for (khoathi khoathi : list) {
            if(khoathi.getIdkhoathi().equals(idkhoathi)){
                return false;
            }
        }
        return true;
    }

    public boolean checkIDexcept(String idkhoathi, String idkhoathi_old){
        ArrayList<khoathi> list = getAll();
        for (khoathi khoathi : list) {
            if(khoathi.getIdkhoathi().equals(idkhoathi) && !khoathi.getIdkhoathi().equals(idkhoathi_old)){
                return false;
            }
        }
        return true;
    }

    public DefaultComboBoxModel getAll_ComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<khoathi> list = getAll();
        for (khoathi khoathi : list) {
            model.addElement(khoathi.getIdkhoathi());
        }
        return model;
    }
}
