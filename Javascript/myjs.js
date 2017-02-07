var id = 0;

$("#button").on("click", function(){
	var tarefa = $("#novaTarefa");
	var thisid = id;
	id++;
	$("#lista").append("<li id="+thisid+"><p id=text"+thisid+">"+tarefa.val()+"</p><button onclick='editar("+thisid+")'>Editar</button><button onclick='deletar("+thisid+")'>X</button></li>");
	tarefa.val('');
});

function editar(thisid){
	$("#text"+thisid).text(""+prompt("Novo valor:"));
}

function deletar(thisid){
	$("#"+thisid).remove();
}