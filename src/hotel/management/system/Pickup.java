/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
/**
 *
 * @author Home
 */
public class Pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    Choice cartype;  
    JCheckBox available;
    
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text); 
        
        JLabel lblbed=new JLabel("Car Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        cartype =new Choice();
        cartype.setBounds(150,100,200,25);
        add(cartype);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartype.add(rs.getString("model"));
            }
            
        }catch(Exception e){
        e.printStackTrace();
        }
    
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Car");
        l4.setBounds(490,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Model");
        l5.setBounds(620,160,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Avilability");
        l6.setBounds(760,160,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
        e.printStackTrace();
        }
        
        submit=new JButton("Submit");
        submit.setBounds(300,520,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(500,520,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setBounds(200,100,1000,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            
            try{
                String query1="select * from driver where model='"+cartype.getSelectedItem()+"'";
                
                
                Conn conn=new Conn();
                ResultSet rs;
                
                rs=conn.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
    setVisible(false);
    new Reception();
        }
    }
    
    public static void main(String args[]){
    new Pickup();
    }
    
}
