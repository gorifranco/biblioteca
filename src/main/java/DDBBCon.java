import java.sql.*;

public class DDBBCon {
    String jdbcURL = "jdbc:mysql://localhost:3307/biblioteca";
    String username = "usuari";
    String password = "tu_contraseña";

    private void connect() {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
        ) {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conexión exitosa a la base de datos MySQL.");

            // Aquí puedes ejecutar tus consultas SQL
            String sqlQuery = "SELECT * FROM tu_tabla";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Procesar los resultados
            while (resultSet.next()) {
                // Acceder a las columnas de la fila actual
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                // Realizar acciones con los datos obtenidos
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            // Cerrar recursos
            resultSet.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


