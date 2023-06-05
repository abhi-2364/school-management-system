package Admin;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class Add_marks extends JFrame{
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_marks frame = new Add_marks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public Add_marks() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1014, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhead = new JLabel("UPDATE MARKS");
		lblhead.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblhead.setBounds(400, 0, 300, 50);
		contentPane.add(lblhead);
		
		JLabel lblid = new JLabel("STUDENT ID");
		lblid.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblid.setBounds(59, 75, 145, 32);
		contentPane.add(lblid);
		
		JTextField textId = new JTextField();
		textId.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textId.setBounds(235, 75, 166, 37);
		contentPane.add(textId);
		
		

		
		JLabel lblHindi = new JLabel("HINDI");
		lblHindi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHindi.setBounds(59, 150, 145, 32);
		contentPane.add(lblHindi);
		
		JTextField texthindi = new JTextField();
		texthindi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		texthindi.setBounds(235, 150, 166, 37);
		contentPane.add(texthindi);
		
		JLabel lblEnglish = new JLabel("ENGLISH");
		lblEnglish.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEnglish.setBounds(59, 230, 145, 32);
		contentPane.add(lblEnglish);
		
		JTextField textEnglish = new JTextField();
		textEnglish.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textEnglish.setBounds(235, 230, 166, 37);;
		contentPane.add(textEnglish);
		
		JLabel lblmaths= new JLabel("MATHS");
		lblmaths.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblmaths.setBounds(59, 320, 145, 32);
		contentPane.add(lblmaths);
		
		JTextField textmaths = new JTextField();
		textmaths.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textmaths.setBounds(235, 320, 166, 37);
		contentPane.add(textmaths);
		
		JLabel lblScience = new JLabel("SCIENCE");
		lblScience.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScience.setBounds(550, 150, 145, 32);
		contentPane.add(lblScience);
		
		JTextField textscience = new JTextField();
		textscience.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textscience.setBounds(700, 150, 166, 37);
		contentPane.add(textscience);
		
		JLabel lblBiology = new JLabel("BIOLOGY");
		lblBiology.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBiology.setBounds(550,230,145,32);
		contentPane.add(lblBiology);
		
		JTextField textbiology = new JTextField();
		textbiology.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textbiology.setBounds(700, 230, 166, 37);;
		contentPane.add(textbiology);
		
		JLabel lblsocial= new JLabel("SOCIAL");
		lblsocial.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblsocial.setBounds(550, 320, 145, 32);
		contentPane.add(lblsocial);
		
		JTextField textsocial = new JTextField();
		textsocial.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textsocial.setBounds(700, 320, 166, 37);
		contentPane.add(textsocial);
		
		JLabel lbltotal= new JLabel("TOTAL");
		lbltotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbltotal.setBounds(400, 410, 145, 32);
		contentPane.add(lbltotal);
		
		JTextField texttotal = new JTextField();
		texttotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		texttotal.setBounds(550, 410, 166, 37);
		texttotal.setEditable(false);
		contentPane.add(texttotal);
		
		
		JButton btnNewButton1 = new JButton("UPDATE");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton1.setBounds(400, 490, 170, 60);
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton = new JButton("GET INFO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(btnNewButton,"Are you sure?");
				//JOptionPane.setRootFrame(null);
				int i;
				if(a==JOptionPane.YES_OPTION){
				
					String id=textId.getText();
					try{
						System.out.println("add");
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
						
						PreparedStatement s=(PreparedStatement) con.prepareStatement("SELECT m.Hindi,m.English,m.Maths,m.Science,m.Biology,m.Social,m.Id, m.Hindi+m.English+m.Maths+m.Science+m.Biology+m.Social as t FROM marks as m WHERE m.Id=?");
						
					     s.setString(1, id);
						
						
			
						ResultSet r=s.executeQuery();
						if(r.next()) {
							texthindi.setText(r.getString(1));
							textEnglish.setText(r.getString(2));
							textmaths.setText(r.getString(3));
							textscience.setText(r.getString(4));
							textbiology.setText(r.getString(5));
							textsocial.setText(r.getString(6));
							texttotal.setText(r.getString(8));
							
							btnNewButton1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									int b=JOptionPane.showConfirmDialog(btnNewButton1,"Are you sure?");
									//JOptionPane.setRootFrame(null);
									int i=1,j=0;
									if(b==JOptionPane.YES_OPTION){
									
										String it=textId.getText();
										int hindi= Integer.parseInt(texthindi.getText());
										int english= Integer.parseInt(textEnglish.getText());
										int maths= Integer.parseInt(textmaths.getText());
										int science= Integer.parseInt(textscience.getText());
										int biology= Integer.parseInt(textbiology.getText());
										int social= Integer.parseInt(textsocial.getText());

										
										try{
											System.out.println("add");
											
											Class.forName("com.mysql.cj.jdbc.Driver");
											PreparedStatement st=con.prepareStatement("show tables");
											Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
											if(r.getString(7)==it) {
												
											    st=(PreparedStatement) con.prepareStatement("INSERT INTO marks(Hindi,English,Maths,Science,Biology,Social,Id) values(?,?,?,?,?,?,?)");
											}
											else {
												
												st=(PreparedStatement) con.prepareStatement("update marks set Hindi=?,English=?,Maths=?,Science=?,Biology=?,Social=? where Id=?");
											}
											
											st.setInt(1, hindi);
											st.setInt(2, english);
											st.setInt(3, maths);
											st.setInt(4, science);
											st.setInt(5, biology);
											st.setInt(6, social);
											st.setString(7, it);
											
											
											j=st.executeUpdate();
											
										}
										catch(Exception w1)
										{
										System.out.println(w1);	
										}
										
										
										if(j==1)
										{
											String n="\n";
											
											
											JOptionPane.showMessageDialog(btnNewButton1,"Congratulations,"+n+"Student marks is added sucessfully"+n);
										}
										else
										{

											JOptionPane.showMessageDialog(btnNewButton1,"Please,enter valid information");
										}
									}
									
								}
							});
						}
						else {
							
							JOptionPane.showMessageDialog(btnNewButton1,"Enter valid info");
						}
					}
					catch(Exception w1)
					{
					System.out.println(w1);	
					}
					
					
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		btnNewButton.setBounds(600, 60, 190, 50);
		contentPane.add(btnNewButton);
		
		



}}
	

