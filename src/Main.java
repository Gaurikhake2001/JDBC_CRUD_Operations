import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException{

        System.out.println("Employee Management");
        char ask = 0;
        do {
            System.out.println("1:create , 2:read , 3:update , 4:delete, 5:join");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("eid, ename, email, salary, department");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    String ename = sc.nextLine();
                    String email = sc.nextLine();
                    int salary = sc.nextInt();
                    sc.nextLine();
                    String department = sc.nextLine();

                    Employee emp = new Employee(eid, ename, email, salary, department);
                    EmployeeDAO.createEmployee(emp);
                    break;

                case 2:
                    ArrayList<Employee> List = EmployeeDAO.showEmployee();
                    for (Employee employee : List) {
                        System.out.println(employee);
                    }
                    break;

                case 3:
                    System.out.println("eid,ename");
                    eid = sc.nextInt();
                    sc.nextLine();
                    ename = sc.nextLine();
                    EmployeeDAO.updateEmployee(eid, ename);
                    break;

                case 4:
                    System.out.println("eid");
                    eid = sc.nextInt();
                    EmployeeDAO.deleteEmployee(eid);
                    break;

                case 5:
                    ArrayList<EmployeeAddress> l = EmployeeDAO.joinEmployeeAddress();
                    for (EmployeeAddress empadd : l) {
                        System.out.println(empadd);
                    }
                    break;
            }
            System.out.println("Do you want to continue?(Y/N)");
            ask = sc.next().charAt(0);
        } while (ask == 'Y' | ask == 'y');

    }
}