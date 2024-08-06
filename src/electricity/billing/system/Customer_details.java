package electricity.billing.system;
import  net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Customer_details extends JFrame implements ActionListener {
    Choice searchMeterCho,searchNameCho;
    JTable table;
    JButton search,print,close;
    Customer_details(){
        super("Customer Details");
        getContentPane().setBackground(new Color(192,186,254));



        setSize(700,500);
        setLocation(400,200);
        setLayout(null);

        JLabel searchMeter = new JLabel("Search By Meter Number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                searchMeterCho.add(resultSet.getString("meter_no"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel searchName = new JLabel("Search By Name");
        searchName.setBounds(400,20,100,20);
        add(searchName);

        searchNameCho = new Choice();
        searchNameCho.setBounds(520,20,150,20);
        add(searchNameCho);
        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
                searchNameCho.add(resultSet.getString("name"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);

        search = new JButton("Search");
        search.setBackground(Color.LIGHT_GRAY);
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBackground(Color.LIGHT_GRAY);
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        close = new JButton("Close");
        close.setBackground(Color.LIGHT_GRAY);
        close.setBounds(600,70,80,20);
        close.addActionListener(this);
        add(close);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query_search = "select * from new_customer where meter_no = '"+searchMeterCho.getSelectedItem()+"' and name ='"+searchNameCho.getSelectedItem()+"'";

            try{
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception E){
                E.printStackTrace();
            }
        }else if(e.getSource()==print){
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Customer_details();
    }
}
