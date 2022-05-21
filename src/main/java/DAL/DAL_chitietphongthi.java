package DAL;

import ENTITY.chitietphongthi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_chitietphongthi extends DatabaseManager{
    public DAL_chitietphongthi() {
        super();
    }

    public ArrayList<chitietphongthi> getALL(String idphongthi){
        ResultSet rs = null;
        ArrayList<chitietphongthi> list = new ArrayList<>();
        String sql = "SELECT sobaodanh.idphongthi,phongthi.idtrinhdo,phongthi.idkhoathi,phongthi.idcathi,sobaodanh.idthisinh,sobaodanh.sbd,hoten" + " "
                + "FROM sobaodanh,phongthi,thisinh" + " "
                + "WHERE sobaodanh.idphongthi = phongthi.idphongthi AND sobaodanh.idthisinh = thisinh.idthisinh AND sobaodanh.idphongthi = " + "'" + idphongthi + "'" + "ORDER BY sobaodanh.idphongthi";
        try {
            System.out.println(sql);
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.err.println("Error: " + throwables.getMessage());
            throwables.printStackTrace();
        }
        try {
            while (rs.next()) {
                chitietphongthi ct = new chitietphongthi();
                ct.setIdphongthi(rs.getString("idphongthi"));
                ct.setIdtrinhdo(rs.getString("idtrinhdo"));
                ct.setIdkhoathi(rs.getString("idkhoathi"));
                ct.setIdcathi(rs.getString("idcathi"));
                ct.setIdthisinh(rs.getString("idthisinh"));
                ct.setSbd(rs.getString("sbd"));
                ct.setTenthisinh(rs.getString("hoten"));
                list.add(ct);
            }
        } catch (SQLException throwables) {
            System.err.println("Error: " + throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }
}
