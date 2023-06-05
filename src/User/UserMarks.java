package User;

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
public class UserMarks extends JFrame{
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMarks frame = new UserMarks("");
					frame.setVisible(true);
					frame.setTitle("View Marks");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public UserMarks(String ID) {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1014, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhead = new JLabel("MARKS");
		lblhead.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblhead.setBounds(450, 0, 300, 50);
		contentPane.add(lblhead);
		
		JLabel lblid = new JLabel("STUDENT ID");
		lblid.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblid.setBounds(350, 75, 145, 32);
		contentPane.add(lblid);
		
		JTextField textId = new JTextField();
		textId.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textId.setBounds(520, 75, 166, 37);
		textId.setEditable(false);
		contentPane.add(textId);
		
		
		JLabel lblHindi = new JLabel("HINDI");
		lblHindi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHindi.setBounds(59, 150, 145, 32);
		contentPane.add(lblHindi);
		
		JTextField texthindi = new JTextField();
		texthindi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		texthindi.setBounds(235, 150, 166, 37);
		texthindi.setEditable(false);
		contentPane.add(texthindi);
		
		JLabel lblEnglish = new JLabel("ENGLISH");
		lblEnglish.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEnglish.setBounds(59, 230, 145, 32);
		contentPane.add(lblEnglish);
		
		JTextField textEnglish = new JTextField();
		textEnglish.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textEnglish.setBounds(235, 230, 166, 37);
		textEnglish.setEditable(false);
		contentPane.add(textEnglish);
		
		JLabel lblmaths= new JLabel("MATHS");
		lblmaths.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblmaths.setBounds(59, 320, 145, 32);
		contentPane.add(lblmaths);
		
		JTextField textmaths = new JTextField();
		textmaths.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textmaths.setBounds(235, 320, 166, 37);
		textmaths.setEditable(false);
		contentPane.add(textmaths);
		
		JLabel lblScience = new JLabel("SCIENCE");
		lblScience.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblScience.setBounds(550, 150, 145, 32);
		contentPane.add(lblScience);
		
		JTextField textscience = new JTextField();
		textscience.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textscience.setBounds(700, 150, 166, 37);
		textscience.setEditable(false);
		contentPane.add(textscience);
		
		JLabel lblBiology = new JLabel("BIOLOGY");
		lblBiology.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblBiology.setBounds(550,230,145,32);
		contentPane.add(lblBiology);
		
		JTextField textbiology = new JTextField();
		textbiology.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textbiology.setBounds(700, 230, 166, 37);
		textbiology.setEditable(false);
		contentPane.add(textbiology);
		
		JLabel lblsocial= new JLabel("SOCIAL");
		lblsocial.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblsocial.setBounds(550, 320, 145, 32);
		contentPane.add(lblsocial);
		
		JTextField textsocial = new JTextField();
		textsocial.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textsocial.setBounds(700, 320, 166, 37);
		textsocial.setEditable(false);
		contentPane.add(textsocial);
		
		JLabel lbltotal= new JLabel("TOTAL");
		lbltotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbltotal.setBounds(350, 410, 145, 32);
		contentPane.add(lbltotal);
		
		JTextField texttotal = new JTextField();
		texttotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		texttotal.setBounds(500, 410, 166, 37);
		texttotal.setEditable(false);
		contentPane.add(texttotal);
		
		
		try {
			System.out.println("add");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
			PreparedStatement s=(PreparedStatement) con.prepareStatement("SELECT m.Hindi,m.English,m.Maths,m.Science,m.Biology,m.Social,m.Id, m.Hindi+m.English+m.Maths+m.Science+m.Biology+m.Social as total FROM marks as m WHERE m.Id=?");
			
		     s.setString(1, ID);
			
			

			ResultSet r=s.executeQuery();
			if(r.next()) {
				texthindi.setText(r.getString(1));
				textEnglish.setText(r.getString(2));
				textmaths.setText(r.getString(3));
				textscience.setText(r.getString(4));
				textbiology.setText(r.getString(5));
				textsocial.setText(r.getString(6));
			    textId.setText(r.getString(7));
			    texttotal.setText(r.getString(8));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
}}