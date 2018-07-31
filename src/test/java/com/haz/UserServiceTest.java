package com.haz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.haz.base.BaseTest;
import com.haz.pojo.UserPojo;
import com.haz.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
		UserPojo entity = new UserPojo();
		entity.setUserName("2222");
		entity.setCreateTime(new Date());
		UserPojo entity2 = new UserPojo();
		entity2.setUserName("3333");
		entity.setCreateTime(new Date());
		List<UserPojo> list = new ArrayList<UserPojo>();
		list.add(entity);
		list.add(entity2);
		userService.save(list);
	}

	@Test
	public void testFindByPage() {
		PageHelper.startPage(1, 10);
		List<UserPojo> list = userService.select(null);
		System.out.println(list.size());
	}

}
