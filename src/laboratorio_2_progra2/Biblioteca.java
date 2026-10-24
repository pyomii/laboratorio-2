package laboratorio_2_progra2;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;

public class Biblioteca {

    private ArrayList<MaterialBibliografico> materiales;
    private ArrayList<Prestamo> prestamos;
    private String mensaje;

    public Biblioteca() {
        materiales= new ArrayList<MaterialBibliografico>();
        prestamos= new ArrayList<Prestamo>();
        mensaje= "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean registrar(MaterialBibliografico material) {
        if (material== null) {
            mensaje= "Error! todas las casillas deben estar llenadas...";
            return false;
        }
        String codigo= material.getCodigo();
         if (codigo == null || codigo.trim().isEmpty()) {
            mensaje= "Error! todas las casillas deben estar llenadas...";
            return false;
        }
        String titulo= material.getTitulo();
        if (titulo == null || titulo.trim().isEmpty()) {
            mensaje= "Error! todas las casillas deben estar llenadas...";
            return false;
        }
        int anioActual= Calendar.getInstance().get(Calendar.YEAR);
        if (material.getAnio() < 1000 || material.getAnio() > anioActual) {
           mensaje = "El año debe estar entre 1000 y " + anioActual + "...";
            return false;
        }
        if (buscarCodigo(codigo, 0)!= null) {
            mensaje= "Ya existe un material con el codigo " + codigo + "...";
            return false;
        }
        materiales.add(material);
        mensaje= "Material registrado correctamente...";
        return true;
    }

    public MaterialBibliografico buscarCodigo(String codigo, int indice) {
        if (codigo == null || indice >= materiales.size()) {
        return null;
        }
        if (materiales.get(indice).getCodigo().equalsIgnoreCase(codigo.trim())) {
            return materiales.get(indice);
        }
        return buscarCodigo(codigo, indice + 1);
    }

    public MaterialBibliografico consultar(String codigo) {
        MaterialBibliografico m= buscarCodigo(codigo, 0);
        if (m== null) {
            mensaje= "El codigo " + codigo + " no se encuentra registrado...";
        } else {
            mensaje= "Material encontrado: " + m.toString();
        }
        return m;
    }

    public Prestamo prestar(String codigo) {
        MaterialBibliografico material = buscarCodigo(codigo, 0);
        if (material== null) {
            mensaje= "No existe un material con el codigo " + codigo + "...";
            return null;
        }
      if (material.isDisponible() == false) {
            mensaje = "\"" + material.getTitulo() + "\" no esta disponible...";
            return null;
        }
        Prestamo prestamo= new Prestamo(material);
        material.setDisponible(false);
        prestamos.add(prestamo);
        mensaje= "Prestamo registrado \nFecha prevista de devolucion: " + fecha(prestamo.getFechaPrevista());
        return prestamo;
    }

    public Prestamo devolver(String codigo) {
        return devolver(codigo, Calendar.getInstance());
    }
    
    public Prestamo devolver(String codigo, Calendar fechaReal) {
        MaterialBibliografico material = buscarCodigo(codigo, 0);
        if (material== null) {
            mensaje= "No existe un material con el codigo " + codigo + ".";
            return null;
        }
        Prestamo prestamo = buscarPrestamoActivo(material);
        if (prestamo== null) {
            mensaje= "El material \"" + material.getTitulo() + "\" no tiene un prestamo activo.";
            return null;
        }
         prestamo.registrarDevolucion(fechaReal);
        mensaje = "Devolucion registrada \nDias de retraso: " + prestamo.getDiasRetraso()
                + "\nMulta: " + String.format("%.2f", prestamo.getMulta()) + " €";
        return prestamo;
    }

    public Prestamo buscarPrestamoActivo(MaterialBibliografico material) {
        for (Prestamo p : prestamos) {
            if (p.getMaterial()== material && p.isActivo()) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<MaterialBibliografico> getMateriales() {
        return materiales;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<MaterialBibliografico> getMaterialesDisp() {
        ArrayList<MaterialBibliografico> disponibles= new ArrayList<MaterialBibliografico>();
        for (MaterialBibliografico m : materiales) {
            if (m.isDisponible()) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }

    public ArrayList<MaterialBibliografico> getMaterialesActivo() {
        ArrayList<MaterialBibliografico> activos= new ArrayList<MaterialBibliografico>();
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                activos.add(p.getMaterial());
            }
        }
        return activos;
    }

    private String fecha(Calendar fecha) {
        if (fecha== null) {
            return "...";
        }
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH) + 1; 
        int anio = fecha.get(Calendar.YEAR);
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }
    
    public String Recibo(Prestamo p) {
        MaterialBibliografico m = p.getMaterial();
        String recibo= "";
        if (p.isActivo()) {
            recibo+= "===== RECIBO DE PRESTAMO =====\n\n";
        } else {
            recibo+= "===== RECIBO DE DEVOLUCION =====\n\n";
        }
        recibo+= "Tipo: " + m.getTipo() + "\n";
        recibo+= "Codigo: " + m.getCodigo() + "\n";
        recibo+= "Titulo: " + m.getTitulo() + "\n";
        recibo+= "Detalle: " + m.toString() + "\n\n";
        recibo+= "Fecha de prestamo: " + fecha(p.getFechaPrestamo()) + "\n";
        recibo+= "Fecha prevista de devolucion: " + fecha(p.getFechaPrevista()) + "\n";
        if (!p.isActivo()) {
            recibo+= "Fecha de devolucion: " + fecha(p.getFechaDevolucion()) + "\n";
            recibo+= "Dias de retraso: " + p.getDiasRetraso() + "\n";
            recibo+= "Multa: " + p.getMulta() + " EUR\n";
        }
        recibo += "Estado: " + p.getEstado() + "\n";
        return recibo;
    }
}