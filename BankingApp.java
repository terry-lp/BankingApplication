package BankingApplication;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavingsAccount SA = new SavingsAccount(new BigDecimal("0.00"), 0.11);
        ChequingAccount CA = new ChequingAccount(new BigDecimal("0.00"), 0.0);

        String mainAcc = "Bank Account Menu\n" +
                "A) Savings\n" +
                "B) Chequing\n" +
                "Q) Quit\n";
        String chequingAcc = "Chequing Account\n" +
                "A) Deposit\n" +
                "B) Withdrawal\n" +
                "C) Report\n" +
                "Q) Quit and Return to Accounts Menu";
        String savingsAcc = "Savings Account\n" +
                "A) Deposit\n" +
                "B) Withdrawal\n" +
                "C) Report\n" +
                "Q) Quit and Return to Accounts Menu";
        String accChoice = "Selection: ";
        String answer1 = null;
        String answer2 = null;
        String answer3 = null;

        while (true) {
            System.out.println(mainAcc);
            System.out.println(accChoice);
            answer1 = sc.nextLine();

            // menu for savings account
            if (answer1.equalsIgnoreCase("A")) {
                while (true) {
                    System.out.println(savingsAcc);
                    System.out.println(accChoice);
                    answer3 = sc.nextLine();
                    BigDecimal newSB = new BigDecimal(SA.getInterestRate());

                    if (answer3.equalsIgnoreCase("A")) {
                        System.out.println("How much would you like to deposit?");
                        answer1 = sc.nextLine();
                        try {
                            double chDeposit = Double.parseDouble(answer1);
                            SA.deposit();
                            System.out.println(SA.getCurrentBalance().add(BigDecimal.valueOf(chDeposit)));
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Must be digits only.");
                        }
                        break;
                    }
                    if (answer3.equalsIgnoreCase("B")) {
                        System.out.println("How much would you like to withdraw?");
                        answer3 = sc.nextLine();
                        try {
                            double sbWithdraw = Double.parseDouble(answer3);
                            SA.deposit();
                            System.out.println(SA.getCurrentBalance().subtract(BigDecimal.valueOf(sbWithdraw)));
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Must be digits only.");
                        }
                        break;
                    }
                    if (answer3.equalsIgnoreCase("C")) {
                        System.out.println("View Reports");
                        SA.generateMonthlyReport();
                        break;
                    }
                    if (answer3.equalsIgnoreCase("Q")) {
                        System.out.println("To Main Menu");
                        break;
                    }
                    break;
                }
            }

            // menu for chequing account
            if (answer1.equalsIgnoreCase("B")) {
                while (true) {
                    System.out.println(chequingAcc);
                    System.out.println(accChoice);
                    answer2 = sc.nextLine();
                    BigDecimal newCB = new BigDecimal(CA.getInterestRate());

                    if (answer2.equalsIgnoreCase("A")) {
                        System.out.println("How much would you like to deposit?");
                        answer2 = sc.nextLine();
                        try {
                            double chDeposit = Double.parseDouble(answer2);
                            SA.deposit();
                            System.out.println(CA.getCurrentBalance().add(BigDecimal.valueOf(chDeposit)));
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Must be digits only.");
                        }
                        break;
                    }
                    if (answer2.equalsIgnoreCase("B")) {
                        System.out.println("How much would you like to withdraw?");
                        answer2 = sc.nextLine();
                        try {
                            double chWithdraw = Double.parseDouble(answer2);
                            SA.deposit();
                            System.out.println(CA.getCurrentBalance().add(BigDecimal.valueOf(chWithdraw)));
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Must be digits only.");
                        }
                        break;
                    }
                    if (answer2.equalsIgnoreCase("C")) {
                        System.out.println("View Reports");
                        CA.generateMonthlyReport();
                        break;
                    }
                    if (answer2.equalsIgnoreCase("Q")) {
                        System.out.println("To Main Menu");
                        break;
                    }
                    break;
                }
            }
            if (answer1.equalsIgnoreCase("Q")) {
                System.out.println("Quit");
            }
        }
    }
}
