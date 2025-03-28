package app;

import static spark.Spark.*;

import concursosService.ConcursosService;

public class Aplicacao {
	
	private static ConcursosService concursosService = new ConcursosService();
	
	public static void main(String[] args) {
		staticFiles.externalLocation("src/main/resources/public");
		port(8076);
		post("/concurso", (request, response) -> concursosService.insert(request, response));
		get("/concurso/delete/:id", (request, response) -> concursosService.delete(request, response));
		get("/concurso/:id", (request, response) -> concursosService.get(request, response));
		post("/concurso/update/:id", (request, response) -> concursosService.update(request, response));
	}
}
