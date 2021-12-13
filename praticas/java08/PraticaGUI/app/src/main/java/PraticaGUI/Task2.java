package PraticaGUI;

import java.util.Random;
import javax.swing.JTextArea;

public class Task2 extends AbstractTask {
    public Task2(JTextArea textArea) {
        super(textArea, 500);
    }

    @Override
    public void run() {
        try {
            while (true) {
                final String randomString = createRandomString(5, 15);
                final String str = "Random string: " + randomString + "\n";
                textArea.append(str);
                Thread.sleep(SLEEP_MILLIS);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    private String createRandomString(int min_length, int max_length) {
        Random random = new Random();
        int length = random.nextInt(min_length, max_length);
        String string = "";

        for (int i = 0; i < length; i++) {
            string += (char)random.nextInt(32, 126);
        }

        return string;
    }
}
