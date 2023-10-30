import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;


public class DDBBCon {
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public DDBBCon() {
        Dotenv dotenv = Dotenv.load();
        databaseUrl = dotenv.get("DATABASE_URL");
        databaseUser = dotenv.get("DATABASE_USER");
        databasePassword = dotenv.get("DATABASE_PASSWORD");
    }

    private void openConnection() throws SQLException, ClassNotFoundException{

            connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
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

        String sql = "existeixUsuari(" + username + ", " + password + ")";
        openConnection();

        try{
            statement = connection.createStatement();
            return statement.execute(sql);
        } finally {
            closeConnections();
        }
    }
}


