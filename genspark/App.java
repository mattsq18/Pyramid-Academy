package genspark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Configs.class);
        student stu = (student)  context.getBean("student");
        System.out.println(stu);
    }
}

