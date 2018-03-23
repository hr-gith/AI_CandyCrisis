package models;

import javax.swing.*;
import java.awt.*;

public class LoggingView {
    private JFrame myFrame;
    JTextArea txt_window=new JTextArea();


    private LoggingView() {
        myFrame=new JFrame("Logging Window");
        myFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        JScrollPane scroll = new JScrollPane (txt_window);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        txt_window.setColumns(200);
        txt_window.setRows(1000);
        txt_window.setAutoscrolls(true);
        txt_window.setBackground(Color.WHITE);
        txt_window.setEditable(false);
        myFrame.add(scroll);
        scroll.setBounds(0, 0, 800, 700);
        myFrame.setSize(420, 720);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
    public JTextArea getTxt_window() {
        return txt_window;
    }

    /**
     * setter for Txt_window
     * @param txt_window
     *            An instance of JTextField to be associated with the window
     *            instance
     */
    public void setTxt_window(JTextArea txt_window) {
        this.txt_window = txt_window;
    }

    /**
     * Method for AddAction
     * @param action An instance of String to be associated with the action instance
     */
    public void AddAction(String action) {

        this.getTxt_window().setText(this.getTxt_window().getText() + "\n" + action);

    }

    private static LoggingView loggingViewObject;

    /**
     * getter for LoggingView
     * @return LoggingView
     */
    public static LoggingView getLoggingViewObject() {
        if (loggingViewObject == null)
            loggingViewObject = new LoggingView();
        else
        if(!loggingViewObject.myFrame.isVisible())
        {
            loggingViewObject.getTxt_window().setText("");
            loggingViewObject.myFrame.show();
        }
        return loggingViewObject;
    }
}
