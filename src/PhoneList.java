import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class PhoneList implements Initializable {
    public TextField txtTelePhone;
    public TextField txtName;
    public static TextField stTelePhone;
    public static TextField stName;
    public Text txtInfo;
    public ObservableList<Phone> listPhoneNumber = FXCollections.observableArrayList();
    public static Phone editPhoneNumber;
//    public boolean tangdan = true;
    public TableView<Phone> tbview;
    public TableColumn<Phone, String> cFullName;
    public TableColumn<Phone, String> cTelePhone;
    public TableColumn<Phone, Button> cAction;


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
        tbview.setItems(listPhoneNumber);
        tbview.refresh();
        editPhoneNumber = null;
        clearInput();
    }
    void  clearInput(){
        txtName.clear();
        txtTelePhone.clear();
    }
    public void edit(MouseEvent mouseEvent) {
//        editPhoneNumber = lv.getSelectionModel().getSelectedItem();
        txtName.setText(editPhoneNumber.getName());
        txtTelePhone.setText(editPhoneNumber.getTelephone());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cFullName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cTelePhone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        stName = txtName;
        stTelePhone = txtTelePhone;
    }
//    public void sort(MouseEvent mouseEvent) {
//        if (tangdan) {
//            Collections.sort(listPhoneNumber, new Comparator<Phone>() {
//                @Override
//                public int compare(Phone o1, Phone o2) {
//                    return o1.name.compareTo(o2.name);
//                }
//            });
//        }else{
//            Collections.sort(listPhoneNumber, new Comparator<Phone>() {
//                @Override
//                public int compare(Phone o1, Phone o2) {
//                    return o2.name.compareTo(o1.name);
//                }
//            });
//        }
//        tangdan = !tangdan;
//    }

}
