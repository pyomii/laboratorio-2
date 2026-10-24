
package laboratorio_2_progra2;

public class Revista extends MaterialBibliografico{
    private int numEdicion;

    public Revista(String codigo, String titulo, int anio, String imagen, int numEdicion){
        super(codigo, titulo, anio, imagen);
        this.numEdicion = numEdicion;
    }

    public int getNumeroDeEdicion(){
        return numEdicion;
    }

    @Override
    public int getPlazoDias(){
        return 7;
    }

    @Override
    public double getMultaDiaria(){
        return 0.75;
    }

    @Override
    public String toString(){
        return super.toString()+" , Edicion: "+numEdicion;
    }
    public String getTipo() {
        return "Revista" ;
    }
}
