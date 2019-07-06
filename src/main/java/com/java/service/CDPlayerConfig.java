package com.java.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Spring 的组件扫描默认是不启用的，需要显式配置启用组件扫描去寻找被 @Component 注解修饰的组件类，并为其创建 bean 实例。
* */
/*
* 标记类 CDPlayerConfig 是 Spring 的配置类，通过 java 代码定义 Spring 的装配规则。
* 该类应该包含在Spring应用上下文中如何创建bean的细节。
* */
@Configuration
public class CDPlayerConfig {

	
	 /*
	    * 要在 JavaConfig 中声明 bean ，我们需要编写一个方法，这个方法会创建所需类型的实例，然后给这个方法添加 @Bean 注解。
	    *
	    * @Bean 注解会告诉 Spring 这个方法将会返回一个对象，该对象要注册为 Spring 应用上下文中的 bean 。
	    * 方法体中包含了最终产生 bean 实例的逻辑。
	    *
	    * 默认，bean 的 ID 和方法名是一样的，如下 bean 的 ID 为 sgtPeppers 。
	    * 如果想手动为 bean 指定一个 ID ，可以使用 @Bean 的 name 属性，如：
	    *   @Bean(name="lonelyHeartsClubBand")
	    * */
	    @Bean
	    public CompactDisc sgtPeppers() {
	        return new SgtPeppers();
	    }

	    // 这里是使用 Java 创建 bean，因此我们可以发挥 Java 提供的所有功能，只要最终生成一个 CompactDisc 实例即可。例如：
	    @Bean
	    public CompactDisc randomBeatlesCD() {
	        CompactDisc cd;
	        int choice = (int) Math.floor(Math.random() * 4);
	        switch (choice) {
	            case 1:
	                cd = new SgtPeppers();
	                break;
	            case 2:
	                cd = new WhiteAlbum();
	                break;
	            case 3:
	                cd = new HardDaysNight();
	                break;
	            default:
	                cd = new Revolver();
	                break;
	        }
	        return cd;
	    }

	    /*
	    * Spring 装配方式一：
	    * 在JavaConfig中装配bean的最简单方式就是引用创建bean的方法。
	    * */
	    @Bean
	    public CDPlayer cdPlayer() {
//	        return new CDPlayer(sgtPeppers());
	        return new CDPlayer(new WhiteAlbum());
	    }

	    /*
	    * Spring 装配方式二：
	    * 当 Spring 调用 cdPlayer() 创建 CDPlayer bean 的时候，它会自动装配一个 CompactDisc 到配置方法之中。
	    * 然后，方法体就可以按照合适的方式来使用它。
	    *
	    * 通过这种方式引用其他的 bean 通常是最佳的选择，因为它不会要求将 CompactDisc 声明到同一个配置类之中。
	    * 在这里甚至没有要求 CompactDisc 必须要在 JavaConfig 中声明，
	    * 实际上它可以通过组件扫描功能自动发现或者通过 XML 来进行配置。
	    * 你可以将配置分散到多个配置类、XML 文件以及自动扫描和装配 bean 之中，
	    * 只要功能完整健全即可。不管 CompactDisc 是采用什么方式创建出来的，
	    * Spring 都会将其传入到配置方法中，并用来创建 CDPlayer bean 。
	    *
	    * 当配置类中有多个同类型的 bean 时，此时可以使用 @Qualifier 注解来指定参数注入的是哪一个具体的 bean 。
	    * */
	    @Bean
	    public CDPlayer cdPlayer(@Qualifier("randomBeatlesCD") CompactDisc compactDisc) {
	        return new CDPlayer(compactDisc);
	    }

	    /*
	    * 我们也可以采用属性赋值的方式来注入依赖值，这里所存在的可能性仅仅受到Java语言的限制。
	    * */
//	    @Bean
//	    public CDPlayer cdPlayer(@Qualifier("sgtPeppers") CompactDisc compactDisc) {
//	        CDPlayer cdPlayer = new CDPlayer();
//	        cdPlayer.setCd(compactDisc);
//	        return cdPlayer;
//	    }
}
