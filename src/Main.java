import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File("customer.txt"));
        LoginReader Lr = new LoginReader();

        Lr.testMethod(input);

        LoginPage loginPage = new LoginPage(Lr.getLoginInfo());
    }
}