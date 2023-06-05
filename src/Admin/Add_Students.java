package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.*;
public class Add_Students extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Students frame = new Add_Students();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Add_Students() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100, 1014, 460);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 25, 145, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblGurdiansName = new JLabel("Parent Name");
		lblGurdiansName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGurdiansName.setBounds(59, 101, 145, 32);
		contentPane.add(lblGurdiansName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblGender.setBounds(59, 184, 145, 32);
		contentPane.add(lblGender);
		
		JTextField stuname = new JTextField();
		stuname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		stuname.setBounds(235, 26, 166, 37);
		contentPane.add(stuname);
		
		JTextField partname = new JTextField();
		partname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		partname.setBounds(235, 102, 166, 37);
		contentPane.add(partname);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(235, 172, 75, 32);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(235, 213, 138, 26);
		contentPane.add(rdbtnNewRadioButton_1);
		ButtonGroup btg=new ButtonGroup();
		btg.add(rdbtnNewRadioButton_1);
		btg.add(rdbtnNewRadioButton);
		
		
		JLabel lblDob = new JLabel("DD/MM/YYYY");
		lblDob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDob.setBounds(481, 25, 158, 32);
		contentPane.add(lblDob);
		
		JComboBox date = new JComboBox();
		for(int i=1;i<=31;i++)
		{
			String str=String.valueOf(i);
			date.addItem(str);
		}
		date.setBounds(662, 32, 48, 27);
		contentPane.add(date);
		
		JComboBox month = new JComboBox();
		month.setBounds(739, 32, 75, 27);
		month.addItem("01");
		month.addItem("02");
		month.addItem("03");
		month.addItem("04");
		month.addItem("05");
		month.addItem("06");
		month.addItem("07");
		month.addItem("08");
		month.addItem("09");
		month.addItem("10");
		month.addItem("11");
		month.addItem("12");
		contentPane.add(month);
		
		JComboBox year = new JComboBox();
		for(int i=2023;i>=1990;i--)
		{
			String str=String.valueOf(i);
			year.addItem(str);
		}
		year.setBounds(841, 32, 109, 27);
		contentPane.add(year);
		
		JLabel lblRollNo = new JLabel("Student ID");
		lblRollNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblRollNo.setBounds(481, 184, 158, 32);
		contentPane.add(lblRollNo);
		
		JLabel lblClassTeacher = new JLabel("Class Teacher");
		lblClassTeacher.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblClassTeacher.setBounds(481, 261, 145, 32);
		contentPane.add(lblClassTeacher);
		
		JTextField roll = new JTextField();
		roll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		roll.setBounds(662, 185, 166, 37);
		contentPane.add(roll);
		
		JLabel lblSection = new JLabel("Section ");
		lblSection.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSection.setBounds(481, 101, 169, 32);
		contentPane.add(lblSection);
		
		JTextField teacher = new JTextField();
		teacher.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		teacher.setBounds(662, 262, 166, 37);
		contentPane.add(teacher);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblClass.setBounds(59, 261, 145, 32);
		contentPane.add(lblClass);
		
		JTextField stuclass = new JTextField();
		stuclass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		stuclass.setBounds(235, 262, 166, 37);
		contentPane.add(stuclass);

		JTextField section = new JTextField();
		section.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		section.setBounds(662, 110, 166, 37);
		contentPane.add(section);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				if(a==JOptionPane.YES_OPTION){
				
					String name=stuname.getText();
					String prnt= partname.getText();

					String  gender="";
					if(rdbtnNewRadioButton.isSelected())
					{
						gender="Male";
						
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
						gender="Female";
						
					}
					int i =1;
					String cls=stuclass.getText();
					String rl=roll.getText();
					String tch=teacher.getText();
					String sec=section.getText();
					
					
					String dt=(String) date.getSelectedItem();
					String mnth=(String) month.getSelectedItem();
					String yr=(String) year.getSelectedItem();
					
					
					
					String date=yr+'-'+mnth+'-'+dt;
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
						
						PreparedStatement st=(PreparedStatement) con.prepareStatement("INSERT INTO student(Student_ID,Name,Parent_Name,Gender,Class,DOB,Section,Class_Advisor,Password,Marks) values(?,?,?,?,?,?,?,?,?,?)");
						
						st.setString(1, rl);
						st.setString(2, name);
						st.setString(3, prnt);
						st.setString(4, gender);
						st.setString(5, cls);
						st.setString(6, date);
						st.setString(7, sec);
						st.setString(8, tch);
						st.setString(9, "student");
						st.setLong(10,0);
						
						int j=0;
						j=st.executeUpdate();
						PreparedStatement mt=(PreparedStatement) con.prepareStatement("INSERT INTO marks values(?,0,0,0,0,0,0)");
						mt.setString(1, rl);
						mt.executeUpdate();
						
						
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
					
					if(i==1)
					{
						String n="\n";
						
						
						JOptionPane.showMessageDialog(btnNewButton,"Congratulations,"+n+"Student is added sucessfully"+n+"Thankyou.");
					}
					else
					{

						JOptionPane.showMessageDialog(btnNewButton,"Please,enter the informations");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(400, 340, 125, 45);
		contentPane.add(btnNewButton);
		
	}
}