public class SingletonLogger {

    private static SingletonLogger instance;
    private static final Object locker = new Object();

    protected SingletonLogger() {

    }

    public static SingletonLogger getInstance() {

        if (instance == null) {

            synchronized (locker) {

                if (instance == null) {

                    instance = new SingletonLogger();
                }
            }
        }
        return instance;
    }

    public enum LogLevel {

        COMMENT,
        WARNING,
        ERROR
    }

    public void log(LogLevel level, String message) {

        synchronized (locker) {

            switch (level) {

                case COMMENT:

                    System.out.println("Comment: " + message);
                    break;
                case WARNING:

                    System.out.println("\033[33mWarning: " + message + "\033[0m");
                    break;
                case ERROR:

                    System.out.println("\033[31mError: " + message + "\033[0m");
                    System.exit(1);
                    break;
            }
        }
    }
}
