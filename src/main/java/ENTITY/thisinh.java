package ENTITY;

public class thisinh {
    String idthisinh;
    String hoten;
    String gioitinh;
    String diachi;
    String sdt;
    String trinhdo;

    public thisinh(String idthisinh, String hoten, String gioitinh, String diachi, String sdt, String trinhdo) {
        this.idthisinh = idthisinh;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.trinhdo = trinhdo;
    }

    public thisinh() {
    }

    public String getIdthisinh() {
        return idthisinh;
    }

    public void setIdthisinh(String idthisinh) {
        this.idthisinh = idthisinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
