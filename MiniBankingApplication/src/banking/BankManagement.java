package banking;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.*;

// this class provides all bank method
public class BankManagement {

    private static final int NULL = 0;

    static Connection con = connection.getConnection();
    static String sql = "";

    // create bank account
    public static boolean createAccount(String name, int passCode) {
        try {
            // check valid data
            if(name == "" || passCode == NULL) {
                System.out.println("All Field Required");
                return false;
            }
            // query
            Statement st = con.createStatement();
            sql = "INSERT INTO customer(cname, balance, pass_code) values('" + name + "', 1000, " + passCode + ")";

            // Execution
            if(st.executeUpdate(sql) == 1) {
                System.out.println(name + ", Now you are logged in!");
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
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            // execution
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
                            if ()
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch () {

        }
    }
}
