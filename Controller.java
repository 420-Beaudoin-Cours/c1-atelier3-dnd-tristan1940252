package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class Controller {

    public TextField txfSource;
    public ImageView img;

    public void txfDragDetected(MouseEvent mouseEvent) {
        TextField ref = (TextField) mouseEvent.getSource();
        if (!ref.getText().isEmpty()){
        Dragboard db = ref.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(ref.getText());
        db.setContent(content);
        }
    }
    public void txfTargetDrapDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        TextField refTarget = (TextField) dragEvent.getGestureTarget();
        Dragboard db = dragEvent.getDragboard();
        refTarget.setText(db.getString());
        if (refSource != refTarget)
        refSource.clear();
    }

    public void txfTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    public void imgTargetDragDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        ImageView refTarget = (ImageView) dragEvent.getGestureTarget();
        Dragboard db = dragEvent.getDragboard();
        refSource.clear();
    }

    public void cmbTargetDragDrop(DragEvent dragEvent) {
        TextField refSource = (TextField) dragEvent.getGestureSource();
        ComboBox refTarget = (ComboBox) dragEvent.getGestureTarget();
        Dragboard db = dragEvent.getDragboard();
        refTarget.getItems().add(db.getString());
        refTarget.getSelectionModel().selectLast();
        refSource.clear();
    }

    public void cmbTargetDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }
}


