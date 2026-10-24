package laboratorio_2_progra2;

import java.util.Calendar;

public class Prestamo {

    public static final String activo= "ACTIVO";
    public static final String devuelto= "DEVUELTO";

    private MaterialBibliografico material;
    private Calendar fechaPrestamo, fechaPrevista, fechaDevolucion;
    private String estado;
    private int diasRetraso;
    private double multa;
    
    public Prestamo(MaterialBibliografico material) {
<<<<<<< HEAD
        this(material, Calendar.getInstance());
    }
    
   public Prestamo(MaterialBibliografico material, Calendar inicio) {
        this.material = material;
        this.fechaPrestamo = fecha(inicio);
        this.fechaPrevista = fecha(inicio);
      
        this.fechaPrevista.add(Calendar.DAY_OF_MONTH, material.getPlazoDias());
        this.fechaDevolucion = null;
        this.estado = activo;
        this.diasRetraso = 0;
        this.multa = 0;
=======
        this.material= material;
        this.fechaPrestamo= fecha(Calendar.getInstance());
        this.fechaPrevista= fecha(Calendar.getInstance());
        this.fechaPrevista.setTime(fechaPrestamo.getTime());
        this.fechaPrevista.add(Calendar.DAY_OF_MONTH, material.getPlazoDias());
        this.fechaDevolucion= null;
        this.estado= activo;
        this.diasRetraso= 0;
        this.multa= 0;
>>>>>>> adb1f3704362752a8e3ed821d6902f8411cb1cbe
    }
    
    public int diasRetraso(Calendar fechaAct) {
        Calendar act= fecha(fechaAct);
        int dias= 0;
        Calendar c= Calendar.getInstance();
        c.setTime(fechaPrevista.getTime());
        if (act.getTimeInMillis() <= fechaPrevista.getTimeInMillis()) {
            return 0;
        }
        while (c.getTimeInMillis() < act.getTimeInMillis()) {
            c.add(Calendar.DAY_OF_MONTH, 1);
            dias++;
        }
        return dias;
    }

    public boolean registrarDevolucion() {
        return registrarDevolucion(Calendar.getInstance());
    }


    public boolean registrarDevolucion(Calendar fechaAct) {
       if (isActivo() == false) {
            return false;
        }
        this.fechaDevolucion= fecha(fechaAct);
        this.diasRetraso= diasRetraso(fechaAct);
        this.multa= material.calcularMulta(diasRetraso);
        this.estado= devuelto;
        this.material.setDisponible(true);
        return true;
    }
    
    private static Calendar fecha(Calendar c) {
        Calendar temp= Calendar.getInstance();
        temp.setTime(c.getTime());
        temp.set(Calendar.HOUR_OF_DAY, 0);
        temp.set(Calendar.MINUTE, 0);
        temp.set(Calendar.SECOND, 0);
        temp.set(Calendar.MILLISECOND, 0);
        return temp;
    }

    public boolean isActivo() {
        return activo.equals(estado);
    }

    public MaterialBibliografico getMaterial() {
        return material;
    }

    public Calendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Calendar getFechaPrevista() {
        return fechaPrevista;
    }

    public Calendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    public double getMulta() {
        return multa;
    }
}