package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import jdbc.ConnectionManager;
import model.Manager;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jt_user;
	private JPasswordField jt_psw;
	public static Jrame2 jrame;
	/**
	 * @wbp.nonvisual location=1029,134
	 */
	private final JPanel panel_3 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(new Color(224, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/线性图书 (1).png")));
		setTitle("图书信息管理系统v4.0by--CSDN@缘分锝天空-vx:17641244340");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 377);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(10, 25, 576, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to use the System!");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/welcome.png")));
		lblNewLabel.setBounds(73, 25, 435, 34);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 29));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 116, 576, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("账号：");
		lblNewLabel_1.setBounds(96, 5, 98, 32);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/账号 (1).png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);
		
		jt_user = new JTextField();
		jt_user.setBounds(199, 6, 281, 30);
		jt_user.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(jt_user);
		jt_user.setColumns(25);
		
		JLabel mess1 = new JLabel("");
		mess1.setFont(new Font("宋体", Font.PLAIN, 14));
		mess1.setForeground(Color.RED);
		mess1.setBounds(199, 38, 125, 24);
		panel_1.add(mess1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.menu);
		panel_1_1.setBounds(10, 186, 576, 60);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("密码：");
		lblNewLabel_1_1.setBounds(97, 10, 98, 32);
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/img/密码 (7).png")));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1_1.add(lblNewLabel_1_1);
		
		jt_psw = new JPasswordField();
		jt_psw.setBounds(201, 5, 280, 32);
		jt_psw.setFont(new Font("宋体", Font.BOLD, 15));
		jt_psw.setColumns(25);
		panel_1_1.add(jt_psw);
		
		JLabel mess2 = new JLabel("");
		mess2.setForeground(Color.RED);
		mess2.setFont(new Font("宋体", Font.PLAIN, 14));
		mess2.setBounds(201, 36, 125, 24);
		panel_1_1.add(mess2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 270, 576, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton jb_reset = new JButton("重置");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				重置输入框
				jt_user.setText("");
				jt_psw.setText("");
			}
		});
		jb_reset.setIcon(new ImageIcon(Login.class.getResource("/img/重置.png")));
		jb_reset.setFont(new Font("宋体", Font.BOLD, 17));
		jb_reset.setBounds(113, 10, 97, 23);
		panel_2.add(jb_reset);
		
		JButton jb_login = new JButton("登录");
		jb_login.setIcon(new ImageIcon(Login.class.getResource("/img/登录统计.png")));
		jb_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取账号和密码
				String userString=jt_user.getText();
				char[] a=jt_psw.getPassword();
				String pswString=String.valueOf(a);
//				查询是否匹配
				String sql="select * from manager where user=?";
				if (jt_user.getText().equals("")) {
					mess1.setText("请输入账号：");
				}else {
					try {
						ResultSet set=ConnectionManager.query(sql, new Object[] {userString});
						if(set.next()) {
//							找到用户
							String user=set.getString("user");
							String psw=set.getString("password");
						
							System.out.println(user+psw);
//							判断密码
							if (pswString.equals("")) {
								mess2.setText("请输入密码!");
							}else if (psw.equals(pswString)) {
//								登录成功
								System.out.println("登录成功！");
//								打开新窗口
							    jrame=new Jrame2(new Manager(userString, pswString));
//								关闭当前
								dispose();
								jrame.setVisible(true);
							}else {
								System.out.println("密码输入错误！");
								mess2.setText("密码输入错误!");
							}
						}else {
							System.out.println("账号不存在！");
							mess1.setText("该账号不存在!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
//		动态清零
		Document dt=jt_user.getDocument();
		dt.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				mess1.setText("");
				mess2.setText("");
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				mess1.setText("");
				mess2.setText("");
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				mess1.setText("");
				mess2.setText("");
			}
		});
		jb_login.setFont(new Font("宋体", Font.BOLD, 17));
		jb_login.setBounds(356, 10, 97, 23);
		panel_2.add(jb_login);
	}
}
