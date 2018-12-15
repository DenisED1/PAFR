package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static File logFile;

    public void createLogFile() {
        logFile = new File(getDateTime() + ".txt");
        try {
            logFile.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void print(String text) {
        try {
            FileWriter fileWriter = new FileWriter(logFile.getAbsolutePath(), true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);
            printWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void printStackTrace(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile(), true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(sw.toString());
            printWriter.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    private String getDateTime() {
        Date date = new Date();
        String strDateFormat = "hh-mm-ss_dd-MM-yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        return dateFormat.format(date);
    }
}
