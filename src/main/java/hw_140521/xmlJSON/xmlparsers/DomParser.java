package java.hw_140521.xmlJSON.xmlparsers;

import java.hw_140521.xmlJSON.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser {
    private static final ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/hw_140521/xmlJSON/employees"));

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            employees.add(getEmployee(employee));
        }

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        //поиск сотрудника
        findEmployee(employeeElements, "Alena", "Alenovskaya", "Alekseevna");
    }

    private static void findEmployee(NodeList employeeElements, String firstname, String lastname, String middlename) {
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            String actualFirstName = getTagValue("firstName", employee);
            String actualLastName = getTagValue("lastName", employee);
            String actualMiddleName = getTagValue("middleName", employee);

            if (actualFirstName.equalsIgnoreCase(firstname) && actualLastName.equalsIgnoreCase(lastname) && actualMiddleName.equalsIgnoreCase(middlename)) {
                Employee findedEmployee = getEmployee(employeeElements.item(i));
                System.out.printf("Имя: %s \nФамилия: %s \nДолжность: %s \nОтделение: %s \nСтаж работы: %s",
                        findedEmployee.getFirstName(),
                        findedEmployee.getLastName(),
                        findedEmployee.getPosition(),
                        findedEmployee.getDepartment(),
                        findedEmployee.getWorkExpirience()
                );
            }
        }
    }

    private static Employee getEmployee(Node node) {
        Employee employee = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            employee.setFirstName(getTagValue("firstName", element));
            employee.setLastName(getTagValue("lastName", element));
            employee.setMiddleName(getTagValue("middleName", element));
            employee.setDepartment(Integer.parseInt(getTagValue("department", element)));
            employee.setWorkExpirience(Integer.parseInt(getTagValue("workExpirience", element)));
            employee.setPosition(getTagValue("position", element));
        }
        return employee;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}

