package PraticaGUI;

import javax.swing.*;

public class AppView extends JFrame {
    private JButton buttonRun0;
    private JButton buttonRun1;
    private JButton buttonStop0;
    private JButton buttonStop1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea textArea0;
    private JTextArea textArea1;

    public AppView() {
        jScrollPane1 = new JScrollPane();
        textArea0 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        buttonRun1 = new JButton();
        buttonStop1 = new JButton();
        buttonStop0 = new JButton();
        buttonRun0 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textArea0.setColumns(20);
        textArea0.setEditable(false);
        textArea0.setRows(5);
        jScrollPane1.setViewportView(textArea0);

        textArea1.setColumns(20);
        textArea1.setEditable(false);
        textArea1.setRows(5);
        jScrollPane2.setViewportView(textArea1);

        jLabel1.setText("Thread1");

        jLabel2.setText("Thread0");

        buttonRun0.setText("Run");
        buttonStop0.setText("Stop");

        buttonRun1.setText("Run");
        buttonStop1.setText("Stop");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonRun0)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonStop0)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonRun1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonStop1)))
                                .addGap(12, 12, 12)));

        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { buttonRun1, buttonStop1 });

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 235,
                                                Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(buttonStop0)
                                                .addComponent(buttonRun0))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(buttonStop1)
                                                .addComponent(buttonRun1)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setVisible(true);
    }

    public JTextArea getTextArea(int id) {
        if (id == 0) return this.textArea0;

        if (id == 1) return this.textArea1;
    
        return null;
    }

    public JButton getButtonRun(int id) {
        if (id == 0) return this.buttonRun0;

        if (id == 1) return this.buttonRun1;
    
        return null;
    }

    public JButton getButtonStop(int id) {
        if (id == 0) return this.buttonStop0;

        if (id == 1) return this.buttonStop1;
    
        return null;
    }

    public JLabel getJLabel(int id) {
        if (id == 0) return this.jLabel1;

        if (id == 1) return this.jLabel2;
    
        return null;
    }

    public JScrollPane getScrollPane(int id) {
        if (id == 0) return this.jScrollPane1;

        if (id == 1) return this.jScrollPane2;
    
        return null;
    }

    public void setRunning(int id) {
        if (id == 0) {
            textArea0.setText("");
            buttonRun0.setEnabled(false);
            buttonStop0.setEnabled(true);
        }

        if (id == 1) {
            textArea1.setText("");
            buttonRun1.setEnabled(false);
            buttonStop1.setEnabled(true);
        }
    }

    public void setStopped(int id) {
        if (id == 0) {
            buttonRun0.setEnabled(true);
            buttonStop0.setEnabled(false);
        }

        if (id == 1) {
            buttonRun1.setEnabled(true);
            buttonStop1.setEnabled(false);
        }
    }
}
