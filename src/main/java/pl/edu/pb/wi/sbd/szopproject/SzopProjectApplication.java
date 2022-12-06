package pl.edu.pb.wi.sbd.szopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pb.wi.sbd.szopproject.front.MainView;

@SpringBootApplication
public class SzopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SzopProjectApplication.class, args);
//        new MainView();
    }

}
