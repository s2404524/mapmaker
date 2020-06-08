package di20.team06.utils;

/**
 * A procedure can be used as a cleaner way to use try-catch blocks
 */
@FunctionalInterface
public interface Procedure {
    void run() throws Throwable;

    /**
     * Execute a procedure, catching any errors it might throw
     *
     * @param procedure The procedure to execute
     * @param ignoreException Whether any thrown exceptions should be ignored
     */
    static void execute(Procedure procedure, boolean ignoreException) {
        try {
            procedure.run();
        } catch (Throwable throwable) {
            if (!ignoreException)
                throwable.printStackTrace();
        }
    }

    /**
     * Execure a procedure
     * <p>Effectively the same as {@link Procedure#execute(Procedure, boolean) Procedure.execute(procedure, false)}
     * @param procedure The procedure to execute
     */
    static void execute(Procedure procedure) {
        execute(procedure, false);
    }
}
