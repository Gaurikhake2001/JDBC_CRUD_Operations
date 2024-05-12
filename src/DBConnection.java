import java.sql.DriverManager;
import java.sql.Connection;
public class DBConnection {

    public static void main(String args[]) throws Exception
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/Employee";
            String root = "root";
            String password = "gauri";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,root,password);

            System.out.println("Connection Established successfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();


        }


    }
}
