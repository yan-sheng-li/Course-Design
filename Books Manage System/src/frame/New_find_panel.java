package frame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jdbc.ConnectionManager;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class New_find_panel extends JPanel {
	private JTextField jt_text;
	private JTable table;
	private JTextField jt_text2;
	private JTable table_1;
	private JLabel jl_result; 
	private Object[] o1;
	private JLabel jl2;
	private Object[] headrObjects;

	/**
	 * Create the panel.
	 */
	public New_find_panel() {
		setBackground(new Color(255, 192, 203));
		setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u4FE1\u606F\u67E5\u8BE2\u6A21\u5757", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "\u4FE1\u606F\u67E5\u8BE2\u6A21\u5757", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 690, 426);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("新书查询", new ImageIcon(New_find_panel.class.getResource("/img/查询 (5).png")), panel, null);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 25, 685, 371);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 22, 685, 43);
		panel_5.add(panel_6);
		
		jt_text = new JTextField();
		jt_text.setFont(new Font("宋体", Font.BOLD, 20));
		jt_text.setColumns(30);
		panel_6.add(jt_text);
		
		JButton jb_find = new JButton("查询");
		jb_find.setIcon(new ImageIcon(New_find_panel.class.getResource("/img/查询 (3).png")));
		
		jb_find.setFont(new Font("宋体", Font.BOLD, 20));
		panel_6.add(jb_find);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 67, 685, 43);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("查询方式：");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(lblNewLabel_6);
		
		JRadioButton jrb_isbn = new JRadioButton("ISBN");
		jrb_isbn.setSelected(true);
		jrb_isbn.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_isbn);
		
		JRadioButton jrb_bookname = new JRadioButton("书名");
		jrb_bookname.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_bookname);
		
		JRadioButton jrb_intime = new JRadioButton("入库时间");
		jrb_intime.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_intime);
		
