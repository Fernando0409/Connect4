package consolaGame;

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
                    play();
                    break;
                case 2:     // Tutorial
                    tutorial();
                    break;
                case 3:     // Login
                    account();
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
    }

    public static void play() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Play");

    }

    public static void tutorial() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Tutorial");

    }

    // Tiene bug, cuando ingresas una letra incorrecta
    public static void account() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        Scanner scanner = new Scanner(System.in);
        String nickname, pass, email;
        byte option = 0;

        do {
            try {
                System.out.println("Account");
                System.out.println("Sign in [1]\nSign Up [2]");
                System.out.println("Back [3]");

                System.out.print("Enter an option: ");
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
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        }while (option != 3);

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
            try{
                System.out.println("Exit");
                System.out.println("Are you sure?\nConfirm[1] - Cancel[2]");
                System.out.print("Enter an option: ");

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
