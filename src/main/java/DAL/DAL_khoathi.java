package DAL;

import ENTITY.khoathi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_khoathi extends DatabaseManager {
    String tablename="khoathi";
    public DAL_khoathi() {
        ConnectDB();
    }

    public ArrayList<khoathi> getAll(String Where, String Order){
        ArrayList<khoathi> list = new ArrayList<>();
        ResultSet rs = readTable(tablename, Where, Order);
        try {
            while (rs.next()) {
                khoathi khoathi = new khoathi();
                khoathi.setIdkhoathi(rs.getString("idkhoathi"));
                khoathi.setTenkhoathi(rs.getString("tenkhoathi"));
                khoathi.setNgaythi(rs.getString("ngaythi"));
                list.add(khoathi);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertKhoathi(khoathi khoathi){
        String[] columns = {"idkhoathi","tenkhoathi","ngaythi"};
        String[] values = {khoathi.getIdkhoathi(),khoathi.getTenkhoathi(),khoathi.getNgaythi()};
        return insertRow(tablename,columns,values);
    }

    public boolean updateKhoathi(khoathi khoathi){
        String[] columns = {"idkhoathi","tenkhoathi","ngaythi"};
        String[] values = {khoathi.getIdkhoathi(),khoathi.getTenkhoathi(),khoathi.getNgaythi()};
        return updateRow(tablename,columns,values,"idkhoathi= '" + khoathi.getIdkhoathi() + "'");
    }

    public boolean deleteKhoathi(String idkhoathi){
        return deleteRow(tablename,"idkhoathi= '" + idkhoathi + "'");
    }
}
