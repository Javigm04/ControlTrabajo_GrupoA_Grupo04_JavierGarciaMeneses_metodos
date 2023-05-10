package PaqG04;

import java.io.Serializable;
import java.util.Objects;

public class Hub implements Serializable {

    Contenedor[][] contenedores;

    public Hub(int filas, int columnas){
        contenedores=new Contenedor[filas][columnas];
    }

    public Contenedor getContenedor(int fila, int columna){
        if(fila<0 || fila> contenedores.length || columna<0 || columna> contenedores[0].length){
            return null;
        }
        return contenedores[fila][columna];
    }

    public String toString(){
       String resultado="";
        for(int f=0;f<contenedores.length;f++){
            for(int c=0;c<contenedores[f].length;c++){
                if(contenedores[f][c]==null){
                    resultado+="L ";
                }else{
                    resultado+="O ";
                }
            }
            resultado+="\n";
        }
        return resultado;
    }
    public boolean apilarContenedor(Contenedor contenedor) {
            if (contenedor.prioridad == 1) {
                    for (int f = contenedores.length-1; f >= 0; f--) {
                        if (contenedores[f][0] == null) {
                            contenedores[f][0] = contenedor;
                            return true;
                        }
                    }
                return false;
            }
            if (contenedor.prioridad == 2) {
                        for (int f = contenedores.length-1; f >= 0; f--) {
                            if (contenedores[f][1] == null) {
                                contenedores[f][1] = contenedor;
                                return true;
                            }
                        }
                    return false;
                }
            for (int c = 2; c < contenedores[0].length; c++) {
                    for (int f = contenedores.length - 1; f >= 0; f--) {
                        if (contenedores[f][c] == null) {
                            contenedores[f][c] = contenedor;
                            return true;
                        }
                    }
                }
            return false;
            }

            public boolean desapilar(int columna) {
                if (columna < 0 || columna > contenedores[0].length) {
                    return false;
                }
                for (int f = 0; f < contenedores.length; f++) {
                    if (contenedores [f][columna] != null) {
                        contenedores[f][columna] = null;
                        return true;
                    }
                }
                return false;
            }
            public String mostrarDatos(int id){
                String resultado="";
                for(int f=0;f< contenedores.length; f++){
                    for (int c = 0; c < contenedores[f].length; c++) {
                        if(contenedores[f][c]!=null){
                            if(contenedores[f][c].id==id){
                                resultado+="Id: "+contenedores[f][c].id+"\n";
                                resultado+="Peso: "+contenedores[f][c].peso+"\n";
                                resultado+="Pais: "+contenedores[f][c].pais+"\n";
                                resultado+="Control de aduanas: "+contenedores[f][c].aduanas+"\n";
                                resultado+="Prioridad: "+contenedores[f][c].prioridad+"\n";
                                resultado+="Descripción: "+contenedores[f][c].descripcion+"\n";
                                resultado+="Empresa que lo envía: "+contenedores[f][c].empresaEnvia+"\n";
                                resultado+="Empresa que lo recibe: "+contenedores[f][c].empresaRecibe+"\n";
                                return resultado;
                        }
                    }
                    }
                }
                return "0";
    }
    public int calcularContenedoresDeterminadoPais(String pais){
        int cont=0;
        for(int f=0;f< contenedores.length; f++){
            for (int c = 0; c < contenedores[f].length; c++) {
                if(contenedores[f][c]!=null) {
                    if (Objects.equals(contenedores[f][c].pais, pais)) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }
}
