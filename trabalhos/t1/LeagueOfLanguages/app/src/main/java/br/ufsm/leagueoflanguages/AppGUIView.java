package br.ufsm.leagueoflanguages;

import javax.swing.*;
import java.awt.Insets;
import java.awt.Dimension;

public class AppGUIView {
    private JFrame frame;

    private JLabel languageIdLabel;
    private JLabel firstAppearedLabel;
    private JLabel paradigmLabel;
    private JLabel userIdLabel;

    private JTextField languageIdTextField;
    private JTextField firstAppearedTextField;
    private JTextField paradigmTextField;
    private JTextField userIdTextField;

    private JButton saveLanguageButton;
    private JButton listAllLinguagesButton;

    private JPanel panel;

    private JTextArea textArea;

    private JScrollPane scrollPane;

    private Insets insets;

    private Dimension dimension;

    public AppGUIView() {
        this.initFrame();
        this.createLabels();
        this.createTextFields();
        this.createButtons();
        this.createOthers();
        this.addComponentsToFrame();
        this.updateFrame();
    }

    private void initFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Linguagens para a League of Languages");
        this.frame.setSize(600, 600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    private void updateFrame() {
        this.frame.revalidate();
        this.frame.repaint();
    }

    private void createLabels() {
        this.languageIdLabel = new JLabel("languageId:");
        this.firstAppearedLabel = new JLabel("firstAppeared:");
        this.paradigmLabel = new JLabel("paradigm:");
        this.userIdLabel = new JLabel("userId:");

        this.languageIdLabel.setBounds(80, 10, 103, 25);
        this.firstAppearedLabel.setBounds(80, 40, 103, 25);
        this.paradigmLabel.setBounds(80, 70, 103, 25);
        this.userIdLabel.setBounds(80, 100, 103, 25);
    }

    private void createTextFields() {
        this.languageIdTextField = new JTextField();
        this.firstAppearedTextField = new JTextField();
        this.paradigmTextField = new JTextField();
        this.userIdTextField = new JTextField();

        this.languageIdTextField.setBounds(190, 10, 125, 25);
        this.firstAppearedTextField.setBounds(190, 40, 125, 25);
        this.paradigmTextField.setBounds(190, 70, 125, 25);
        this.userIdTextField.setBounds(190, 100, 125, 25);
    }

    private void createButtons() {
        this.saveLanguageButton = new JButton("Save language");
        this.listAllLinguagesButton = new JButton("List all languages");

        this.saveLanguageButton.setBounds(352, 40, 150, 25);
        this.listAllLinguagesButton.setBounds(340, 70, 175, 25);
    }

    private void createOthers() {
        this.panel = new JPanel();
        this.textArea = new JTextArea(25, 45);
        this.scrollPane = new JScrollPane(this.textArea);
        
        this.panel.add(this.scrollPane);

        this.insets = this.frame.getContentPane().getInsets();
        this.dimension = this.panel.getPreferredSize();

        this.panel.setBounds(45 + insets.left, 150 + insets.top, this.dimension.width, this.dimension.height);
    }

    private void addComponentsToFrame() {
        this.frame.add(this.languageIdLabel);
        this.frame.add(this.languageIdTextField);
        this.frame.add(this.firstAppearedLabel);
        this.frame.add(this.firstAppearedTextField);
        this.frame.add(this.paradigmLabel);
        this.frame.add(this.paradigmTextField);
        this.frame.add(this.userIdLabel);
        this.frame.add(this.userIdTextField);
        this.frame.add(this.saveLanguageButton);
        this.frame.add(this.listAllLinguagesButton);
        this.frame.add(this.panel);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JLabel getLanguageIdLabel() {
        return this.languageIdLabel;
    }

    public JLabel getFirstAppearedLabel() {
        return this.firstAppearedLabel;
    }

    public JLabel getparadigmLabel() {
        return this.paradigmLabel;
    }

    public JLabel getUserIdLabel() {
        return this.userIdLabel;
    }

    public JTextField getLanguageIdTextField() {
        return this.languageIdTextField;
    }

    public JTextField getFirstAppearedTextField() {
        return this.firstAppearedTextField;
    }

    public JTextField getParadigmTextField() {
        return this.paradigmTextField;
    }

    public JTextField getUserIdTextField() {
        return this.userIdTextField;
    }

    public JButton getSaveLanguageButton() {
        return this.saveLanguageButton;
    }

    public JButton getListAllLinguagesButton() {
        return this.listAllLinguagesButton;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JTextArea getTextArea() {
        return this.textArea;
    }

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public Insets getInsets() {
        return this.insets;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setLanguageIdLabel(JLabel languageIdLabel) {
        this.languageIdLabel = languageIdLabel;
    }

    public void setFirstAppearedLabel(JLabel firstAppearedLabel) {
        this.firstAppearedLabel = firstAppearedLabel;
    }

    public void setParadigmLabel(JLabel paradigmLabel) {
        this.paradigmLabel = paradigmLabel;
    }

    public void setUserIdLabel(JLabel userIdLabel) {
        this.userIdLabel = userIdLabel;
    }

    public void setLanguageIdTextField(JTextField languageIdTextField) {
        this.languageIdTextField = languageIdTextField;
    }

    public void setFirstAppearedTextField(JTextField firstAppearedTextField) {
        this.firstAppearedTextField = firstAppearedTextField;
    }

    public void setParadigmTextField(JTextField paradigmTextField) {
        this.paradigmTextField = paradigmTextField;
    }

    public void setUserIdTextField(JTextField userIdTextField) {
        this.userIdTextField = userIdTextField;
    }

    public void setSaveLanguageButton(JButton saveLanguageButton) {
        this.saveLanguageButton = saveLanguageButton;
    }

    public void setListAllLinguagesButton(JButton listAllLinguagesButton) {
        this.listAllLinguagesButton = listAllLinguagesButton;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
