package BLL;

import DAL.DAL_chitietphongthi;
import ENTITY.chitietphongthi;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_chitietphongthi {
    DAL_chitietphongthi dal_chitietphongthi;
    public BLL_chitietphongthi() {
        dal_chitietphongthi = new DAL_chitietphongthi();
    }

    public ArrayList<chitietphongthi> getAll(String idphongthi){
        return dal_chitietphongthi.getALL(idphongthi);
    }

    public DefaultTableModel getAll_Table(ArrayList<chitietphongthi> list){
        String[] cols = {"Số báo danh","Mã thí sinh","Tên thí sinh"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (chitietphongthi item : list) {
            Object[] row = {item.getSbd(),item.getIdthisinh(),item.getTenthisinh()};
            model.addRow(row);
        }
        return model;
    }
}
