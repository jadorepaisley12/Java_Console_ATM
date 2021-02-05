package com.javaatm;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("This is the ATM!");


        boolean correctCreds = false;
        float balance = 0.0f;

        for (int i = 1; i <= 3 && !correctCreds; i++) {
            if (i > 1) {
                System.out.println(String.format("You did not enter the correct credentials. Please try again. You have %d attempts left.", (3 - i + 1)));
            }
            System.out.println("Please enter your username");

            String username = scanner.nextLine().trim();

            System.out.println("Please enter your pin: ");

            String pin = scanner.nextLine().trim();

            String hardUsername = "bob";
            String hardPin = "1234";

            if (username.equalsIgnoreCase(hardUsername) && pin.equals(hardPin)) {
                correctCreds = true;
            }
        }

        boolean running = true;

        while (running && correctCreds) {
            System.out.println("Please choose an option:\nD) Deposit\nW) Withdraw\nI) Info\nE) Exit");


            String userInput = scanner.nextLine().toLowerCase();


            switch (userInput) {
                case "d":
                case "deposit":
                    System.out.println("How much do you want to deposit?");

                    float depositAmt = Float.parseFloat(scanner.nextLine());

                    balance += depositAmt;

                    System.out.println(String.format("Your account balance is now: $%.02f", balance));

                    break;
                case "w":
                case "withdraw":
                    System.out.println(String.format("Your current account balance is $%.02f.", balance));
                    System.out.println("How much would you like to withdraw?");
                    float withdrawAmt = Float.parseFloat(scanner.nextLine());
                    if (withdrawAmt <= balance) {
                        balance -= withdrawAmt;
                    } else {
                        System.out.println("You do not have sufficient funds to make that transaction.");
                        break;
                    }
                    System.out.println(String.format("Your new account balance is $%.02f.", balance));
                    break;
                case "i":
                case "info":
                    System.out.println(String.format("Your current account balance is $%.02f.", balance));
                    break;
                case "e":
                case "x":
                case "exit":
                    running = false;
                    continue;
                default:
                    System.out.println("I did not understand that input. Please try again.");
                    break;
            }

            System.out.println("Would you like to perform another operation? Type yes or no");


            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase("no")) {
                running = false;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the ATM. Please come back soon!");
    }
}
