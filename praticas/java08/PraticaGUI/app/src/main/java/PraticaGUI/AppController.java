package PraticaGUI;

import javax.swing.*;
import java.awt.event.*;

public class AppController {
    private AppView appView;
    private AbstractTask[] threads;

    public AppController(AppView appView, AbstractTask[] threads) {
        this.appView = appView;
        this.threads = threads;
    }

    public void init() {
        JButton buttonRun1 = this.appView.getButtonRun(1);
        buttonRun1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonRun1ActionPerformed(e);
            }
        });

        JButton buttonStop1 = this.appView.getButtonStop(1);
        buttonStop1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonStop1ActionPerformed(e);
            }
        });

        JButton buttonRun0 = this.appView.getButtonRun(0);
        buttonRun0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonRun0ActionPerformed(e);
            }
        });

        JButton buttonStop0 = this.appView.getButtonStop(0);
        buttonStop0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonStop0ActionPerformed(e);
            }
        });
    }

    public void stopThread(int id) {
        System.out.println("Stopping Thread" + id);
        
        if (threads[id] != null) {
            threads[id].interrupt();
            this.appView.setStopped(id);
        }
    }

    public void runThread(int id) {
        System.out.println("Running Thread" + id);
        
        this.appView.setRunning(id);

        if (id == 0) {
            threads[id] = new Task1(this.appView.getTextArea(id));
        } else {
            threads[id] = new Task2(this.appView.getTextArea(id));
        }

        threads[id].start();
    }

    public void buttonStop1ActionPerformed(ActionEvent e) {
        this.stopThread(1);
    }

    public void buttonStop0ActionPerformed(ActionEvent e) {
        this.stopThread(0);
    }

    public void buttonRun0ActionPerformed(ActionEvent e) {
        this.runThread(0);
    }

    public void buttonRun1ActionPerformed(ActionEvent e) {
        this.runThread(1);
    }
}
