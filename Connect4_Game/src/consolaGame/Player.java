package consolaGame;

import java.util.Scanner;

/**
 * Clase perteneciente al package consolaGame
 * que tiene como proposito general el control de los jugadores
 * para poder jugar.
 *
 * @author Luis Fernando Martinez Silva
 * @version 1.0
 */
public class Player {
    // Atributos de la clase Player
    private String name;
    private int turn, token;

    /**
     * Crea un objeto de la clase Player para el manejo de las propiedades del jugador
     * @param nickname nickname del jugador
     * @param turn turno de participacion del jugador
     * @param token fichas que tendra el jugador al comenzar la partida
     */
    public Player(String nickname, int turn, int token){
        name = nickname;
        this.turn = turn;
        this.token = token;
    }

    /**
     * Metodo que nos permte saber cual es nombre del jugador,
     * el nombre se establece en el constructor.
     * @return el nombre del jugador proporcionado inicialmente
     */
    public String getName() {
        return name;
    }

    // Solo metodo get porque establecemos cual sera su turno
    // en el metodo contructor.

    /**
     * Metodo que nos proporciona el turno de participacion
     * del jugador, este valor es generado de manera aleatoria.
     * @return el turno de participacion del jugador.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Metodo que nos permite saber cuantas fichas tiene el jugador
     * al momento de la partida.
     * @return el numero de fichas que tiene el jugador
     */
    public int getToken() {
        return token;
    }

    /**
     * Elimina cada una de las fichas del jugador
     * por cada participacion
     */
    public void deleteToken(){
        if(token > 0) {
            token -= 1;
            System.out.println("El jugador "+getName()+" tiene "+getToken()+" fichas");
        }
        else
            System.out.println("El jugador "+getName()+" ya no tiene fichas");
    }

    /**
     * Metodo que permite al jugador decidir en que columna
     * desea colocar su ficha
     * @return la columna en donde colocara la ficha
     */
    public int getPositionToken(){
        Scanner scanner = new Scanner(System.in);
        byte columnUser = 0;
        boolean invalidColumn = true;

        // Se verifica que el jugador tenga tokens
        while(invalidColumn && getToken() > 0){
            System.out.println("Numero de columna donde colocaras la ficha "+getName()+" ");
            columnUser = scanner.nextByte();

            // Se verifica que la columna en la que desea colocar la ficha sea valida segun el tamaño del frame
            if(GameManagement.getColumns() > columnUser || GameManagement.getColumns() < 0){
                System.out.println("Numero de columna invalido, intenta de nuevo");
            } else
                invalidColumn = false;
        }

        System.out.println("Valor de columnaUser "+columnUser);
        return columnUser;
    }

}
