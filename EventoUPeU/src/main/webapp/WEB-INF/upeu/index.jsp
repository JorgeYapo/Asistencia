<%-- 
    Document   : index
    Created on : 08/02/2018, 11:02:27 AM
    Author     : Docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="req" value="${pageContext.request}"/>
        <c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}"/>
        
        <h1>Hello World! Clase</h1>
        <h1><c:out value="${baseURL}" /></h1>
        <center>
            <c:set var="count" value="0" scope="page"/>
            <c:set var="countx" value="0" />
            <c:if test="${!empty ListaUsuario}">
        <table border="1">
            <c:forEach items="${ListaUsuario}" var= "dato">
           
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:set var="countx" value="${countx + 1}"/>
            <c:if test="${count!=2}">
                <tr >
            </c:if>    
                <td style="text-align: center">
                    <c:out value="${dato.apellidos}" />, <c:out value="${dato.nombres}" /><br/>
                    <img src="${baseURL}/GeneradorQR?dni=${dato.dnicodigo}"/>
                </td>

            <c:if test="${count==2}">
                </tr>
                <c:set var="count" value="0" scope="page"/>
            </c:if>
                <c:if test="${(countx==ListaUsuario.size()) && (count==1) }">
                    </tr>
                </c:if>
            </c:forEach> 
        </table>
            </c:if>    
            </center>
    </body>
</html>
