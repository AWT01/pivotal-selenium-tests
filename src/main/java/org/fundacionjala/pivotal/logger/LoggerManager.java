package org.fundacionjala.pivotal.logger;

import org.apache.commons.logging.impl.Log4JLogger;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class LoggerManager {
    private static LoggerManager instance = null;
    private Log4JLogger logger;

    /**
     *
     */
    public LoggerManager() {
        logger = new Log4JLogger();
    }

    /**
     * .
     * @return .
     */
    public Log4JLogger getLogger() {
        return logger;
    }

    /**
     * .
     * @return .
     */
    public static LoggerManager getInstance() {
        if (instance == null) {
            instance = new LoggerManager();
        }
        return instance;

    }

}
