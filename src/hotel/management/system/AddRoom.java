/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Home
 */
public class AddRoom extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox availablecombo,bedcombo,cleanncombo;
    
    AddRoom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
           
        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,180,200,30);
        add(lblclean);
        
        String cleannOptions[]={"Clean","Unclean"};
        cleanncombo=new JComboBox(cleannOptions);
        cleanncombo.setBounds(200,180,150,30);
        cleanncombo.setBackground(Color.WHITE);
        add(cleanncombo);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,280,200,30);
        add(lbltype);
        
        String bedOptions[]={"Single Bed","Double Bed"};
        bedcombo=new JComboBox(bedOptions);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        add=new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this); 
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(230,150,940,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String roomno=tfroom.getText();
            String availability=(String)availablecombo.getSelectedItem();
            String status=(String)cleanncombo.getSelectedItem();
            String price=tfprice.getText();
            String bed=(String)bedcombo.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                String query="insert into room values('"+roomno+"','"+availability+"','"+status+"','"+price+"','"+bed+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "New room added successfully");
                
              
             
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
           
        }
        
    }
    public static void main(String args[]){
        new AddRoom();
    }
}
