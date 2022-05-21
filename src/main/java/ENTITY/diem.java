package ENTITY;

public class diem {
    String idthisinh;
    String idkhoathi;
    String tenthisinh;
    double nghe, noi, doc, viet;

    public diem(String idthisinh, String idkhoathi, String tenthisinh, double nghe, double noi, double doc, double viet) {
        this.idthisinh = idthisinh;
        this.idkhoathi = idkhoathi;
        this.tenthisinh = tenthisinh;
        this.nghe = nghe;
        this.noi = noi;
        this.doc = doc;
        this.viet = viet;
    }

    public diem() {
    }

    public String getIdthisinh() {
        return idthisinh;
    }

    public void setIdthisinh(String idthisinh) {
        this.idthisinh = idthisinh;
    }

    public String getIdkhoathi() {
        return idkhoathi;
    }

    public void setIdkhoathi(String idkhoathi) {
        this.idkhoathi = idkhoathi;
    }

    public double getNghe() {
        return nghe;
    }

    public void setNghe(double nghe) {
        this.nghe = nghe;
    }

    public double getNoi() {
        return noi;
    }

    public void setNoi(double noi) {
        this.noi = noi;
    }

    public double getDoc() {
        return doc;
    }

    public void setDoc(double doc) {
        this.doc = doc;
    }

    public double getViet() {
        return viet;
    }

    public void setViet(double viet) {
        this.viet = viet;
    }


    public String getTenthisinh() {
        return tenthisinh;
    }

    public void setTenthisinh(String tenthisinh) {
        this.tenthisinh = tenthisinh;
    }
}
