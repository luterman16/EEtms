package hw210521;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String middlename;
    private int age;
    private String position;
    private String specialization;

    public Employee( String name, String surname, String middlename, int age, String position, String specialization) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.age = age;
        this.position = position;
        this.specialization = specialization;
    }

    public Employee(int id, String name, String surname, String middlename, int age, String position, String specialization) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.age = age;
        this.position = position;
        this.specialization = specialization;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
