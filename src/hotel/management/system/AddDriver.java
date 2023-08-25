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
public class AddDriver extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfname,tfage,tfcar,tfmodel,tflocation;
    JComboBox availablecombo,gendercombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD DRIVER");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblname.setBounds(60,80,120,30);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
           
        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,130,120,30);
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblgender.setBounds(60,180,200,30);
        add(lblgender);
        
        String genderOptions[]={"Male","Female","Other"};
        gendercombo=new JComboBox(genderOptions);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblcar=new JLabel("Car Company");
        lblcar.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblcar.setBounds(60,230,120,30);
        add(lblcar);
        
        tfcar=new JTextField();
        tfcar.setBounds(200,230,150,30);
        add(tfcar);
        
        JLabel lblmodel=new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblmodel.setBounds(60,280,200,30);
        add(lblmodel);
       
        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);
        
        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,330,200,30);
        add(lblavailable);
        
        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,330,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbllocation.setBounds(60,380,200,30);
        add(lbllocation);
       
        tflocation=new JTextField();
        tflocation.setBounds(200,380,150,30);
        add(tflocation);
        
        add=new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(400,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(550,350,130,30);
        cancel.addActionListener(this); 
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(230,150,980,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)gendercombo.getSelectedItem();
            String company=tfcar.getText();
            String model=tfmodel.getText();
            String available=(String)availablecombo.getSelectedItem();;
            String location=tflocation.getText();
            
            try{
                Conn conn=new Conn();
                String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "New driver added successfully");
                
              
             
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
           
        }
        
    }
    public static void main(String args[]){
        new AddDriver();
    }
}
