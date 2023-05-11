package PaqG04;

import java.io.Serializable;
import java.util.Objects;

public class Hub implements Serializable {

    private Contenedor[][] contenedores;

    public Hub(int filas, int columnas) {
        contenedores = new Contenedor[filas][columnas];
    }

    public Contenedor getContenedor(int fila, int columna) {
        if (fila < 0 || fila > contenedores.length || columna < 0 || columna > contenedores[0].length) {
            return null;
        }
        return contenedores[fila][columna];
    }

    public String toString() {
        String resultado = "";
        for (int f = 0; f < contenedores.length; f++) {
            for (int c = 0; c < contenedores[f].length; c++) {
                if (contenedores[f][c] == null) {
                    resultado += "L ";
                } else {
                    resultado += "O ";
                }
            }
            resultado += "\n";
        }
        return resultado;
    }

    public boolean apilarContenedor(Contenedor contenedor) {
        if (contenedor.getPrioridad() == 1) {
            for (int f = contenedores.length - 1; f >= 0; f--) {
                if (contenedores[f][0] == null) {
                    contenedores[f][0] = contenedor;
                    return true;
                }
            }
            return false;
        }
        if (contenedor.getPrioridad() == 2) {
            for (int f = contenedores.length - 1; f >= 0; f--) {
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
            if (contenedores[f][columna] != null) {
                contenedores[f][columna] = null;
                return true;
            }
        }
        return false;
    }

    public String mostrarDatos(int id) {
        String resultado = "";
        for (int f = 0; f < contenedores.length; f++) {
            for (int c = 0; c < contenedores[f].length; c++) {
                if (contenedores[f][c] != null) {
                    if (contenedores[f][c].getId() == id) {
                        resultado += "Id: " + contenedores[f][c].getId()+ "\n";
                        resultado += "Peso: " + contenedores[f][c].getPeso() + "\n";
                        resultado += "Pais: " + contenedores[f][c].getPais() + "\n";
                        resultado += "Control de aduanas: " + contenedores[f][c].isAduanas() + "\n";
                        resultado += "Prioridad: " + contenedores[f][c].getPrioridad() + "\n";
                        resultado += "Descripción: " + contenedores[f][c].getDescripcion() + "\n";
                        resultado += "Empresa que lo envía: " + contenedores[f][c].getEmpresaEnvia() + "\n";
                        resultado += "Empresa que lo recibe: " + contenedores[f][c].getEmpresaRecibe() + "\n";
                        return resultado;
                    }
                }
            }
        }
        return "0";
    }

    public int calcularContenedoresDeterminadoPais(String pais) {
        int cont = 0;
        for (int f = 0; f < contenedores.length; f++) {
            for (int c = 0; c < contenedores[f].length; c++) {
                if (contenedores[f][c] != null) {
                    if (Objects.equals(contenedores[f][c].getPais(), pais)) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }

    //Metodo de buscar contenedores según la prioridad en un hub
    public String buscarContenedoresPrioridad(int prioridad) {
        String resultado = "";        //Inicializo el valor a devolver
        for (int c = 0; c < contenedores[0].length; c++) {      //Como la fila a comprobar es la base del hub, solo recorró las columnas
            if (this.contenedores[contenedores.length - 1][c] != null) {      //Comprubo que el contenedor no sea nulo
                if (this.contenedores[contenedores.length - 1][c].getPrioridad() == prioridad) {      //Comprubo si el contenedor tiene la misma prioridad que la pasada a la función
                    resultado += "Id:" + this.contenedores[contenedores.length - 1][c].getId() + "| Empresa remitente:" +
                            this.contenedores[contenedores.length - 1][c].getEmpresaEnvia() + "| Peso: " +
                            this.contenedores[contenedores.length - 1][c].getPeso() + "| Aduana:" +
                            this.contenedores[contenedores.length - 1][c].isAduanas() + "\n";       //Meto los datos del contenedor en la variable
                }
            }
        }
        return resultado;       //Devuelvo el resultado
    }
}