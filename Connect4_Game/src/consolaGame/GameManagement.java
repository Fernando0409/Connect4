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
    public static int [] generatePosition(int players){
        int [] numbers = new int[players];
        int [] numberAnterior = new int[players];

        for(int i = 0; i < players; i++) {
            numberAnterior[i] = 0;
            numbers[i] = 0;
        }

        for (int x = 0; x < players; x++) {
            int number = (int) (Math.random() * players + 1);

            for(int y = 0; y < numberAnterior.length; y++){
                if(numberAnterior[y] == number){
                    x--;
                    break;
                } else if(numberAnterior[y] != number && numberAnterior[y] == 0){
                    numbers[x] = number;
                    numberAnterior[x] = number;
                    break;
                }
            }

        }

        return numbers;
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

    public static String [][] getTablero(){
        String [][] tablero = new String [rows][columns];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                tablero[i][j] = "*";
                System.out.print(tablero[i][j] + "   ");
            }
            System.out.println("\n");
        }
        return tablero;
    }

    public static boolean setWin(String [][] tablero, String character){
        boolean win = false;

        win = tokensHorizontal(tablero, character);
        if(!win)
            win = tokensVertical(tablero, character);
        if(!win)
            win = tokensDiagonal(tablero, character);

        return win;
    }

    private static boolean tokensVertical(String [][] tablero, String character){
        boolean win = false, first = true;
        int origen = 0;
        System.out.println("Metodo tokensVertical");
        for(int i = GameManagement.getRows() - 1; i >= 0; i--){             //  6
            for (int j = GameManagement.getColumns() - 1; j >= 0; j--){     // 7
                if(tablero[i][j].equals(character)){
                    origen = i;
                    System.out.println(origen);
                    if(origen-3 >= 0) {
                        if (tablero[origen][j-1].equals(character) && tablero[origen][j-2].equals(character) && tablero[origen][j-3].equals(character)){
                            win = true;
                            break;
                        }
                    }
                }
            }
            if(win)
                break;
        }
        System.out.println(win);
        return win;
    }

    private static boolean tokensHorizontal(String [][] tablero, String character){
        boolean win = false;
        for(int i = GameManagement.getRows()-1; i >= 0; i--){      // 6
            for (int j = GameManagement.getColumns()-1; j >= 0; j--){  // 7
                if(tablero[i][j].equals(character)){
                    if(i-3 >= 0){
                        if (tablero[i-1][j].equals(character) && tablero[i-2][j].equals(character) && tablero[i-3][j].equals(character)) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if(win)
                break;
        }
        System.out.println(win) ;
        return win;
    }

    private static boolean tokensDiagonal(String [][] tablero, String character){
        boolean win = false;
        System.out.println("Metdodo tokensDiagonal");
        for(int i = GameManagement.getRows()-1; i >= 0; i--){
            for (int j = GameManagement.getColumns()-1; j >= 0; j--){
                if(tablero[i][j].equals(character)){
                    if(i-3 >= 0 && j-3 >= 0)
                        System.out.println("Caracter: "+character+"\n Posicion ["+i+"]["+j+"]");
                }
            }
        }
        return win;
    }
}
