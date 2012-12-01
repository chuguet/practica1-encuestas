<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset id="parent">
	<legend>Listado de Encuestas</legend>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" onclick="javascript:generic.getForm('encuesta');" />
		<input type="button" id="btnEditar" value="Editar" onclick="javascript:generic.getForm('encuesta', $('#lista').jqGrid('getRowData', encuesta.rowID).id);" disabled="true" />
		<input type="button" id="btnEliminar" value="Eliminar" onclick="javascript:generic.delete('encuesta', $('#lista').jqGrid('getRowData', encuesta.rowID).id);" disabled="true" />
	</div>
	<table id="lista" ></table>
	<div id=paginadorLista></div>
</fieldset>

<script type="text/javascript">
usuario.formatList();
function showInformationIntoView(information){
	$("#lista").setGridParam({
		data : information
	}).trigger("reloadGrid");
};
</script>