package com.leapsign.kosmos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Rahul on 3/16/16.
 */
public class ChatPanel extends JPanel {
    JPanel text;
    JPanel io;
    JTextField field;
    JButton send;
    JTextArea transcript;
    Chat c;
    Object boi = "sa;lkdjfslad;kfj";

    public ChatPanel()
    {
        c = new Chat("https://blazing-torch-4342.firebaseio.com/","Person 1","Person 2");
        setSize(200,550);
        setVisible(true);
        text = new JPanel();
        io = new JPanel();
        send = new JButton("Send");
        field = new JTextField("Type Message Here");
        transcript = new JTextArea();
        transcript.setRows(28);
        transcript.setColumns(35);
        transcript.setSize(200,100);
        transcript.setText("Welcome to FireChat v.1.0.0 beta \n Who would you like to message?");
        text.setSize(200,300);
        io.setSize(200,200);
        send.setSize(50,100);
        field.setSize(150,100);
        text.setVisible(true);
        send.setVisible(true);
        transcript.setVisible(true);
        io.setVisible(true);
        field.setVisible(true);
        field.setMinimumSize(new Dimension(150,100));
        field.setMaximumSize(new Dimension(150,100));
        setLayout(new BorderLayout());
        io.setLayout(new BorderLayout());
        text.setLayout(new BorderLayout());
        setVisible(true);

        send.addActionListener(new ClickSendListener());
        text.add(transcript,BorderLayout.NORTH);
        io.add(field,BorderLayout.WEST);
        io.add(send,BorderLayout.EAST);
        add(text,BorderLayout.NORTH);
        add(io,BorderLayout.SOUTH);
        field.addKeyListener(new AL());
        field.setFocusable(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() { // Function runs every MINUTES minutes.
                // Run the code you want here
                Object b = c.getChange();


                    if (b != null) {
                        if(!boi.equals(b)) {
                            boi = b;
                            transcript.setText(transcript.getText() + "\n" + b);
                            System.out.println("change");
                        }
                    }


            }
        }, 0,100);



    }


    private class ClickSendListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            transcript.setText( transcript.getText() +"\n" + field.getText());
            field.setText("");
        }
    }

    private class AL extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
           // System.out.println(keyCode);
        if(keyCode==10)
        {
            transcript.setText( transcript.getText() +"\n" +  "                            " + "\t" + field.getText());
            c.updateDatabase(field.getText());
            field.setText("");

        }

    }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }
}
