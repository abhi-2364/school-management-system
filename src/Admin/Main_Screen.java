package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

import User.UserLogin;
import Admin.AdminLogin;

public class Main_Screen extends JFrame {

  private JPanel contentPane;


  Main_Screen(String s){
    super(s);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          
          Main_Screen frame = new Main_Screen();
          frame.setTitle("School management system");
          frame.setVisible(true);
          frame.setBackground(Color.black);
          frame.getContentPane().setBackground(Color.BLACK);
        
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  
  }

  public Main_Screen() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 50, 1020, 700);
    setResizable(false);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("LEARNING TREE");
    lblNewLabel.setForeground(Color.orange);
    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 46));
    lblNewLabel.setBounds(350, 0, 590, 103);
    contentPane.add(lblNewLabel);
    
    JButton AdminBtn = new JButton("Faculty Login");
    AdminBtn.setFont(new Font("Bahnschrift SemiLight", Font.PLAIN, 32));
    AdminBtn.setForeground(Color.black);
    AdminBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        AdminLogin ad=new AdminLogin();
        ad.setTitle("School management system");
        ad.setVisible(true);
      }
    });
    AdminBtn.setBounds(130, 300, 250, 80);
    contentPane.add(AdminBtn);
    
    JButton UserBtn = new JButton("Student Login");
    UserBtn.setFont(new Font("Bahnschrift SemiLight", Font.PLAIN, 32));
    UserBtn.setForeground(Color.black);
    UserBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        UserLogin ad=new UserLogin();
        ad.setTitle("School management system");
        ad.setVisible(true);
      }
    });
    UserBtn.setBounds(650, 300, 250, 80);
    contentPane.add(UserBtn);
    
    JLabel lblNewLabel_1 = new JLabel("Welcome");
    lblNewLabel_1.setBounds(455, 150, 150, 50);
    lblNewLabel_1.setForeground(Color.orange);
    lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
    contentPane.add(lblNewLabel_1);
  }
}