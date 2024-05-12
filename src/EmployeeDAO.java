import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    public static void createEmployee(Employee employee) throws SQLException {

        Connection con = DB.connect();
        String query = Query.insert;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,employee.getEid());
        ps.setString(2,employee.getEname());
        ps.setString(3,employee.getEmail());
        ps.setInt(4,employee.getSalary());
        ps.setString(5,employee.getDepartment());

        System.out.println("Values Inserted Successfully! ");
        ps.executeUpdate();
        ps.close();

    }

    public static void updateEmployee(int eid, String ename) throws SQLException {

        Connection con = DB.connect();
        String query = Query.update;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,ename);
        ps.setInt(2,eid);

        System.out.println("Name is updated successfully ");
        ps.executeUpdate();
        ps.close();

    }

    public static void deleteEmployee(int eid) throws SQLException {

        Connection con = DB.connect();
        String query = Query.delete;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,eid);

        System.out.println(" Record deleted Successfully! ");
        ps.executeUpdate();
        ps.close();

    }

    public static ArrayList<Employee> showEmployee() throws SQLException {
        ArrayList<Employee> empList  = new ArrayList<Employee>();
        Connection con = DB.connect();
        String query = Query.select;

        Statement st = con.prepareStatement(query);
        System.out.println("Employee details are above: ");
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            Employee emp = new Employee(rs.getInt(1) ,rs.getString(2) , rs.getString(3) ,rs.getInt(4) , rs.getString(5));
            empList.add(emp);
        }
        st.close();
        return empList;
    }

    public static ArrayList<EmployeeAddress> joinEmployeeAddress() throws SQLException{
        ArrayList<EmployeeAddress> list = new ArrayList<EmployeeAddress>();
        Connection con = DB.connect();
        String query = Query.join;

        Statement st = con.prepareStatement(query);
        System.out.println("Employee details are above: ");
        ResultSet rs = st.executeQuery(query);

        while(rs.next())
        {
            Employee emp = new Employee(
                    rs.getInt("eid"),
                    rs.getString("ename"),
                    rs.getString("email"),
                    rs.getInt("salary"),
                    rs.getString("department")
            );

            Address add = new Address(
                    rs.getInt("houseNo"),
                    rs.getString("street"),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("country")
            );

            EmployeeAddress empadd = new EmployeeAddress(emp , add);
            list.add(empadd);
        }
        st.close();
        return list;
    }
    }



