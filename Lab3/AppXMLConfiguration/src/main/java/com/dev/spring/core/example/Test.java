package com.dev.spring.core.example; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import org.springframework.context.*; 
public class Test { 
	public static void main(String[] args) { 
	ApplicationContext ctx= new ClassPathXmlApplicationContext("com/dev/spring/core/example/config.xml"); 
	Book book = ctx.getBean(Book.class); 
	System.out.println(book); 
	} 
}