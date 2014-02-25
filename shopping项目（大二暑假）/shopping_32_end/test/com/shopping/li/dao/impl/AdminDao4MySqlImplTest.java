/**
* @package_name   com.shopping.li.dao.impl
* @file_name AdminDao4MySqlImplTest.java
* @author Administrator
* @date 2013-7-23
*/
package com.shopping.li.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * @ClassName: AdminDao4MySqlImplTest
 * @Description: TODO
 */
public class AdminDao4MySqlImplTest {

	@Test
	public void test() {
		System.out.println(new AdminDao4MySqlImpl().findAdminByUsername("admin"));
	}
	
	

}
