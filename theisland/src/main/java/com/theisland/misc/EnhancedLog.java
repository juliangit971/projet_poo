package com.theisland.misc;

import java.time.LocalDateTime;

public class EnhancedLog {

    /**
     * Shows an enhanced log with the current date and hour, Class that called it
     * and a message type (optionnal)
     * @param message the message to display
     * @param messageType the type of message (e.g. "INFO, ERROR, "WARNING, ...") displayed. Invisible if set to {@code null}
     */
    public static void eventLogger(String message, String messageType) {
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        logWritter(message, messageType, true, callingClassName);
    }


    /**
     * Shows an enhanced log with the current date and hour, Class that called it (optionnal)
     * and a message type (optionnal)
     * @param message the message to display
     * @param messageType the type of message (e.g. "INFO, ERROR, "WARNING, ...") displayed. Invisible if set to {@code null}
     * @param showCurrentClassPackage show calling Class' path if {@code true}, invisible if {@code false}
     */
    public static void eventLogger(String message, String messageType, boolean showCurrentClassPackage) {
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        logWritter(message, messageType, showCurrentClassPackage, callingClassName);
    }

    /**
     * Write the enhanced log with the correct parameters
     * @param message
     * @param messageType
     * @param showCurrentClassPackage
     * @param callingClassName
     */
    private static void logWritter(String message, String messageType, boolean showCurrentClassPackage, String callingClassName) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Write date
        String currentLogString = "[" + currentDateTime.getDayOfMonth() +  "/" + currentDateTime.getMonthValue() + "/" + currentDateTime.getYear() + " - " + currentDateTime.getHour() + ":" + currentDateTime.getMinute() + ":" + currentDateTime.getSecond() + "]";
        
        // If asked, write Class' path
        if (showCurrentClassPackage) {
            currentLogString +=  " (" + callingClassName + ")";
        }

        // If any, write Message Type
        if (messageType != null) {
            currentLogString +=  " [" + messageType + "]";
        }
        
        // Write message
        currentLogString += " " + message;

        System.out.println(currentLogString);
    }
}
