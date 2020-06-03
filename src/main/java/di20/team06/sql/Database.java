package di20.team06.sql;

import di20.team06.utils.Procedure;

import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for communicating with the database
 */
public class Database {
    public static Database INSTANCE;

    private final Connection connection;
    
    /**
     * Connect to a database
     *<p>
     * TODO find an alternative to user/pass login
     */
    private Database(InetSocketAddress address, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:postgresql://" + address.getHostName(),
                username, password
        );
    }

    /**
     * Connect to the database
     * <p>
     * TODO replace hard-coded info with values from config file
     */
    static void init() {
        String username = "dab_dsgnprj_9", password = "G908WZerR3RH/cwD";
        try {
            INSTANCE = new Database(
                    new InetSocketAddress("bronto.ewi.utwente.nl/" + username, 5432),
                    username, password
            );
        } catch (SQLException e) {
            throw new IllegalStateException("Couldn't connect to database!");
        }
    }

    /**
     * Terminate the database connection
     */
    static void shutdown() {
        Procedure.execute(INSTANCE.connection::close, true);
    }
}
