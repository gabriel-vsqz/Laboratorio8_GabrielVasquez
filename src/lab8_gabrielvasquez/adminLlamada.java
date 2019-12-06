package lab8_gabrielvasquez;

import javax.swing.JLabel;

public class adminLlamada extends Thread {
 
    private JLabel duration;
    private boolean onCall;

    public adminLlamada(JLabel duration) {
        this.duration = duration;
        onCall = true;
    }

    public JLabel getDuration() {
        return duration;
    }

    public void setDuration(JLabel duration) {
        this.duration = duration;
    }
    
    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

    @Override
    public void run() {
        while (onCall) {
            String llamada = duration.getText();
            String[] tiempo = llamada.split(":");
            //String h = "", m = "", s = "";
            //tiempo[0] = h; tiempo[1] = m; tiempo[2] = s;
            int secs = Integer.parseInt(tiempo[2]);
            int mins = Integer.parseInt(tiempo[1]);
            int hrs = Integer.parseInt(tiempo[0]);
            secs++;
            if (secs == 60) {
                secs = 0;
                mins++;
            }
            if (mins == 60) {
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