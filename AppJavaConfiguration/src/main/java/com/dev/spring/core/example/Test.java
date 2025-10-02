package com.dev.spring.core.example; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
public class Test { 
public static void main(String[] args) { 
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); 
Book book = ctx.getBean(Book.class); 
book.setId(95468); 
book.setName("Spring In Action"); 
System.out.println(book); 
}
}