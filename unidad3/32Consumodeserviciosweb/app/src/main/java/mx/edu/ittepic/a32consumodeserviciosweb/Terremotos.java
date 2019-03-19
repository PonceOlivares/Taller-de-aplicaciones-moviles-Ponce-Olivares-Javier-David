package mx.edu.ittepic.a32consumodeserviciosweb;



public class Terremotos {
    String Titulo;
    String Magnitud;
    String Tipo;
    String Profundidad;
    String Latitud;
    String Longitud;
    String Fecha;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getMagnitud() {
        return Magnitud;
    }

    public void setMagnitud(String magnitud) {
        Magnitud = magnitud;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getProfundidad() {
        return Profundidad;
    }

    public void setProfundidad(String profundidad) {
        Profundidad = profundidad;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Terremotos(String titulo, String magnitud, String tipo, String profundidad, String latitud, String longitud, String fecha) {

        Titulo = titulo;
        Magnitud = magnitud;
        Tipo = tipo;
        Profundidad = profundidad;
        Latitud = latitud;
        Longitud = longitud;
        Fecha = fecha;
    }
}
