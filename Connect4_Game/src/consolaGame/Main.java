package consolaGame;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Scanner scanner = new Scanner(System.in);
        byte optionMenu, optionExit = 0;

        do {
            System.out.println("Welcome to Connect 4 Game\n");

            System.out.println("Play [1]  -  Tutorial[2]");
            System.out.println("Statics[3] - Settings[4]");
            System.out.println("Exit[5]");

            // Choose an option
            System.out.print("Enter an option to start: ");
            optionMenu = scanner.nextByte();
            switch (optionMenu){
                case 1:     // Play
                    setPlay();
                    break;
                case 2:     // Tutorial
                    tutorial();
                    break;
                case 3:     // Statics
                    statics();
                    break;
                case 4:     // Settings
                    settings();
                    break;
                case 5:     // Exit
                    optionExit = exit();
                    break;
                default:
                    System.out.print("\nOption unavailable, try again...\nEnter to continue ");
                    System.in.read();
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
            }
        }while(optionExit != 1);
        scanner.close();
    }

    public static void setPlay() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Play");
        System.out.print("Enter number of players: ");
        try {
            byte numberPlayers = scanner.nextByte();
            String [] players = new String[numberPlayers];

            if(numberPlayers < 4 && numberPlayers > 1) {
                for (int x = 0; x < numberPlayers; x++) {
                    System.out.print("Enter your nickname player "+(x+1)+": ");
                    players[x] = scanner.next();
                }
                System.out.println("Let's go to play!");
                play(numberPlayers, players);

            } else{
                System.out.println("The maxim players allow are 4 AND minimum 2 \nEnter to continue...");
                System.in.read();
                setPlay();
            }
        } catch (InputMismatchException ex){
            System.out.println("Invalid value");
            System.in.read();
            setPlay();
        }
    }

    public static void play(int player, String [] players) throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Metodo play");

        // Creamos los objetos de la clase Player
        Player [] gamers = new Player[players.length];

        // Invocamos al metodo que establece cuales seran las caracteristicas del juego
        // columnas y filas del tablero, fichas por cada jugador
        GameManagement.setSizeFrame(players.length);
        int tokens = GameManagement.getTokens();        // Obtenemos las fichas para cada jugador

        System.out.println("Obtain players' data...");
        int [] arrayPositions = GameManagement.generatePosition(players.length);

        for (int x = 0; x < players.length; x++){
            gamers[x] = new Player(players[x], arrayPositions[x] ,tokens);

            System.out.println("Nickname: " + gamers[x].getName());
            System.out.println("Token: " + gamers[x].getToken());
            System.out.println("Position: " + gamers[x].getTurn());

            System.out.println();
        }

        /*
                        Vamoooooos a jugar!
         */

        String [][] tablero = GameManagement.getTablero();
        
        System.in.read();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void tutorial() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Tutorial");

    }

    public static void statics() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Statics");
    }

    public static void settings() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Settings");
    }

    public static byte exit() throws IOException, InterruptedException {
        byte optionExit = 0;
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        do {
            Scanner scanner = new Scanner(System.in);
                System.out.println("Exit");
                System.out.println("Are you sure?\nConfirm[1] - Cancel[2]");
                System.out.print("Enter an option: ");
            try{
                optionExit = scanner.nextByte();

                switch (optionExit) {
                    case 1:
                        System.out.println("Thank you! Good bye!");
                        break;
                    case 2:
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        break;
                    default:
                        System.out.print("Option unavailable, try again\nEnter to continue...");
                        System.in.read();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        break;
                }
            } catch (InputMismatchException ex){
                System.out.println("Invalid value: "+ex.getMessage());
                System.out.print("Enter to continue...");
                System.in.read();
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } while (optionExit < 1 || optionExit > 2);     // Repetira mientras sea true

        return optionExit;
    }
}
