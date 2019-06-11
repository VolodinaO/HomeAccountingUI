import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WizardController {

    private int screen = 1;

    @FXML
    Button backButton;

    @FXML
    Button forwardButton;

    @FXML
    Label firstLabel;

    @FXML
    Label secondLabel;

    @FXML
    Label thirdLabel;


    @FXML
    private void initialize() {
        backButton.setDisable(true);
    }

    @FXML
    public void backButtonPressed() {
        --screen;
        if (screen == 1) {
            backButton.setDisable(true);
            firstLabel.setText("Для начала работы создайте новый Счет.");
            secondLabel.setText("Для этого, укажите его Название, Описание и Баланс денежных средств.");
            thirdLabel.setText("После этого Вы сможете редактировать счет или удалить его, нажав на кнопки Изменить или Удалить, располагающиеся под блоком счетов.");
        }

        if (screen == 2) {
            firstLabel.setText("Теперь вы можете работать с операциями. Для начала создайте одну.");
            secondLabel.setText("Для этого, укажите Метку времени, Тип (Приход, Расход, Перевод), Значение (всегда положительное), " +
                    "С какого счёта, На какой счёт, Категорию (Расходная или Приходная), Описание операции.");
            thirdLabel.setText("После этого Вы сможете редактировать операции или удалять их, нажав на кнопки Изменить или Удалить, располагающиеся под блоком операций.");
        }
    }

    @FXML
    public void forwardButtonPressed() {

        backButton.setDisable(false);
        ++screen;
        if (screen == 2) {
            firstLabel.setText("Теперь вы можете работать с операциями. Для начала создайте одну.");
            secondLabel.setText("Для этого, укажите Метку времени, Тип (Приход, Расход, Перевод), Значение (всегда положительное), " +
                    "С какого счёта, На какой счёт, Категорию (Расходная или Приходная), Описание операции.");
            thirdLabel.setText("После этого Вы сможете редактировать операции или удалять их, нажав на кнопки Изменить или Удалить, располагающиеся под блоком операций.");
        }
        if (screen == 3) {
            firstLabel.setText("Во вкладке Категории можно пронаблюдать общую картину по Категории приходов и Категории расходов для счетов.");
            secondLabel.setText("Для того, чтобы создать Категорию, необходимо указать Название счета, Сумму и Тип категории (Расходная или Приходная).");
            thirdLabel.setText("После этого Вы сможете редактировать категории или удалять их, нажав на кнопки Изменить или Удалить, располагающиеся под блоком категорий.");
            forwardButton.setText("Закрыть");
        }
        if (screen == 4) {
            Stage stage = (Stage) forwardButton.getScene().getWindow();
            stage.close();
        }
    }

}
