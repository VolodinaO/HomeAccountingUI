import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController extends AbstractController{

    @FXML
    Button okRedactAccountButton;

    @FXML
    Button cancelRedactAccountButton;

    @FXML
    TextField accountName;

    @FXML
    TextArea accountDescription;

    @FXML
    TextField accountSum;


    @FXML
    public void redactAccountOkPress(){
        Stage stage = (Stage) okRedactAccountButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void redactAccountCancelPress(){
        Stage stage = (Stage) cancelRedactAccountButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initData() {
        accountName.setText("Счет №1");
        accountDescription.setText("Оплата транспортной карты");
        accountSum.setText("1500");
    }
}
