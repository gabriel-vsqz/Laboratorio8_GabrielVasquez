package lab8_gabrielvasquez;

public class Llamada {
 
    private String emisor;
    private String receptor;
    private String fecha;
    private String tiempo;

    public Llamada(String receptor, String fecha, String tiempo) {
        this.emisor = "Rigby";
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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