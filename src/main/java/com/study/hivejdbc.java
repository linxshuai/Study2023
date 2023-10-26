package com.study;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.UserGroupInformation;

import java.sql.*;

public class hivejdbc {
    //private static String  url2 = "jdbc:hive2://dsc-demo21.jdlt.163.org:2182,dsc-demo22.jdlt.163.org:2182,dsc-demo20.jdlt.163.org:2182/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2;principal=hive/_HOST@BDMS.COM";
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";


    /**
     * @description: 通过jdbc连接hive2
     */

    public Connection getConnection(String url2,String keytabfile,String personkey) {
        Configuration conf = new Configuration();
        conf.set("hadoop.security.authentication", "Kerberos");
        System.setProperty("krb5_ini", System.getProperty("user.dir") + "/krb5.conf");
        System.setProperty("hive_keytab", System.getProperty("user.dir") + "/"+keytabfile);
        System.setProperty("java.security.krb5.conf", System.getProperty("krb5_ini"));
        //System.setProperty("sun.security.krb5.debug", "true");
        UserGroupInformation.setConfiguration(conf);
        try {
            UserGroupInformation.loginUserFromKeytab(personkey, System.getProperty("hive_keytab"));
            // 使用hive用户登陆
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn = DriverManager.getConnection(url2, "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @description: 创建数据库
     */
    public void cresteDatabase(){
        try {
            conn.prepareStatement("show database").execute();
            System.out.println("数据库创建成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * @description: 查询数据
     */
    public void getAll(Connection conn) {
        String sql = "select * from mammut.test3";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // 获取所有列
            int columns = rs.getMetaData().getColumnCount();
            //处理数据
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showTables(Connection conn,String database) {
        try {
            // 进入default数据库
            System.out.println("进入数据库*********");
            ps = conn.prepareStatement("use "+database);
            ps.execute();
            // 展示所有表
            rs = ps.executeQuery("show tables");
            // 处理结果集
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(2));
//            }
            int columns = rs.getMetaData().getColumnCount();
            //处理数据
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 执行DDL语句
     */
    public void execute() {
        String sql = "INSERT overwrite directory '/user/hue/learn_oozie/mazy_hive_1/output'\n" +
                "row format delimited fields terminated by \"\\t\"\n" +
                "SELECT sid,sname FROM mytable LIMIT 10";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 创建表格
     */

    public void createTables() {
        String createSql = "create table if not exists default.mytable(id String, name String) row format delimited fields terminated by \",\" stored as textfile";
        try {
            conn.prepareStatement(createSql).execute();
            System.out.println("创建表成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("创建表失败");
        }
    }

    /**
     * @description: 进入数据库，展示所有表
     */



    /**
     * @description: 加载数据
     */

    public void loadTable() {
        String loadSql = "load data inpath \"/user/liuyzh/mytable.txt\" into table mytable";
        try {
            conn.prepareStatement(loadSql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 删除数据表
     */

    public void deleteTable(){
        try {
            conn.prepareStatement("DROP table default.mytable").execute();
            System.out.println("数据表被删除");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 删除数据库
     */

    public void dropDatabase(){
        String sql = "drop database test";
        try {
            conn.prepareStatement(sql).execute();
            System.out.println("删除数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 关闭连接
     */

    public void closeConnect() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}