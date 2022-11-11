package com.scut.community.scutbbs;

import com.scut.community.scutbbs.dao.AlphaDao;
import com.scut.community.scutbbs.dao.AlphaDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
// 使用的配置类与ScutbbsApplication一致 测试环境的配置类与正式环境一致
@ContextConfiguration(classes = ScutbbsApplication.class)
// 得到IoC容器，实现ApplicationContextAware这个接口
class ScutbbsApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	@Test
	void testApplicationContext() {
		// org.springframework.web.context.support.GenericWebApplicationContext@2c9399a4, started on Tue Nov 08 20:48:01 HKT 2022
		System.out.println(applicationContext);
		// 来看applicationContext如何管理bean

		// 获取IoC容器自动装配到的bean
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);

		// select * from user where name = wuyuda
		System.out.println(alphaDao.select());
		// true —— 不会重复创建对象。从容器中获取的都是同一个对象(这个可以改变bean的Scope，如果改成Prototype就是会创建多次)
		// 如果该类型的bean 只有一个，那么使用getBean(AlphaDao.class);就不会报错，
		// 如果Alpha类型的bean由多个，那么applicationContext.getBean(AlphaDao.class)会报错
		// 可以使用实现的类去获取bean，也可以使用name去获取bean
		AlphaDao alphaDao2 = applicationContext.getBean("alphaV1",AlphaDao.class);
		System.out.println(alphaDao == alphaDao2);

	}

	@Test
	void testBeanConfig() {
		// 测试获取第三方jar包的Bean
		SimpleDateFormat simpleDateFormat =  applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));

	}

	// 依赖注入的方式获取bean
	@Autowired
	private AlphaDao alphaDao;
	@Autowired
	@Qualifier("alphaV1")
	private AlphaDao alphaDaoV1;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Test
	void testDI(){
		// select * from user where name = wuyuda and age = 19 因为它使用了Primary的注解
		System.out.println(alphaDao.select());
		// select * from user where name = wuyuda
		System.out.println(alphaDaoV1.select());
		System.out.println(simpleDateFormat);
	}

	/**
	 * 可以看到熟悉的ApplicationContext接口 这个就是接口就是代表了Spring里的IoC容器
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException bean异常
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
