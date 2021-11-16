package util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {

    @Test
    void testConnection() throws SQLException {
        HikariDataSource hikariDataSource = DatabaseUtil.getHikariDataSource();

        Connection connection = hikariDataSource.getConnection();

        connection.close();

        hikariDataSource.close();

    }

}
