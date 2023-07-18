import java.awt.*;
import java.awt.event.*;

public class mnu extends Frame implements ActionListener {
    MenuBar mb;
    Menu m1,m2,m3;
    MenuItem n1,n2, n3, o1,o2,o3,o4,p1,p2,p3,p4;
    mnu(){
//      setLayout(null);
      mb =new MenuBar();
      m1=new Menu("Billing");
      m2=new Menu("Customer");
      m3=new Menu("Products");

      n1=new MenuItem("New"); n2=new MenuItem("View"); n3=new MenuItem("Edit");
      o1=new MenuItem("New"); o2=new MenuItem("View"); o3=new MenuItem("Edit"); o4=new MenuItem("Delete");
        p1=new MenuItem("New"); p2=new MenuItem("View"); p3=new MenuItem("Edit"); p4=new MenuItem("Delete");

        m1.add(n1); m1.add(n2); m1.add(n3);
        m2.add(o1); m2.add(o2); m2.add(o3); m2.add(o4);
        m3.add(p1); m3.add(p2); m3.add(p3); m3.add(p4);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        setMenuBar(mb);

        n1.addActionListener(this); //jump to naya?new
        n2.addActionListener(this); //jump to searchR?view

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){dispose();}
        });
    }
    public static void main(String args[]){
        mnu mu=new mnu();
        mu.setBackground(Color.darkGray);
        mu.setSize(1000,600);
        mu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

            if(ae.getSource()==n1)
            {
                naya fr= new naya();
                fr.setSize(1000,600);
                fr.setBackground(Color.cyan);
                fr.setVisible(true);
                dispose();
            }
        if(ae.getSource()==n2)
        {
            searchR fr= new searchR();
            fr.setSize(1000,600);
            fr.setBackground(Color.cyan);
            fr.setVisible(true);
            dispose();
        }
        }

}

