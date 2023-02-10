import javafx.scene.control.Button;

public class Student {
    String fullName;
    String email;
    Button edit;

    public Student(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            ThongTin.editStudent = this;
            ThongTin.stFullName.setText(this.fullName);
            ThongTin.stEmail.setText(this.email);
        });
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String toString(){
        return this.fullName+ "--" +this.email;
    }
}
