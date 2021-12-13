package PraticaGUI;

import java.awt.*;

public class App {
    private static final int NTHREADS = 2;
    private AbstractTask[] threads = new AbstractTask[NTHREADS];

    public App() {
        AppView appView = new AppView();
        AppController appController = new AppController(appView, threads);
        appController.init();

        for (int i = 0; i < NTHREADS; i++) {
            appView.setStopped(i);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
