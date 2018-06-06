<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <title> MVC Spring UPeU</title>  
            <%@include file="../header.jsp" %>                         
  </head>
  <body  class="hold-transition skin-blue sidebar-mini">
      <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
            <%@include file="../menu.jsp" %>           
        <div class="content-wrapper">
        <div class="content">
          
          
          
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  
                  
                          
        <c:out value="${saludo}"/>

        
        
        <div id="idFormulario" align="center">
            
        <form  id="formBuscar" action="buscarEventox"  method="post" name="formBuscar" >
        <table align="center"  class="myform">
        
        <tr align="center">
        &nbsp;&nbsp;
        <td  style="color:black">
        Periodo <input type="text" class="myinput" id="dato" size="50" name="dato"  value="">
        
        <input  type="submit"  class="button2" value="Buscar" >&nbsp;
        </td>
        <td>
            <input  type="button" value="Nuevo" onclick="document.location.href='${pageContext.request.contextPath}/formEvento'" class="btn btn-success" >&nbsp;   
        </td>

        </tr>
        </table>
        </form>
        </div> 
        
        

                  
                  
                  
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                          <c:if test="${!empty ListaEvento}">
                            <table >
                                <tr style="align-content: center">
                                    <th>Nombre</th>
                                    <th>Lugar</th>
                                    <th>Fecha</th>
                                    <th>Hora Inicio</th>
                                    <th>Coordenadas</th>
                                    <th>Opciones</th>

                                </tr>

                                <c:forEach items="${ListaEvento}" var= "dato">   
                                <tr>
                                    <td><c:out value="${dato.nombreevento}"/></td>
                                    <td><c:out value="${dato.lugarevento}"/></td>
                                    <td><c:out value="${dato.fecha}"/></td>
                                    <td><c:out value="${dato.horainicio}"/></td>                                    
                                    <td><c:out value="${dato.latitud}"/>; <c:out value="${dato.longitud}"/></td>                                    
                                    
                                    <td>
                                        <a href="eliminarEvento?id=${dato.idEvento}">Eliminar</a>&emsp14;
                                        <a href="modificarEventoX?id=${dato.idEvento}">Modificar</a>
                                    </td>

                                </tr>
                                </c:forEach>
                            </table>

                         
                        </c:if>
              </div>
          </div>
        
        
        
        </div>               
        </div> 
        
            <%@include file="../footer.jsp" %>        
        </div>
            <%@include file="../footerscript.jsp" %>
  </body>
</html>