package com.shopping.util;

import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;



public class DBPoolUtils {
	private DBPoolUtils() {}
	private static DBPoolUtils dbPoolUtils = null;
	private static DruidDataSource dataSource = null;
	static {
		Properties properties = PropUtil.getProp("dbConfig.properties");
		try {
			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized DBPoolUtils getInstance() {
		if (null == dbPoolUtils) {
			dbPoolUtils = new DBPoolUtils();
		}
		return dbPoolUtils;
	}
	
	public DruidDataSource getDataSource() {
		return dataSource;
	}

	public DruidPooledConnection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}