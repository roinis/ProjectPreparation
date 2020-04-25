import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class StadiumTest {

    @Test
    public void stadiumDetailsTest(){
        String name,city;
        name="Turner Stadium";
        city="Beer-Sheva";
        Stadium stadium=new Stadium(name,city);
        assertEquals("Turner Stadium",stadium.getStadiumName());
        assertEquals("Beer-Sheva",stadium.getCity());
    }

    @Test
    public void editDetailsTest() {
        String input = "Toto Turner";
        try {
            InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream);
            String name, city;
            name = "Turner Stadium";
            city = "Beer-Sheva";
            Stadium stadium = new Stadium(name, city);
            stadium.editDetails();
            assertEquals("Toto Turner", stadium.getStadiumName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
