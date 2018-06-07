<%-- 
    Document   : formPeriodo
    Created on : 23-jun-2015, 10:23:00
    Author     : SistemasUpeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

     <%@include file="../header.jsp" %>       
    </head>
  <body  class="hold-transition skin-blue sidebar-mini">
      <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
            <%@include file="../menu.jsp" %>           
        <div class="content-wrapper">
        <div class="content">
        <div>
            <c:url var="savedientex"  value="guardarUsuario" />
            <fm:form modelAttribute="modeloUsuario" method="post" action="${savedientex}">
                <table>
                    <tr>
                        <td><fm:label path="imagen">Imagen</fm:label> </td>
                        <td><fm:input path="imagen" /></td>
                    </tr>
                    <tr>
                        <td><fm:label path="codigo">Codigo</fm:label> </td>
                        <td><fm:input path="codigo" size="60" /></td>
                    </tr>
                    
                    <tr>
                        <td><fm:label path="nombre">Nombre</fm:label> </td>                        
                        <td><fm:input path="nombre" size="60" /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="tipoDiente">Tipo Diente</fm:label> </td>
                        <td>
                        <fm:select path="tipoDiente">
                            <fm:option value="Adult">Adulto</fm:option>
                            <fm:option value="Ninho">Niño</fm:option>
                        </fm:select>
                            
                        </td>
                    </tr>
                    
                    <tr>                        
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>         
        </div>
        </div>               
        </div> 
        
            <%@include file="../footer.jsp" %>        
        </div>
            <%@include file="../footerscript.jsp" %>            
    </body>
</html>
