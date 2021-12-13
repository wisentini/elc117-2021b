package PraticaGUI;

import javax.swing.JTextArea;

public class Task1 extends AbstractTask {
    public Task1(JTextArea textArea) {
        super(textArea, 1000);
    }

    @Override
    public void run() {
        int i = 0;

        try {
            while (true) {
                final String str = "Counting: " + i + "\n";
                textArea.append(str);
                Thread.sleep(SLEEP_MILLIS);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
