import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class NewMain {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();

        JFrame frame = new JFrame();

        JButton addUserButton = new JButton("Add user");
        JButton listUsersButton = new JButton("Show list of added users");

        addUserButton.setBounds(80, 105, 250, 40);
        listUsersButton.setBounds(80, 150, 250, 40);

        JTextField textField = new JTextField();
        textField.setBounds(80, 60, 250, 40);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();

                if (text.isEmpty() || text.isBlank()) {
                    System.out.println("\nSorry, this field can't be empty. Try again!");
                } else {
                    for (User user : users) {
                        if (user.getName().equals(text)) {
                            System.out.println("\nSorry, there is already a user with that same name in the list.");
                            return;
                        }
                    }

                    users.add(new User(textField.getText()));
                    System.out.println("\n" + User.getCount() + " users have been added to the list.");
                }
            }
        });

        listUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (users.isEmpty()) {
                    System.out.println("\nNo users have been added to the list yet.");
                } else {
                    int userID = 1;

                    for (User user : users) {
                        System.out.println("\nUser " + userID + " -> " + user.getName());
                        userID++;
                    }
                }
            }
        });

        frame.add(textField);
        frame.add(addUserButton);
        frame.add(listUsersButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
