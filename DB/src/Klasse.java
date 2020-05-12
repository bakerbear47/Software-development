import java.sql.*;
import java.util.Scanner;

public class Klasse {
    public static void creatNewDatabase(String klasse) {

        String url = "jdbc:sqlite:C:/Users/baker/Documents/" + klasse;


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is" + meta.getDriverName());
                System.out.println("A new database has been created");
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        creatNewDatabase("SKOLE.db");




        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/baker/Documents/SKOLE.db";

            conn = DriverManager.getConnection(url);
            System.out.println("Connection established");

            Statement stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM SKOLE";

            ResultSet rs = stmt.executeQuery(sql);

            PresentStudents(rs);

            /*
            System.out.println("Which student do you wish to find?");
            Scanner scanner = new Scanner(System.in);
            String Student = scanner.nextLine();

            sql = "SELECT * FROM SKOLE WHERE StudentID= '"+Student+"'";

            ResultSet rs = stmt.executeQuery(sql);

            PresentStudents(rs);
*/






        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null){
                    conn.close();
                    System.out.println("Connection closed");
                }
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    static public void PresentStudents(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No records for user");
        while (res != null & res.next()) {
            String name = res.getString("FirstName");
            int StudentID = res.getInt("StudenID");
            int Grade1 = res.getInt("Grade1");
            System.out.println(StudentID + " " + name +" " + Grade1);
        }
    }

}

/*            throw new Error("problem", e);
        } finally {
            try {
                if (Klasse.conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }


}*/
