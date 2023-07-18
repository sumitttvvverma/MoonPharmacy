import java.awt.*;
import java.awt.event.*;

class start extends Frame implements ActionListener ,WindowListener
{
    Button b1;Label l1;
    start() {

        setLayout(null);



        b1 = new Button("Start");
        b1.setBounds(450,500,120,60);
        Font f2=new  Font("",Font.TRUETYPE_FONT,45);
        b1.setFont(f2);


        l1 = new Label("Moon Pharma");
        l1.setBackground(Color.darkGray);
                   Font f1=new Font("verdana",Font.BOLD,80);
        l1.setFont(f1);
        l1.setForeground(Color.black);
        l1.setBounds(200, 100, 550, 80);


        add(l1);         add(b1);
        b1.addActionListener(this);



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


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            login1 fr= new login1();
            fr.setSize(1000,600);
            fr.setBackground(Color.cyan);
            fr.setVisible(true);
            dispose();
        }
        else {
            setBackground(Color.red);
        }
    }
}
class frm5 {
    public static void main(String args[]){
        start ff=new start();
        ff.setSize(1000,600);
        ff.setBackground(Color.GRAY);
        ff.setVisible(true);
    }
}


