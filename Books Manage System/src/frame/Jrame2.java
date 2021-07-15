
package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import jdbc.ConnectionManager;
import model.Manager;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Jrame2 extends JFrame {
	
//	当前用户
	static Manager manager;
	private JPanel contentPane;
	CardLayout cardLayout=new CardLayout();
//	标价设置
	static double inprice_add=1.0;
//	折扣设置
	static double zhekou=1.00;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jrame2 frame = new Jrame2(new Manager("test","123"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Jrame2(Manager manager) throws SQLException {
		this.manager=manager;
		setIconImage(Toolkit.getDefaultToolkit().getImage("/img/线性图书 (1).png"));
		setFont(new Font("Courier New", Font.BOLD, 21));
		setTitle("图书信息管理系统v4.0-by计181李延胜");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 596);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		panel.setBounds(5, 5, 710, 60);
		panel.setBorder(new TitledBorder(null, "\u529F\u80FD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
//		内容显示面板，可切换，卡片布局
		
		JPanel main_panel = new JPanel();
		main_panel.setBounds(5, 77, 710, 460);
		contentPane.add(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));
//		给内容面板设置卡片布局
		main_panel.setLayout(cardLayout);
//		添加图书面板
		Books_panel books_panel=new Books_panel();
		main_panel.add(books_panel,"book_panel");
//		添加信息查询面板
		New_find_panel new_find_panel=new New_find_panel();
		main_panel.add(new_find_panel,"New_find_panel");
//		添加图书销售模块
		Book_sele book_sele=new Book_sele();
		main_panel.add(book_sele,"book_sele");
//		添加系统设置面板
		System_setting_panel system_setting_panel=new System_setting_panel();
		main_panel.add(system_setting_panel,"4");
		
		JButton btnNewButton = new JButton("书库管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main_panel, "book_panel");
			}
		});
		btnNewButton.setIcon(new ImageIcon(Jrame2.class.getResource("/img/书 (2).png")));
		btnNewButton.setForeground(new Color(51, 51, 255));
		btnNewButton.setBackground(new Color(175, 238, 238));
		btnNewButton.setFont(new Font("新宋体", Font.BOLD, 16));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("信息查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main_panel, "New_find_panel");
			}
			
		});
		btnNewButton_1.setIcon(new ImageIcon(Jrame2.class.getResource("/img/查询 (1).png")));
		btnNewButton_1.setForeground(new Color(51, 51, 255));
		btnNewButton_1.setBackground(new Color(255, 192, 203));
		btnNewButton_1.setFont(new Font("新宋体", Font.BOLD, 16));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("图书销售");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main_panel, "book_sele");
			
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Jrame2.class.getResource("/img/销售 (1).png")));
		btnNewButton_2.setForeground(new Color(51, 51, 255));
		btnNewButton_2.setBackground(new Color(152, 251, 152));
		btnNewButton_2.setFont(new Font("新宋体", Font.BOLD, 16));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("系统设置");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(main_panel, "4");
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Jrame2.class.getResource("/img/设置 (1).png")));
		btnNewButton_3.setForeground(new Color(51, 51, 255));
		btnNewButton_3.setBackground(new Color(176, 196, 222));
		btnNewButton_3.setFont(new Font("新宋体", Font.BOLD, 16));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("退出系统");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Jrame2.class.getResource("/img/退出 (1).png")));
		btnNewButton_4.setForeground(new Color(51, 51, 255));
		btnNewButton_4.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_4.setFont(new Font("新宋体", Font.BOLD, 16));
		panel.add(btnNewButton_4);
		
		JLabel welcome_mess = new JLabel("");
		welcome_mess.setFont(new Font("宋体", Font.BOLD, 15));
		welcome_mess.setBounds(48, 543, 153, 20);
		contentPane.add(welcome_mess);
		welcome_mess.setText("你好！"+manager.getUserString());
		
		JLabel day_mess = new JLabel("");
		String string=ConnectionManager.getday();
		day_mess.setText(string);
		day_mess.setFont(new Font("宋体", Font.BOLD, 15));
		day_mess.setBounds(541, 543, 153, 20);
		contentPane.add(day_mess);
		
		
		
	}
}

