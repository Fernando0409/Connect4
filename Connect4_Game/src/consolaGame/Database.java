package consolaGame;

import java.sql.*;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/connect4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return connection;
    }

    /**
     * Metodo que permite crear una cuenta a los jugadores
     * para el juego.
     * @param name Nombre real del jugador
     * @param lastName Apellido del jugador xD
     * @param nickname Apodo o nombre ficticio del jugador
     * @param country Paise de origen
     * @param birthday Fecha de nacimiento del jugador
     * @param email Correo electronico del jugador
     * @param password Contraseña de la cuenta.
     */
    public static void addPlayers(String name, String lastName, String nickname, String country, Date birthday, String email, String password){
       /*
         Añadir codigo para realizar consulta que verifique si
          existen jugadores con el mismo nickname y mismo correo
       */

        String query = "INSERT INTO player(name, lastName, nickname, country, birthday, email, password) " +
                "VALUES ('"+name+"', '"+lastName+"', '"+nickname+"','"+country+"', '1999-09-04', '"+email+"', '"+password+"')";
        Connection connection = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            int value = stmt.executeUpdate(query);
            System.out.println("Datos insertados exitosamente");

        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


    private void setWins(String nickname){
        // Generar consulta para verificar si existe el usuario
        // Posteriormente, añadirle 1 a su campo wins
        // Y actualizar los datos
    }

    private int getWins(String nickname){
        // Generar consulta para verificar si existe el usuario

        int wins = 0;
        return wins;
    }

    private void setDraw(String nickname){
        // Generar consulta para verificar si existe el usuario
        // Posteriormente, añadirle 1 a su campo wins
        // Y actualizar los datos
    }

    private int getDraw(String nickname){
        // Generar consulta para verificar si existe el usuario

        int draws = 0;
        return draws;
    }

    private void setDefeat(String nickname){
        // Generar consulta para verificar si existe el usuario
        // Posteriormente, añadirle 1 a su campo wins
        // Y actualizar los datos
    }

    private int getDefeat(String nickname){
        // Generar consulta para verificar si existe el usuario
        int defeats = 0;
        return defeats;
    }

    private void setStreak(String nickname){
        // Generar consulta para verificar si existe el usuario
        // Posteriormente, añadirle 1 a su campo wins
        // Y actualizar los datos
    }

    private int getSteak(String nickname){
        // Generar consulta para verificar si existe el usuario
        int streaks = 0;
        return streaks;
    }

}
