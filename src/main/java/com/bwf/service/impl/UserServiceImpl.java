package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	UserMapper userMapper;
	
	//在service中，单个方法中执行多条SQL语句，我们通常作为一个事物来进行处理
	//在方法上添加注解@Transactional（在spring-mybatis中开启基于注解的Spring事物管理方式）
	@Transactional
	@Override
	public User login(User user) {	
		//获取user的基本信息
		User u = userMapper.getUserByUsernameAndPassword( user );
		if(u!=null){
			u = userMapper.getMenusAndOperatesByUserId(u.getUserId());
		}
		return u;
	}

/*	@Override
	public User getMenusByUserId(int userId) {
		// TODO Auto-generated method stub
		return userMapper.getMenusByUserId( userId );
	}
*/
}
