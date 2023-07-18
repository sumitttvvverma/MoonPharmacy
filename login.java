

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.*;


class login1 extends Frame implements ActionListener {
    Button b1,b2;       Label l1,l2,l3;     TextField t1,t2;
    login1(){
        setLayout(null);
        t1=new TextField(40);  t2=new TextField(40);
        l1=new Label("Name");     l2=new Label("Password");
        b1=new Button("OK");      b2=new Button("Cancel");
        l1.setBounds(100,100,100,40);
        t1.setBounds(300,100,100,40);
        t2.setBounds(300,150,100,40);
        l2.setBounds(100,150,100,40);
        b1.setBounds(100,250,100,40);
        b2.setBounds(300,250,100,40);

        add(b1);add(b2);add(l1);add(l2);add(t1);add(t2);
        b1.addActionListener(this); //for jump

        l3=new Label("Wrong Password/Name");
        l3.setBounds(250,300,130,40);

        addWindowListener(new WindowAdapter() {    //important window adaptor
                public void windowClosing(WindowEvent e){dispose();}
            });
    }
    public void actionPerformed(ActionEvent ae){
        String s1=t1.getText(); String s2=t2.getText();
        if(s1.equals("abc")&&s2.equals("123")){
        if(ae.getSource()==b1)
        {
            mnu fr= new mnu(); //for jump to menu actionPerformed
            fr.setSize(1000,600);
            fr.setBackground(Color.cyan);
            fr.setVisible(true);
            dispose();
        }
        else {
            setBackground(Color.red);
        }}else {
            add(l3);
            setBackground(Color.orange);
        }
    }
}

public class login {
    public static void main(String args[]){
        login1 f1=new login1();
        f1.setBackground(Color.red);
        f1.setSize(1000,600);
        f1.setVisible(true);


    }}
