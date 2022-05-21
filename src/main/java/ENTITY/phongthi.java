package ENTITY;

public class phongthi {
    String idphongthi;
    String tenphongthi;
    String idtrinhdo;
    String idkhoathi;
    String idcathi;

    public phongthi(String idphongthi, String tenphongthi, String idtrinhdo, String idkhoathi, String idcathi) {
        this.idphongthi = idphongthi;
        this.tenphongthi = tenphongthi;
        this.idtrinhdo = idtrinhdo;
        this.idkhoathi = idkhoathi;
        this.idcathi = idcathi;
    }

    public phongthi() {
    }

    public String getIdphongthi() {
        return idphongthi;
    }

    public void setIdphongthi(String idphongthi) {
        this.idphongthi = idphongthi;
    }

    public String getTenphongthi() {
        return tenphongthi;
    }

    public void setTenphongthi(String tenphongthi) {
        this.tenphongthi = tenphongthi;
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

    public String getIdcathi() {
        return idcathi;
    }

    public void setIdcathi(String idcathi) {
        this.idcathi = idcathi;
    }
}
