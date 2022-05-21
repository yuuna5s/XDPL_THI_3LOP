package DAL;

import ENTITY.phongthi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_phongthi extends DatabaseManager{
    String table = "phongthi";
    public DAL_phongthi() {
        ConnectDB();
    }

    public ArrayList<phongthi> getAll(String Where, String Order) {
        ArrayList<phongthi> list = new ArrayList<>();
        ResultSet rs = readTable(table, Where, Order);
        try {
            while (rs.next()) {
                phongthi phongthi = new phongthi();
                phongthi.setIdphongthi(rs.getString("idphongthi"));
                phongthi.setTenphongthi(rs.getString("tenphongthi"));
                phongthi.setIdtrinhdo(rs.getString("idtrinhdo"));
                phongthi.setIdkhoathi(rs.getString("idkhoathi"));
                phongthi.setIdcathi(rs.getString("idcathi"));
                list.add(phongthi);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables);
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertRow(phongthi phongthi) {
        String[] columns = {"idphongthi", "tenphongthi", "idtrinhdo", "idkhoathi", "idcathi"};
        String[] values = {phongthi.getIdphongthi(), phongthi.getTenphongthi(), phongthi.getIdtrinhdo(), phongthi.getIdkhoathi(), phongthi.getIdcathi()};
        return insertRow(table, columns, values);
    }

    public boolean updateRow(phongthi phongthi) {
        String[] columns = {"tenphongthi", "idtrinhdo", "idkhoathi", "idcathi"};
        String[] values = {phongthi.getTenphongthi(), phongthi.getIdtrinhdo(), phongthi.getIdkhoathi(), phongthi.getIdcathi()};
        return updateRow(table, columns, values, "idphongthi= '"+ phongthi.getIdphongthi()+"'");
    }

    public boolean deleteRow(String idphongthi) {
        return deleteRow(table, "idphongthi= '"+ idphongthi+"'");
    }
}
