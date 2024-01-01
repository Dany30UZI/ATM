import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textView;



    @FXML
    void delete(ActionEvent event) {
        String del = ((Button)event.getSource()).getText();
        textView.setText("");
    }

    @FXML
    void digitsHand(ActionEvent event) {
        String digitObj = ((Button)event.getSource()).getText();
        String oldText = textView.getText();
        String newText = oldText + digitObj;
        textView.setText(newText);
    }

    //change the scen if the pin is good (pre def pin)
    public void switchToPanel(ActionEvent event) throws IOException {

        try {
            int pin = Integer.parseInt(textView.getText());

            if (pin == 1234) {
                root = FXMLLoader.load(getClass().getResource("panel.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else textView.setText("Pin incorect");

        }catch(Exception n){
            textView.setText("Foloseste cifrele");
        }
    }

    //sent you back to the first scene (pin)
    public void switchToPin(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("pin.fxml"));
           scene = new Scene(root);
           String css = this.getClass().getResource("app.css").toExternalForm();
           scene.getStylesheets().add(css);
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(scene);
           stage.show();
    }

    @FXML
    void depunereBani(ActionEvent event) {

    }

    @FXML
    void retragreBani(ActionEvent event) {

    }

    @FXML
    void trimiteBani(ActionEvent event) {

    }
}



