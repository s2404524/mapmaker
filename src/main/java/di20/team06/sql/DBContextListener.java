package di20.team06.sql;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Class responsible for receiving Tomcat's ServletContext events
 * <p>
 * ServletContext events are used for executing code on startup & shutdown,<br>
 * Which is used here to initialize & shut down the database connection
 */
public class DBContextListener implements ServletContextListener {

    /**
     * Receives notification that the web application initialization
     * process is starting.
     *
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param e the ServletContextEvent containing the ServletContext
     *            that is being initialized
     */
    @Override public void contextInitialized(ServletContextEvent e) {
        Database.init();
    }

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     *
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param e the ServletContextEvent containing the ServletContext
     *            that is being destroyed
     */
    @Override public void contextDestroyed(ServletContextEvent e) {
        Database.shutdown();
    }
}
