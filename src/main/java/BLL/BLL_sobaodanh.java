package BLL;

import DAL.DAL_sobaodanh;
import ENTITY.sobaodanh;

public class BLL_sobaodanh{
    DAL_sobaodanh dal_sobaodanh;

    public BLL_sobaodanh() {
        dal_sobaodanh = new DAL_sobaodanh();
    }

    public boolean insert_sobaodanh(String sbd, String idthisinh, String idphongthi) {
        sobaodanh s = new sobaodanh(sbd, idthisinh, idphongthi);
        return dal_sobaodanh.insertSobaodanh(s);
    }


}