//		按钮组
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(jrb_intime);
		buttonGroup.add(jrb_bookname);
		buttonGroup.add(jrb_isbn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 148, 685, 249);
		panel_5.add(scrollPane_1);
		
		o1=new Object[] { "序号", "ISBN", "书名", "作者", "进价", "数量", "入库时间" };
		Object[][] o2=new Object[][] {
			
		};
		
		table = new JTable(o2,o1);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_7 = new JLabel("查询结果：");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(38, 120, 86, 18);
		panel_5.add(lblNewLabel_7);
		
		jl_result = new JLabel("");
		jl_result.setFont(new Font("宋体", Font.PLAIN, 16));
		jl_result.setForeground(Color.RED);
		jl_result.setBackground(Color.RED);
		jl_result.setBounds(122, 112, 183, 26);
		panel_5.add(jl_result);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("库存查询", new ImageIcon(New_find_panel.class.getResource("/img/查询 (2).png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(0, 0, 685, 387);
		panel_1.add(panel_5_1);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBounds(0, 22, 685, 43);
		panel_5_1.add(panel_6_1);
		
		jt_text2 = new JTextField();
		jt_text2.setFont(new Font("宋体", Font.BOLD, 20));
		jt_text2.setColumns(30);
		panel_6_1.add(jt_text2);
		
		JButton jb_find2 = new JButton("查询");
		jb_find2.setIcon(new ImageIcon(New_find_panel.class.getResource("/img/查询 (3).png")));
		
		jb_find2.setFont(new Font("宋体", Font.BOLD, 20));
		panel_6_1.add(jb_find2);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBounds(0, 67, 685, 43);
		panel_5_1.add(panel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("查询方式：");
		lblNewLabel_6_1.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7_1.add(lblNewLabel_6_1);
		
		JRadioButton jrb1_isbn = new JRadioButton("ISBN");
		jrb1_isbn.setSelected(true);
		jrb1_isbn.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7_1.add(jrb1_isbn);
		
		JRadioButton jrb2_name = new JRadioButton("书名");
		jrb2_name.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7_1.add(jrb2_name);
		
//		按钮组
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(jrb2_name);
		bGroup.add(jrb1_isbn);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 148, 685, 249);
		panel_5_1.add(scrollPane_1_1);
		
		headrObjects=new Object[]{"序号","ISBN","书名","作者","数量","标价"};
		Object [][] numObjects= {
		};
		
		table_1 = new JTable(numObjects,headrObjects);
		scrollPane_1_1.setViewportView(table_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("查询结果：");
		lblNewLabel_7_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_7_1.setBounds(38, 120, 86, 18);
		panel_5_1.add(lblNewLabel_7_1);
		
		jl2 = new JLabel("");
		jl2.setFont(new Font("宋体", Font.PLAIN, 16));
		jl2.setForeground(Color.RED);
		jl2.setBounds(123, 111, 183, 27);
		panel_5_1.add(jl2);
		
		
		jb_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取文本框数据
				String text=jt_text.getText();
				if (text.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的内容！","提示",JOptionPane.INFORMATION_MESSAGE);
				}else {
//					判断所选择的查询方法
					int isselect=0;
					if (jrb_isbn.isSelected()) {
						isselect=1;
					}
					if (jrb_bookname.isSelected()) {
						isselect=2;
					}
					if (jrb_intime.isSelected()) {
						isselect=3;
					}
//					按ISBN查询结果
					if (isselect==1) {
						String sql="select ISBN,bookname,author,price,num,time from new_book_in where ISBN like '"+text+"%';";
						get_result(sql);
					}
					if (isselect==2) {
						String sql="select ISBN,bookname,author,price,num,time from new_book_in where bookname like '"+text+"%';";
						get_result(sql);
						
					}
					if (isselect==3) {
						String sql="select ISBN,bookname,author,price,num,time from new_book_in where time like '"+text+"%';";
						get_result(sql);

					}
				}
				

				
			}
		});
		jb_find2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取文本框数据
				String text=jt_text2.getText();
				if (text.equals("")) {
					JOptionPane.showMessageDialog(null, "请先输入要查询的内容！","提示",JOptionPane.INFORMATION_MESSAGE);
				}else {
//					判断所选择的查询方法
					int isselect=0;
					if (jrb1_isbn.isSelected()) {
						isselect=1;
					}
					if (jrb2_name.isSelected()) {
						isselect=2;
					}
//					按ISBN查询结果
					if (isselect==1) {
						String sql="select ISBN,bookname,author,num,markprice from book_stack where ISBN like '"+text+"%';";
						get_result1(sql);
						
					}
//					按书名查询
					if (isselect==2) {
						String sql="select ISBN,bookname,author,num,markprice from book_stack where bookname like '"+text+"%';";
						get_result1(sql);
					}
					
				}
			}

		});
		
	}
		
	/**
	 * 传入SQL语句，查询结果集，并显示到表格中
	 * @param sql
	 */
	public void get_result(String sql) {
		Object[][] a=new Object[][] {};
//		查询结果：
		try {
			ResultSet set=ConnectionManager.query(sql, new Object[] {});
//			如果结果集不为空
			if (set.next()) {
//				将结果转为二维数组
				a=ConnectionManager.getSetArrays(set);
//				将数组反馈到表格
				TableModel dataModel = new DefaultTableModel(a,o1);
				table.setModel(dataModel);
				jl_result.setText("");
			}else {
				TableModel dataModel = new DefaultTableModel(new Object[][] {},o1);
				table.setModel(dataModel);
				jl_result.setText("没有查询到结果");
				System.out.println("没有查询到结果!!!");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void get_result1(String sql) {
		// TODO Auto-generated method stub
		Object[][] a=new Object[][] {};
//		查询结果：
		try {
			ResultSet set=ConnectionManager.query(sql, new Object[] {});
//			如果结果集不为空
			if (set.next()) {
//				将结果转为二维数组
				a=ConnectionManager.getSetArrays(set);
//				将数组反馈到表格
				TableModel dataModel = new DefaultTableModel(a,headrObjects);
				table_1.setModel(dataModel);
				jl2.setText("");
			}else {
				TableModel dataModel = new DefaultTableModel(new Object[][] {},headrObjects);
				table_1.setModel(dataModel);
				
				jl2.setText("没有查询到结果");
				System.out.println("没有查询到结果!!!");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
