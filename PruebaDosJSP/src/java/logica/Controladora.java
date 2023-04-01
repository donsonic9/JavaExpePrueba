
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

/* Esta es la que nos va a hacer de intermediario entre la lógica con la persona
Esta controladora estara conectada a la controladora de la persistencia.

*/

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Con este metodo, se llama a la controladora de persistencia, que es donde esta toda la logica.
    //Llama al metodo de crear persona
    public void crearPersona(Persona per) {
        controlPersis.crearPersona(per);
    }
    
    //Con este se llama al metodo de eliminar persona de ControladoraPersistencia.
    public void eliminarPersona(Persona pers) {
        controlPersis.eliminarPersona(pers);
    }
    
    //Con este lo mismo, solo que por el id.
    public void eliminarPersona(int id) {
        controlPersis.eliminarPersona(id);
    }
    
    //Llama al metodo para traer personas de la controladora de persistencia.
    public List<Persona> traerPersonas() {
        return controlPersis.traerPersonas();
    }
}
