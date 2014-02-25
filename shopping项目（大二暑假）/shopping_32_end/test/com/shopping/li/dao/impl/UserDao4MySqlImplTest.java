/**
* @package_name   com.shopping.li.dao.impl
* @file_name UserDao4MySqlImpl.java
* @author Administrator
* @date 2013-8-2
*/
package com.shopping.li.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.shopping.po.Goods;
import com.shopping.po.User;
import com.shopping.po.UserGoods;

/** 
 * @ClassName: UserDao4MySqlImpl
 * @Description: TODO
 */
public class UserDao4MySqlImplTest {

	@Test
	public void test() {
		System.out.println(new UserDao4MySqlImpl().findCommentByGid(3));
	}

}
