import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewMain {
  public static void main(String[] args) {
    ArrayList<User> userlist = new ArrayList<User>();

    // create instance of JFrame
    JFrame f = new JFrame();

    // create instance of JButton
    JButton b = new JButton("Add");

    // x axis, y axis, width, height
    b.setBounds(80, 100, 250, 40);


    JTextField t = new JTextField();
    t.setBounds(80, 60, 250, 40);

    // add event listener
    // this code can be simplified
    // see: https://www.codejava.net/java-core/the-java-language/java-8-lambda-listener-example
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        userlist.add(new User(t.getText()));
	      System.out.println("Another user: " + User.getCount());
      }
    });


    f.add(t);
    // add button to JFrame
    f.add(b);
    
    f.setSize(400, 500);
    f.setLayout(null);
    // make the frame visible
    f.setVisible(true);
  }
}
