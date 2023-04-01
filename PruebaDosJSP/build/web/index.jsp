<%-- 
    Document   : index
    Created on : 21/03/2023, 14:05:48
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de prueba</title>
    </head>
    <body>
        
        <h1>Datos de la persona</h1>
        <form action="SVPersona" method="POST">
            <p><label>Dni: </label> <input type="text" name="dni"></p>
            <p><label>Nombre: </label> <input type="text" name="nombre"></p>
            <p><label>Apellido: </label> <input type="text" name="apellido"></p>
            <p><label>Telefono: </label> <input type="text" name="telefono"></p>
            <button type="submit">Enviar </button>
        </form>
        
        <h2>Ver lista de personas</h2>
        <p>Si desea ver la lista de personas, haga click en el boton 'Mostrar Personas'</p>
        <form action="SVPersona" method="GET">
            <button type="submit">Mostrar Personas</button>
        </form>
        
        <h2>Eliminar persona</h2>
        <p>Ingrese el id de la persona a eliminar: </p>
        <form action="SVEliminarPersona" method="POST">
            <p><label>Id: </label><input type="text" name="id_elim"></p>
            <button type="submit">Eliminar</button>
        </form>
        
    </body>
</html>
