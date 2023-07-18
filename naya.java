

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


class naya extends Frame implements ActionListener {
    Button b1,b2,b3;       Label l1,l2,l3,l4,l5,l6,l7;     TextField t1,t2,t3,t4,t5,t6,t7;
    naya(){
        setLayout(null);
        t1=new TextField(20);  t2=new TextField(20);
        t3=new TextField(20);  t4=new TextField(20);
        t5=new TextField(20);  t6=new TextField(20);
        t7=new TextField(20);
        l1=new Label("ProductID");     l2=new Label("ProductName");
        l3=new Label("MRP");     l4=new Label("Tax");
        l5=new Label("Discount");     l6=new Label("Quantity");
        l7=new Label("Reorder");
        b1=new Button("Save");      b2=new Button("Clear"); b3=new Button("back");
        l1.setBounds(100,100,100,40);
        l2.setBounds(100,145,100,40);
        l3.setBounds(100,190,100,40);
        l4.setBounds(100,235,100,40);
        l5.setBounds(100,280,100,40);
        l6.setBounds(100,325,100,40);
        l7.setBounds(100,370,100,40);

        t1.setBounds(300,100,100,40);
        t2.setBounds(300,145,100,40);
        t3.setBounds(300,190,100,40);
        t4.setBounds(300,235,100,40);
        t5.setBounds(300,280,100,40);
        t6.setBounds(300,325,100,40);
        t7.setBounds(300,370,100,40);

        b1.setBounds(100,500,100,40);
        b2.setBounds(300,500,100,40);
        b3.setBounds(500,500,100,40);

        add(b1);add(b2);add(b3);
        add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
        add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);
        b1.addActionListener(this); //for Save data which user put
        b2.addActionListener(this); //for clear
        b3.addActionListener(this);

        addWindowListener(new WindowAdapter() {    //important window adaptor
            public void windowClosing(WindowEvent e){dispose();}
        });
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b2){ // for clear all textField in one click
            t1.setText(" ");
            t2.setText(" ");
            t3.setText(" ");
            t4.setText(" ");
            t5.setText(" ");
            t6.setText(" ");
            t7.setText(" ");

        }
        if(ae.getSource()==b1)
            {                             //for save text in sql phama/p1
               String Pid =t1.getText();
               String Name= t2.getText();
               String MRP=t3.getText();
               String Tax=t4.getText();
               String MaxDis=t5.getText();
               String Quality=t6.getText();
               String Reorder=t7.getText();
                                    System.out.println("Saved");
             try{
                 System.out.println("Try called");
                 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phama?allowPublicKeyRetrieval=true&useSSL=false","root","root");
                 Statement st=con.createStatement();
                 String ss="Insert Into p1(Pid,Name,MRP,Tax,MaxDis,Quantity,Reorder)" + "Values('"+Pid+"','"+Name+"','"+MRP+"','"+Tax+"','"+MaxDis+"','"+Quality+"','"+Reorder+"')";
                 System.out.println(ss);
                 st.executeUpdate("Insert Into p1(Pid,Name,MRP,Tax,MaxDis,Quantity,Reorder)" + "Values('"+Pid+"','"+Name+"','"+MRP+"','"+Tax+"','"+MaxDis+"','"+Quality+"','"+Reorder+"')");
                 st.close();
                 con.close();

             } catch (Exception e) {
                 System.out.println("Exception"+e);
                                    }
            }
        if(ae.getSource()==b3){
            mnu p1=new mnu();
            p1.setSize(1000,600);
            p1.setBackground(Color.cyan);
            p1.setVisible(true);
            dispose();
        }
    }
    public static void main(String args[]){
        naya f1=new naya();
        f1.setBackground(Color.red);
        f1.setSize(1000,600);
        f1.setVisible(true);
    }
}

