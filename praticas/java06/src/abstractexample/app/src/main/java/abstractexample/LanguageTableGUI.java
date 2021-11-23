package abstractexample;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.SwingUtilities;

public class LanguageTableGUI extends JFrame {

  public LanguageTableGUI() {

    // build the list
    List<Language> languageList = new ArrayList<Language>();
    languageList.add(new Language("C", "1972", "Imperative", "andreainfufsm"));

    // create the model
    LanguageTableModel model = new LanguageTableModel(languageList);
    // create the table
    JTable table = new JTable(model);

    // create instance of JButton (Add)
    JButton btnAdd = new JButton("Add row");
    // add event listener
    btnAdd.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        model.add(new Language("", "", "", ""));
      }
    });

    // create instance of JButton (Save)
    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (Language lang : languageList)
          System.out.println(lang);
      }
    });

    // configure the components
    btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("LanguageTableGUI");

    // add the components to the frame
    this.add(new JScrollPane(table));
    this.add(btnAdd);
    this.add(btnSave);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new LanguageTableGUI();
      }
    });
  }
}
