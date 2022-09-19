package genspark;

import org.springframework.stereotype.Component;

@Component
public class Phone {

    private String mob;


    public Phone(){

    }
    public Phone(String mob) {
        this.mob = mob;
    }


    @Override
    public String toString() {
        return "genspark.Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}
