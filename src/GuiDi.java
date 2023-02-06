import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GuiDi {
    public TextField txtuser;
    public TextField txtdetai;
    public TextArea txacontent;
    public Text txtmenu;

    public void submit(ActionEvent actionEvent) {
        String fu = txtuser.getText();
        String dt = txtdetai.getText();
        String ct = txacontent.getText();
        String txt = txtmenu.getText();
        txt += "\n_______________";
        txt += "\n" +fu+ "/" + ""+dt;
        txt += "\n" +ct;
        txtmenu.setText(txt);
    }
}
