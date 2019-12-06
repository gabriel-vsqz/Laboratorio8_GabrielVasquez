package lab8_gabrielvasquez;

import java.util.Date;

public class Mensaje {
 
    private String emisor;
    private String receptor;
    private Date envio;
    private String contenido;

    public Mensaje() {
    
    }

    public Mensaje(String receptor, Date envio, String contenido) {
        this.emisor = "Diego";
        this.receptor = receptor;
        this.envio = envio;
        this.contenido = contenido;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Date getEnvio() {
        return envio;
    }

    public void setEnvio(Date envio) {
        this.envio = envio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return contenido;
    }
    
}