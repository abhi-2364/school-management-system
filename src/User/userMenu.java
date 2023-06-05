package User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Admin.Add_marks;
import Admin.AdminLogin;
import Admin.Main_Screen;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class userMenu extends JFrame{
			private JButton btnNewButton;
			private JButton btnNewButton_1;
			private JButton btnNewButton_2;
			private JButton btnNewButton_3;
			private JPanel contentPane;
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							userMenu frame = new userMenu("","");
							frame.setVisible(true);
							frame.setTitle("Student-Home");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			public userMenu(String name,String Id) {
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(300, 100, 1014, 700);
				setResizable(false);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblClass = new JLabel("Hello "+ name);
				lblClass.setFont(new Font("Segoe UI", Font.PLAIN, 27));
				lblClass.setBounds(400, 30, 180, 32);
				contentPane.add(lblClass);
				
				btnNewButton = new JButton("View Profile");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UserHome home=new UserHome(name);
						home.setTitle("Profile");
						home.setVisible(true);
			   }
				});
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton.setBounds(150, 250, 250, 70);
				contentPane.add(btnNewButton);
			
			btnNewButton_1 = new JButton("Update Password");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Change pw=new Change(name);
					pw.setTitle("Change Password");
					pw.setVisible(true);
		   }
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_1.setBounds(150, 450, 250, 70);
			contentPane.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("View Marks");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UserMarks marks = new UserMarks(Id);
					marks.setTitle("VIEW MARKS");
					marks.setVisible(true);
					
		   }
			});
			btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_2.setBounds(550, 250, 250, 70);
			contentPane.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Logout");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Main_Screen main=new Main_Screen();
					main.setTitle("School management system");
					main.setVisible(true);
		   }
			});
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_3.setBounds(550, 450, 250, 70);
			contentPane.add(btnNewButton_3);
	}}

