import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DBClient {
    private JPanel panel;
    private JButton actionButton;
    private JTextField queryTextBox;
    private JLabel dbStatusLabel;
    private JLabel label;
    private final String EXECUTE_QUERY = "Execute query";
    Database db = null;

    public DBClient() {
        db = new Database("localhost", "root", "my-secret-pw");

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (actionButton.getText() != EXECUTE_QUERY) {
                        db.Connect();
                        dbStatusLabel.setText("Connect to the database");
                        queryTextBox.setText("SHOW DATABASES;");
                        queryTextBox.setEditable(true);
                        actionButton.setText(EXECUTE_QUERY);
                    } else {
                        String result = db.Execute(queryTextBox.getText());
                        JOptionPane.showMessageDialog(null, result);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DBClient");
        frame.setContentPane(new DBClient().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
