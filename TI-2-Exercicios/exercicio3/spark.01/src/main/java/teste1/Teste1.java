package teste1;

import static spark.Spark.*;

public class Teste1 {
	public static void main(String[] args) {
		port(8080); 
		get("/hello", (request, response) -> "eai");
	}
}
