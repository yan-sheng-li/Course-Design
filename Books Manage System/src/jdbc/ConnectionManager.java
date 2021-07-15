package jdbc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
/**
 * 简述：
 *数据库管理类
 * @author:LiYansheng
 * @date:2021/04/26 19:31
 * @version:
 */
public class ConnectionManager {
    /**
     * 连接数据库的四大必需属性
     */
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/book_management?useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String user = "root";
    private static final String psd = "root";
 
    /**
     * 静态块加载驱动
     */
    static {
        try {
            Class.forName(driver);
            System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
    }
    /**
     * 返回一个连接对象
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, psd);
//            System.out.println("连接数据库ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 通用查询方法,返回结果集
     * @param sql
     * @param objects
     * @return
     * @throws SQLException
     */
    public static ResultSet query(String sql, Object[] objects) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet resultSet=null;
//        判断Object是否为空，为空直接执行sql语句
        if (objects == null) {
            resultSet = pst.executeQuery();
        } else {
            for (int i = 0; i < objects.length; i++) {
                pst.setObject(i+1,objects[i]);
            }
            resultSet = pst.executeQuery();
        }
        return resultSet;
    }
    /**
     * 通用增删改方法
     * @param sql
     * @param objects
     * @return
     * @throws SQLException
     */
    public static int Update(String sql,Object[] objects) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
//      判断数组是否为空
        try {
            if (objects == null || objects.equals("")) {
                return pst.executeUpdate();
            } else {
                for (int i = 0; i < objects.length; i++) {
                    pst.setObject(i + 1, objects[i]);
                }
                return pst.executeUpdate();
            }
        } finally {
            closeall(conn, pst);
        }
 
    }
    /**
     * 返回结果集的二维数组形式，这个在JavaGUI里创建了表格要调用显示数据库的数据时可以用到
     * @param set
     * @return
     * @throws SQLException
     */
    public static Object[][] getSetArrays(ResultSet set) throws SQLException {
        Object[][] objects;
        
        set.last();
        int rowcount = set.getRow();
        ResultSetMetaData rsm = set.getMetaData();
        int colcount = rsm.getColumnCount();//获取列数
//      创建二维数组
        objects = new Object[rowcount][colcount+1];
        set.first();
        for (int i = 0; i < rowcount; i++) {
            objects[i][0]=i+1;//给每一行的第一列添加序号
            for (int j = 1; j < colcount+1; j++) {
                objects[i][j] = set.getObject(j);
            }
            set.next();
        }
        return objects;
    }
 
    /**
     * 关闭资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        try {
            if (connection != null && (!connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        try {
            if (connection != null && (!connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeall(Connection c, PreparedStatement p) throws SQLException {
        c.close();
        p.close();
    }
    
//    获取时间
    public static String gettime() {
    	Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
	}
    
    public static String getday() {
    	Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return simpleDateFormat.format(calendar.getTime());
	}

    
    
 
}
 
