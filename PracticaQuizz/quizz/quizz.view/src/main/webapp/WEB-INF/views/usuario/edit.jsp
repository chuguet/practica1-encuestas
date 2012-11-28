<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form id="edicion" modelAttribute="usuario" action="javascript:generic.post('usuario/${usuario.id}', generic.getParamsUsuario());">
	<fieldset>
		<form:hidden path="id" />
		<legend>Edici&oacute;n de Usuario</legend>
		<p>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" maxlength="200" />
		</p>
		<p>
			<form:label path="apellidos">Apellidos:</form:label>
			<form:input path="apellidos" />
		</p>
		<p>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
		</p>
		<p>
			<form:label path="usuario">Usuario: </form:label>
			<form:input path="usuario" />
		</p>
		<p>
			<form:label path="pwd">Contrase&ntilde;a: </form:label>
			<form:input path="pwd" />
		</p>
		<p>
			<form:label path="admin">Es administrador: </form:label>
			<form:checkbox path="admin" value="1"></form:checkbox>
		</p>
		<div class="botonera">
			<input type="submit" value="Modificar" /> <input type="button" value="Cancelar" onclick="javascript:generic.get('usuario');" />
		</div>
	</fieldset>
</form:form>
