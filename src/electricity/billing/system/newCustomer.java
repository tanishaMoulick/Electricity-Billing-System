package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {
    JLabel heading,customerName,meternum,address,city,state,email,phone;
    JButton cancel,next;
    TextField nameText,meterText,addsText,cityText,stateText,emailText,phoneText;
    newCustomer(){
        super("New Customer");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(heading);

        customerName = new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(200,80,150,20);
        panel.add(nameText);

        meternum = new JLabel("Meter Number");
        meternum.setBounds(50,120,150,20);
        panel.add(meternum);

        meterText = new TextField();
        meterText.setBounds(200,120,150,20);
        panel.add(meterText);

        Random ram = new Random();
        long number = ram.nextLong() % 1000000;  //util
        meterText.setText(""+ Math.abs(number));

        address = new JLabel("Address");
        address.setBounds(50,160,150,20);
        panel.add(address);

        addsText = new TextField();
        addsText.setBounds(200,160,150,20);
        panel.add(addsText);

        city = new JLabel("City");
        city.setBounds(50,200,150,20);
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(200,200,150,20);
        panel.add(cityText);

//        state = new JLabel("State");
//        state.setBounds(50,240,150,20);
//        panel.add(state);
//
//        stateText = new TextField();
//        stateText.setBounds(200,240,150,20);
//        panel.add(stateText);

        email = new JLabel("Email");
        email.setBounds(50,280,150,20);
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(200,280,150,20);
        panel.add(emailText);

        phone = new JLabel("Phone Number");
        phone.setBounds(50,320,150,20);
        panel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(200,320,150,20);
        panel.add(phoneText);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(240,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        //imgLabel.setBounds(300,20,250,250);
        add(imgLabel,"West");



        setSize(700,500);
        setLocation(400,200);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String sname = nameText.getText();
            String smeter = meterText.getText();
            String saddress = addsText.getText();
            String scity = cityText.getText();
            //String sstate = stateText.getText();
            String sphn = phoneText.getText();
            String semail = emailText.getText();

            String query_customer = "INSERT INTO new_customer VALUES ('" + sname + "','" + smeter + "','" + saddress + "','" + scity + "','" + sphn + "','" + semail + "')";
            String query_signup = "INSERT INTO Signup VALUES ('" + smeter + "','" + sname + "','','')";


            try{
                Database c= new Database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new Meterinfo(smeter);


            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();

    }
}
