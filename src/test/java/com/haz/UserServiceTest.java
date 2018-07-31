package com.haz;

import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.haz.base.BaseTest;
import com.haz.pojo.UserPojo;
import com.haz.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		entity2.setCreateTime(new Date());

		List<UserPojo> list = Lists.newArrayList(entity, entity2);
		userService.save(list);
	}

	@Test
	public void testFindByPage() {
		PageHelper.startPage(1, 10);
		List<UserPojo> list = userService.select(null);
		log.info("size:{}", list.size());
	}

}
