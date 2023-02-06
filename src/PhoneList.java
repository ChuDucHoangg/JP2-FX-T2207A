import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.Comparator;

public class PhoneList {
    public TextField txtTelePhone;
    public TextField txtName;
    public Text txtInfo;
    public ObservableList<Phone> listPhoneNumber = FXCollections.observableArrayList();
    public ListView<Phone> lv;
    public Phone editPhoneNumber;
    public boolean tangdan = true;


    public void submit(ActionEvent actionEvent) {
        String na = txtName.getText();
        String ph = txtTelePhone.getText();

        if(editPhoneNumber == null){
            Phone p = new Phone(na, ph);
            listPhoneNumber.add(p);
        }else{
            for(Phone p: listPhoneNumber){
                if(p.telephone.equals(editPhoneNumber.telephone) && p.name.equals(editPhoneNumber.name)){
                    p.setName(na);
                    p.setTelephone(ph);
                }
            }
        }
        lv.setItems(listPhoneNumber);
        lv.refresh();
        editPhoneNumber = null;
        clearInput();
    }
    void  clearInput(){
        txtName.clear();
        txtTelePhone.clear();
    }
    public void edit(MouseEvent mouseEvent) {
        editPhoneNumber = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editPhoneNumber.getName());
        txtTelePhone.setText(editPhoneNumber.getTelephone());
    }
    public void sort(MouseEvent mouseEvent) {
        if (tangdan) {
            Collections.sort(listPhoneNumber, new Comparator<Phone>() {
                @Override
                public int compare(Phone o1, Phone o2) {
                    return o1.name.compareTo(o2.name);
                }
            });
        }else{
            Collections.sort(listPhoneNumber, new Comparator<Phone>() {
                @Override
                public int compare(Phone o1, Phone o2) {
                    return o2.name.compareTo(o1.name);
                }
            });
        }
        tangdan = !tangdan;
    }
}
