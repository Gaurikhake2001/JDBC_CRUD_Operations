import java.sql.Connection;
import java.sql.DriverManager;



public class DB {

    static Connection con = null;
    public static Connection connect()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/Employee?useUnicode=yes&characterEncoding=UTF-8&useSSl=false&allowPublicKeyRetrieval=true";
            String root = "root";
            String password = "gauri";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,root,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        finally {
//            if (con != null) {
//                try {
//                    con.close();
//                    System.out.println("Database Connection Terminated");
//                } catch (Exception e) {}
//            }
//        }
        return con;
    }



}
