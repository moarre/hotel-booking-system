import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class HomePage extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    private JTextField textDays;
    private JTextField textDate;
    private JRadioButton btnSingle;
    private JRadioButton btnDouble;
    private JRadioButton btnQueen;
    private JRadioButton btnKing;
    private JLabel sign;
    private JLabel lblDay;
    private JLabel lblDate;
    private JLabel order1;
    private JLabel order2;
    private JLabel order3;
    private JLabel order4;
    private JPanel pnlHome;
    private JButton btnConfirm;
    private JLabel cHorder1;
    private JLabel cHorder2;
    private JLabel cHorder3;
    private JLabel cHorder4;
    private JLabel lblFormat;
    private JButton btnLogout;
    private JLabel lblFormat2;
    ButtonGroup G1;

    public HomePage () {
        super();
        super.setContentPane(pnlHome);

        // Initialization of object of "ButtonGroup" class.
        G1 = new ButtonGroup();

        // Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2".
        G1.add(btnSingle);
        G1.add(btnDouble);
        G1.add(btnQueen);
        G1.add(btnKing);

        //super.setSize(500,500);
        super.setBounds(100,100,500,500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        sign.setForeground(Color.BLACK);
        sign.setBackground(Color.WHITE);
        sign.setFont(new Font("Arial", Font.BOLD, 19));
        sign.setBounds(140,40,200,40);

        lblDay.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDate.setFont(new Font("Arial", Font.PLAIN, 14));
        lblFormat.setFont(new Font("Monospaced", Font.ITALIC, 10));
        lblFormat2.setFont(new Font("Arial", Font.ITALIC, 10));

        btnConfirm.setBackground(new Color(153,130,188));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Arial", Font.BOLD, 15));
        btnConfirm.setBounds(70,260,60,20);
        btnConfirm.setFocusable(false);
        btnConfirm.addActionListener(this);

        btnLogout.setBackground(new Color(153,130,188));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
        btnLogout.setBounds(70,260,60,20);
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(this);

        order1.setFont(new Font("Arial", Font.BOLD, 12));
        order2.setFont(new Font("Arial", Font.BOLD, 12));
        order3.setFont(new Font("Arial", Font.BOLD, 12));
        order4.setFont(new Font("Arial", Font.BOLD, 12));

        cHorder1.setFont(new Font("Arial", Font.PLAIN, 12));
        cHorder2.setFont(new Font("Arial", Font.PLAIN, 12));
        cHorder3.setFont(new Font("Arial", Font.PLAIN, 12));
        cHorder4.setFont(new Font("Arial", Font.PLAIN, 12));

        super.setVisible(true);
    }

    /*
    public static void main(String args[]) {
        HomePage of = new HomePage();
    }
     */

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            //JOptionPane.showMessageDialog(this, "User clicked this button");
            int price = 0;
            String order = "";
            if ( btnSingle.isSelected()) {
                price = 70;
                order = "Single 'Solo'";
            }
            else if (btnDouble.isSelected()) {
                price = 140;
                order = "Double 'Marble'";
            }
            else if (btnQueen.isSelected()) {
                price = 210;
                order = "Queen 'Meow'";
            }
            else if (btnKing.isSelected()) {
                price = 280;
                order = "King 'Taeyeon'";
            }

            String dateS = textDate.getText();

            String dayS = textDays.getText();
            int day = Integer.parseInt(dayS);

            int totalcost = price*day;
            ReceiptForm rf = new ReceiptForm(totalcost, order, dateS, price, day);
        }

        if (e.getSource() == btnLogout) {
            try {
                Scanner input = new Scanner(new File("customer.txt"));
                LoginReader Lr = new LoginReader();

                Lr.testMethod(input);

                super.setVisible(false);
                //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                LoginPage loginPage = new LoginPage(Lr.getLoginInfo());
            }
            catch (Exception h) {
                h.printStackTrace();
            }
        }
    }
}
