package ENTITY;

public class chitietphongthi {
    String idphongthi;
    String idtrinhdo;
    String idkhoathi;
    String idcathi;
    String idthisinh;
    String sbd;
    String tenthisinh;

    public chitietphongthi() {
    }

    public chitietphongthi(String idphongthi, String idtrinhdo, String idkhoathi, String idcathi, String idthisinh, String sbd, String tenthisinh) {
        this.idphongthi = idphongthi;
        this.idtrinhdo = idtrinhdo;
        this.idkhoathi = idkhoathi;
        this.idcathi = idcathi;
        this.idthisinh = idthisinh;
        this.sbd = sbd;
        this.tenthisinh = tenthisinh;
    }

    public String getIdphongthi() {
        return idphongthi;
    }

    public void setIdphongthi(String idphongthi) {
        this.idphongthi = idphongthi;
    }

    public String getIdtrinhdo() {
        return idtrinhdo;
    }

    public void setIdtrinhdo(String idtrinhdo) {
        this.idtrinhdo = idtrinhdo;
    }

    public String getIdkhoathi() {
        return idkhoathi;
    }

    public void setIdkhoathi(String idkhoathi) {
        this.idkhoathi = idkhoathi;
    }

    public String getIdthisinh() {
        return idthisinh;
    }

    public void setIdthisinh(String idthisinh) {
        this.idthisinh = idthisinh;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getTenthisinh() {
        return tenthisinh;
    }

    public void setTenthisinh(String tenthisinh) {
        this.tenthisinh = tenthisinh;
    }

    public String getIdcathi() {
        return idcathi;
    }

    public void setIdcathi(String idcathi) {
        this.idcathi = idcathi;
    }
}
