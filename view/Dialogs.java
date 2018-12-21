package PNGCompressor.view;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

class Dialogs {
    File FileChooserDialog(Stage s) {
        try {
            return handleFileChoosing(s);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private File handleFileChoosing(Stage s) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Choose an image");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Images (*.bmp, *.jpg)", "*.bmp", "*.jpg");
        choose.getExtensionFilters().add(filter);
        File file = choose.showOpenDialog(s);
        if (file != null) {
            if (file.getName().endsWith(".bmp") || (file.getName().endsWith(".jpg"))) {
                return file;
            } else {
                file = handleFileChoosing(s);
            }
        }
        return null;
    }

    void aboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Made by Sirius Silverclaw - Telegram: @BlackFolf \n Tested by Despiad\nReviewed by BaLiK");
        alert.showAndWait();
    }
}