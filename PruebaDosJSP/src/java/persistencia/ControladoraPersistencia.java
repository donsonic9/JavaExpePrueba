
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Persona;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    //El proposito de esta clase es poder controlar la logica, sin depender de otras partes del programa.
    //Llamando al controller que haga falta cuando sea necesario.
    //En este caso solo tiene que lidiar con 1 controller, pero podrian ser mas.
    
    PersonaJpaController persJPA = new PersonaJpaController();
    
    //crea una persona.
    public void crearPersona (Persona per) {
        
        persJPA.create(per);
        
    }
    
    //se recomienda hacer 2 metodos eliminar, uno con dni y otro con id.
    public void eliminarPersona(int id) {
        try{
            persJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            String msg="Not found bro.";
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, msg);
        }
    }
    
    public void eliminarPersona (Persona pers) {
        try {
            persJPA.destroy(pers.getId());
        } catch (NonexistentEntityException ex) {
            String msg="Not found bro.";
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, msg);
        }
    }
    
    //Con este mostramos la lista de personas, que son Entitys.
    public List<Persona> traerPersonas () {
        return persJPA.findPersonaEntities();
    }
    
    
    
}
