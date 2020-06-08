package di20.team06.sql;

import di20.team06.utils.Procedure;
import org.intellij.lang.annotations.Language;

import java.net.InetSocketAddress;
import java.sql.*;

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
     * Create & execute an sql query
     * <p>
     * This should <b>NOT</b> be used for queries handling any user input.<br>
     * Use {@link #query(String, String[])} instead, as it uses prepared statements
     *
     * @param sql The query to execute
     * @return The query's result
     */
    public ResultSet query(@Language("SQL") String sql) {
        try(var statement = connection.createStatement()) {
            if (statement.execute(sql)) {
                return statement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create & execute a prepared statement query
     *
     * @param sql The SQL query to execute
     * @param args Any arguments for the query
     * @return The query's results
     * @throws IllegalArgumentException if the number of arguments in {@code args} doesn't match the amount expected {@code sql}
     */
    public ResultSet query(@Language("SQL") String sql, String[] args) {
        try(var statement = connection.prepareStatement(sql)) {

            //Check if the amount of supplied args is correct
            var parameterCount = statement.getParameterMetaData().getParameterCount();
            if (parameterCount != args.length) {
                throw new IllegalArgumentException(String.format(
                        "Wrong amount of arguments for query! (expected: %d, got %d)",
                        parameterCount, args.length
                ));
            }

            //Fill the arguments into the statement
            for (int i = 0; i < args.length; i++) {
                statement.setString(i + 1, args[i]);
            }

            //Execute the statement & return the result
            if (statement.execute())
                return statement.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
