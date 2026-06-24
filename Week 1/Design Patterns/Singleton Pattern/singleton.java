class Logger {
    private static Logger instance;
    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("Application started");
        log2.log("Doing some work");

        System.out.println("Same instance? " + (log1 == log2));
    }
}
