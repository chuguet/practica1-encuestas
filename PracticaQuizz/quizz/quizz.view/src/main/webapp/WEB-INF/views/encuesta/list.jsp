<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<fieldset id="parent">
	<legend>Listado de Encuestas</legend>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" onclick="javascript:generic.getForm('encuesta');" />
		<input type="button" id="btnEditar" value="Editar" onclick="javascript:generic.getForm('encuesta', $('#lista').jqGrid('getRowData', rowID).id);" disabled="true" />
		<input type="button" id="btnEliminar" value="Eliminar" onclick="javascript:generic.delete('encuesta', $('#lista').jqGrid('getRowData', rowID).id);" disabled="true" />
	</div>
	<table id="lista" ></table>
	<div id=paginadorLista></div>
	
</fieldset>
<script type="text/javascript">
var rowID;
$(function() {
	$("#lista").jqGrid({
		datatype : 'local',
		data : [],
		colNames : [
				"Id", "Encuesta", "Fecha Inicio", "Fecha Fin"
		],
		colModel : [
				{
					name : 'id',
					index : 'idRest',
					width : 0,
					hidden : true
				}, {
					name : 'nombre',
					index : 'nombre',
					width : 60,
					sorttype : 'string',
					sortable : true,
					align : 'left'
				}, {
					name : 'fecha_inicio',
					index : 'fecha_inicio',
					width : 15,
					sorttype : 'string',
					sortable : true,
					align : 'left'
				},
				{
					name : 'fecha_fin',
					index : 'fecha_fin',
					width : 15,
					sorttype : 'string',
					sortable : true,
					align : 'left'
				}
		],
		autowidth: true,
		shrinkToFit: true,
		rowNum : 20,
		rowList : [
				10, 20, 30
		],
		pager : '#paginadorLista',
		sortname : 'nombre',
		sortorder : 'asc',
		viewrecords : true,
		rownumbers : false,
		scroll : false,
		onSelectRow : function(rowid, status) {
			$("#btnEditar").attr('disabled', false);
			$("#btnEliminar").attr('disabled', false);
			rowID = rowid;
		}
	});
	$(window).bind('resizeEnd', function() {
		$('#lista').setGridWidth($('#parent').width()-30, true);
	}).trigger('resize');
});

function showInformationIntoView(information){
	$("#lista").setGridParam({
		data : information
	}).trigger("reloadGrid");
};
</script>