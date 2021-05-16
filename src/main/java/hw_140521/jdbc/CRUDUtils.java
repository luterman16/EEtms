package java.hw_140521.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static String INSERT_STUDENT = "INSERT INTO students(name, surname, course_name) VALUES (?, ?, ?);";
    private static String UPDATE_STUDENT = "UPDATE students SET course_name = ? WHERE id = ?";
    private static String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";


    public static List<Student> getStudentData(String query) {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");

                students.add(new Student(id, name, surname, course_name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;

    }

    public static List<Student> saveStudent(Student student) {
        List<Student> updateStudents = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getCurs_name());
            preparedStatement.executeUpdate();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");
                updateStudents.add(new Student(id, name, surname, course_name));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
        return updateStudents;
    }


    public static List<Student> updateStudent(int studentId, String courseName) {
        List<Student> updatedStudents = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {

            preparedStatement.setString(1, courseName);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");
                updatedStudents.add(new Student(id, name, surname, course_name));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return updatedStudents;
    }

    public static List<Student> deleteStudent(int studentId) {
        List<Student> updatedStudents = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.execute();

            PreparedStatement allStudentsStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = allStudentsStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");
                updatedStudents.add(new Student(id, name, surname, course_name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updatedStudents;
    }
}
