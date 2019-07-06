package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.service.CDPlayerConfig;
import com.xml.service.ComplexAssembly;

@RunWith(SpringJUnit4ClassRunner.class)
// 自动装配的配置
//@ContextConfiguration(classes = TapeConfig.class)
// 手动装配的配置
@ContextConfiguration(classes = CDPlayerConfig.class)
public class PlayerTest {

	// ---------------自动装配-------------------
	/*
	 * 
	 * 1、通过扫描包的方式实现装配bean，使用@Component注解或@Named 注解进行配置
	 *
	 * @Autowired private Tape tape;
	 * 
	 * @Test public void player(){ assertNotNull(tape); tape.play(); }
	 */

	/*
	 * 2、通过bean添加注解实现自动装配 自动装配就是让Spring 自动满足bean以来的一种方法，在满足依赖过程中，会在Spring
	 * 应用上下文中寻找匹配 某个bean 需求的其他bean,为了声明进行自动装配，可以节主Spring的Autowired注解。
	 * 
	 * 注解方式： 注解构造方法中 注解到set方法中 注解到普通方法中 验证注解的方法
	 * 
	 * 
	 * @Autowired private Player player;
	 * 
	 * @Test public void player(){ assertNotNull(player); player.play(); }
	 * 
	 */

	// ---------------手动装配-------------------
	/*
	 * 
	 @Autowired
	 private CDPlayer cdPlayer;
	
	 @Test
	 public void cdShouldNotBeNull() {
		assertNotNull(cdPlayer);
		cdPlayer.play();
	 }
	 */
	
	 @Test
	 public void getXmlComplexAssembly() {
		 ApplicationContext context = new ClassPathXmlApplicationContext(
	    			new String[]{"applicationContext.xml"}
	    			);
	    	
		 ComplexAssembly complexAssembly = (ComplexAssembly) context.getBean("complexAssembly");
		 System.out.println(complexAssembly.getId());
		 System.out.println(complexAssembly.getMap().get("key1"));
		 
	 }
	
	
	
	
}
