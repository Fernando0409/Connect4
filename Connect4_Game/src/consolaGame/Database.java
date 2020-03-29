package consolaGame;

import java.sql.*;

/**
 * Clase perteneciente el package consolaGame.
 * Contiene los metodos para realizar una conexion a la base
 * de datos, recuperar la informacion de los jugadores (estadisticas)
 * para manipularla.
 * @author Luis Fernando Martinez Silva
 * @version 1.0
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/connect4";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Establece conexion con la base de datos usando.
     * @return un valor positivo en caso de haber conectado exitosamente
     *          o negativo generando una excepcion.
     */
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
     * Metodo que genera una consulta, verifica la existencia de la cuenta
     * y devuelve los valores especificados en los parametros (victorias, empates, derrotas, racha)
     * @param nickname Nickname del jugador que se pretende buscar
     * @param option Dato que se pretende obtener, se cuenta con 4 opciones:
     *
     *               Conseguir victorias (1)
     *               Conseguir empates (2)
     *               Conseguir derrotas (3)
     *               Conseguir racha (4)
     * @return array con el nickname del jugador y el dato buscado para el jugador
     */
    private static String[] getValuesStatics(String nickname, int option){
        String  nick = "", value = "";
        Statement stmt;  ResultSet rs;

        try{
            Connection connection = getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM stadistics WHERE nickname = '"+nickname+"'");

            if(rs.next()){
                nick = rs.getString("nickname");
                switch (option){
                    case 1:         // Conseguir wins
                        value = rs.getString("wins");
                        break;
                    case 2:         // Conseguir draws
                        value = rs.getString("draws");
                        break;
                    case 3:         // Conseguir defeats
                        value = rs.getString("defeats");
                        break;
                    case 4:         // Conseguir streak
                        value = rs.getString("streak");
                        break;
                    default:
                        System.out.println("No se encontro la opcion deseada");
                }
            }else
                System.out.print("No se encontraron resultados");

        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return new String[]{nick, value};
    }

    //************************************ Metodos de uso comun ********************************************************

    /**
     * Metodo que permite crear una cuenta a los jugadores
     * para el juego.
     * @param nickname Apodo o nombre ficticio del jugador
     * @param email Correo electronico del jugador
     * @param password Contraseña de la cuenta.
     */
    public static void addPlayers(String nickname, String email, String password){
       String [] values;
       values = getValuesStatics(nickname, 1);
       if(values[0].equals("")) {

           String query = "INSERT INTO player(nickname, email, password) " +
                          "VALUES ('" + nickname + "', '" + email + "', '" + password + "')";

           try {
               Connection connection = getConnection();
               Statement stmt = connection.createStatement();
               stmt.executeUpdate(query);

               System.out.println("Datos insertados exitosamente");
               stmt.close();
               connection.close();

           } catch (SQLException ex) {
               System.out.println("SQLException: " + ex.getMessage());
               System.out.println("SQLState: " + ex.getSQLState());
               System.out.println("VendorError: " + ex.getErrorCode());
           }
       } else
           System.out.println("Este usuario ya existe");
    }

    public static Boolean verifyUser(String nickname, String password){
        boolean verify = false;
        Statement stmt;  ResultSet rs;

        try{
            Connection connection = getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM player WHERE nickname = '"+nickname+"'");

            if(rs.next()){
                System.out.println("Busqueda exitosa, se encontro el usuario");
                verify = true;
            }else
                System.out.println("No se encontraron resultados");

        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return verify;
    }

    /**
     * Metodo que actualiza las victorias del jugador
     * @param nickname nickname del jugador en el que se efectuaran
     *                 los cambios.
     */
    public static void setWins(String nickname){
        String [] valuesUser;

        valuesUser = getValuesStatics(nickname, 1);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals("")) {
            int wins = Integer.parseInt(valuesUser[1]);
            try {
                Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                String query = "UPDATE stadistics SET wins = '" + (wins + 1) + "' WHERE nickname = '" + valuesUser[0] + "'";

                int value = stmt.executeUpdate(query);
                System.out.println("Metodo setWins: " + value);

                stmt.close();
                connection.close();

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } else
            System.out.println("Este usuario no esta registrado - Metodo setWins");
    }

    /**
     * Metodo que retornar las victorias del jugador
     * registradas en la DB
     * @param nickname nickname del jugador
     * @return las victorias del jugador
     */
    public static int getWins(String nickname){

        int wins = 0;
        String [] valuesUser;

        valuesUser = getValuesStatics(nickname, 1);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals(""))
            wins = Integer.parseInt(valuesUser[1]);
        else
            System.out.println("Este usuario no esta registrado - Metodo getWins");

        return wins;
    }

    /**
     * Metodo que permite actualizar los empates de
     * los jugadores.
     * @param nickname nickname del jugador en el que se surtiran los efectos
     */
    public static void setDraw(String nickname){
        String [] valuesUser;
        valuesUser = getValuesStatics(nickname, 2);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals("")) {
           int draws = Integer.parseInt(valuesUser[1]);
            try {
                String query = "UPDATE stadistics SET draws = '" + (draws + 1) + "' WHERE nickname = '" + valuesUser[0] + "'";

                Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);

                stmt.close();
                connection.close();

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } else
            System.out.println("Este usuario no esta registrado - Metodo setDraw");
    }

    /**
     * Metodo que retornar los empates del jugador
     * registradas en la DB
     * @param nickname nickname del jugador
     * @return los empates del jugador
     */
    public static int getDraw(String nickname){
        int draws = 0;
        String [] valuesUser;

        valuesUser = getValuesStatics(nickname, 2);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals(""))
            draws = Integer.parseInt(valuesUser[1]);
        else
            System.out.println("Este usuario no esta registrado - Metodo getDraw");

        return draws;
    }

    /**
     * Metodo que permite actualizar las derrotas de
     * los jugadores.
     * @param nickname nickname del jugador en el que se surtiran los efectos
     */
    public static void setDefeat(String nickname){
        String [] valuesUser;
        valuesUser = getValuesStatics(nickname, 3);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals("")) {
            int defeats = Integer.parseInt(valuesUser[1]);
            try {
                String query = "UPDATE stadistics SET defeats = '" + (defeats + 1) + "' WHERE nickname = '" + valuesUser[0] + "'";

                Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);

                stmt.close();
                connection.close();

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } else
            System.out.println("Este usuario no esta registrado - Metodo setDefeat");
    }

    /**
     * Metodo que retornar las derrotas del jugador
     * registradas en la DB
     * @param nickname nickname del jugador
     * @return las derrotas del jugador
     */
    public static int getDefeat(String nickname){
        int defeats = 0;
        String [] valuesUser;

        valuesUser = getValuesStatics(nickname, 3);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals(""))
            defeats = Integer.parseInt(valuesUser[1]);
        else
            System.out.println("Este usuario no esta registrado - Metodo getDefeat");

        return defeats;
    }


    /*
        Verficar el funcionamiento logico de setStreak y getStreak
        Si ganas, te suman 1
        Si pierdes, regresas a 0
     */

    /**
     * Metodo que permite actualizar la racha de victorias
     * del jugador.
     * @param nickname nickname del jugador en el que se surtiran los efectos
     */
    public static void setStreak(String nickname){
        String [] valuesUser;
        valuesUser = getValuesStatics(nickname, 4);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals("")) {
            int streak = Integer.parseInt(valuesUser[1]);
            try {
                String query = "UPDATE stadistics SET streak = '" + (streak + 1) + "' WHERE nickname = '" + valuesUser[0] + "'";

                Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);

                stmt.close();
                connection.close();

            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } else
            System.out.println("Este usuario no esta registrado - Metodo setDefeat");
    }

    /**
     * Metodo que retornar los racha de victorias del jugador
     * registradas en la DB
     * @param nickname nickname del jugador
     * @return cantidad de rachas consecutivas del jugador
     */
    public static int getStreak(String nickname){
        int streaks = 0;
        String [] valuesUser;

        valuesUser = getValuesStatics(nickname, 4);

        if(valuesUser[0].equals(nickname) && !valuesUser[1].equals(""))
            streaks = Integer.parseInt(valuesUser[1]);
        else
            System.out.println("Este usuario no esta registrado - Metodo getStreak");
        return streaks;
    }

}
