<%-- 
    Document   : verPersonas
    Created on : 27 mar. 2023, 16:45:03
    Author     : Alex
--%>
<%@page import="java.util.List" %>
<%@page import="logica.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver personas</title>
    </head>
    <body>
        
        <h1>Lista de Personas</h1>
        <!--Para establecer el código Java en el HTML, usamos la apertura y cierre con % -->
        
        <% 
            //de esta forma obtenemos la info que quedo en la sesion de usuario. 
            List <Persona> listaPersonas = (List) request.getSession().getAttribute("listaPersonas");
            
            //Ahora traemos la lista de personas, y con un bucle "for of" las mostramos:
            for (Persona per : listaPersonas) {
            //Observar que no cerraomos el for, no tieen llave de cierre:
            //Eso es porque el codigo html debajo se va a ejecutar DENTRO del for
            //Por lo que debemos cerrar el for cuando terminemos con el html
            //Eso lo hacemos con las etiquetas especiales de Java y poniendo la llave de cierre
        %>
        
            <p><b>DNI: </b><%=per.getDni()%></p>
            <p><b>Nombre: </b><%=per.getNombre()%></p>
            <p><b>Apellido: </b><%=per.getApellido()%></p>
            <p><b>Telefono: </b><%=per.getTelefono()%></p>
            <br>
        
        <%
            } 
        %>
        
    </body>
</html>
