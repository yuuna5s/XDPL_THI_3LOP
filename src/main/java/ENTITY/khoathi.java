package ENTITY;

public class khoathi {
    String idkhoathi;
    String tenkhoathi;
    String ngaythi;

    public khoathi(String idkhoathi, String tenkhoathi, String ngaythi) {
        this.idkhoathi = idkhoathi;
        this.tenkhoathi = tenkhoathi;
        this.ngaythi = ngaythi;
    }

    public khoathi() {
    }

    public String getIdkhoathi() {
        return idkhoathi;
    }

    public void setIdkhoathi(String idkhoathi) {
        this.idkhoathi = idkhoathi;
    }

    public String getTenkhoathi() {
        return tenkhoathi;
    }

    public void setTenkhoathi(String tenkhoathi) {
        this.tenkhoathi = tenkhoathi;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }
}
