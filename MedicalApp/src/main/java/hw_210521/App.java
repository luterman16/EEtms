package hw_210521;

import hw210521.CRUDUtils;
import hw210521.Employee;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Employee employee = new Employee(
                "Alex",
                "Ivanov",
                "Ivanovich",
                35,
                "Doctor",
                "LOR"
        );


        List<Employee> employeeList = CRUDUtils.getEmployeesData("SELECT * FROM employees");
        System.out.println(employeeList);

        List<Employee> updateEmployee = CRUDUtils.updateEmployee(1,"Top Doctor");
        System.out.println(updateEmployee);

        List<Employee> addEmployeeList = CRUDUtils.saveEmployee(employee);
        System.out.println(addEmployeeList);

        List<Employee> withDeletedEmployees = CRUDUtils.deleteEmployee(1);
        System.out.println(withDeletedEmployees);

    }
}
