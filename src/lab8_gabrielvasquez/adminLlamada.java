package lab8_gabrielvasquez;

import java.util.Scanner;
import javax.swing.JLabel;

public class adminLlamada extends Thread {
 
    private JLabel duration;
    private boolean onCall;

    public adminLlamada(JLabel duration) {
        this.duration = duration;
        onCall = true;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

    @Override
    public void run() {
        while (onCall) {
            
            String llamada = duration.getText();
            
            String s = Character.toString(llamada.charAt(4));
            String m = Character.toString(llamada.charAt(2));
            String h = Character.toString(llamada.charAt(0));
            int secs = Integer.parseInt(s);
            int mins = Integer.parseInt(m);
            int hrs = Integer.parseInt(h);
            secs++;
            if (secs == 60) {
                secs = 0;
                mins++;
            } else if (mins == 60) {
                mins = 0;
                hrs++;
            }
            duration.setText(hrs + ":" + mins + ":" + secs);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}