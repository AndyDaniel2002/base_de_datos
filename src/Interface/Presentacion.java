package Interface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.io.File;
import javax.swing.SwingUtilities;

public class Presentacion extends Application {
	

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        // Ruta del archivo de video
        String videoPath = "src/Video/Mi video.mp4";

        // Crear un objeto Media con la ruta del archivo de video
        Media media = new Media(new File(videoPath).toURI().toString());

        // Crear un reproductor de medios
        final MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Crear una vista de medios
        MediaView mediaView = new MediaView(mediaPlayer);
        
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getBounds();

        // Configurar el tama�o de la vista de medios seg�n tus necesidades
        mediaView.setFitWidth(bounds.getMaxX());
        mediaView.setFitHeight(bounds.getMaxY());
        
        primaryStage.setMaximized(true);

        // Apilar la vista de medios en un dise�o de pila
        StackPane root = new StackPane();
        root.getChildren().add(mediaView);

        // Crear una escena
        Scene scene = new Scene(root, 800, 600);

        // Configurar el escenario principal
        primaryStage.setTitle("Video Presentation App");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                mediaPlayer.stop();
                primaryStage.close();
            }
        });

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.stop();
                primaryStage.close();
                abrirLogin();
            }
        });
     
        primaryStage.show();
        

        // Configurar el reproductor de medios para reproducir autom�ticamente al abrir la aplicaci�n
        mediaPlayer.play();
    }

    // M�todo est�tico para ejecutar la presentaci�n
    public static void run() {
        launch();
    }
    
    private void abrirLogin() {
        // Mostrar otra ventana (JFrame)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Principal login = new  Principal();
                login.setVisible(true);
                login.setAlwaysOnTop(true);
            }
        });
    }
}