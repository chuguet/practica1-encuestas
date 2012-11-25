<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>
	<legend>Listado de Encuestas</legend>
	<div class="botonera">
		<input type="button" value="Alta" onclick="javascript:generic.get('encuesta/form');" />
	</div>
	<table class="table-bordered table-striped table-condensed cf">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Fecha de Inicio</th>
				<th>Fecha de Fin</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="encuesta" items="${encuestas}">
				<tr>
					<td>${encuesta.nombre}</td>
					<td>${encuesta.fecha_inicio}</td>
					<td>${encuesta.fecha_fin}</td>
					<td>
					<input type="button" value="Modificar" onclick="javascript:generic.get('encuesta/${encuesta.id}');" /> 
					<input type="button" value="Eliminar" onclick="javascript:generic.delete('encuesta/${encuesta.id}');" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</fieldset>