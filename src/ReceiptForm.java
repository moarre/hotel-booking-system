import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ReceiptForm extends JFrame implements ActionListener {
    private JLabel sign;
    private JLabel totalPrice;
    private JLabel lblWish;
    private JPanel pnlReceipt;
    private JLabel lblOrder;
    private JLabel lblTotal;
    private JLabel sign2;
    private JButton btnPrint;
    private JLabel lblDesc;
    private JLabel lblDate;

    public ReceiptForm(int totalcost,String orderName, String date, int Price, int Day) {
        super.setContentPane(pnlReceipt);
        super.setBounds(100,100,500,500);

        lblOrder.setText(orderName);
        //int totalcost = 12;
        totalPrice.setText("RM" + totalcost);
        lblDate.setText(date);
        lblDesc.setText(Day + "days" + " x" + " RM" + Price);

        sign.setForeground(Color.BLACK);
        sign.setBackground(Color.WHITE);
        sign.setFont(new Font("Arial", Font.BOLD, 19));
        sign.setBounds(140,40,200,40);

        sign2.setFont(new Font("Arial", Font.PLAIN, 14));

        lblOrder.setFont(new Font("Monospaced", Font.BOLD, 14));
        lblDesc.setFont(new Font("Monospaced", Font.ITALIC, 12));
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        totalPrice.setFont(new Font("Arial", Font.BOLD, 16));
        lblWish.setFont(new Font("Arial", Font.ITALIC, 14));
        lblDate.setFont(new Font("Arial", Font.BOLD, 12));

        btnPrint.setBackground(new Color(153,130,188));
        btnPrint.setForeground(Color.WHITE);
        btnPrint.setFont(new Font("Arial", Font.BOLD, 15));
        btnPrint.setBounds(70,260,60,20);
        btnPrint.setFocusable(false);
        btnPrint.addActionListener(this);

        super.setVisible(true);
    }

    /*
    public static void main(String args[]) {
        ReceiptForm of = new ReceiptForm();
    }
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnPrint){
            //JOptionPane.showMessageDialog(this, "User clicked this button");
            try {
                //prepare Printwriter
                PrintWriter pw = new PrintWriter("Receipt.txt");

                //print header
                pw.println("\t\t\tHOTEL LANG BUANA\t\t\t");
                pw.println("=========================================");
                pw.println("\t\t\t\tReceipt\t\t\t\t");

                //print body
                pw.println("Date Book\t\t" + ": " + lblDate.getText());
                //pw.println("(First Day Only)");
                pw.println("Room\t\t" + "    : "  + lblOrder.getText());
                pw.println("Price\t\t" + "    : " + lblDesc.getText() + " = " + totalPrice.getText());

                //print footer
                pw.println("=========================================");
                pw.println("\t\t\t\tTHANK YOU\t\t\t\t");

                JOptionPane.showMessageDialog(this, "Success");

                //close stream
                pw.close();
            }
            catch (Exception w) {
                System.out.println("Error");
            }
        }
    }

}
