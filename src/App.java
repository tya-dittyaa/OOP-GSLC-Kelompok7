import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            System.out.println("3. Back");
            System.out.print(">> ");

            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                input = 0;
            }
            scanner.nextLine();
        } while (input < 1 || input > 3);

        if (input == 3) {
            new App();
            return;
        }

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
                System.err.println("Error: NIM/Name Already Exist or Team are full.");
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
        String columnNameForCondition = null;
        String operationForCondition = null;
        String conditionForCondition = null;

        do {
            System.out.println("Hackathon - Show");
            System.out.println("=========================");
            System.out.println("Which table to show?");
            System.err.println("1. User");
            System.out.println("2. Team");
            System.out.println("3. Back");
            System.out.print(">> ");

            try {
                inputTable = scanner.nextInt();
            } catch (Exception e) {
                inputTable = 0;
            }
            scanner.nextLine();
        } while (inputTable < 1 || inputTable > 3);

        if (inputTable == 3) {
            new App();
            return;
        }

        do {
            System.out.println();
            System.out.println("Want to filter by condition?");
            System.err.println("1. Yes");
            System.out.println("2. No");
            System.out.println("3. Back");
            System.out.print(">> ");

            try {
                inputFilter = scanner.nextInt();
            } catch (Exception e) {
                inputFilter = 0;
            }
            scanner.nextLine();
        } while (inputFilter < 1 || inputFilter > 3);

        if (inputFilter == 3) {
            clearScreen();
            Show();
            return;
        }

        if (inputFilter == 1) {
            int checkLenInputCondition = 0;

            do {
                System.out.println();
                System.out.println("Add condition, separate by semicolon.");

                if (inputTable == 1) {
                    System.out.println("Example: name;=;kevin");
                    System.out.println("Available: nim, name, teamId");
                } else {
                    System.out.println("Example: name;=;innonest");
                    System.out.println("Available: id, name");
                }

                System.out.print(">> ");

                inputCondition = scanner.nextLine();

                String pattern = "([^;]+);=;([^;]+)";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(inputCondition);

                if (matcher.matches()) {
                    checkLenInputCondition = inputCondition.length();
                } else {
                    checkLenInputCondition = 0;
                }
            } while (checkLenInputCondition == 0);

            String[] inputSplit = inputCondition.split(";");
            columnNameForCondition = inputSplit[0];
            operationForCondition = inputSplit[1];
            conditionForCondition = inputSplit[2];
        }

        // Show all User
        if (inputTable == 1 && inputFilter == 2) {
            ArrayList<User> users = hackathon.findUsers(null, null, null, null);
            ArrayList<Team> teams = hackathon.findTeams(null, null, null, null);

            System.out.println();
            if (users.size() == 0) {
                System.out.println("Data is empty.");
            } else {
                System.out.println("Hackathon - Show All User");
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                System.out.printf("| %-10s | %-40s | %-7s | %-20s |\n", "NIM", "Name", "ID Team", "Team Name");
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                for (User user : users) {
                    System.out.printf("| %-10s | %-40s | %-7d | %-20s |", user.nim, user.name, user.id,
                            teams.get(user.id - 1).name);
                    System.out.println();
                }
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                System.out.println();
            }
        }

        // Show all team
        if (inputTable == 2 && inputFilter == 2) {
            ArrayList<Team> teams = hackathon.findTeams(null, null, null, null);

            System.out.println();
            if (teams.size() == 0) {
                System.out.println("Data is empty.");
            } else {
                System.out.println("Hackathon - Show All Team");
                System.out.println("------------------------------");
                System.out.printf("| %-3s | %-20s |\n", "ID", "Name");
                System.out.println("------------------------------");
                for (Team team : teams) {
                    System.out.printf("| %-3d | %-20s |", team.id, team.name);
                    System.out.println();
                }
                System.out.println("------------------------------");
                System.out.println();
            }
        }

        // Show user with condition
        if (inputTable == 1 && inputFilter == 1) {
            String[] arrayOfCondition = { operationForCondition, conditionForCondition };
            ArrayList<User> users = hackathon.findUsers(columnNameForCondition, arrayOfCondition, null, null);
            ArrayList<Team> teams = hackathon.findTeams(null, null, null, null);

            System.out.println();
            if (users.size() == 0) {
                System.out.println("Data is empty.");
            } else {
                System.out.printf("Hackathon - Show User with Condition [%s]\n", inputCondition);
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                System.out.printf("| %-10s | %-40s | %-7s | %-20s |\n", "NIM", "Name", "ID Team", "Team Name");
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                for (User user : users) {
                    System.out.printf("| %-10s | %-40s | %-7d | %-20s |", user.nim, user.name, user.id,
                            teams.get(user.id - 1).name);
                    System.out.println();
                }
                System.out.println(
                        "------------------------------------------------------------------------------------------");
                System.out.println();
            }
        }

        // Show team with condition
        if (inputTable == 2 && inputFilter == 1) {
            String[] arrayOfCondition = { operationForCondition, conditionForCondition };
            ArrayList<Team> teams = hackathon.findTeams(columnNameForCondition, arrayOfCondition, null, null);

            System.out.println();
            if (teams.size() == 0) {
                System.out.println("Data is empty.");
            } else {
                System.out.printf("Hackathon - Show Team with Condition [%s]\n", inputCondition);
                System.out.println("------------------------------");
                System.out.printf("| %-3s | %-20s |\n", "ID", "Name");
                System.out.println("------------------------------");
                for (Team team : teams) {
                    System.out.printf("| %-3d | %-20s |", team.id, team.name);
                    System.out.println();
                }
                System.out.println("------------------------------");
                System.out.println();
            }
        }

        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
        new App();
    }
}
