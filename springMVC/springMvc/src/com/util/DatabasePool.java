package com.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if (hikariDataSource != null){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            if (hikariDataSource != null){
                return hikariDataSource;
            }

            String url = "jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
            String driverName = "com.mysql.cj.jdbc.Driver";

            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setUsername("root");
            hikariConfig.setPassword("Bth147258369");
            hikariConfig.setJdbcUrl(url);
            hikariConfig.setDriverClassName(driverName);

            hikariDataSource = new HikariDataSource(hikariConfig);

            return hikariDataSource;
        }
    }

    public static void main(String[] args){
        getHikariDataSource();
    }
}
