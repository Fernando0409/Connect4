package consolaGame;

/**
 * Clase perteneciente al package consolaGame
 * que tiene como proposito general el control del
 * establecer la configuracion del juego como columnas, filas,
 * fichas y tamaño del tablero para poder jugar.
 *
 * @author Luis Fernando Martinez Silva
 * @version 1.0
 */
public class GameManagement {

    private static int columns, rows, tokens, players;

    /**
     * Establece el tamaño del tablero para jugar: columnas, filas y fichas
     * @param players numero de jugadores que participaran
     */
    public static void setSizeFrame(int players){
        GameManagement.players = players;

        switch (players){
            case 2:
                rows = 6;       // Se genera una matriz de 6 * 7 = 42 posiciones
                columns = 7;    // 42/4 = 10 grupos de 4
                tokens = 21;    // Numero de fichas, 42/2 jugadores, pueden crear 5
                break;
            case 3:
                rows = 7;       // Se genera una matriz de 56 posiciones
                columns = 8;    // 57/4 = 14 grupos de 4
                tokens = 19;    // Numero de fichas, 57/3, pueden crear 4
                break;
            case 4:
                rows = 8;       // Se genera una matriz de 72 posiciones
                columns = 9;    // 72/4 = 18 grupos de 4
                tokens = 18;     // Numero de fichas, 72/4, pueden crear 4
                break;
            default:
                System.out.println("El maximo de jugadores posibles es de 4 personas.");
                break;
        }
    }

    /**
     * Genera numeros aleatorios entre 1 y 100 para
     * el orden de participacion de los jugadores.
     * @return numero de posicion de los jugadores.
     */
    public static int generatePosition(){
        int position = (int) (Math.random()*100+1);
        return position;
    }

    /**
     * Metodo estatico para conocer el numero de columnas de la matriz
     * @return el numero de columnas del tablero
     */
    public static int getColumns() {
        return columns;
    }

    /**
     * Metodo estatico para conocer el numero de filas de la matriz
     * @return el numero de filas del tablero
     */
    public static int getRows() {
        return rows;
    }

    /**
     * Metodo estatico para conocer el numero de fichas de los jugadores
     * @return el numero de fichas de cada jugador
     */
    public static int getTokens() {
        return tokens;
    }

}
