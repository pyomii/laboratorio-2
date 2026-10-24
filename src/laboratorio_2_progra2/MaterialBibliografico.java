
package laboratorio_2_progra2;

public class MaterialBibliografico {
    // Atributos 
     private String codigo;
    private String titulo;
    private int anio;
    private boolean disponible;
   private String rutaImagen;
    
     public MaterialBibliografico(String codigo, String titulo, int anio, String Imagen) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this. rutaImagen = Imagen;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
     // metodos
    public int getPlazoDias() {
        return 7 ;
        
    }
    public double getMultaDiaria() {
        return 1.0 ;
    }
    public String getTipo() {
        return "Material" ;
    }
    // metodo calcular multa total
    public double calcularMulta(int diasRetraso) {
        return getMultaDiaria() * diasRetraso ;
    }
    
     @Override
    public String  toString () {
        return "Codigo: " + codigo + ", Titulo: " + titulo + ", Año: " + anio ;
    }
}
