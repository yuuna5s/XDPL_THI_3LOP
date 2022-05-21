package DAL;

import ENTITY.diem;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class DAL_diem extends DatabaseManager{
    String table = "diem";
    public DAL_diem() {
        super();
    }

    public ArrayList<diem> getAll() throws SQLException {
        ArrayList<diem> list = new ArrayList<>();
        String sql = "SELECT diem.idthisinh, diem.idkhoathi, thisinh.hoten, diem.nghe, diem.noi, diem.doc, diem.viet " +
                " FROM diem,thisinh, sobaodanh " +
                " Where diem.idthisinh = thisinh.idthisinh AND diem.idthisinh=sobaodanh.idthisinh ORDER BY diem.idthisinh ASC";
        ResultSet rs = statement.executeQuery(sql);
        try {
            while(rs.next())
            {
                diem diem = new diem();
                diem.setIdthisinh(rs.getString("idthisinh"));
                diem.setIdkhoathi(rs.getString("idkhoathi"));
                diem.setTenthisinh(rs.getString("hoten"));
                diem.setNghe(rs.getDouble("nghe"));
                diem.setNoi(rs.getDouble("noi"));
                diem.setDoc(rs.getDouble("doc"));
                diem.setViet(rs.getDouble("viet"));
                list.add(diem);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public ArrayList<diem> getdanhsach() throws SQLException {
        ArrayList<diem> list = new ArrayList<>();
        String sql = "SELECT sobaodanh.idthisinh, thisinh.hoten, phongthi.idkhoathi, diem.nghe, diem.noi, diem.doc, diem.viet " +
                " FROM diem,thisinh, sobaodanh, phongthi " +
                " Where sobaodanh.idthisinh = thisinh.idthisinh AND" +
                " sobaodanh.idphongthi = phongthi.idphongthi";
        ResultSet rs = statement.executeQuery(sql);
        try {
            diem diem = new diem();
            while(rs.next())
            {
                diem.setIdthisinh(rs.getString("idthisinh"));
                diem.setTenthisinh(rs.getString("hoten"));
                diem.setIdkhoathi(rs.getString("idkhoathi"));
                diem.setNghe(rs.getDouble("nghe"));
                diem.setNoi(rs.getDouble("noi"));
                diem.setDoc(rs.getDouble("doc"));
                diem.setViet(rs.getDouble("viet"));
                list.add(diem);
            }
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return list;
    }

    public boolean insertDiem(diem diem){
        String tablename = "diem";
        String[] columns = {"idthisinh", "idkhoathi", "nghe", "noi", "doc", "viet"};
        String[] values = {diem.getIdthisinh(), diem.getIdkhoathi(), String.valueOf(diem.getNghe()), String.valueOf(diem.getNoi()), String.valueOf(diem.getDoc()), String.valueOf(diem.getViet())};
        if (diem.getDoc() == 0 && diem.getNghe() == 0 && diem.getNoi() == 0 && diem.getViet() == 0) {
            try {
                String query = "INSERT INTO " + tablename + "(" + columns[0] + "," + columns[1] + "," + columns[2] + "," + columns[3] + "," + columns[4] + "," + columns[5] + ") VALUES(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, diem.getIdthisinh());
                preparedStatement.setString(2, diem.getIdkhoathi());
                preparedStatement.setNull(3, Types.DOUBLE);
                preparedStatement.setNull(4, Types.DOUBLE);
                preparedStatement.setNull(5, Types.DOUBLE);
                preparedStatement.setNull(6, Types.DOUBLE);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return insertRow(table, columns, values);
    }

    public boolean updateDiem(diem diem){
        String[] columns = {"idthisinh", "idkhoathi", "nghe", "noi", "doc", "viet"};
        String[] values = {diem.getIdthisinh(), diem.getIdkhoathi(), String.valueOf(diem.getNghe()), String.valueOf(diem.getNoi()), String.valueOf(diem.getDoc()), String.valueOf(diem.getViet())};
        String query = "UPDATE diem SET nghe = ?, noi = ?, doc = ?, viet = ? WHERE idthisinh = ? AND idkhoathi = ?";
        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, diem.getNghe());
            preparedStatement.setDouble(2, diem.getNoi());
            preparedStatement.setDouble(3, diem.getDoc());
            preparedStatement.setDouble(4, diem.getViet());
            preparedStatement.setString(6, diem.getIdthisinh().trim());
            preparedStatement.setString(5, diem.getIdkhoathi().trim());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean deleteDiem(diem diem){
        return deleteRow(table, "idthisinh = '" + diem.getIdthisinh() + "' AND idkhoathi = '" + diem.getIdkhoathi() + "'");
    }
}
