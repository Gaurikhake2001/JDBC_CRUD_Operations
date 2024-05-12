public class EmployeeAddress {
    private Employee employee;
    private Address address;

    EmployeeAddress(Employee employee, Address address)
    {
        this.employee = employee;
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                employee + " " +address +
                '}';
    }
}
