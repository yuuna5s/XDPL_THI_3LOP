package BLL;

import DAL.DAL_trinhdo;
import ENTITY.trinhdo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_trinhdo {
    DAL_trinhdo dal_trinhdo;

    public BLL_trinhdo(){
        dal_trinhdo = new DAL_trinhdo();
    }

    public ArrayList<trinhdo> getAll(){
        String Where = "idtrinhdo like '%%'";
        String Order = "idtrinhdo ASC";
        return dal_trinhdo.getAll(Where, Order);
    }

    public DefaultTableModel getAll_Table(ArrayList<trinhdo> list){
        String[] header = {"Mã trình độ", "Tên trình độ"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        if (list != null && list.size() > 0) {
            for (trinhdo item : list) {
                Object[] row = {item.getIdtrinhdo(), item.getTentrinhdo()};
                model.addRow(row);
            }
        }
        return model;
    }

    public boolean insert(String idtrinhdo, String tentrinhdo){
        trinhdo item = new trinhdo(idtrinhdo, tentrinhdo);
        return dal_trinhdo.insertTrinhdo(item);
    }

    public DefaultComboBoxModel getAll_ComboBox(){
        ArrayList<trinhdo> list = getAll();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        if (list != null && list.size() > 0) {
            for (trinhdo item : list) {
                model.addElement(item.getIdtrinhdo());
            }
        }
        return model;
    }
}
