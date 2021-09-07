<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>

<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Livraria Online</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="resources/css/styles.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet">
        
    </head>
    <body>
        <!-- Responsive navbar-->
        <jsp:include page="menu.jsp" />
        
        <h1 class="text-center my-3">Autores</h1>
        <!-- Page content-->
        <div class="container ">
        	<div class="row" style="--bs-gutter-x: unset;">
        		
        		<div class="card ">
				  <div class="card-header text-center fw-bold">
				    Cadastro de Autor 
				    <button class="btn btn-primary float-end" data-bs-toggle="collapse" href="#formulario"><i class="bi bi-plus-lg" ></i></button>
				  </div>
				  <div class="card-body">
				  
				    <form action="<c:url value="/autores" />" method="post" class="collapse" id="formulario">
						<div class="form-group">
							<label for="nome">Nome</label>
							<input class="form-control" name="nome" type="text" required>
						</div>
						<div class="form-group">
							<label for="email">Email</label>
							<input class="form-control" name="email" type="text" required>
						</div>
						<div class="form-group">
							<label for="dt_nascimento">DT Nascimento</label>
							<input class="form-control" name="dt_nascimento" type="text" required>
						</div>
						<div class="form-group">
							<label for="mini_curriculo">Mini Currículo</label>
							<input class="form-control" name="mini_curriculo" type="text">
						</div>
						
						<button class="btn btn-primary mt-2" type="submit">Gravar</button>
					</form>				    
				  </div>				  
				</div>
        	       		
        	</div>
            <div class="row mt-3" style="--bs-gutter-x: unset;">
            
            	<div class="card ">
				  <div class="card-header text-center fw-bold">
				    Lista de Autores
				  </div>
				  <div class="card-body">				    
				    <table class="table table-hover table-striped table-bordered">
						<thead>
							<th>NOME</th>
							<th>EMAIL</th>
							<th>DT NASCIMENTO</th>
							<th></th>
						</thead>
						<tbody>
							<c:forEach items="${autores}" var="a">
								<tr id="linha-${a.id_autor}">
									<td>${a.nome}</td>
									<td>${a.email}</td>								
									<td><tags:localDate date="${a.dt_nascimento}"/></td>
									<td class="text-center">
										<a class="btn btn-danger btn-action btn-excluir-confirm " id="${a.id_autor}"><i class="bi bi-trash-fill"></i></a>
										<!--a class="btn btn-warning btn-action" href="?id=${a.id_autor}"><i class="bi bi-pencil-square"></i></a>
										<a class="btn btn-success btn-action" ><i class="bi bi-eye-fill"></i></a-->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				  </div>
				</div>
                
            </div>
        </div>
        <!-- Footer-->
        <jsp:include page="footer.jsp" />
        
        
        <!-- Modal -->
		<div class="modal fade" id="modal-excluir" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        Essa ação não poderá ser desfeita. <br>
		        Deseja excluir o autor?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancelar</button>
		        <button type="button" class="btn btn-danger btn-excluir-modal">Excluir</button>
		        <input type="hidden" id="id_temp">
		      </div>
		    </div>
		  </div>
		</div>
        
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
        <script>
        	$(function(){
        		
        		$(".btn-excluir-confirm").click(function(){ 
        			var id = $(this).attr("id");
        			$("#id_temp").val(id);
        			$('#modal-excluir').modal('show');
        		});
        		
        		$(".btn-excluir-modal").click(function(){
        			var id_autor = $("#id_temp").val();
        			$.ajax({
       				  url: "autores",
       				  method: "POST",	
       				  data: {
       				    id: id_autor,
       				    excluir: 1
       				  },
       				  success: function( result ) {
       				    if(result){
       				    	$("#linha-"+id_autor).hide('slow');
       				    	$('#modal-excluir').modal('hide');
       				    }else{
       				    	alert("Ocorreu algum erro!");
       				    }
       				  }
       				});
        		});
        		
        		
        	});
        </script>

    </body>
</html>
