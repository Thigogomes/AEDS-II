package concursosService;

import spark.Request;
import spark.Response;
import dao.ConcursoDAO;
import concursos.Concurso;

public class ConcursosService {
	
	public ConcursoDAO concursoDAO = new ConcursoDAO();
	
	public String insert(Request request, Response response) {
		int codigo = Integer.parseInt(request.queryParams("codigo"));
		String nome = request.queryParams("nome");
		String categoria = request.queryParams("categoria");
		String banca = request.queryParams("banca");
		String localizacao = request.queryParams("localizacao");
		String resp = "";
		
		Concurso concurso = new Concurso(codigo, nome, categoria, banca, localizacao);
		
		if(concursoDAO.insert(concurso)) {
            resp = "Concurso (" + nome + ") inserido!";
            response.status(201); 
		} else {
			resp = "Concurso (" + nome + ") não inserido!";
			response.status(404);
		}
		return resp;
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		Concurso concurso = concursoDAO.getConcurso(id);
		
		if(concurso != null) {
			response.header("Content-Type", "application/xml");
			response.header("Content-Encoding", "UTF-8");
			
			return "<concurso>\n" +
					"\t<id>" + concurso.getCodigoConcurso() + "</id>\n" +
					"\t<nome>" + concurso.getNomeConcurso() + "</nome>\n" +
					"\t<categoria>" + concurso.getCategoria() + "</categoria>\n" +
					"\t<banca>" + concurso.getBanca() + "</banca>\n" +
					"\t<localizacao>" + concurso.getLocalizacao() + "</localizacao>\n" +
					"</concurso>\n";
		}else {
			response.status(404);
			return "Produto " + id + " não encontrado";
		}
	}

	public Object delete(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));

		Concurso concurso = concursoDAO.getConcurso(id);
		if(concurso != null) {
			concursoDAO.delete(id);
			response.status(200);
			return "Concurso com ID " + id + " foi deletado com sucesso!";
		}else {
			response.status(404);
			return "Concurso não encontrado!";
		}
	}
	
	public Object update(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		Concurso concurso = concursoDAO.getConcurso(id);
		if(concurso != null) {
			concurso.setNomeConcurso(request.queryParams("nome"));
			concurso.setCategoria(request.queryParams("categoria"));
			concurso.setBanca(request.queryParams("banca"));
			concurso.setLocalizacao(request.queryParams("localizacao"));
			concursoDAO.update(concurso);
			return id;
		}else {
			response.status(404);
			return "Produto não encontrado!";
		}
	}
}
