import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryController extends AbstractController{
    @FXML
    Button createCategoryButton;

    @FXML
    Button cancelCategoryButton;

    @FXML
    TextField nameField;

    @FXML
    TextField sumField;

    @FXML
    ComboBox<String> typeBox;

    @FXML
    String defVal3;

    @FXML
    public void createCategoryButtonPressed(){
        Stage stage = (Stage) createCategoryButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelCategoryButtonPressed(){
        Stage stage = (Stage) cancelCategoryButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initData() {
        nameField.setText("Счет №1");
        sumField.setText("2500");
        typeBox.setValue(defVal3);
    }
}
