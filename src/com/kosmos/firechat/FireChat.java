package com.leapsign.kosmos;

/**
 * Created by Rahul on 3/14/16.
 */
public class FireChat {
    static JLabel bruh;
    static String receiver;
    static ArrayList<String> text;
    public static void main(String[] args)
    {

        JFrame frame = new JFrame("FireChat");
        frame.setSize(200, 500);
        frame.setLocation(100, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChatPanel());
        frame.setVisible(true);

    }
}
