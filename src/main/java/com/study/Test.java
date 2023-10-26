package com.study;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        String urlhive = "jdbc:hive2://dsc-demo21.jdlt.163.org:2182,dsc-demo22.jdlt.163.org:2182,dsc-demo20.jdlt.163.org:2182/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2;principal=hive/_HOST@BDMS.COM";
        String keytabfile = "admin.mammut.keytab";
        String personkey = "bdms_admin.mammut/dev@BDMS.COM";
        String database = "mammut_qa";
        System.out.println("url=" + urlhive);
        System.out.println("keytabfile=" + keytabfile);
        System.out.println("personkey=" + personkey);
        System.out.println("database=" + database);
        hivejdbc jd = new hivejdbc();
        Connection con = jd.getConnection(urlhive, keytabfile, personkey);
        System.out.println(con);
        jd.showTables(con, database);
    }
}
