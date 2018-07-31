package com.haz.base;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.haz.Application;

/**
 * 单元测试基类
 * 
 * @author aizhou.huang
 * @date 2018年7月31日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

}
