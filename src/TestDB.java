import java.sql.*;
import java.util.Scanner;

public class TestDB {
    static final String URL = "jdbc:mysql://";
    static final String USER = "root";
    static final String PASSWORD = "";
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            /*Class.forName("com.mysql.cj.jdbc.Drive");*/
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение установлено!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            System.out.println("Введите email: ");
            String email = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String pass = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, lastname, email, pass) VALUE ('Коля', 'Николаев', 'nikola@mail.ru', '123')");

            statement = connection.createStatement();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, pass);

            preparedStatement.executeUpdate();
            System.out.println("Добавлен новый пользователь");

            //statement.execute("INSERT INTO users (name, lastname, email, pass) VALUE ('Коля', 'Николаев', 'nikola@mail.ru', '123')");


            resultSet = statement.executeQuery("SELECT * FROM users");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
