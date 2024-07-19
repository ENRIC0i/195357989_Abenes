import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class calculator {
    public static void main(String[] args) {
        double num1 = 10.5;
        double num2 = 5.5;

        double resultAddition = num1 + num2;
        double resultSubtraction = num1 - num2;
        double resultMultiplication = num1 * num2;
        double resultDivision = num1 / num2;
        double resultModulo = num1 % num2;

        System.out.println("Addition: " + resultAddition);
        System.out.println("Subtraction: " + resultSubtraction);
        System.out.println("Multiplication: " + resultMultiplication);
        System.out.println("Division: " + resultDivision);
        System.out.println("Modulo: " + resultModulo);

        storeInDatabase("addition", num1, num2, resultAddition);
        storeInDatabase("subtraction", num1, num2, resultSubtraction);
        storeInDatabase("multiplication", num1, num2, resultMultiplication);
        storeInDatabase("division", num1, num2, resultDivision);
        storeInDatabase("modulo", num1, num2, resultModulo);
    }

    private static void storeInDatabase(String operation, double num1, double num2, double result) {
        String url = "jdbc:mysql://localhost:3306/calculator";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO calculations (operation, num1, num2, result) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, operation);
            statement.setDouble(2, num1);
            statement.setDouble(3, num2);
            statement.setDouble(4, result);
            statement.executeUpdate();
            System.out.println("Saved to database: " + operation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

