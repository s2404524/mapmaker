package di20.team06.sql;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
    @BeforeAll public static void init() {
        Database.init();
    }

    @AfterAll public static void cleanup() {
        Database.shutdown();
    }

    @Test public void testConnection() throws SQLException {
        System.out.println("Creating test table...");
        Database.INSTANCE.query(
            "create table creationTest (\n" +
                "   id int primary key,\n" +
                "   test varchar\n" +
                ");"
        );

        System.out.println("Inserting test values...");
        Database.INSTANCE.query(
                "insert into creationTest(id, test)\n" +
                    "values (0, 'foo'),\n" +
                    "       (1, 'bar'),\n" +
                    "       (2, 'baz');"
        );

        System.out.println("Querying test values...");
        var result = Database.INSTANCE.query("select test from creationTest");

        assertEquals("foo", result.getString("test"));
        assertEquals("bar", result.getString("test"));
        assertEquals("baz", result.getString("test"));

        System.out.println("Deleting test table...");
        Database.INSTANCE.query("drop table creationTest;");
    }
}
