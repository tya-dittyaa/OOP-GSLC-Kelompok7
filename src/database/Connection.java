package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Connection {
  Scanner scan = new Scanner(System.in);

  public void readFile() {
    int x = 0;
    System.out.println("WHich table to show? 1. User | 2. Team");
    x = scan.nextInt();
    scan.nextLine();
    
    if(x == 1) {
      System.out.println("this is user file: ");

      try {
        FileReader fileInput = new FileReader("src/database/user.csv");
        BufferedReader reader = new BufferedReader(fileInput);

        reader.readLine();

        String line;

        while ((line = reader.readLine()) != null) {
          String[] splitResult = line.split(",");
          String nim = splitResult[0];
          String name = splitResult[1];
          Integer team = Integer.parseInt(splitResult[2]);
          System.out.printf("NIM: %s | Name: %s | Team: %d\n", nim, name, team);
        }

        reader.close();
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }

    } else {
      System.out.println("this is team file: ");

      try {
        FileReader fileInput = new FileReader("src/database/teams.csv");
        BufferedReader reader = new BufferedReader(fileInput);

        reader.readLine();

        String line;

        while ((line = reader.readLine()) != null) {
          String[] splitResult = line.split(",");
          String nim = splitResult[0];
          String teamName = splitResult[1];
          System.out.printf("NIM: %s | Team Name: %s\n", nim, teamName);
        }
        reader.close();
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }

    }

  }

  public void writeFile() {
    int x = 0;
    System.out.println("Which table to insert? 1. User | 2. Team");
    x = scan.nextInt();
    scan.nextLine();
    
    if(x == 1) {
      String nim, name;
      int id;

      System.out.print("Enter name: ");
      name = scan.nextLine();

      System.out.print("Enter nim: ");
      nim = scan.nextLine();

      System.out.print("Enter id team: ");
      id = scan.nextInt();
      scan.nextLine();

      System.out.println("you are in user file: ");

      try {
        FileWriter fileInput = new FileWriter("src/database/user.csv", true);
        BufferedWriter writer = new BufferedWriter(fileInput);

        writer.write(nim + "," + name + "," + id);

        writer.close();
      } catch (Exception e) {
        // do nothing
      }

      System.out.println("User data successfully inserted!");

    } 
    else if(x == 2) {
      String teamName;
      int id;

      System.out.print("Enter team name: ");
      teamName = scan.nextLine();

      System.out.print("Enter id team: ");
      id = scan.nextInt();
      scan.nextLine();

      System.out.println("you are in user file: ");

      try {
        FileWriter fileInput = new FileWriter("src/database/teams.csv", true);
        BufferedWriter writer = new BufferedWriter(fileInput);

        writer.write(id + "," + teamName);

        writer.close();
      } catch (Exception e) {
        // do nothing
      }
      
      System.out.println("Team data successfully inserted!");
    }
    else {
      System.out.println("Invalid input");
    }

  }
}