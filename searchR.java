import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class searchR extends Frame implements ActionListener{
    JFrame frame, frame1;
    DefaultTableModel model;
    JTextField textbox;
    JLabel label;
    JButton button,b2;
    JPanel panel;
    static JTable table;

    //  String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/moonpha?allowPublicKeyRetrieval=true&useSSL=false";
    String userName = "root";
    String password = "root";
    String[] columnNames = {"pid", "Name","Tax","MaxDis","Quantity","Quantity","Reorder"};

    public void createUI()
    {
        frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        textbox = new JTextField();
        textbox.setBounds(120,30,150,20);
        label = new JLabel("Enter Name");
        label.setBounds(10, 30, 100, 20);
        button = new JButton("search");
        button.setBounds(120,130,150,20);
        button.addActionListener(this);
        b2=new JButton("remove");
        b2.setBounds(150,170,150,20);
        b2.addActionListener(this);
        frame.add(b2);
        frame.add(textbox);
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
        frame.setSize(500, 400);
    }

    public void actionPerformed(ActionEvent ae)

    {
        if (ae.getSource()==b2){
            if(table.getSelectedRow() != -1) {
                // remove selected row from the model
                model.removeRow(table.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
        }
        button = (JButton)ae.getSource();
        System.out.println("Showing Table Data.......");
        showTableData();
    }

    public void showTableData()
    {

        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
//TableModel tm = new TableModel();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String textvalue = textbox.getText();
        String pid= "";
        String Name= "";
        String MRP= "";
        String Tax="";
        String MaxDis= "";
        String Quantity= "";
        String Reorder= "";

//        String cl = "";
//        String sec = "";
        try
        {

            // Class.forName(driverName);
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phama?allowPublicKeyRetrieval=true&useSSL=false","root","root");
            // Statement st = con.createStatement();
            // ResultSet rs = st.executeQuery("select * from product");
            int i =0;
            String sql = "select * from p1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                pid = rs.getString("Pid");
                Name = rs.getString("Name");
                MRP= rs.getString("MRP");
                Tax = rs.getString("Tax");
                MaxDis = rs.getString("MaxDis");
                Quantity = rs.getString("Quantity");
                Reorder = rs.getString("Reorder");


//                cl = rs.getString("class");
//                sec = rs.getString("section");
                model.addRow(new Object[]{pid,Name,MRP,Tax,MaxDis,Quantity,Reorder});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(1000,600);
        frame1.setBackground(Color.cyan);
    }

    public static void main(String args[])
    {
        searchR sr = new searchR();
        sr.setBackground(Color.cyan);
        sr.setSize(1000,600);
        sr.setVisible(true);
        sr.createUI();
    }
}
