import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXInitializer extends Application {

    private static final Object barrier = new Object();

    public static void initialize() throws InterruptedException {
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(JavaFXInitializer.class);
            }
        };
        t.setDaemon(true);
        t.start();
        synchronized (barrier) {
            barrier.wait();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        synchronized (barrier) {
            barrier.notify();
        }
    }
}