import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
public class RegisterTest {

    @Test
    public void registerToSystemTest1(){
        String user_name_one = "roei\n"+"1234\n"+"12345\n"+"roei cohen\n";
        Register r= new Register();
        try {

            InputStream inputStream1 = new ByteArrayInputStream(user_name_one.getBytes("UTF8"));
            System.setIn(inputStream1);
            assertTrue(r.registerToSystem());
        }
        catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void registerToSystemTest2(){
        String user_name_one = "roei\n"+"1234\n"+"12345\n"+"roei cohen\n";
        Register r= new Register();
        try {
            InputStream inputStream1 = new ByteArrayInputStream(user_name_one.getBytes("UTF8"));
            System.setIn(inputStream1);
            assertFalse(r.registerToSystem());
        }
        catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }
}
