package BLL;

import DAL.DAL_diem;
import DAL.DAL_phongthi;
import DAL.DAL_sobaodanh;
import DAL.DAL_thisinh;
import ENTITY.diem;
import ENTITY.phongthi;
import ENTITY.sobaodanh;
import ENTITY.thisinh;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_phongthi {
    DAL_phongthi dal_phongthi;
    public BLL_phongthi(){
        dal_phongthi = new DAL_phongthi();
    }

    public ArrayList<phongthi> getAll(){
        String Where = "idphongthi like '%%'";
        String Order = "idphongthi ASC";
        return dal_phongthi.getAll(Where, Order);
    }

    public DefaultTableModel getAll_Table(ArrayList<phongthi> list){
        String[] header = {"Mã phòng thi", "Tên phòng thi", "Trình độ", "Khóa thi", "Ca thi"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(header);
        Object[] row = new Object[header.length];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getIdphongthi();
            row[1] = list.get(i).getTenphongthi();
            row[2] = list.get(i).getIdtrinhdo();
            row[3] = list.get(i).getIdkhoathi();
            row[4] = list.get(i).getIdcathi();
            model.addRow(row);
        }
        return model;
    }

    public boolean them(String idphongthi, String tenphongthi, String idtrinhdo, String idkhoathi, String idcathi){
        phongthi phongthi = new phongthi(idphongthi, tenphongthi, idtrinhdo, idkhoathi, idcathi);
        return dal_phongthi.insertRow(phongthi);
    }

    public boolean xepphongthi(String idphongthi, String idtrinhdo, String idkhoathi){
        DAL_thisinh dal_thisinh = new DAL_thisinh();
        DAL_diem dal_diem = new DAL_diem();
        String Where = "idthisinh like '%%'";
        String Order = "idthisinh ASC";
        ArrayList<thisinh> list = dal_thisinh.getAll(Where, Order);
        ArrayList<thisinh> thisinhdacosbd = new ArrayList<>();
        DAL_sobaodanh dal_sobaodanh = new DAL_sobaodanh();
        Where = "sbd like '%%'";
        Order = "sbd ASC";
        ArrayList<sobaodanh> danhsanhthisinhcosbd = dal_sobaodanh.getAll(Where, Order);

        String startid = "";
        int startid_num = 1;
        int count=0;
        if (danhsanhthisinhcosbd.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < danhsanhthisinhcosbd.size(); j++) {
                    if (list.get(i).getIdthisinh().equals(danhsanhthisinhcosbd.get(j).getIdthisinh())){
                        thisinhdacosbd.add(list.get(i));
                    }
                }
                if (list.get(i).getIdthisinh().equals(startid)){
                    continue;
                }
                else if (list.get(i).getTrinhdo().equals(idtrinhdo)){
                    String sbd =  idtrinhdo + String.format("%03d", startid_num);
                    danhsanhthisinhcosbd.add(new sobaodanh(sbd, list.get(i).getIdthisinh(), idphongthi));
                    thisinhdacosbd.add(list.get(i));
                    xepphongthi_sbd(sbd, list.get(i).getIdthisinh(), idphongthi);
                    diem d = new diem(list.get(i).getIdthisinh(),idkhoathi,list.get(i).getHoten(),0d,0d,0d,0d);
                    dal_diem.insertDiem(d);
                    count++;
                    startid_num++;
                    if (count == 10){
                        break;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTrinhdo().equals(idtrinhdo)) {
                    String sbd = idtrinhdo + String.format("%03d", startid_num);
                    danhsanhthisinhcosbd.add(new sobaodanh(sbd, list.get(i).getIdthisinh(), idphongthi));
                    thisinhdacosbd.add(list.get(i));
                    xepphongthi_sbd(sbd, list.get(i).getIdthisinh(), idphongthi);
                    diem d = new diem(list.get(i).getIdthisinh(),idkhoathi,list.get(i).getHoten(),0d,0d,0d,0d);
                    dal_diem.insertDiem(d);
                    if (thisinhdacosbd.size()==10) break;
                    startid_num++;
                }
                else
                    continue;
            }
        }
        return true;
    }

    public boolean xepphongthi_sbd(String sbd, String idthisinh, String idphongthi){
        DAL_sobaodanh dal_sobaodanh = new DAL_sobaodanh();
        sobaodanh ts = new sobaodanh(sbd, idthisinh, idphongthi);
        return dal_sobaodanh.insertSobaodanh(ts);
    }
}
