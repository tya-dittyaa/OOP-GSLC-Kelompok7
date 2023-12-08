import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        new App();
    }

    private void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    private App() {
        int input = 0;

        do {
            clearScreen();
            System.out.println("Hackathon Team Management");
            System.out.println("=========================");
            System.out.println("1. Insert");
            System.out.println("2. Show");
            System.out.println("3. Exit");
            System.out.print(">> ");

            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                input = 0;
            }

            scanner.nextLine();
        } while (input < 1 || input > 3);

        switch (input) {
            case 1:
                Insert();
                break;

            case 2:
                Show();
                break;

            default:
                System.out.println("Thank you for using this application...");
                System.out.println("© 2023, kuitkatnekat by Aditya, Karina, and Luke");
                return;
        }
    }

    private void Insert() {
        System.out.println("Ini Insert");
    }

    private void Show() {
        System.out.println("Ini Show");
    }
}
