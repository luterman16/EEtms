package java.hw_140521.xmlJSON.xmlparsers;

import java.hw_140521.xmlJSON.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParserSax {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();

            parser.parse(new File("src/hw_140521/xmlJSON/employees"), handler);

            for (Employee employee: employees){
                System.out.println(employee.getFirstName());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class XMLHandler extends DefaultHandler {
        String stringContent;
        int intContent;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes){
            if (qName.equals("employee")){
                employees.add(new Employee());
           }
        }

        public void characters(char[] ch, int start, int length) {
            stringContent = String.copyValueOf(ch, start, length).trim();
        }

        public void endElement(String uri, String localName, String qName) {
            switch(qName){
                case "firstName":
                    employees.get(employees.size()-1).setFirstName(stringContent);
                    break;
                case "lastName":
                    employees.get(employees.size()-1).setLastName(stringContent);
                    break;
                case "middleName":
                    employees.get(employees.size()-1).setMiddleName(stringContent);
                    break;
                case "position":
                    employees.get(employees.size()-1).setPosition(stringContent);
                    break;
                case "department":
                    intContent = Integer.parseInt(stringContent);
                    employees.get(employees.size()-1).setDepartment(intContent);
                    break;
                case "workExpirience":
                    intContent = Integer.parseInt(stringContent);
                    employees.get(employees.size()-1).setWorkExpirience(intContent);
                    break;
            }
        }
    }
}
