package frame;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import jdbc.ConnectionManager;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class System_setting_panel extends JPanel {
	private JTextField OriginalCode;
	private JTextField NewPassword;
	private JTextField jt1;
	private JTextField jt2;
	/**
	 * Create the panel.系统设置
	 */
	public System_setting_panel() {
		setBackground(new Color(220, 220, 220));
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u7CFB\u7EDF\u8BBE\u7F6E\u6A21\u5757", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setSize(710, 460);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 690, 426);
		add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("买卖设置", new ImageIcon(System_setting_panel.class.getResource("/img/设 置.png")), panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 58, 665, 80);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("标价=进价*");
		lblNewLabel_4.setBounds(190, 27, 136, 27);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 23));
		panel_4.add(lblNewLabel_4);
		
		jt1 = new JTextField();
		jt1.setBounds(331, 24, 136, 33);
		jt1.setFont(new Font("宋体", Font.BOLD, 23));
		panel_4.add(jt1);
		jt1.setColumns(10);
		jt1.setText(Double.toString(Jrame2.inprice_add));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(10, 156, 665, 80);
		panel_3.add(panel_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("今日折扣：");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_4_1.setBounds(211, 28, 121, 27);
		panel_4_1.add(lblNewLabel_4_1);
		
		jt2 = new JTextField();
		jt2.setFont(new Font("宋体", Font.BOLD, 23));
		jt2.setColumns(10);
		jt2.setBounds(330, 25, 136, 33);
		panel_4_1.add(jt2);
		jt2.setText(Double.toString(Jrame2.zhekou));
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBounds(10, 263, 665, 80);
		panel_3.add(panel_4_1_1);
		
		JButton jb_reset = new JButton("重置");
		jb_reset.setIcon(new ImageIcon(System_setting_panel.class.getResource("/img/重置.png")));
		jb_reset.setBounds(172, 5, 103, 35);
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
			}
		});
		panel_4_1_1.setLayout(null);
		jb_reset.setFont(new Font("宋体", Font.BOLD, 20));
		panel_4_1_1.add(jb_reset);
		
		JButton jb_ok = new JButton("确定修改");
		jb_ok.setIcon(new ImageIcon(System_setting_panel.class.getResource("/img/确定.png")));
		jb_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				拿到数据,设置新数值
				Jrame2.inprice_add=Double.parseDouble(jt1.getText());
				Jrame2.zhekou=Double.parseDouble(jt2.getText());
				System.out.println(Jrame2.inprice_add);
				System.out.println(Jrame2.zhekou);
				Book_sele.jt_zhekou.setText(jt2.getText());
//				
			}
		});
		jb_ok.setBounds(342, 5, 146, 35);
		jb_ok.setFont(new Font("宋体", Font.BOLD, 20));
		panel_4_1_1.add(jb_ok);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("修改密码", new ImageIcon(System_setting_panel.class.getResource("/img/修改密码 (1).png")), panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 44, 665, 41);
		panel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("请输入");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(lblNewLabel_2);
		
		OriginalCode = new JTextField();
		OriginalCode.setFont(new Font("宋体", Font.BOLD, 25));
		OriginalCode.setColumns(10);
		OriginalCode.setBounds(215, 124, 299, 29);
		panel.add(OriginalCode);
		
		JLabel lblNewLabel = new JLabel("原密码：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel.setBounds(116, 95, 122, 87);
		panel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("新密码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_1.setBounds(116, 163, 105, 97);
		panel.add(lblNewLabel_1);
		
		NewPassword = new JTextField();
		NewPassword.setFont(new Font("宋体", Font.BOLD, 25));
		NewPassword.setColumns(10);
		NewPassword.setBounds(215, 197, 299, 29);
		panel.add(NewPassword);
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.setIcon(new ImageIcon(System_setting_panel.class.getResource("/img/重置.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton.setBounds(145, 285, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.setIcon(new ImageIcon(System_setting_panel.class.getResource("/img/确定.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				先获取输入的密码与已经登录的密码匹配是否一致
				String originalCodeString=OriginalCode.getText();
				if (originalCodeString.equals(Jrame2.manager.getPswString())) {
					System.out.println("原密码正确！");
//					获取新密码
					String newPasswordString=NewPassword.getText();
//					保存新密码到用户表中
					System.out.println(newPasswordString);
					String sql="update manager set password=? where user=?";
					try {
						int n=ConnectionManager.Update(sql, new Object[] {newPasswordString,Jrame2.manager.getUserString()});
						if (n>0) {
//							密码修改成功
							JOptionPane.showMessageDialog(null,"密码修改成功，请重新登录！！！","提示",JOptionPane.INFORMATION_MESSAGE);
							Login.jrame.dispose();
							System.out.println("当前窗口关闭");
							Login login=new Login();
							login.setVisible(true);
							System.out.println("打开新窗口，请登录！");
						}else {
							System.out.println("密码修改发生错误！！！！！！");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"原密码错误!","提示",JOptionPane.INFORMATION_MESSAGE);
					System.out.println("原密码错误!");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 21));
		btnNewButton_1.setBounds(390, 285, 97, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("更多联系作者VX：17641244340，觉得不错可以打赏一下哦！O(∩_∩)O", new ImageIcon(System_setting_panel.class.getResource("/img/联系.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 500, 400);
		lblNewLabel_3.setIcon(new ImageIcon(System_setting_panel.class.getResource("/img/vx_pay.jpg")));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel_5.setBounds(193, 359, 367, 40);
		panel_1.add(lblNewLabel_5);

	}
}
