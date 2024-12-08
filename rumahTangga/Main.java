package rumahTangga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import rumahTangga.config.Database;
import rumahTangga.repositories.RumahTanggaRepository; // Assuming you have a repository interface
import rumahTangga.repositories.RumahTanggaRepositoryDbImpl; // Assuming you have a DB implementation
import rumahTangga.services.RumahTanggaService; // Assuming you have a service interface
import rumahTangga.services.RumahTanggaServiceImpl; // Assuming you have a service implementation
import rumahTangga.views.RumahTanggaView; // Your main view class

@ComponentScan(basePackages = "rumahTangga")
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        RumahTanggaView rumahTanggaView = applicationContext.getBean(RumahTanggaView.class);
        rumahTanggaView.run();
    }

    @Bean
    Database database() {
        Database database = new Database("rumahTangga_db", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }

}