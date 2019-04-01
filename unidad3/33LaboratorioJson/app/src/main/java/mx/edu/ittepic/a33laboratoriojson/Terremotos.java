package mx.edu.ittepic.a33laboratoriojson;



public class Terremotos {
    int Titulo;
    String Titulo2=Titulo+"";

    String Magnitud;

    int Tipo;
    String Tipo2=Tipo+"";

    int Profundidad;
    String Profundidad2= Profundidad+"";

    int Latitud;
    String  Latitud2 = Latitud+"";

    String Longitud;
    String Fecha;

    public int getTitulo() {
        return Titulo;
    }

    public void setTitulo(int titulo) {
        Titulo = titulo;
    }

    public String getMagnitud() {
        return Magnitud;
    }

    public void setMagnitud(String magnitud) {
        Magnitud = magnitud;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public int getProfundidad() {
        return Profundidad;
    }

    public void setProfundidad(int profundidad) {
        Profundidad = profundidad;
    }

    public int getLatitud() {
        return Latitud;
    }

    public void setLatitud(int latitud) {
        Latitud = latitud;
    }

  //  public String getLongitud() {
      //  return Longitud;
    //}

    //public void setLongitud(String longitud) {
      //  Longitud = longitud;
    //}

    //public String getFecha() {
        //return Fecha;
    //}

   // public void setFecha(String fecha) {
      //  Fecha = fecha;
    //}

    public Terremotos(String titulo, String magnitud, String tipo, String profundidad, String latitud) {

        Titulo = Integer.parseInt(titulo);
        Magnitud = magnitud;
        Tipo = Integer.parseInt(tipo);
        Profundidad = Integer.parseInt(profundidad);
        Latitud = Integer.parseInt(latitud);
        //Longitud = longitud;
        //Fecha = fecha;
    }
}
