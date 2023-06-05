package Admin;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JTextField;
public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JFrame jf;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminHome() {
		
		
		setBounds(300, 100, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1008, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Main Menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAddOldBooks = new JMenuItem("Add Student");
		mntmAddOldBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Students obj=new Add_Students();
				obj.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmAddOldBooks);
		
		JMenuItem mntmAddNewBooks = new JMenuItem("Add Marks");
		mntmAddNewBooks.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			aa obj=new aa();
			obj.setVisible(true);
		}
	});
		mnNewMenu_1.add(mntmAddNewBooks);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnNewMenu_3 = new JMenu("Adminstration");
		mnSettings.add(mnNewMenu_3);
		
		
		JMenuItem mntmAddFaculty = new JMenuItem("Add Faculty");
		mnNewMenu_3.add(mntmAddFaculty);
		
		JMenuItem mntmManageFaculty = new JMenuItem("Manage Faculty");
		mnNewMenu_3.add(mntmManageFaculty);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				
				if(a==JOptionPane.YES_OPTION){
						
				dispose();
				AdminLogin ms=new AdminLogin();
				ms.setTitle("Faculty Login");
				ms.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(850, 39, 90, 30);
		contentPane.add(btnNewButton);
		
		JButton add = new JButton("Add student");
		add.setFont(new Font("Tahoma", Font.PLAIN, 29));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Students obj=new Add_Students();
				obj.setVisible(true);
			}
		});
		add.setBounds(183, 250, 250, 70);
		contentPane.add(add);
		
		
		
		JButton button = new JButton("Add marks");
		button.setFont(new Font("Tahoma", Font.PLAIN, 29));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_marks obj=new Add_marks();
				obj.setVisible(true);
			}
		});
		button.setBounds(528, 250, 250, 70);
		contentPane.add(button);
		
		JButton btnAlter = new JButton("Update Student");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa obj=new aa();
				obj.setVisible(true);
			}
		});
		btnAlter.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnAlter.setBounds(183, 400, 250, 70);
		contentPane.add(btnAlter);
		
		JButton btnAddFaculty = new JButton("Add Faculty");
		btnAddFaculty.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnAddFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_faculty obj=new Add_faculty();
				obj.setVisible(true);
			}
		});
		btnAddFaculty.setBounds(528, 400, 250, 70);
		contentPane.add(btnAddFaculty);
		
		JMenu mnNewMenu = new JMenu("Search");
		mnNewMenu.setBounds(0, 39, 58, -32);
		contentPane.add(mnNewMenu);
		
		
		JTextField textArea = new JTextField();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textArea.setBounds(130, 100, 500, 60);
		contentPane.add(textArea);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton_2.setBounds(688, 100, 148, 60);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String pstr=textArea.getText();
				try{
					System.out.println("add");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
					
					PreparedStatement st=(PreparedStatement) con.prepareStatement("Select Name,Parent_Name,Gender,Class,DOB,Section,Class_Advisor,Student_ID,Marks from student where Name=? or Student_ID=?");
					int i;
					
					st.setString(1,pstr);
					st.setString(2,pstr);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
						
						AdminSearch obj=new AdminSearch(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
						obj.setVisible(true);
					
					}
					else{
						JOptionPane.showMessageDialog(btnNewButton,"Sorry, Record Not Found");
						i=0;
					}
					
					
					
					
				}
				catch(Exception w1)
				{
				System.out.println(w1);	
				}
				
			}
		});
		
		
	}
}