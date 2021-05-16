package java.hw_140521.xmlJSON.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonExample2 {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Staff staff = mapper.readValue(new File("staff.json"), Staff.class);

            String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            System.out.println(staff2);

            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(prettyStaff1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}