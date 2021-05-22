package hw210521;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static String INSERT_EMPLOYEE = "INSERT INTO employees(name, surname, middlename, age, position, specialization) VALUES (?, ?, ?, ?, ?, ?);";
    private static String UPDATE_EMPLOYEE = "UPDATE employees SET position = ? WHERE id = ?";
    private static String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id = ?";


    public static List<Employee> getEmployeesData(String query) {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middlename = rs.getString("middlename");
                int age = rs.getInt("age");
                String position = rs.getString("position");
                String specialization = rs.getString("specialization");
                employees.add(new Employee(id, name, surname, middlename,age,position,specialization ));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;

    }

    public static List<Employee> saveEmployee(Employee employee) {
        List<Employee> updateEmployees = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getMiddlename());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setString(6, employee.getSpecialization());
            preparedStatement.executeUpdate();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middlename = rs.getString("middlename");
                int age = rs.getInt("age");
                String position = rs.getString("position");
                String specialization = rs.getString("specialization");
                updateEmployees.add(new Employee(id, name, surname, middlename,age,position,specialization ));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
        return updateEmployees;
    }


    public static List<Employee> updateEmployee(int studentId, String position) {
        List<Employee> updatedEmployees = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE)) {

            preparedStatement.setString(1, position);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middlename = rs.getString("middlename");
                int age = rs.getInt("age");
                String positionEdit = rs.getString("position");
                String specialization = rs.getString("specialization");
                updatedEmployees.add(new Employee(id, name, surname, middlename, age, positionEdit, specialization));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return updatedEmployees;
    }

    public static List<Employee> deleteEmployee(int studentId) {
        List<Employee> updatedEmployees = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.execute();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middlename = rs.getString("middlename");
                int age = rs.getInt("age");
                String positionEdit = rs.getString("position");
                String specialization = rs.getString("specialization");
                updatedEmployees.add(new Employee(id, name, surname, middlename, age, positionEdit, specialization));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updatedEmployees;
    }
}
