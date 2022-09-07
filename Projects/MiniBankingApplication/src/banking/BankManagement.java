package banking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

// this class provides all bank method
public class BankManagement {

    private static final int NULL = 0;

    static Connection con = connection.getConnection();
    static String sql = ""; // class variable

    // create bank account
    public static boolean createAccount(String name, int passCode) {
        try {
            // check valid data
            if(name == "" || passCode == NULL) {
                System.out.println("All Field Required");
                return false;
            }
            // query - general purpose access to database
            Statement st = con.createStatement();
            sql = "INSERT INTO customer(cname, balance, pass_code) values('" + name + "', 1000, " + passCode + ")";

            // Execution
            if(st.executeUpdate(sql) == 1) {
                System.out.println(name + ", please proceed to log in");
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username Not Available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // log in
    public static boolean loginAccount(String name, int passCode) {
        try {
            // check valid data
            if (name == "" || passCode == NULL) {
                System.out.println("All Field Required!");
                return false;
            }
            // query
            sql = "SELECT * FROM customer WHERE cname='" + name + "' AND pass_code=" + passCode;
            PreparedStatement st = con.prepareStatement(sql); // can be used "?" as parameter.
            ResultSet rs = st.executeQuery();
            // reader
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            if (rs.next()) {
                int ch = 5;
                int amt = 0;
                int senderAc = rs.getInt("ac_no");
                int receiveAc;
                while (true) {
                    try {
                        System.out.println("Hello, " + rs.getString("cname"));
                        System.out.println("1) Transfer Money");
                        System.out.println("2) View Balance");
                        System.out.println("3) Log Out");
                        System.out.print("Enter your choice: ");

                        ch = Integer.parseInt(sc.readLine());
                        if (ch == 1) {
                            System.out.print("Enter Receiver Account No: ");
                            receiveAc = Integer.parseInt(sc.readLine());
                            System.out.print("Enter Amount: ");
                            amt = Integer.parseInt(sc.readLine());
                            if (BankManagement.transferMoney(senderAc, receiveAc, amt)) {
                                System.out.println("Money sent successfully!\n");
                            } else {
                                System.out.println("Money Transfer Failed!\n");
                            }
                        } else if (ch == 2) {
                            BankManagement.getBalance(senderAc);
                        } else if (ch == 3) {
                            break;
                        } else {
                            System.out.println("Enter valid input!\n");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                return false;
            }
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Username not available!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // fetch balance
    public static void getBalance(int actNo) {
        try {
            sql = "SELECT * FROM customer WHERE ac_no=" + actNo;
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%12s %10s %10s\n", "Account No", "Name", "Balance");

            // print balance
            while (rs.next()) {
                System.out.printf("%12d %10s %10d.00\n",
                        rs.getInt("ac_no"),
                        rs.getString("cname"),
                        rs.getInt("balance"));
            }
            System.out.println("-----------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // transfer money
    public static boolean transferMoney(int sender_ac, int receiver_ac, int amt) throws SQLException{
        // check validation
        if (receiver_ac == NULL || amt == NULL) {
            System.out.println("All Field Required!");
            return false;
        }
        try {
            con.setAutoCommit(false);
            sql = "SELECT * FROM customer WHERE ac_no=" + sender_ac;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // check the balance amount
            if (rs.next()) {
                if (rs.getInt("balance") < amt) {
                    System.out.println("Insufficient Balance!");
                    return false;
                }
            }
            Statement st = con.createStatement();

            // subtract money from sender's account
            con.setSavepoint(); // set savepoint
            sql = "UPDATE customer SET balance=balance-" + amt + " WHERE ac_no=" + sender_ac;
            if (st.executeUpdate(sql) == 1) {
                System.out.println("Amount subtracted!");
            }
            // add money to receiver's account
            sql = "UPDATE customer SET balance=balance+" + amt + " WHERE ac_no=" + receiver_ac;
            st.executeUpdate(sql);
            con.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return false;
    }
}




























