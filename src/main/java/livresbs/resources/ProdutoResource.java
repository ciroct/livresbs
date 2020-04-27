package livresbs.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import livresbs.model.Produto;
import livresbs.model.dao.DAO;

@Path("/produto")
public class ProdutoResource {

	@GET
	@Produces("application/json")
	public Response getAll() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listarGenerico("Produto.listarTodos");
		return Response.ok(produtos).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = dao.consultarGenerico("Produto.consultarPorId", id);
		if (produto != null) {
			return Response.ok(produto).build();	
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@Path("/produtor/{produtor}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("produtor") String produtor) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listarGenerico("Produto.listarPorProdutor", produtor);
		return Response.ok(produtos).build();	
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.adicionar(produto);
		return Response.ok(produto).build();		
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.alterar(produto);
		return Response.ok(produto).build();		
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
}
