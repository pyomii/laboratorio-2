
package laboratorio_2_progra2;

public class Libro extends MaterialBibliografico {
    // Atributo
    private String autor ;
    // Constructor 
    public Libro (String codigo , String titulo , int anio , String imagen , String autor ) {
    super(codigo , titulo , anio , imagen)   ;
    this.autor = autor ;
    }
    public String getAutor () {
        return autor ;
    }
    // reglas de libro 
    public int getPlazoDias () {
        return 14 ;
    }
    @Override
    public double getMultaDiaria () {
        return 1.50 ;
    }
    @Override
    public String getTipo () {
        return "Libro" ;
    }
    public String toString () {
        return super.toString() + ", Autor: " + autor ;
    }
}
