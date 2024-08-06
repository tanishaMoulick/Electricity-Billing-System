package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Calcu_bill extends JFrame implements ActionListener {
    Choice meternumCho,monthCho;
    JLabel nameText,addressText;
    TextField unitText;
    JButton submit,cancel;

    Calcu_bill(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.yellow);
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meternumber = new JLabel("Meter Number");
        meternumber.setBounds(50,80,100,20);
        panel.add(meternumber);

        meternumCho = new Choice();
        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                meternumCho.add(resultSet.getString("meter_no"));

            }

        }catch(Exception E){
            E.printStackTrace();
        }

        meternumCho.setBounds(200,80,100,20);
        panel.add(meternumCho);

        JLabel name = new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        JLabel address = new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no= '"+meternumCho.getSelectedItem()+"' ");
            while(resultSet.next()){
                nameText.setText(resultSet.getString("name"));
                addressText.setText(resultSet.getString("address"));
            }

        }catch(Exception E){
            E.printStackTrace();
        }
        meternumCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Database c = new Database();
                    ResultSet resultSet = c.statement.executeQuery("select * from new_customer where meter_no= '"+meternumCho.getSelectedItem()+"' ");
                    while(resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }

            }
        });
        JLabel unit = new JLabel("Unit Consumed");
        unit.setBounds(50,200,100,20);
        panel.add(unit);

        unitText = new TextField("");
        unitText.setBounds(180,200,150,20);
        panel.add(unitText);

        JLabel month = new JLabel("Months");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho = new Choice();
        monthCho.add("January");
        monthCho.add("Feb");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.setBounds(180,240,100,20);
        panel.add(monthCho);

        submit = new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.LIGHT_GRAY);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,300,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.LIGHT_GRAY);
        cancel.addActionListener(this);
        panel.add(cancel);



        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/budget.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        //imgLabel.setBounds(300,20,250,250);
        add(imgLabel,"East");




        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeterNo = meternumCho.getSelectedItem();
            String sunit = unitText.getText();
            String smonth = monthCho.getSelectedItem();

            int totalBill = 0;
            int units = Integer.parseInt(sunit);
            String query_tax = "select * from tax";
            try{
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery(query_tax);
                while (resultSet.next()){
                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
                    totalBill += Integer.parseInt(resultSet.getString("service_tax"));
                    totalBill += Integer.parseInt(resultSet.getString("swacch bharat"));
                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));

                }


            }catch (Exception E){
                E.printStackTrace();


            }
            String query_total_bill = "insert into bill values('"+smeterNo+"', '"+smonth+"', '"+sunit+"','"+totalBill+"','Not paid')";
            try{
                Database c = new Database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null,"Customer Bill updated Successfullly");
                setVisible(false);




            }catch(Exception E){
                E.printStackTrace();

            }



        }else{
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new Calcu_bill();

    }

}
