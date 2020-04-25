import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
public class MemberTest {


    @Test
    public void editPersonalInformationTest1(){

        String input = "1\n"+"tamir";
        try{
            Member m = new Member("roei","1234","12345","roei cohen");
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.editPersonalInformation();
            assertEquals("tamir",m.getUser_name());
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }


    
}
