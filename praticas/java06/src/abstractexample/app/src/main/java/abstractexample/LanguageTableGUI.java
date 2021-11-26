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
        List<Language> languages = new ArrayList<Language>();
        languages.add(new Language("C", "1972", "Imperative", "andreainfufsm"));

        LanguageTableModel model = new LanguageTableModel(languages);
        JTable table = new JTable(model);

        JButton addRowButton = new JButton("Add row");
        JButton removeSelectedRowButton = new JButton("Remove selected row");
        JButton saveRowsButton = new JButton("Save rows");

        addRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.add(new Language("", "", "", ""));
            }
        });

        removeSelectedRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();

                for (int rowIndex : selectedRows) {
                    model.remove(rowIndex);
                }
            }
        });

        saveRowsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.writeLanguagesToFile(languages, "src/main/resources/languages.json");
            }
        });

        // configure the components
        addRowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeSelectedRowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveRowsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("LanguageTableGUI");

        // add the components to the frame
        this.add(new JScrollPane(table));
        this.add(addRowButton);
        this.add(removeSelectedRowButton);
        this.add(saveRowsButton);
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
