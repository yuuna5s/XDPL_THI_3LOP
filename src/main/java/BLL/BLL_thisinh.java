package BLL;

import DAL.DAL_thisinh;
import ENTITY.thisinh;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_thisinh {
    DAL_thisinh dal_thisinh;
    public BLL_thisinh(){
        dal_thisinh = new DAL_thisinh();
    }

    public ArrayList<thisinh> getAll(){
        String Where = "idthisinh like '%%'";
        String Order = "idthisinh ASC";
        return dal_thisinh.getAll(Where,Order);
    }

    public DefaultTableModel getAll_Table(ArrayList<thisinh> list){
        list = getAll();
        String[] cols = {"ID","Họ và tên","Giới tính","Địa chỉ","Số điện thoại","Trình độ"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for(thisinh t : list){
            Object[] row = {t.getIdthisinh(),t.getHoten(),t.getGioitinh(),t.getDiachi(),t.getSdt(),t.getTrinhdo()};
            model.addRow(row);
        }
        return model;
    }

    public boolean them(String idthisinh, String hoten, String gioitinh, String diachi, String sdt, String trinhdo){
        thisinh t = new thisinh(idthisinh,hoten,gioitinh,diachi,sdt,trinhdo);
        return dal_thisinh.insertThisinh(t);
    }

    public boolean sua(String hoten, String gioitinh, String diachi, String sdt, String trinhdo){
        ArrayList<thisinh> list = getAll();
        String idthisinh="";
        for (thisinh t : list){
            if (t.getHoten().equals(hoten)){
                idthisinh = t.getIdthisinh();
                break;
            }
        }
        thisinh t = new thisinh(idthisinh,hoten,gioitinh,diachi,sdt,trinhdo);
        return dal_thisinh.updateThisinh(t);
    }

    public boolean xoa(String hoten)
    {
        ArrayList<thisinh> list = getAll();
        String idthisinh="";
        for (thisinh t : list){
            if (t.getHoten().equals(hoten)){
                idthisinh = t.getIdthisinh();
                break;
            }
        }
        return dal_thisinh.deleteThisinh(idthisinh);
    }
}
