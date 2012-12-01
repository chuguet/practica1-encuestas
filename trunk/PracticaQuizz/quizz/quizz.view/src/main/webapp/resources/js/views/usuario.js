var encuesta = {
	'rowID' : null,
	'formatList' : function() {
		$(function() {
			$("#lista").jqGrid({
				datatype : 'local',
				data : [],
				colNames : [
						"Id", "Nombre", "Apellidos", "Email", "Usuario", "Contraseña", "Es admin"
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
							width : 30,
							sorttype : 'string',
							sortable : true,
							align : 'left'
						}, {
							name : 'apellidos',
							index : 'fecha_inicio',
							width : 40,
							sorttype : 'string',
							sortable : true,
							align : 'left'
						}, {
							name : 'email',
							index : 'email',
							width : 20,
							sorttype : 'string',
							sortable : true,
							align : 'left'
						}, {
							name : 'usuario',
							index : 'usuario',
							width : 20,
							sorttype : 'string',
							sortable : true,
							align : 'left'
						}, {
							name : 'pwd',
							index : 'pwd',
							width : 20,
							sorttype : 'string',
							sortable : true,
							align : 'left'
						}, {
							name : 'admin',
							index : 'admin',
							width : 20,
							sorttype : 'boolean',
							sortable : true,
							align : 'center'
						}
				],
				autowidth : true,
				shrinkToFit : true,
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
					encuesta.rowID = rowid;
				}
			});
			$(window).bind('resizeEnd', function() {
				$('#lista').setGridWidth($('#parent').width() - 30, true);
			}).trigger('resize');
		});
	}
}