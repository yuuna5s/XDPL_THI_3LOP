package BLL;

import DAL.DAL_cathi;
import ENTITY.cathi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BLL_cathi {
    DAL_cathi dal_cathi;
    public BLL_cathi(){
        dal_cathi = new DAL_cathi();
    }

    public ArrayList<cathi> getALL(){
        String WHERE = "idcathi like '%%'";
        String Order = "idcathi ASC";
        return dal_cathi.getAll(WHERE, Order);
    }

    public DefaultTableModel getALL_Table(ArrayList<cathi> list){
        String[] cols = {"ID ca thi","Giờ thi"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(cols);
        for(int i=0; i<list.size(); i++){
            model.addRow(new Object[]{
                list.get(i).getIdcathi(),
                list.get(i).getGiothi()
            });
        }
        return model;
    }

    public boolean insert(String idcathi, String giothi){
        cathi c = new cathi(idcathi, giothi);
        return dal_cathi.insertCathi(c);
    }

    public boolean update(String idcathi, String giothi){
        cathi c = new cathi(idcathi, giothi);
        return dal_cathi.updateCathi(c);
    }

    public boolean delete(String idcathi){
        return dal_cathi.deleteCathi(idcathi);
    }

    public boolean checkID(String idcathi){
        ArrayList<cathi> list = getALL();
        for (cathi c : list) {
            if (c.getIdcathi().equals(idcathi)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIDexcept(String idcathi, String idcathi_old){
        ArrayList<cathi> list = getALL();
        for (cathi c : list) {
            if (c.getIdcathi().equals(idcathi) && !c.getIdcathi().equals(idcathi_old)) {
                return false;
            }
        }
        return true;
    }

    public DefaultComboBoxModel getAll_ComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<cathi> list = getALL();
        for (cathi c : list) {
            model.addElement(c.getIdcathi());
        }
        return model;
    }
}
