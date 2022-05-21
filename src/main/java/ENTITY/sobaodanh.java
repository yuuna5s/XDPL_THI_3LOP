package ENTITY;

public class sobaodanh {
    String sbd;
    String idthisinh;
    String idphongthi;

    public sobaodanh(String sbd, String idthisinh, String idphongthi) {
        this.sbd = sbd;
        this.idthisinh = idthisinh;
        this.idphongthi = idphongthi;
    }

    public sobaodanh() {
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getIdthisinh() {
        return idthisinh;
    }

    public void setIdthisinh(String idthisinh) {
        this.idthisinh = idthisinh;
    }

    public String getIdphongthi() {
        return idphongthi;
    }

    public void setIdphongthi(String idphongthi) {
        this.idphongthi = idphongthi;
    }
}
