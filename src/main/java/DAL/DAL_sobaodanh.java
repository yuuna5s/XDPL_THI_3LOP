package DAL;

import ENTITY.sobaodanh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_sobaodanh extends DatabaseManager {
    String table = "sobaodanh";
    public DAL_sobaodanh() {
        super();
    }

    public ArrayList<sobaodanh> getAll(String Where, String Order) {
        ArrayList<sobaodanh> list = new ArrayList<>();
        ResultSet rs = readTable(table, Where, Order);
        try {
            while (rs.next()) {
                sobaodanh sobaodanh = new sobaodanh();
                sobaodanh.setSbd(rs.getString("sbd"));
                sobaodanh.setIdthisinh(rs.getString("idthisinh"));
                sobaodanh.setIdphongthi(rs.getString("idphongthi"));
                list.add(sobaodanh);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertSobaodanh(sobaodanh sobaodanh) {
        String[] columns = {"sbd", "idthisinh", "idphongthi"};
        String[] values = {sobaodanh.getSbd(), sobaodanh.getIdthisinh(), sobaodanh.getIdphongthi()};
        return insertRow(table, columns, values);
    }

    public boolean updateSobaodanh(sobaodanh sobaodanh) {
        String[] columns = {"sbd", "idthisinh", "idphongthi"};
        String[] values = {sobaodanh.getSbd(), sobaodanh.getIdthisinh(), sobaodanh.getIdphongthi()};
        return updateRow(table, columns, values, "sbd= '"+sobaodanh.getSbd()+"'");
    }

    public boolean deleteSobaodanh(String sbd) {
        return deleteRow(table, "sbd= '"+sbd+"'");
    }
}
