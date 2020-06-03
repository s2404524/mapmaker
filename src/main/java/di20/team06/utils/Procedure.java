package di20.team06.utils;

/**
 * A procedure can be used as a cleaner way to use try-catch blocks
 */
public interface Procedure {
    void run() throws Throwable;

    static void execute(Procedure procedure, boolean ignoreException) {
        try {
            procedure.run();
        } catch (Throwable throwable) {
            if (!ignoreException)
                throwable.printStackTrace();
        }
    }

    static void execute(Procedure procedure) {
        execute(procedure, false);
    }
}
