package lab8_gabrielvasquez;

import javax.swing.JLabel;

public class adminLlamada implements Runnable {
 
    private JLabel duration;

    public adminLlamada(JLabel duration) {
        this.duration = duration;
    }

    @Override
    public void run() {
        while (true) {
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}