package com.study;

import java.sql.Connection;
public class hivetest {
    public static void main(String[] args) {
        String url2=args[0];
        String keytabfile=args[1];
        String personkey=args[2];
        String database=args[3];
        System.out.println("url="+url2);
        System.out.println("keytabfile="+keytabfile);
        System.out.println("personkey="+personkey);
        System.out.println("database="+database);
        hivejdbc jd = new hivejdbc();

        Connection con = jd.getConnection(url2,keytabfile,personkey);
        System.out.println(con);
        jd.showTables(con,database);

    }
}
