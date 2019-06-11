import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class OperationController extends AbstractController{

    @FXML
    Button createOperation;

    @FXML
    Button cancelOperation;


    @FXML
    DatePicker operationDate;

    @FXML
    ComboBox<String> operationType;

    @FXML
    TextField operationSum;

    @FXML
    TextField operationFrom;

    @FXML
    TextField operationWhere;

    @FXML
    ComboBox<String> operationCategory;

    @FXML
    TextArea operationDescription;


    @FXML
    String defVal1;

    @FXML
    String defVal2;

    @FXML
    public void createOperationPressed(){
        Stage stage = (Stage) createOperation.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelOperationPressed(){
        Stage stage = (Stage) cancelOperation.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initData() {
        operationDate.setValue(LocalDate.now());
        operationType.setValue(defVal1);
        operationSum.setText("1500");
        operationFrom.setText("Счет №1");
        operationWhere.setText("Счёт №4");
        operationCategory.setValue(defVal2);
        operationDescription.setText("Оплата транспортной карты");
    }
}
