
package laboratorio_2_progra2;

public class Tesis extends MaterialBibliografico{
     private String autor;

    public Tesis(String codigo, String titulo, int anio, String imagen, String autor){
        super(codigo, titulo, anio, imagen);
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }

    @Override
    public int getPlazoDias(){
        return 3;
    }

    @Override
    public double getMultaDiaria(){
        return 3.00;
    }

    @Override
    public String toString(){
        return super.toString()+" ,Autor: "+autor;
    }
}
