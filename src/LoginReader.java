import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LoginReader {
    HashMap<String,String> logininfo = new HashMap<>();
    public void testMethod(Scanner x)
    {
        try {
            ArrayList<String> arrayStaff = new ArrayList<>();

            while (x.hasNextLine()) {
                // read one line
                String line = x.nextLine();

                // split string
                String tokens[] = line.split(";");

                //declare tokens
                arrayStaff.add(tokens[0]);
                arrayStaff.add(tokens[1]);
                arrayStaff.add(tokens[2]);
            }

            //compare staff.txt with login pass
            for (int i=0; i<arrayStaff.size(); i+=3)
            {
                logininfo.put(arrayStaff.get(i+1),arrayStaff.get(i+2));
            }

            //System.out.println(logininfo);

            //close stream
            x.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
    public HashMap getLoginInfo(){
        return logininfo;
    }
}
