package genspark;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "genspark")
public class Configs {
    @Bean("stu1")
    public student Student1() {
        List<Phone> list = new ArrayList<>(List.of(new Phone("1234567890")));
        Address add = new Address("Gotham", "Philadelphia","United States","12345");
        return new student(21,"Steve",list,add);
    }
    @Bean("stu2")
    public student Student2() {
        List<Phone> list = new ArrayList<>(List.of(new Phone("0987654321")));
        Address add = new Address("Gotham", "Philadelphia","United States","12345");
        return new student(22,"Joe",list,add);
    }
}
