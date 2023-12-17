import java.util.ArrayList;
import java.util.Scanner;

import connection.Connection;
import connection.UserConnection;
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
                break;

            case 2:
                clearScreen();
                Show();
                break;

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
            System.out.print("Add name : ");
            inputName = scanner.nextLine();

            boolean isValidNIM = false;
            do {
                System.out.print("Add NIM  : ");
                inputNIM = scanner.nextLine();

                if (inputNIM.matches("^[1-9]\\d*$")) {
                    isValidNIM = true;
                }
            } while (!isValidNIM);
        }

        System.out.print("Add team : ");
        inputTeamName = scanner.nextLine();
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

        boolean joinTable;

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

            joinTable = (inputFilter == 1) ? true : false;

        } while (inputFilter < 1 || inputFilter > 2);

        if (inputFilter == 1) {
            System.out.println();
            System.out.println("Add condition, separate by semicolon.");
            System.out.println("Example: name;=;kevin");
            System.out.print(">> ");

            inputCondition = scanner.nextLine();
            String columnName = null, operation = null, condition = null;
            String[] inputSplit = inputCondition.split(";", 5);          

            columnName = inputSplit[0];
            operation = inputSplit[1];
            condition = inputSplit[2];

            UserConnection uc = UserConnection.getInstance();
            System.out.println();
            hackathon.findUsers(columnName, inputSplit, joinTable, condition, uc);
            // System.out.println("data displayed");
        }
        else if(inputFilter == 2){
            String columnName = null, operation = null, condition = null;

            UserConnection uc = UserConnection.getInstance();
            // System.out.println("col: " + columnName + ", jointbl: " + joinTable);
            hackathon.findUsers(null, null, false, null, uc);
            // System.out.println("data displayed");
        }
    }
}
