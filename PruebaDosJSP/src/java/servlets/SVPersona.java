package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import logica.Controladora;
import logica.Persona;

/**
 *
 * @author Alex
 */
@WebServlet( name = "SVPersona", urlPatterns = {"/SVPersona"})
public class SVPersona extends HttpServlet {

    //Para poder mandar los datos de la persona, creamos una nueva Controladora:
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Como no podemos pasar la informacion asi nomas, debemos trabajar con sesiones.
        //El cliente inicia sesion, y esa info se queda guardada en la web.
        //Lo que hacemos es pasar esa sesion de servlet en servlet, o jsp a jsp a como necesitemos.
        //para hacer eso, trabajamos con un metodo especial de HTTP:
        
        //creamos un List de Persona para poder traer la lista de personas:
        List <Persona> listaPersonas = control.traerPersonas();
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("listaPersonas", listaPersonas);
        
        //Por ultimo agregamos la redireccion con el response al "verPersonas"
        response.sendRedirect("verPersonas.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
                //aca tenemos que poner las mismas variables del form para poder procesarlas con el servlet:

                String dni = request.getParameter("dni");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String telefono = request.getParameter("telefono");

                //Por ultimo, luego de haber creado toda la logica, las controladoras, la persistencia y demas
                //Podemos crear los metodos para crear las personas.
                
                Persona pers = new Persona(0, dni, nombre, apellido, telefono);
                control.crearPersona(pers);
                //esto se manda a la persistencia, y de ahi al JPA.
                
                // y como respuesta, para devovlernos a la pagina del formulario, si todo salio bien:
                response.sendRedirect("index.jsp");
                
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
