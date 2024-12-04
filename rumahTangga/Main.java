package rumahTangga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import rumahTangga.config.Database;
import rumahTangga.views.RumahTanggaView;

@ComponentScan(basePackages = "todoapp")
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        RumahTanggaView rumahTanggaView = applicationContext.getBean(RumahTanggaView.class);
        rumahTanggaView.run();
    }

    @Bean
    Database database() {
        Database database = new Database("mydb", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }
}