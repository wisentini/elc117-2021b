package PraticaGUI;

import javax.swing.JTextArea;

public abstract class AbstractTask extends Thread {
    protected JTextArea textArea;
    protected final int SLEEP_MILLIS;

    public AbstractTask(JTextArea textArea, int SLEEP_MILLIS) {
        this.textArea = textArea;
        this.SLEEP_MILLIS = SLEEP_MILLIS;
    }
}
