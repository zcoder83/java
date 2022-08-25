package banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bank {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String name = "";

        int pass_code, ac_no, choice;

        while (true) {
            System.out.println("\n ->||    Welcome to InBank    ||<- \n");
            System.out.println("1) Create Account");
            System.out.println("2) Login Account");
            System.out.println("3) Exit");

            try {
                System.out.print("\n    Enter choice: ");
                choice = Integer.parseInt(sc.readLine());

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter Username: ");
                            name = sc.readLine();
                            System.out.print("Enter Password: ");
                            pass_code = Integer.parseInt(sc.readLine());

                            if (BankManagement.createAccount(name, pass_code)) {
                                System.out.println("Account created successfully!\n");
                            } else {
                                System.out.println("Account creation failed!\n");
                            }
                        } catch (Exception e) {
                            System.out.println("Enter Valid Data - Account creation failed\n");
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter Username: ");
                            name = sc.readLine();
                            System.out.print("Enter Password: ");
                            pass_code = Integer.parseInt(sc.readLine());

                            if (BankManagement.loginAccount(name, pass_code)) {
                                System.out.println("Logged in successfully!\n");
                            } else {
                                System.out.println("Login Failed!\n");
                            }
                        } catch (Exception e) {
                            System.out.println("Enter valid data - Login Failed");
                        }
                        break;
                    default:
                        System.out.println("Invalid Entry\n");
                }
                if (choice == 3) {
                    System.out.println("Exited successfully!\n\n Thank you!!!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter valid entry!");
            }
        }
        sc.close();
    }
}
