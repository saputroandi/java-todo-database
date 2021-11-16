package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java_database?serverTimezone=Asia/Jakarta");

        config.setMaximumPoolSize(10);
        config.setIdleTimeout(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
