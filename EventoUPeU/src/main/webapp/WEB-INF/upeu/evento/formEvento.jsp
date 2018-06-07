<%-- 
    Document   : formPeriodo
    Created on : 23-jun-2015, 10:23:00
    Author     : SistemasUpeu
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

     <%@include file="../header.jsp" %>  
<style type="text/css">
      #google_map {width: 650px; height: 400px;margin-top:5px;margin-left:auto;margin-right:auto;}
      
      .mapControl {
        width: 100px;
        height: 12px;
        background-color: #FFFFFF;
        border-style: solid;
        border-width: 1px;
        padding: 2px 5px;
        }
    </style>
    <script type="text/javascript"
     src="//maps.googleapis.com/maps/api/js?key=AIzaSyB73Tu5Fwh4BqzKlDG1qLQ258Mc_QlJpnk&sensor=false">
    </script>
    <script type="text/javascript">

      var mapCenter = new google.maps.LatLng(-12.0510,-77.0229); //Google map Coordinates
      var map;
      function initialize() //function initializes Google map
      {
        var googleMapOptions =
        {
            center: mapCenter, // map center
            zoom: 15, //zoom level, 0 = earth view to higher value
            panControl: true, //enable pan Control
            zoomControl: true, //enable zoom control
            zoomControlOptions: {
                style: google.maps.ZoomControlStyle.SMALL //zoom control size
             },
            scaleControl: true, // enable scale control
            mapTypeId: google.maps.MapTypeId.ROADMAP // google map type
        };
        map = new google.maps.Map(document.getElementById("google_map"), googleMapOptions);
        
        //Defining control parameters
        var controlDiv = document.createElement('div');
        var controlTextLat = document.getElementById('idLat');
        var controlTextLnt = document.getElementById('idLnt');
        
        controlDiv.className = 'mapControl';
        controlDiv.id = 'mapCoordinates';
        controlDiv.innerHTML = 'Lat/Lng: 0.00 / 0.00';      

        //Creating a control and adding it to the map.
        map.controls[google.maps.ControlPosition.LEFT_BOTTOM].
        push(controlDiv);  

        //Listening the map for mousemove event to show it in control.
        google.maps.event.addListener(map, 'mousemove', function(e) {
        var coordinateText = 'Lat/Lng: ' +
        e.latLng.lat().toFixed(6) + ' / ' +
        e.latLng.lng().toFixed(6);
        controlDiv.innerHTML = coordinateText;
//        controlTextLat.value=e.latLng.lat().toFixed(6);
//        controlTextLnt.value=e.latLng.lng().toFixed(6);
        });
              
        //Listening the map for mousemove event to show it in control.
        google.maps.event.addListener(map, 'rightclick', function(e) {
            e.latLng.lat().toFixed(6) + ' / ' +
            e.latLng.lng().toFixed(6);
            
            controlTextLat.value=e.latLng.lat().toFixed(6);
            controlTextLnt.value=e.latLng.lng().toFixed(6);            
            addMyMarker(e.latLng.lat().toFixed(6),e.latLng.lng().toFixed(6));
        });              
              

    
        }




        function addMyMarker(lat, lng) { //function that will add markers on button click
            var marker = new google.maps.Marker({                
                position: new google.maps.LatLng(lat, lng),
                map: map,
                draggable:true,
                animation: google.maps.Animation.DROP,
                title:"This a new marker!",
              icon: "http://maps.google.com/mapfiles/ms/micons/blue.png"
            });
            
            
        var contentString = '<div id="content">'+
             '<div id="siteNotice">'+
             '</div>'+
             '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
             '<div id="bodyContent">'+
             '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
             'sandstone rock formation in the southern part of the '+
             'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
             'south west of the nearest large town, Alice Springs; 450&#160;km '+
             '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
             'features of the Uluru - Kata Tjuta National Park. Uluru is '+
             'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
             'Aboriginal people of the area. It has many springs, waterholes, '+
             'rock caves and ancient paintings. Uluru is listed as a World '+
             'Heritage Site.</p>'+
             '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
             'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
             '(last visited June 22, 2009).</p>'+
             '</div>'+
             '</div>';

         var infowindow = new google.maps.InfoWindow({
           content: contentString
         });            
         marker.addListener('click', function() {
           infowindow.open(map, marker);
         });            
        }
    </script>     
    </head>
  <body  class="hold-transition skin-blue sidebar-mini" onLoad="initialize()">
      <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
        <%@include file="../menu.jsp" %>           
        <div class="content-wrapper">
        <div class="content">
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Formulario de Registro de Eventos</span></div>
              <div class="tablecontainer">
           
                  
                  
      <c:url var="saveeventox"  value="guardarEvento" />
      <table>
          <tr>
              <td>
                  
        <fm:form modelAttribute="modeloEvento" method="post" action="${saveeventox}" >
                <table>
                    <tr>
                        <td><fm:label path="nombreevento">Nombre Evento</fm:label> </td>
                        <td><fm:input path="nombreevento" /></td>
                    </tr>
                    <tr>
                        <td><fm:label path="lugarevento">Lugar Evento</fm:label> </td>
                        <td><fm:input path="lugarevento" size="40" /></td>
                    </tr>
                    
                    <tr>
                        <td><fm:label path="fecha">Fecha</fm:label> </td>                        
                        <td><fm:input path="fecha"  /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="horainicio">H. Inicio</fm:label> </td>                        
                        <td><fm:input path="horainicio"  /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="horafin">H. Fin</fm:label> </td>                        
                        <td><fm:input path="horafin"  /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="tiempotolerancia">T. Tolerancia</fm:label> </td>                        
                        <td><fm:input path="tiempotolerancia"  /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="latitud">Latitud:</fm:label> </td>                        
                        <td><fm:input path="latitud"  id="idLat" /></td>
                    </tr>                                     
                    <tr>
                        <td><fm:label path="longitud">Longitud:</fm:label> </td>                        
                        <td><fm:input path="longitud" id="idLnt" /></td>
                    </tr>                                     

                    
                    <tr>                        
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>                   
              </td>
              <td><div id="google_map" ></div></td>
          </tr>
          
      </table>              
            
            
            
            
            
        </div>
        </div>
        </div>               
        </div> 
        
            <%@include file="../footer.jsp" %>        
        </div>
            <%@include file="../footerscript.jsp" %>            
    </body>
</html>