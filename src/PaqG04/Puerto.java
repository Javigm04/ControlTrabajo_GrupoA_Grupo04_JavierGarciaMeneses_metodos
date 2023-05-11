//Javier García Meneses
//Grupo: A, G04
package PaqG04;

import java.io.Serializable;

public class Puerto implements Serializable {
    private Hub[] hubs;

    public Puerto(){
        //Inicializo los hubs
        hubs=new Hub[3];
        for(int i=0;i<3;i++){
            hubs[i]=new Hub(10,12);
        }
    }

    public String toString(){
        String resultado="";
        for(int i=0;i<3;i++){
            resultado+=hubs[i].toString()+"\n";
        }
        return resultado;
    }

    public String apilar(Contenedor contenedor){
        for(int i=0;i<3;i++){
            if(hubs[i].apilarContenedor(contenedor)){
                return "El contenedor ha sido apilado con éxito";
            }
        }
        return "Los hubs están llenos para la prioridad "+contenedor.getPrioridad();
    }
    public String desapilar(int nHub,int columna){
        if(hubs[nHub].desapilar(columna)) {
            return "El contenedor ha sido desapilado con éxito";
        }
        return "No hay ningún contenedor en la columna "+columna+" del hub "+nHub;
    }
    public String mostrarDatos(int nHub, int id){
        String resultado=hubs[nHub].mostrarDatos(id);
        if(resultado.equals("0")){
            return "No existe ningún contenedor con el id "+id+" en el hub "+nHub;
        }
        return "Hub: "+nHub+"\n"+resultado;
    }
    public String calcularNumeroContenedoresDeUnPais(int nHub, String pais){
        int resultado=hubs[nHub].calcularContenedoresDeterminadoPais(pais);
        return "En el hub "+nHub+" hay "+resultado+" contenedores del país "+pais;
    }
    //Metodo de buscar contenedores según la prioridad en el puerto
    public String BuscarContenedoresPrioridad(int prioridad) {
        String resultado = "";        //Inicializo el resultado
        for (int i = 0; i < 3; i++) {       //Recorro el puerto
            resultado += hubs[i].buscarContenedoresPrioridad(prioridad);      //Añado los contenedores a la variable
        }
        if(resultado.equals("")){       //Compruebo si el resultado tiene almacenado algún contenedor
            return "No hay ningún contenedor de prioridad "+prioridad+" en el puerto";      //Si no lo tiene es porque no hay ningún contenedor con esa prioridad en el puerto y se lo hago saber al usuario
        }
        return resultado;       //Si se han encontrado contenedores con esa prioridad, los devuelvo
    }
}
