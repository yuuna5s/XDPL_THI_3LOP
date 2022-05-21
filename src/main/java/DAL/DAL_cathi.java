package DAL;

import ENTITY.cathi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAL_cathi extends DatabaseManager{
    String tablename = "cathi";
    public DAL_cathi() {
        ConnectDB();
    }

    public ArrayList<cathi> getAll(String Where, String Order) {
        ArrayList<cathi> list = new ArrayList<>();
        ResultSet rs = readTable(tablename, Where, Order);
        try {
            while (rs.next()) {
                cathi cathi = new cathi();
                cathi.setIdcathi(rs.getString("idcathi"));
                cathi.setGiothi(rs.getString("giothi"));
                list.add(cathi);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertCathi(cathi cathi) {
        String[] columns = {"idcathi", "giothi"};
        String[] values = {cathi.getIdcathi(), cathi.getGiothi()};
        return insertRow(tablename, columns, values);
    }

    public boolean updateCathi(cathi cathi) {
        String[] columns = {"idcathi", "giothi"};
        String[] values = {cathi.getIdcathi(), cathi.getGiothi()};
        return updateRow(tablename, columns, values, "idcathi= ' " + cathi.getIdcathi() + "'");
    }

    public boolean deleteCathi(String idcathi) {
        return deleteRow(tablename, "idcathi= '" + idcathi + "'");
    }
}
