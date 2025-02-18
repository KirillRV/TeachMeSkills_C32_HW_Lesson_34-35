package by.tms.flyway;
import org.flywaydb.core.Flyway;

public class FlyWayMigration {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/databse-32", "postgres", "root")
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
    }
}