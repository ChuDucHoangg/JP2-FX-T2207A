import javafx.scene.control.Button;

public class Phone {
    String name;
    String telephone;
    Button edit;

    public Phone(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            PhoneList.editPhoneNumber = this;
            PhoneList.stTelePhone.setText(this.telephone);
            PhoneList.stName.setText(this.name);
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String toString(){
        return  this.name;
    }
}
