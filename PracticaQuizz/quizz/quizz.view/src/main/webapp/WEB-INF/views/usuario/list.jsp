<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>
	<legend>Listado de Usuarios</legend>
	<div class="botonera">
		<input type="button" value="Alta" onclick="javascript:generic.get('usuario/form');" />
	</div>
	<table class="table-bordered table-striped table-condensed cf">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Email</th>
				<th>Usuario</th>
				<th>Es admin</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.nombre}</td>
					<td>${usuario.apellidos}</td>
					<td>${usuario.email}</td>
					<td>${usuario.usuario}</td>
					<td>${usuario.admin}</td>
					<td>
						<input type="button" value="Modificar" onclick="javascript:generic.get('usuario/${usuario.id}');" /> 
						<input type="button" value="Eliminar" onclick="javascript:generic.delete('usuario/${usuario.id}');" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</fieldset>
