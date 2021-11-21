package ir.maktab.examination_online_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExaminationOnlineSystemApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExaminationOnlineSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExaminationOnlineSystemApplication.class, args);
    }

}
