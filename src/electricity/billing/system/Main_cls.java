package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_cls extends JFrame implements ActionListener {
    String acctype;
    String meter_pass;
    Main_cls(String acctype,String meter_pass){
        this.meter_pass = meter_pass;
        this.acctype =  acctype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/billbg.png"));
        Image image = imageicon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageicon2);
        imageLabel.setBounds(300,20,250,250);
        add(imageLabel);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.BOLD,30));


        JMenuBar menuBar = new JMenuBar(); //swing
        setJMenuBar(menuBar);


        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon customerimg = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.png"));
        Image customerimage = customerimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerimage));
        newcustomer.addActionListener((this));
        menu.add(newcustomer);


        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon customerdetailimg = new ImageIcon(ClassLoader.getSystemResource("icon/customerDetails.png"));
        Image customerdetailimage = customerdetailimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerdetailimage));
       customerdetails.addActionListener((this));
        menu.add(customerdetails);

        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon depositdetailimg = new ImageIcon(ClassLoader.getSystemResource("icon/depositdetails.png"));
        Image depositdetailimage = depositdetailimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailimage));
       depositdetails.addActionListener((this));
        menu.add(depositdetails);

        JMenuItem caldetails = new JMenuItem("Calculate Bill");
        caldetails.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon caldetailimg = new ImageIcon(ClassLoader.getSystemResource("icon/calculatorbills.png"));
        Image caldetailimage = caldetailimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        caldetails.setIcon(new ImageIcon(caldetailimage));
        caldetails.addActionListener((this));
        menu.add(caldetails);

        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.BOLD,30));


        JMenuItem upinfo = new JMenuItem("Update Info");
        upinfo.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon upinfoimg = new ImageIcon(ClassLoader.getSystemResource("icon/refresh.png"));
        Image upinfoimage = upinfoimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoimage));
       upinfo.addActionListener((this));
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("View Info");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon viewinfoimg = new ImageIcon(ClassLoader.getSystemResource("icon/info.png"));
        Image viewinfoimage = viewinfoimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoimage));
       viewinfo.addActionListener((this));
        info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.BOLD,30));


        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon paybillimg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image paybillimage = paybillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillimage));
        paybill.addActionListener((this));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon billdetailsimg = new ImageIcon(ClassLoader.getSystemResource("icon/pay.png"));
        Image billdetailsimage = billdetailsimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsimage));
        billdetails.addActionListener((this));
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif",Font.BOLD,30));


        JMenuItem genbill = new JMenuItem("Generate Bill");
        genbill.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon genbillimg = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image genbillimage = genbillimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genbill.setIcon(new ImageIcon(genbillimage));
        genbill.addActionListener((this));
        bill.add(genbill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.BOLD,30));


        JMenuItem calcu = new JMenuItem("Calculator");
        calcu.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon calcuimg = new ImageIcon(ClassLoader.getSystemResource("icon/calculator.png"));
        Image calcuimage = calcuimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calcu.setIcon(new ImageIcon(calcuimage));
        calcu.addActionListener((this));
        utility.add(calcu);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,18));
        ImageIcon notepadimg = new ImageIcon(ClassLoader.getSystemResource("icon/notepad.png"));
        Image notepadimage = notepadimg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadimage));
        notepad.addActionListener((this));
        utility.add(notepad);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif",Font.BOLD,30));

        JMenuItem eexit =new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"));
        Image eexitImage = eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if(acctype.equals("Admin")){
            menuBar.add(menu);

        }else{
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);

        }

        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")) {
            new newCustomer();
        } else if (msg.equals("Customer Details")) {
            new Customer_details();
        } else if (msg.equals("Deposit Details")) {
            new deposit_details();
        } else if (msg.equals("Calculate Bill")) {
            new Calcu_bill();
        } else if (msg.equals("View Info")) {
            new view_information(meter_pass);
        }
         else if (msg.equals("Bill Details")) {
            new bill_details(meter_pass);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new pay_bill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill(meter_pass);
        }

    }

    public static void main(String[] args) {
        new Main_cls("","");
    }
}
