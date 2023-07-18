
//Connection bW sql and java
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class dekhe extends Frame implements ActionListener ,WindowListener
{
    Connection con;Statement st; ResultSet rs;
    Button b1,b2;

    dekhe() { try {
        setLayout(null);
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
      //  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pham", "root", "root");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phama?allowPublicKeyRetrieval=true&useSSL=false","root","root");
        st = con.createStatement();
        rs = st.executeQuery("Select * from p1");

        addWindowListener(this);
        b1=new Button("VIEW");
        b1.setBounds(50,400,100,50);
        b1.addActionListener(this);
        add(b1);
        b2=new Button("Back");
        b2.setBounds(180,400,100,50);
        b2.addActionListener(this);
        add(b2);

    }
    catch(Exception e) {System.out.println("Exception "+e);}
    }
    public void windowActivated(WindowEvent we){
        setBackground(Color.orange);
    }
    public void windowDeactivated(WindowEvent we){
        setBackground(Color.gray);
    }
    public void windowIconified(WindowEvent we){}
    public void windowDeiconified(WindowEvent we){}
    public void windowClosing(WindowEvent we){ dispose();}
    public void windowClosed(WindowEvent we){}
    public void windowOpened(WindowEvent we){}


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            try {
                setLayout(null);
                Label l1, l2, l3,l4,l5,l6,l7;
                String s1;
                String s2;
                String s3;
                String s4;
                String s5;
                String s6;
                String s7;

                while (rs.next()) {
                    s1 = "        "+rs.getInt("Pid");
                    s2 = "        "+rs.getString("Name");
                    s3 = "        " + rs.getInt("MRP");
                    s4 = "        " + rs.getInt("Tax");
                    s5 = "        " + rs.getInt("MaxDis");
                    s6 = "        " + rs.getInt("Quantity");
                    s7 = "        " + rs.getInt("Reorder");

                    l1 = new Label(s1);
                    l2 = new Label(s2);
                    l3 = new Label(s3);
                    l4 = new Label(s4);
                    l5 = new Label(s5);
                    l6 = new Label(s6);
                    l7 = new Label(s7);
                    l1.setBounds(300, 100, 100, 20);
                    l2.setBounds(300, 140, 100, 20);
                    l3.setBounds(300, 180, 100, 20);
                    l4.setBounds(300, 220, 100, 20);
                    l5.setBounds(300, 260, 100, 20);
                    l6.setBounds(300, 300, 100, 20);
                    l7.setBounds(300, 340, 100, 20);
                    System.out.println(s1 + "  " + s2+"    "+s3+" "+s4+ "   " + s5+"    "+s6+" "+s7);

                    add(l1);
                    add(l2);
                    add(l3);
                    add(l4);
                    add(l5);
                    add(l6);
                    add(l7);
                }
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
        if(ae.getSource()==b2){
            mnu fr1=new mnu();
            fr1.setSize(1000,600);
            fr1.setBackground(Color.orange);
            fr1.setVisible(true);
            dispose();
        }
    }
    public static void main(String args[]){
        dekhe ff=new dekhe();
        ff.setSize(1000,600);
        ff.setBackground(Color.cyan);
        ff.setVisible(true);}
}





