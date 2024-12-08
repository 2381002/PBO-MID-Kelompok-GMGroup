package rumahTangga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import rumahTangga.config.Database;
import rumahTangga.views.TerminalView;

@ComponentScan(basePackages = "rumahTangga")
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        TerminalView terminalView = applicationContext.getBean(TerminalView.class);
        terminalView.run();
    }

    @Bean
    Database database() {
        Database database = new Database("rumahTangga_db", "root", "", "localhost", "3306");
        database.setup();
        return database;
    }

}