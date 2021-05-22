package java.hw_140521.jdbc;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Ivan");
        student.setCurs_name("Java Core");
        student.setSurname("Ivanov");
        System.out.println(CRUDUtils.saveStudent(student));

        List<Student> studentList = CRUDUtils.getStudentData("SELECT * FROM students");
        System.out.println(studentList);

        List<Student> updateStudent = CRUDUtils.updateStudent(1,"Java EE");
        System.out.println(updateStudent);

        List<Student> withDeletedStudents = CRUDUtils.deleteStudent(1);
        System.out.println(withDeletedStudents);

    }
}
