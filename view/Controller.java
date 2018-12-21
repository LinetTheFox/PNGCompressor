package PNGCompressor.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import PNGCompressor.model.Compression;
import PNGCompressor.model.tableData;

import java.io.File;

public class Controller {
    @FXML
    protected CheckBox pngCheck, gifCheck;
    @FXML
    protected TableView<tableData> table;
    @FXML
    protected TableColumn<tableData, String> imgNameCol;
    @FXML
    protected TableColumn<tableData, Long> origSizeCol, pngSizeCol, pngTimeCol, gifSizeCol, gifTimeCol;
    @FXML
    protected TableColumn<tableData, Double> pngEffCol, gifEffCol;

    private static Stage mainStage;

    public static void getStage(Stage st) {
        mainStage = st;
    }

    private ObservableList<tableData> tableValuesList = FXCollections.observableArrayList();

    @FXML
    public void handleCompression() {
        Dialogs dialogs = new Dialogs();
        File file = dialogs.FileChooserDialog(mainStage);
        tableValuesList.add(Compression.compression(file, gifCheck.isSelected(), pngCheck.isSelected()));
        imgNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        origSizeCol.setCellValueFactory(new PropertyValueFactory<>("origSize"));
        pngSizeCol.setCellValueFactory(new PropertyValueFactory<>("pngSize"));
        pngEffCol.setCellValueFactory(new PropertyValueFactory<>("pngEffect"));
        pngTimeCol.setCellValueFactory(new PropertyValueFactory<>("pngTime"));
        gifSizeCol.setCellValueFactory(new PropertyValueFactory<>("gifSize"));
        gifEffCol.setCellValueFactory(new PropertyValueFactory<>("gifEffect"));
        gifTimeCol.setCellValueFactory(new PropertyValueFactory<>("gifTime"));

        table.setItems(tableValuesList);
    }

    @FXML
    void handleAbout() {
        Dialogs dialogs = new Dialogs();
        dialogs.aboutDialog();
    }
}