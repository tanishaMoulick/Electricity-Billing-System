package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener {
    Choice loginAsCho;
    TextField meterText,empText,userText,passText;
    JButton create,back;
    Signup() {
        super("Sign Up");
        getContentPane().setBackground(Color.PINK);

        JLabel createAs = new JLabel("Create Account");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho = new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,120,20);
        add(loginAsCho);

        JLabel meterno = new JLabel("Meter No.");
        meterno.setBounds(30,100,125,20);
        meterno.setVisible(false);
        add(meterno);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel empno = new JLabel("Employer ID.");
        empno.setBounds(30,100,125,20);
        empno.setVisible(true);
        add(empno);

        empText = new TextField();
        empText.setBounds(170,100,125,20);
        empText.setVisible(true);
        add(empText);

        JLabel userName = new JLabel("User Name");
        userName.setBounds(30,140,125,20);
        add(userName);

        userText = new TextField("");
        userText.setBounds(170,140,125,20);
        add(userText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup  where meter_no = '"+meterText.getText()+"'");
                    if (resultSet.next()){
                        userText.setText(resultSet.getString("username"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });

        JLabel password = new JLabel("Password");
        password.setBounds(30,180,125,20);
        add(password);

        passText = new TextField();
        passText.setBounds(170,180,125,20);
        add(passText);

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if(user.equals("Customer")){
                    empno.setVisible(false);
                    empText.setVisible(false);
                    meterno.setVisible(true);
                    meterText.setVisible(true);

                }else{
                    empno.setVisible(true);
                    empText.setVisible(true);
                    meterno.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        create = new JButton("Create");
        create.setBackground(Color.lightGray);
        create.setBounds(40,265,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(180,265,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon signicon = new ImageIcon(ClassLoader.getSystemResource("icon/signupp.png"));
        Image signimg = signicon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon signtwo = new ImageIcon(signimg);
        JLabel signLabel = new JLabel(signtwo);
        signLabel.setBounds(300,20,250,250);
        add(signLabel);









        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== create){
            String sloginAs = loginAsCho.getSelectedItem();
            String susername = userText.getText();
            String spassword = passText.getText();
            String smeter = meterText.getText();
            try{
               Database c = new Database();
               String query = null;

               query = "insert into Signup value('"+smeter+"', '"+susername+"', '"+spassword+"', '"+sloginAs+"')";
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Account created");
               setVisible(false);
               new Login();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()== back){
            setVisible(false);
            new Login();

        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}