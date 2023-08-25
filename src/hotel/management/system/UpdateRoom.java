/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author Home
 */
public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    JButton check,update,back;
    
    UpdateRoom(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
         
        JLabel lblid=new JLabel("Customer ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            
            }
        }catch(Exception e){
        e.printStackTrace();
        }
        
        JLabel lblroom=new JLabel("Room No.");
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setBounds(30,180,100,20);
        add(lblavailable);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setBounds(30,230,100,20);
        add(lblclean);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        check =new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update =new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
    setBounds(200,150,980,450);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            
            String id=ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            
            try{
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                  
                }
                
                ResultSet rs2=conn.s.executeQuery("select * from room where roomno='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaningstatus"));
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()==update){
            
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText();
            
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+available+"',cleaningstatus='"+status+"'where roomno='"+room+"'");
                
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                
            }catch(Exception e){
            e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Reception();
        }
    
    }
    
    public static void main(String args[]){
    new UpdateRoom();}
}
