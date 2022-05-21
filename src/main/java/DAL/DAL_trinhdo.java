package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ENTITY.trinhdo;

public class DAL_trinhdo extends DatabaseManager {
    String tablename = "trinhdo";
    public DAL_trinhdo() {
        ConnectDB();
    }

    public ArrayList<trinhdo> getAll (String Where, String Order){
        ArrayList<trinhdo> list = new ArrayList<trinhdo>();
        ResultSet rs = readTable(tablename, Where, Order);
        try {
            while (rs.next()) {
                trinhdo trinhdo = new trinhdo();
                trinhdo.setIdtrinhdo(rs.getString("idtrinhdo"));
                trinhdo.setTentrinhdo(rs.getString("tentrinhdo"));
                list.add(trinhdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertTrinhdo(trinhdo trinhdo) {
        String[] columns = {"idtrinhdo", "tentrinhdo"};
        String[] values = {trinhdo.getIdtrinhdo(), trinhdo.getTentrinhdo()};
        return insertRow(tablename, columns, values);
    }

    public boolean updateTrinhdo(trinhdo trinhdo) {
        String[] columns = {"idtrinhdo", "tentrinhdo"};
        String[] values = {trinhdo.getIdtrinhdo(), trinhdo.getTentrinhdo()};
        return updateRow(tablename, columns, values, "idtrinhdo = '" + trinhdo.getIdtrinhdo() + "'");
    }

    public boolean deleteTrinhdo(String idtrinhdo) {
        return deleteRow(tablename, "idtrinhdo = '" + idtrinhdo + "'");
    }
}
