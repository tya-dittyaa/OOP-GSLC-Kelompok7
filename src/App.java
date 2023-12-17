import java.util.Scanner;

import models.Team;
import models.User;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Hackathon hackathon = new Hackathon();

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
                clearScreen();
                Insert();
                return;

            case 2:
                clearScreen();
                Show();
                return;

            default:
                System.out.println("Thank you for using this application...");
                System.out.println("© 2023, kuitkatnekat by Aditya, Karina, and Luke");
                return;
        }
    }

    private void Insert() {
        int input = 0;
        String inputName = null;
        String inputNIM = null;
        String inputTeamName = null;

        do {
            System.out.println("Hackathon - Insertion");
            System.out.println("=========================");
            System.out.println("Which table to insert?");
            System.err.println("1. User");
            System.out.println("2. Team");
            System.out.print(">> ");

            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                input = 0;
            }
            scanner.nextLine();
        } while (input < 1 || input > 2);

        System.out.println();

        if (input == 1) {
            int checkLenInputName = 0;
            int checkLenInputTeamName = 0;

            do {
                System.out.print("Add name : ");
                inputName = scanner.nextLine();
                checkLenInputName = inputName.length();
            } while (checkLenInputName == 0);

            boolean isValidNIM = false;
            do {
                System.out.print("Add NIM  : ");
                inputNIM = scanner.nextLine();

                if (inputNIM.matches("^[1-9]\\d*$")) {
                    isValidNIM = true;
                }
            } while (!isValidNIM);

            do {
                System.out.print("Add team : ");
                inputTeamName = scanner.nextLine();
                checkLenInputTeamName = inputTeamName.length();
            } while (checkLenInputTeamName == 0);

            User newUser = hackathon.insertUser(inputNIM, inputName, inputTeamName);

            System.out.println();
            if (newUser != null) {
                System.out.println("User created!");
            } else {
                System.err.println("Error: Team full.");
            }
        }

        else {
            int checkLenInputTeamName = 0;

            do {
                System.out.print("Add team : ");
                inputTeamName = scanner.nextLine();
                checkLenInputTeamName = inputTeamName.length();
            } while (checkLenInputTeamName == 0);

            Team newTeam = hackathon.insertTeam(inputTeamName);

            System.out.println();
            if (newTeam != null) {
                System.out.println("Team created!");
            } else {
                System.err.println("Error: Team name already exist.");
            }
        }

        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
        new App();
    }

    private void Show() {
        int inputTable = 0;
        int inputFilter = 0;
        String inputCondition = null;

        do {
            System.out.println("Hackathon - Show");
            System.out.println("=========================");
            System.out.println("Which table to show?");
            System.err.println("1. User");
            System.out.println("2. Team");
            System.out.print(">> ");

            try {
                inputTable = scanner.nextInt();
            } catch (Exception e) {
                inputTable = 0;
            }
            scanner.nextLine();
        } while (inputTable < 1 || inputTable > 2);

        do {
            System.out.println();
            System.out.println("Want to filter by condition?");
            System.err.println("1. Yes");
            System.out.println("2. No");
            System.out.print(">> ");

            try {
                inputFilter = scanner.nextInt();
            } catch (Exception e) {
                inputFilter = 0;
            }
            scanner.nextLine();
        } while (inputFilter < 1 || inputFilter > 2);

        if (inputFilter == 1) {
            System.out.println();
            System.out.println("Add condition, separate by semicolon.");
            System.out.println("Example: name;=;kevin");
            System.out.print(">> ");

            inputCondition = scanner.nextLine();
        }
    }
}
