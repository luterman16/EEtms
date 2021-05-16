package java.hw_140521.xmlJSON.xmlparsers;

import java.hw_140521.xmlJSON.Employee;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.Characters;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class StaxEventProcessor {
    public static void main(String[] args) {
        boolean isFirstName = false;
        boolean isLastName = false;
        boolean isMiddleName = false;
        boolean isPosition = false;
        boolean isDepartment = false;
        boolean isWorkExpirience = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader("src/hw_140521/xmlJSON/employees"));
            ArrayList<Employee> employees = new ArrayList<>();

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("employee")) {
                            employees.add(new Employee());

                        } else if (qName.equalsIgnoreCase("firstname")) {
                            isFirstName = true;
                        } else if (qName.equalsIgnoreCase("lastname")) {
                            isLastName = true;
                        } else if (qName.equalsIgnoreCase("middleName")) {
                            isMiddleName = true;
                        } else if (qName.equalsIgnoreCase("position")) {
                            isPosition = true;
                        }  else if (qName.equalsIgnoreCase("department")) {
                            isDepartment = true;
                        }  else if (qName.equalsIgnoreCase("workExpirience")) {
                            isWorkExpirience = true;
                        }

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(isFirstName) {
                            employees.get(employees.size()-1).setFirstName(characters.getData());
                            isFirstName = false;
                        }
                        if(isLastName) {
                            employees.get(employees.size()-1).setLastName(characters.getData());
                            isLastName = false;
                        }
                        if(isMiddleName) {
                            employees.get(employees.size()-1).setMiddleName(characters.getData());
                            isMiddleName = false;
                        }
                        if(isPosition) {
                            employees.get(employees.size()-1).setPosition(characters.getData());
                            isPosition = false;
                        }
                        if(isDepartment) {
                            int tmpInt = Integer.parseInt(characters.getData());
                            employees.get(employees.size()-1).setDepartment(tmpInt);
                            isDepartment = false;
                        }
                        if(isWorkExpirience) {
                            int tmpInt = Integer.parseInt(characters.getData());
                            employees.get(employees.size()-1).setWorkExpirience(tmpInt);
                            isWorkExpirience = false;
                        }
                        break;
                }
            }

            for (Employee employee: employees) {
                System.out.println(employee.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }



    }
}
