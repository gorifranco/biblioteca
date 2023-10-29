import java.sql.*;

public class DDBBCon {
    String jdbcURL = "jdbc:mysql://localhost:3307/biblioteca";
    String username = "localhost";
    String password = "1234";
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;


    private void openConnection() throws SQLException, ClassNotFoundException{
            connection = DriverManager.getConnection(jdbcURL, username, password);
            // Cargar el controlador JDBC>
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conexión exitosa a la base de datos MySQL.");

    }

    private void closeConnections() {
        try {
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String login(String user, String password) throws SQLException, ClassNotFoundException {

        openConnection();

        try {
            preparedStatement = connection.prepareStatement("select id from users where ? == ?");
            preparedStatement.setString(0, user);
            preparedStatement.setString(0, password);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString(0);
        }finally {
            closeConnections();
        }
    }
    private boolean register(String username, String password) throws SQLException, ClassNotFoundException {

        openConnection();

        try{
            preparedStatement = connection.prepareStatement();
        }
    }
}


