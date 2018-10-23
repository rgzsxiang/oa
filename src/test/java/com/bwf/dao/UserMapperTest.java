package com.bwf.dao;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.Operate;
import com.bwf.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserMapperTest.class);
	
	@Test
	public void testGetMenusAndOperatesByUserId(){
		User user = userMapper.getMenusAndOperatesByUserId(1);
		logger.info( user.getOperates().size() + "" );
		
		for( Operate o : user.getOperates() ) {
			logger.info( o.getOperateName() );
		}
		Assert.assertNotEquals( 0 , user.getOperates().size() );
	}
}
