package frame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Document;



import jdbc.ConnectionManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Book_sele extends JPanel {
	private JTextField jt_isbn;
	private JTextField jt_bookname;
	private JTextField jt_num;
	private JTextField jt_price;
	public static JTextField jt_zhekou;
	private JTextField jt_shouldpay;
	private JTextField jt_receive;
	private JTextField jt_return;
	private static JTextField dingdan_nums;
	private JTable table;
	private JTextField find_text;
	private JTable table_1;
	private JLabel trips;
	private JLabel trips_1 ;
	private Object[] o1;
	private Object[][] o2;
	private static JLabel yes_no;
	private static JRadioButton jrb_isbn;
	private static JRadioButton jrb_bookname;
	private static JRadioButton jrb_time;

	/**
	 * Create the panel.
	 */
	public Book_sele() {
		setBackground(new Color(152, 251, 152));
		setBorder(new TitledBorder(null, "\u56FE\u4E66\u9500\u552E\u6A21\u5757", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 690, 426);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("图书销售", new ImageIcon(Book_sele.class.getResource("/img/销售 (3).png")), panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 685, 312);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 23, 665, 44);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN：");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel.setBounds(68, 6, 91, 28);
		panel_3.add(lblNewLabel);
		
		jt_isbn = new JTextField();
//		动态监听
		Document d1=jt_isbn.getDocument();
		d1.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				get_bookname_markprice();

			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				get_bookname_markprice();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jt_isbn.setFont(new Font("宋体", Font.BOLD, 19));
		jt_isbn.setBounds(131, 10, 171, 21);
		panel_3.add(jt_isbn);
		jt_isbn.setColumns(25);
		
		JLabel lblNewLabel_1 = new JLabel("书名：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_1.setBounds(352, 6, 75, 28);
		panel_3.add(lblNewLabel_1);
		
		jt_bookname = new JTextField();
		jt_bookname.setFont(new Font("宋体", Font.BOLD, 19));
		jt_bookname.setColumns(25);
		jt_bookname.setBounds(420, 10, 171, 21);
		panel_3.add(jt_bookname);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 91, 665, 58);
		panel_2.add(panel_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("购买数量：");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_2.setBounds(37, 6, 122, 28);
		panel_3_1.add(lblNewLabel_2);
		
		jt_num = new JTextField();
		jt_num.setFont(new Font("宋体", Font.BOLD, 19));
		jt_num.setColumns(25);
		jt_num.setBounds(131, 10, 171, 21);
		panel_3_1.add(jt_num);
		
		JLabel lblNewLabel_1_1 = new JLabel("价格：");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(352, 6, 75, 28);
		panel_3_1.add(lblNewLabel_1_1);
		
		jt_price = new JTextField();
		jt_price.setFont(new Font("宋体", Font.BOLD, 19));
		jt_price.setColumns(25);
		jt_price.setBounds(420, 10, 171, 21);
		panel_3_1.add(jt_price);
		
		trips_1 = new JLabel("");
		trips_1.setForeground(Color.RED);
		trips_1.setFont(new Font("宋体", Font.BOLD, 16));
		trips_1.setBounds(131, 37, 274, 21);
		panel_3_1.add(trips_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBounds(10, 159, 665, 44);
		panel_2.add(panel_3_2);
		
		JLabel lblNewLabel_3 = new JLabel("折扣：");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_3.setBounds(68, 6, 91, 28);
		panel_3_2.add(lblNewLabel_3);
		
		jt_zhekou = new JTextField();
		jt_zhekou.setText(Double.toString(Jrame2.zhekou));
		jt_zhekou.setEditable(false);
		jt_zhekou.setFont(new Font("宋体", Font.BOLD, 19));
		jt_zhekou.setColumns(25);
		jt_zhekou.setBounds(131, 10, 171, 21);
		panel_3_2.add(jt_zhekou);
		
		JLabel lblNewLabel_1_2 = new JLabel("应付：");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(352, 6, 75, 28);
		panel_3_2.add(lblNewLabel_1_2);
		
		jt_shouldpay = new JTextField();
//		动态计算应付金额
		Document dtDocument=jt_num.getDocument();
		dtDocument.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
					try {
						get_shouldpay();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
					try {
						get_shouldpay();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jt_shouldpay.setFont(new Font("宋体", Font.BOLD, 19));
		jt_shouldpay.setColumns(25);
		jt_shouldpay.setBounds(420, 10, 171, 21);
		panel_3_2.add(jt_shouldpay);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBounds(10, 235, 665, 67);
		panel_2.add(panel_3_3);
		
		trips = new JLabel("");
		trips.setFont(new Font("宋体", Font.BOLD, 16));
		trips.setForeground(Color.RED);
		trips.setBounds(131, 35, 202, 21);
		panel_3_3.add(trips);
		
		JLabel lblNewLabel_4 = new JLabel("收取：");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_4.setBounds(68, 6, 91, 28);
		panel_3_3.add(lblNewLabel_4);
		
		jt_receive = new JTextField();
		Document document=jt_receive.getDocument();
		document.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				get_returnmoney();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				get_returnmoney();

			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jt_receive.setFont(new Font("宋体", Font.BOLD, 19));
		jt_receive.setColumns(25);
		jt_receive.setBounds(131, 10, 171, 21);
		panel_3_3.add(jt_receive);
		
		JLabel lblNewLabel_1_3 = new JLabel("找零：");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_1_3.setBounds(352, 6, 75, 28);
		panel_3_3.add(lblNewLabel_1_3);
		
		jt_return = new JTextField();
		jt_return.setFont(new Font("宋体", Font.BOLD, 19));
		jt_return.setColumns(25);
		jt_return.setBounds(420, 10, 171, 21);
		panel_3_3.add(jt_return);
		
		
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.setIcon(new ImageIcon(Book_sele.class.getResource("/img/重置.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				重置输出框
				jt_isbn.setText("");
				jt_bookname.setText("");
				jt_num.setText("");
				jt_price.setText("");
				jt_shouldpay.setText("");
				jt_receive.setText("");
				jt_return.setText("");
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBounds(155, 322, 113, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.setIcon(new ImageIcon(Book_sele.class.getResource("/img/确定.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				判断当前ISBN对应的图书是否存在
				
				if (jt_isbn.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "请输入要购买的图书！","提示",JOptionPane.INFORMATION_MESSAGE);

				}else {
					String isbn=jt_isbn.getText();
					String sql="select * from book_stack where ISBN=?";
					try {
						ResultSet set=ConnectionManager.query(sql, new Object[] {isbn});
//						如果该书不存在
						if (!set.next()) {
							JOptionPane.showMessageDialog(null, "书库中没有该图书","提示",JOptionPane.INFORMATION_MESSAGE);
						}else {
//							当前图书存在，保存相应订单
//							获取要保存的数据
							String isbnString=jt_isbn.getText();
							String bookname=jt_bookname.getText();
							String num=jt_num.getText();
							String markprice=jt_price.getText();
							String zhekou=jt_zhekou.getText();
							String shouldpay=jt_shouldpay.getText();
							String receive=jt_receive.getText();
							String returnmoney=jt_return.getText();
//							下单时间
							String time=ConnectionManager.gettime();
//							保存数据到表
							String sqlstring="insert into book_out values(?,?,?,?,?,?,?,?,?,?);";
							int n=ConnectionManager.Update(sqlstring, new Object[] {null,isbnString,bookname,num,markprice,zhekou,shouldpay,receive,returnmoney,time});
							if(n>0) {
								JOptionPane.showMessageDialog(null, "下单成功！","提示",JOptionPane.INFORMATION_MESSAGE);
//								修改库存数量
								int stocknum=0;
								String sqlString2="select num from book_stack where ISBN=?";
								ResultSet set1=ConnectionManager.query(sqlString2, new Object[] {isbnString});
								if(set1.next()) {
									stocknum=set1.getInt("num");
								}
								stocknum=stocknum-Integer.parseInt(num);
//								保存更改后的数量-库存
								String sqlString3="update book_stack set num=? where ISBN=?";
								int m=ConnectionManager.Update(sqlString3, new Object[] {stocknum,isbn});
								if (m>0) {
									System.out.println("(book-stack table图书数量更新完毕，购买"+num+"现在还剩下"+stocknum);
								}
								else {
									System.out.println("图书数量更新失败！");
								}
//								新书表
								String sqlString4="update new_book_in set num=? where ISBN=?";
								int k=ConnectionManager.Update(sqlString4, new Object[] {stocknum,isbn});
								if (k>0) {
									System.out.println("(new book table)图书数量更新完毕，购买"+num+"现在还剩下"+stocknum);
								}
								else {
									System.out.println("图书数量更新失败！");
								}
//								刷新表格
								
								Update_sele_table();
								Books_panel.update_table_items();
								
							}else {
								JOptionPane.showMessageDialog(null, "下单失败！","提示",JOptionPane.INFORMATION_MESSAGE);
								

							}
							
							
							
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.setBounds(455, 322, 113, 30);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("订单一览", new ImageIcon(Book_sele.class.getResource("/img/浏览.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 43, 665, 344);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 665, 344);
		panel_4.add(scrollPane);
		
		o1=new Object[] {"序号","ISBN","书名","购买数量","标价","折扣","应付","收取","找零","下单时间"};
		o2=new Object[][] {
		
		};
		
		table = new JTable(o2,o1);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("订单总数：");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel_5.setBounds(468, 10, 124, 23);
		panel_1.add(lblNewLabel_5);
		
		dingdan_nums = new JTextField();
		dingdan_nums.setEditable(false);
		dingdan_nums.setBounds(556, 10, 93, 21);
		panel_1.add(dingdan_nums);
		dingdan_nums.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("订单查询", new ImageIcon(Book_sele.class.getResource("/img/查询 (2).png")), panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 22, 685, 43);
		panel_5.add(panel_6);
		
		find_text = new JTextField();
		find_text.setFont(new Font("宋体", Font.BOLD, 20));
		panel_6.add(find_text);
		find_text.setColumns(30);
		
		JButton btnNewButton_2 = new JButton("查询");
		btnNewButton_2.setIcon(new ImageIcon(Book_sele.class.getResource("/img/查询 (3).png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				获取文本框数据
				String text=find_text.getText();
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
					if (jrb_time.isSelected()) {
						isselect=3;
					}
//					按ISBN查询结果
//					String sql2="SELECT ISBN,bookname,out_num,markprice,zhekou,sholdpay,`return`,receive,time from book_out;";

					if (isselect==1) {
						String sql="SELECT ISBN,bookname,out_num,markprice,zhekou,sholdpay,`return`,receive,time from book_out where ISBN like '"+text+"%';";
						get_find_result(sql);
					}
					if (isselect==2) {
						String sql="SELECT ISBN,bookname,out_num,markprice,zhekou,sholdpay,`return`,receive,time from book_out where bookname like '"+text+"%';";
						get_find_result(sql);

						
					}
					if (isselect==3) {
						String sql="SELECT ISBN,bookname,out_num,markprice,zhekou,sholdpay,`return`,receive,time from book_out where time like '"+text+"%';";
						get_find_result(sql);
					}
				}
				

				
			}
			
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		panel_6.add(btnNewButton_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 67, 685, 43);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("查询方式：");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(lblNewLabel_6);
		
		jrb_isbn = new JRadioButton("ISBN");
		jrb_isbn.setSelected(true);
		jrb_isbn.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_isbn);
		
		jrb_bookname = new JRadioButton("书名");
		jrb_bookname.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_bookname);
		
		jrb_time = new JRadioButton("交易时间");
		jrb_time.setForeground(Color.BLACK);
		jrb_time.setFont(new Font("宋体", Font.BOLD, 18));
		panel_7.add(jrb_time);
		
//		按钮组
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(jrb_time);
		bGroup.add(jrb_bookname);
		bGroup.add(jrb_isbn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 148, 685, 249);
		panel_5.add(scrollPane_1);
		
		table_1 = new JTable(o2,o1);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_7 = new JLabel("查询结果：");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(38, 120, 86, 18);
		panel_5.add(lblNewLabel_7);
		
		yes_no = new JLabel("");
		yes_no.setForeground(Color.RED);
		yes_no.setFont(new Font("宋体", Font.PLAIN, 17));
		yes_no.setBounds(121, 120, 183, 20);
		panel_5.add(yes_no);
		

		Update_sele_table();
		

	}
	
	/**
	 * 动态查询ISBN如有结果返回bookname和markprice
	 */
	public void get_bookname_markprice() {
//		获取ISBN值
		String isbn=jt_isbn.getText();
//		从库存表中查询是否有该图书
		String sql="select * from book_stack where ISBN=?;";
//		执行
		try {
			ResultSet set=ConnectionManager.query(sql, new Object[] {isbn});
//			判断结果集
			if(set.next()) {
				String bookname=set.getString("bookname");
				double markprice=set.getDouble("markprice");
//				将值设置到文本框
				jt_bookname.setText(bookname);
				jt_price.setText(Double.toString(markprice));
			}else {
				jt_bookname.setText("");
				jt_price.setText("");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 计算应付金额
	 * @throws SQLException 
	 */
	public void get_shouldpay() throws SQLException {
//		获取该书的库存量
		boolean extis=false;
		String isbn=jt_isbn.getText();
		int num;
		String sql="select num from book_stack where ISBN=?";
		ResultSet set = null;
		try {
			set = ConnectionManager.query(sql, new Object[] {isbn});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stock_num = 0;
		while (set.next()) {
			stock_num=set.getInt("num");
			extis=true;
			
		}
		
		if (jt_num.getText().equals("")) {
			trips_1.setText("");
		}else if (extis) {
//			购买数量超过库存
			num=Integer.parseInt(jt_num.getText());
			if (num>stock_num) {
				trips_1.setText("该书当前库存(最多购买)"+stock_num+"本!!!");
			}else {
//				获取价格，数量，折扣
				trips_1.setText("");
				double price=Double.parseDouble(jt_price.getText());
				double zhekou=Double.parseDouble(jt_zhekou.getText());
//				计算应付金额
				double shouldpay=num*price*zhekou;
//				会显
				jt_shouldpay.setText(Double.toString(shouldpay));
			}
			
		}
		
		
	}
	
	/**
	 * 计算找零
	 */
	public void get_returnmoney() {
		if (jt_receive.getText().equals("")) {
			
		}else {
//			获取应付
			double shouldpay=Double.parseDouble(jt_shouldpay.getText());
//			获取 收取
			double receive=Double.parseDouble(jt_receive.getText());
//			判断收取是否够钱
			if (receive<shouldpay) {
				trips.setText("你的钱不足以支付 ！");
			}else {
				trips.setText("");
				double returnmoney=receive-shouldpay;
				jt_return.setText(Double.toString(returnmoney));
			}
		}
	}
	
	/**
	 * 输入SQL查询语句，返回结果集的二维组形式，并刷新到表格中
	 */
	public void Update_sele_table() {
		// TODO Auto-generated method stub
//		统计数量
		int count=0;

		Object[] objects=new Object[] {"序号","ISBN","书名","购买数量","标价","折扣","应付","收取","找零","下单时间"};
		String sql2="SELECT ISBN,bookname,out_num,markprice,zhekou,sholdpay,`return`,receive,time from book_out;";
		ResultSet set = null;
		try {
			set = ConnectionManager.query(sql2, new Object[] {});
			while (set.next()) {
				count++;		
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Object[][] objects2 = null;
		try {
			objects2 = ConnectionManager.getSetArrays(set);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dingdan_nums.setText(Integer.toString(count));
		TableModel dataModel = new DefaultTableModel(objects2,objects);
		table.setModel(dataModel);
		System.out.println("订单表格刷新!");
			}

	
	/**
	 * 根据输入框的参数查询返回相应的结果到表格
	 * @param sql
	 */
	public void get_find_result(String sql) {
		// TODO Auto-generated method stub
				Object[][] a=new Object[][] {};
//				查询结果：
				try {
					ResultSet set=ConnectionManager.query(sql, new Object[] {});
//					如果结果集不为空
					if (set.next()) {
//						将结果转为二维数组
						a=ConnectionManager.getSetArrays(set);
//						将数组反馈到表格
						TableModel dataModel = new DefaultTableModel(a,o1);
						table_1.setModel(dataModel);
						yes_no.setText("");
					}else {
						TableModel dataModel = new DefaultTableModel(new Object[][] {},o1);
						table_1.setModel(dataModel);
						
						yes_no.setText("没有查询到结果");
						System.out.println("没有查询到结果!!!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
}

