import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.stream.DoubleStream;


public class Calculator {

    static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }

    static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }

    /*
    public static void main( String[] args )  {

        //Database db = new Database("localhost", "example-user", "my_cool_secret");
        Database db = new Database("localhost", "root", "my-secret-pw");
        try {
            db.HelloWorld();

            System.out.println("----------- BEFORE -----------");
            db.ListDatabases();

            db.CreateDatabase("test_db_1");
            db.CreateDatabase("test_db_2");

            System.out.println("----------- AFTER -----------");
            db.ListDatabases();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //MainWindow gui = new MainWindow();
        //gui.show();

        //1. Create the frame.
        JFrame frame = new MainWindow();//("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        //JLabel emptyLabel = new JLabel("test");
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);

    } */
}
