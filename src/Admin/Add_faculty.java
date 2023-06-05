package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.*;
import javax.swing.JTextField;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.border.EmptyBorder;

import java.sql.*;

public class Add_faculty extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_faculty frame = new Add_faculty();
					frame.setTitle("Add faculty");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Add_faculty() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 700, 460);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextField nm = new JTextField();
		nm.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		nm.setBounds(320, 26, 300, 70);
		contentPane.add(nm);
		ButtonGroup btg=new ButtonGroup();
		
		
		JTextField sub = new JTextField();
		sub.setFont(new Font("Segoe UI", Font.PLAIN, 37));
		sub.setBounds(320, 119, 300, 70);
		contentPane.add(sub);
		
		JLabel label = new JLabel("FACULTY NAME");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		label.setBounds(32, 26, 300, 70);
		contentPane.add(label);
		
		JTextField idd = new JTextField();
		idd.setFont(new Font("Segoe UI", Font.PLAIN, 38));
		idd.setBounds(320, 212, 300, 70);
		contentPane.add(idd);
		
		JLabel label_1 = new JLabel("SUBJECT");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		label_1.setBounds(32, 110, 300, 70);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("ID");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		label_2.setBounds(32, 210, 300, 70);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
					
					String name1=nm.getText();
					String sub1=sub.getText();
					int j=0;
				String id1=idd.getText();
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
						
						PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO faculty(Faculty_Name,UserId,Subject,Pass) values(?,?,?,?)");

						st.setString(1, name1);
						st.setString(2, id1);
						st.setString(3, sub1);
						st.setString(4, "faculty");
						
						
						j=st.executeUpdate();
						
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
					int i = 0;
					if(j==1)
					{
						String n="\n";
						
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Faculty details are added sucessfully"+n+"Thankyou.");
					}
					else
					{

						JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(310, 318, 170, 60);
		contentPane.add(btnNewButton);
		
		
	}
}