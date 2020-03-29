package consolaGame;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        byte optionMenu, optionExit = 0;

        do {
            System.out.println("Welcome to Connect 4 Game\n");

            System.out.println("Play [1]  -  Tutorial[2]");
            System.out.println("Account[3]  -  Statics[4]");
            System.out.println(("Settings[5] - Exit[6]"));

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
                case 3:     // Login
                    //account();
                    break;
                case 4:     // Statics
                    statics();
                    break;
                case 5:     // Settings
                    settings();
                    break;
                case 6:     // Exit
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
        String [] players = new String[4];

        System.out.println("Play");
        System.out.print("Enter number of players: ");
        try {
            byte numberPlayers = scanner.nextByte();

            if(numberPlayers < 4) {
                for (int x = 0; x < numberPlayers; x++) {
                    System.out.print("Enter your nickname: ");
                    players[x] = scanner.next();
                }

                System.out.println("Let's go to play!");
                play(numberPlayers, players);

            } else{
                System.out.println("The maxim players allow are 4");
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
    }

    public static void tutorial() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Tutorial");

    }

    /*
    // Tiene bug, cuando ingresas una letra en vez de un numero
    public static void account() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        String nickname, pass, email;
        byte option = 0;

        System.out.println("Account");
        System.out.println("Sign in [1]\nSign Up [2]");
        System.out.println("Back [3]");

        System.out.print("Enter an option: ");
        try {
            option = scanner.nextByte();
            switch (option) {
                case 1:
                    System.out.println("Sign in");
                    System.out.print("Enter your nickname: ");
                    nickname = scanner.next();

                    System.out.print("Enter your password "+nickname+": ");
                    pass = scanner.next();

                    // Llamar al metodo inciar sesion, el cual debe
                    // buscar al usuario en la DB
                    break;
                case 2:
                    System.out.println("Sign Up");

                    System.out.print("Nickname: ");
                    nickname = scanner.next();

                    System.out.print("Password: ");
                    pass = scanner.next();

                    System.out.print("Email: ");
                    email = scanner.next();
                    break;
                case 3:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    break;
                default:
                    System.out.println("Option unavailable, try again...");
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid value: " + ex.getMessage());
                System.out.print("Enter to continue...");
                account();
            }
    }
     */

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
