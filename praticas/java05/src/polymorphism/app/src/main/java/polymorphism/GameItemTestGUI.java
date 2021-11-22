package polymorphism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameItemTestGUI {
    public static void main(String[] args) {
        ArrayList<GameItem> bag = new ArrayList<GameItem>();

        bag.add(new Weapon("Sword", 3, true));
        bag.add(new Weapon("Rock", 1, false));
        bag.add(new Consumable("Potion", 0.5, "restore health"));
        bag.add(new Consumable("Food", 1.5, "sate hunger"));

        for (GameItem item : bag) {
            item.setImage(item.getName().toLowerCase() + ".png");
        }

        ListIterator<GameItem> bagIterator = bag.listIterator();

        GameItem firstItem = bagIterator.next();
        ImageIcon firstImageIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(firstItem.getImage()));
        JLabel imageLabel = new JLabel("", firstImageIcon, JLabel.CENTER);

        JLabel textLabel = new JLabel(firstItem.toString(), JLabel.CENTER);

        JButton buttonNext = new JButton("Next >");

        // addActionListener using an anonymous class
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bagIterator.hasNext()) {
                    GameItem item = bagIterator.next();
                    ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemClassLoader().getResource(item.getImage()));
                    imageLabel.setIcon(imageIcon);
                    textLabel.setText(item.toString());
                }
            }
        });
        // Shorter version of the previous code
        // addActionListener using a lambda expression
        // (this is functional programming in Java!)
        // buttonNext.addActionListener(e -> {
        // if (bagIterator.hasNext()) {
        // textLabel.setText(bagIterator.next().toString());
        // }
        // });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.PAGE_START);
        panel.add(textLabel, BorderLayout.CENTER);
        panel.add(buttonNext, BorderLayout.PAGE_END);

        JFrame f = new JFrame();
        f.add(panel);
        f.setSize(512, 512);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
