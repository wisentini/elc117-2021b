package t2.task;

import java.awt.Desktop;
import java.net.URI;

import javafx.concurrent.Task;

public class OpenBrowserTask extends Task<Void> {
    private String url;

    public OpenBrowserTask(String url) {
        this.url = url;
    }

    @Override
    protected Void call() throws Exception {
        Desktop.getDesktop().browse(new URI(this.url));
        return null;
    }
}
