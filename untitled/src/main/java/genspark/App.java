package genspark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Configs.class);
        student s1 = (student)context.getBean("stu1");
        student s2 = (student)context.getBean("stu2");
        System.out.println(s1);
        System.out.println(s2);
    }
}

