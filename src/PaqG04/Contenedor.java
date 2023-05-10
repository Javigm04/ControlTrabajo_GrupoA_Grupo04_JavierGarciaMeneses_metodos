package PaqG04;

import java.io.Serializable;

public class Contenedor implements Serializable {
    int id;
    double peso;
    String pais;
    boolean aduanas;
    int prioridad;
    String descripcion;
    String empresaEnvia;
    String empresaRecibe;
    public Contenedor(int id,double peso,String pais,boolean aduanas,int prioridad,String descripcion,String empresaEnvia,String empresaRecibe){
        this.id=id;
        if(peso>0)this.peso=peso;
        if(pais!=null)this.pais=pais;
        this.aduanas=aduanas;
        if(prioridad>0 && prioridad<=3)this.prioridad = prioridad;
        if(descripcion!=null)this.descripcion=descripcion;
        if(empresaEnvia!=null)this.empresaEnvia=empresaEnvia;
        if(empresaRecibe!=null)this.empresaRecibe=empresaRecibe;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPeso(double peso) {
        if(peso>0)this.peso=peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPais(String pais) {
        if(pais!=null)this.pais=pais;
    }

    public String getPais() {
        return pais;
    }

    public boolean isAduanas() {
        return aduanas;
    }

    public void setPrioridad(int prioridad) {
        if(prioridad>0 && prioridad<=3)this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion!=null) {
            this.descripcion = descripcion;
        }
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setEmpresaEnvia(String empresaEnvia) {
        if(empresaEnvia!=null)this.empresaEnvia=empresaEnvia;
    }
    public String getEmpresaEnvia() {
        return empresaEnvia;
    }

    public void setEmpresaRecibe(String empresaRecibe) {
        if(empresaRecibe!=null)this.empresaRecibe=empresaRecibe;
    }

    public String getEmpresaRecibe() {
        return empresaRecibe;
    }




}