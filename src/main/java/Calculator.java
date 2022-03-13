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
    }
}
