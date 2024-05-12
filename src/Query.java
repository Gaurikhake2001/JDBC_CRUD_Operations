public class Query {

    final static String insert = "insert into Employee values(?,?,?,?,?)";
    final static String update = "update Employee set ename=? where eid=?";
    final static String delete = "delete from Employee where eid=?";
    final static String select = "select * from Employee";
    final static String join = "select * from Employee inner join Address on Employee.eid = Address.eid";
}
