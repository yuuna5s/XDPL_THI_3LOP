package DAL;

import ENTITY.thisinh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_thisinh extends DatabaseManager {
    String tablename = "thisinh";
    public DAL_thisinh() {
        ConnectDB();
    }

    public ArrayList<thisinh> getAll (String Where, String Order) {
        ArrayList<thisinh> list = new ArrayList<>();
        ResultSet rs = readTable(tablename, Where, Order);
        try {
            while (rs.next()) {
                thisinh thisinh = new thisinh();
                thisinh.setIdthisinh(rs.getString("idthisinh"));
                thisinh.setHoten(rs.getString("hoten"));
                thisinh.setGioitinh(rs.getString("gioitinh"));
                thisinh.setDiachi(rs.getString("diachi"));
                thisinh.setSdt(rs.getString("sdt"));
                thisinh.setTrinhdo(rs.getString("idtrinhdo"));
                list.add(thisinh);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertThisinh(thisinh thisinh) {
        String[] columns = {"idthisinh", "hoten", "gioitinh", "diachi", "sdt","idtrinhdo"};
        String[] values = {thisinh.getIdthisinh(), thisinh.getHoten(), thisinh.getGioitinh(), thisinh.getDiachi(), thisinh.getSdt(), thisinh.getTrinhdo()};
        return insertRow(tablename, columns, values);
    }

    public boolean updateThisinh(thisinh thisinh) {
        String[] columns = {"hoten", "gioitinh", "diachi", "sdt","idtrinhdo"};
        String[] values = {thisinh.getHoten(), thisinh.getGioitinh(), thisinh.getDiachi(), thisinh.getSdt(), thisinh.getTrinhdo()};
        return updateRow(tablename, columns, values, "idthisinh = '"+ thisinh.getIdthisinh()+ "'");
    }

    public boolean deleteThisinh(String idthisinh) {
        return deleteRow(tablename, "idthisinh = '"+ idthisinh+ "'");
    }
}
