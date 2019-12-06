package lab8_gabrielvasquez;

import java.util.Date;

public class Llamada {
 
    private String emisor;
    private String receptor;
    private Date fecha;
    private String tiempo;

    public Llamada(String receptor, Date fecha, String tiempo) {
        this.emisor = "Diego";
        this.receptor = receptor;
        this.fecha = fecha;
        this.tiempo = tiempo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return tiempo;
    }
    
}