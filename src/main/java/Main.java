// import view.MenuView;

// public class Main {
//     public static void main(String[] args) {
//         MenuView menu = new MenuView();
//         menu.exibirMenu();
//     }
// }

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
        Scene scene = new Scene(loader.load(),1280,720);
        primaryStage.setTitle("Sistema de Salão de Beleza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
