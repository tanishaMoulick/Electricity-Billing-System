package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meterinfo extends JFrame implements ActionListener {
    JLabel heading;
    Choice meterLocCho,meterTypCho,billTypeCho,phasecodeCho; //awt
    JButton submit;
    String meterNumber;

    Meterinfo(String meterNumber){
        this.meterNumber=meterNumber;


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        add(panel);

        heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(heading);

        JLabel meternumber = new JLabel("Meter Number");
        meternumber.setBounds(50,80,100,20);
        panel.add(meternumber);

        JLabel meternumberText = new JLabel(meterNumber);
        meternumberText.setBounds(180,80,150,20);
        panel.add(meternumberText);

        JLabel meterloc = new JLabel("Meter Number");
        meterloc.setBounds(50,120,100,20);
        panel.add(meterloc);

        meterLocCho = new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        meterTypCho = new Choice();
        meterTypCho.add("electric meter");
        meterTypCho.add("solar meter");
        meterTypCho.setBounds(180,160,150,20);
        panel.add(meterTypCho);

        JLabel phasecode = new JLabel("Meter Code");
        phasecode.setBounds(50,200,100,20);
        panel.add(phasecode);

        phasecodeCho = new Choice();
        phasecodeCho.add("011");
        phasecodeCho.add("022");
        phasecodeCho.add("033");
        phasecodeCho.add("044");
        phasecodeCho.add("055");
        phasecodeCho.add("066");
        phasecodeCho.add("077");
        phasecodeCho.setBounds(180,200,150,20);
        panel.add(phasecodeCho);

        JLabel billType = new JLabel("Bill type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho = new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industrial");
        billTypeCho.setBounds(180,240,150,20);
        panel.add(billTypeCho);

        JLabel day = new JLabel("30 days billing time...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("By default bill is calculated for 30 days only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);



        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/meter.jpg"));
        Image i2 = i1.getImage().getScaledInstance(230,250,Image.SCALE_DEFAULT);
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
            String smeternum = meterNumber;
            String smeterloc = meterLocCho.getSelectedItem();
            String smetertype = meterTypCho.getSelectedItem();
            String smeterphase = phasecodeCho.getSelectedItem();
            String sbilltype =  billTypeCho.getSelectedItem();
            String sday = "30";

            String query_meterinfo = "insert into meter_info values('"+smeternum+"','"+smeterloc+"','"+smetertype+"','"+smeterphase+"','"+sbilltype+"','"+sday+"')";

            try{
                Database c= new Database();
                c.statement.executeUpdate(query_meterinfo);


                JOptionPane.showMessageDialog(null,"Meter information added successfully");
                setVisible(false);



            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Meterinfo("");
    }
}
