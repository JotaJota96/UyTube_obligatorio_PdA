<%-- 
    Document   : filtro-visible
    Created on : 21/10/2019, 02:00:09 AM
    Author     : Juan
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
 Filtros ocultos
-->
<%
    ArrayList<String> opcionesFiltro = new ArrayList();
    opcionesFiltro.add("Todo");
    opcionesFiltro.add("Canales");
    opcionesFiltro.add("Videos");
    opcionesFiltro.add("Listas");
    
    ArrayList<String> opcionesOrden = new ArrayList();
    opcionesOrden.add("Alfabético");
    opcionesOrden.add("Fecha");
    
    String opcionFiltroSeleccionado = (String) request.getParameter("filtro");
    if (opcionFiltroSeleccionado == null){
        opcionFiltroSeleccionado = "Todo";
    }
    String opcionOrdenSeleccionado = (String) request.getParameter("orden");
    if (opcionOrdenSeleccionado == null){
        opcionOrdenSeleccionado = "Fecha";
    }
%>
<div>                                       
    <div class="form-row">
        <div class="form-group col-md-3">
            <label for="inputState">Filtrar por</label>
            <select id="inputState" class="form-control" name="filtro" form="formBuscar">
                <%                    
                    for (String s : opcionesFiltro){
                        String selected = "";
                        if (opcionFiltroSeleccionado.equals(s)){
                            selected = "selected";
                        }
                %>
                <option <%= selected %>><%= s %></option>
                <%}%>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label for="inputState">Ordenar por</label>
            <select id="inputState" class="form-control" name="orden" form="formBuscar" >
                <%                    
                    for (String s : opcionesOrden){
                        String selected = "";
                        if (opcionOrdenSeleccionado.equals(s)){
                            selected = "selected";
                        }
                %>
                <option <%= selected %>><%= s %></option>
                <%}%>
            </select>
        </div>
        <div class="form-group col-md-6">
        </div>
    </div> 
</div>

