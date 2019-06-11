import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Account;
import model.Category;
import model.Operation;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class IndexController extends Application {

    private Stage primaryStage;
    private VBox rootLayout;

    @FXML
    Button addAccount;

    @FXML
    Button delAccount;

    @FXML
    Button redactAccount;

    @FXML
    Button addOperation;

    @FXML
    Button delOperation;

    @FXML
    Button redactOperation;

    @FXML
    Button addCategory;

    @FXML
    Button redactCategory;

    @FXML
    Button delCategory;

    @FXML
    MenuItem helpItem;

    @FXML
    TableView<Account> accountTable;

    @FXML
    TableColumn<Account, String> accountCol;

    @FXML
    TableColumn<Account, String> accountDescriptionCol;

    @FXML
    TableColumn<Account, String> accountSumCol;

    @FXML
    TableView<Operation> operationTable;

    @FXML
    TableColumn<Operation, String> dateCol;

    @FXML
    TableColumn<Operation, String> typeCol;

    @FXML
    TableColumn<Operation, String> sumCol;

    @FXML
    TableColumn<Operation, String> fromCol;

    @FXML
    TableColumn<Operation, String> whereCol;

    @FXML
    TableColumn<Operation, String> catCol;

    @FXML
    TableColumn<Operation, String> descrCol;


    @FXML
    TabPane tabPane;

    @FXML
    Tab dashboardTab;

    @FXML
    Tab accountsTab;

    @FXML
    Tab categoryTab;

    @FXML
    Label accountsLink;

    @FXML
    Label categoriesLink;

    @FXML
    PieChart dashboardChart;

    @FXML
    TableView<Category> categoryTable;

    @FXML
    TableColumn<Category, String> catTypeCol;

    @FXML
    TableColumn<Category, String> catNameCol;

    @FXML
    TableColumn<Category, String> catSumCol;

    @FXML
    ImageView help1;

    @FXML
    ImageView help2;

    @FXML
    ImageView help3;

    @FXML
    public void help1Pressed(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(null);
        alert.setContentText("Текст о том, как вести счета");

        alert.showAndWait();
    }

    @FXML
    public void help2Pressed(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(null);
        alert.setContentText("Текст о том, как вести операции");

        alert.showAndWait();
    }

    @FXML
    public void help3Pressed(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(null);
        alert.setContentText("Текст о том, как вести категории.");

        alert.showAndWait();
    }


    private ObservableList<Account> accountsData = FXCollections.observableArrayList();

    private ObservableList<Operation> operationsData = FXCollections.observableArrayList();

    private ObservableList<Category> categoriesData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Домашняя бухгалтерия");
        this.primaryStage.setMinHeight(550.0);
        this.primaryStage.setMinWidth(950.0);
        initRootLayout();
    }

    public Image loadPhoto(String photoName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(photoName).getFile());
        Image image = new Image(file.toURI().toString());
        return image;
    }

    @FXML
    private void initialize() {
        initTable0();
        initTable1();
        initTable2();
        initPieChart();

        help1.setImage(loadPhoto("help.png"));
        help2.setImage(loadPhoto("help.png"));
        help3.setImage(loadPhoto("help.png"));

        dateCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        typeCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        sumCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        fromCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        whereCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        catCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));
        descrCol.prefWidthProperty().bind(operationTable.widthProperty().divide(7));

        accountCol.prefWidthProperty().bind(accountTable.widthProperty().divide(3));
        accountDescriptionCol.prefWidthProperty().bind(accountTable.widthProperty().divide(3));
        accountSumCol.prefWidthProperty().bind(accountTable.widthProperty().divide(3));

        catTypeCol.prefWidthProperty().bind(categoryTable.widthProperty().divide(3));
        catSumCol.prefWidthProperty().bind(categoryTable.widthProperty().divide(3));
        catNameCol.prefWidthProperty().bind(categoryTable.widthProperty().divide(3));

        helpItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Parent root;
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SimpleWizard.fxml"));
                    root = (Parent)fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("О программе Домашняя бухгалтерия");
                    stage.setScene(new Scene(root, 610, 160));
                    stage.setResizable(false);
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void initTable0(){
        initTable0Data();
        accountCol.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
        accountDescriptionCol.setCellValueFactory(new PropertyValueFactory<Account, String>("description"));
        accountSumCol.setCellValueFactory(new PropertyValueFactory<Account, String>("sum"));
        accountTable.setItems(accountsData);
    }

    private void initTable0Data(){
        accountsData.add(new Account("Счет №1", "Зарплата", "22200"));
        accountsData.add(new Account("Счет №2", "Транспортные расходы", "11100"));
        accountsData.add(new Account("Счет №3", "Вторая работа", "5500"));
        accountsData.add(new Account("Счет №4", "Копилка", "2500"));
    }

    private void initTable1(){
        initTable1Data();
        dateCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("date"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("type"));
        sumCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("sum"));
        fromCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("from"));
        whereCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("where"));
        catCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("category"));
        descrCol.setCellValueFactory(new PropertyValueFactory<Operation, String>("description"));
        operationTable.setItems(operationsData);
    }

    private void initTable1Data(){
        operationsData.add(new Operation("11.01.2019", "Перевод", "2500", "Счет №2", "Счет №1", "Расход", "Траспортная карта"));
        operationsData.add(new Operation("02.02.2019", "Расход", "2500", "Счет №4", "Счет №1", "Расход", "Оплата бензина"));
        operationsData.add(new Operation("03.03.2019", "Приход", "2500", "Счет №3", "Счет №1", "Приход", "Зарплата"));
        operationsData.add(new Operation("04.04.2019", "Приход", "2500", "Счет №3", "Счет №1", "Приход", "Подарок на день рождения"));
        operationsData.add(new Operation("05.05.2019", "Расход", "2500", "Счет №2", "Счет №1", "Расход", "Оплата штрафов"));
    }

    private void initTable2(){
        initTable2Data();
        catNameCol.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        catSumCol.setCellValueFactory(new PropertyValueFactory<Category, String>("sum"));
        catTypeCol.setCellValueFactory(new PropertyValueFactory<Category, String>("type"));
        categoryTable.setItems(categoriesData);
    }

    private void initTable2Data(){
        categoriesData.add(new Category("Счёт №1", "2500", "Расход"));
        categoriesData.add(new Category("Счет №2", "2500", "Расход"));
        categoriesData.add(new Category("Счет №1", "2500", "Расход"));
        categoriesData.add(new Category("Счет №2", "2500", "Приход"));
        categoriesData.add(new Category("Счет №3", "2500", "Расход"));
        categoriesData.add(new Category("Счет №1", "2500", "Приход"));
        categoriesData.add(new Category("Счет №1", "2500", "Приход"));
        categoriesData.add(new Category("Счет №1", "2500", "Расход"));
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(IndexController.class.getResource("index.fxml"));
            rootLayout = (VBox) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initPieChart(){
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Доходы", 13),
                        new PieChart.Data("Расходы", 25),
                        new PieChart.Data("Переводы", 10));
        dashboardChart.setData(pieChartData);
        dashboardChart.setLegendSide(Side.LEFT);
    }

    @FXML
    public void accountsLinkPressed(){
        selectTab(1);
    }

    @FXML
    public void categoriesLinkPressed(){
        selectTab(2);
    }

    public void selectTab(int tabId){
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(tabId);
    }

    @FXML
    public void addAccountPress(){
        openWindow("RedactAccount.fxml", "Account", 560, 260, false, false);
    }

    @FXML
    public void redactAccountPress(){
        openWindow("RedactAccount.fxml", "Account", 560, 260, false, true);
    }

    @FXML
    public void delAccountPress(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Удаление счета");
        alert.setContentText("Вы уверены, что хотите удалить Счет №***?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }


    @FXML
    public void addOperaionPress(){
        openWindow("CreateOperation.fxml", "Operation", 560, 430, false, false);
    }

    @FXML
    public void delOperationPress(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Удаление операции");
        alert.setContentText("Вы уверены, что хотите удалить данную операцию ***?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    public void redactOperationPress(){
        openWindow("CreateOperation.fxml", "Operation", 560, 430, false, true);
    }


    @FXML
    public void addCategoryPress(){
        openWindow("RedactCategory.fxml", "Category", 220, 150, false, false);
    }

    @FXML
    public void delCategoryPress(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("Удаление категории");
        alert.setContentText("Вы уверены, что хотите удалить категорию ***?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    public void redactCategoryPress(){
        openWindow("RedactCategory.fxml", "Category", 220, 150, false, true);
    }

    private void openWindow(String fileName, String title, int width, int height, boolean resizable, final boolean isRedact){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fileName));
            root = (Parent)fxmlLoader.load();
            final AbstractController controller = fxmlLoader.<AbstractController>getController();
            Stage stage = new Stage();
            stage.addEventHandler(WindowEvent.WINDOW_SHOWING, new  EventHandler<WindowEvent>()
            {
                public void handle(WindowEvent window)
                {
                    if(isRedact) {
                        controller.initData();
                    }
                }
            });
            stage.setTitle(title);
            stage.setScene(new Scene(root, width, height));
            stage.setResizable(resizable);
            stage.show();
            // Hide this current window (if this is what you want)
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        launch(args);
    }
}
