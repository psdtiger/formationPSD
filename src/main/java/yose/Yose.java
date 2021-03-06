package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;

import java.io.IOException;
import java.net.URI;

public class Yose {

    private final WebServer server;

    public Yose(int port) {
        this.server = WebServer.create(port);
    }

    public void start() throws IOException {
        final Gson gson = new Gson();

        server.start(new DynamicRoutes() {{
            get("/").to((request, response) -> response.body("<a id=\"repository-link\" href=\"https://github.com/OrangePSDPanda/formationPSD/tree/master\">Hello Yose repository of Panda</a>"
            		+ "<br /><a id=\"contact-me-link\" href=\"./contact\">Contact</a><br /><a id=\"ping-challenge-link\" href=\"https://damp-dawn-19948.herokuapp.com/ping\">Ping challenge</a>").contentType("content-type text/html"));
            get("/ping").to(new Ping(gson)::pong);
            get("/primeFactors").to( new PrimeFactors(gson)::decompose);
            get("/contact").to((request, response) -> response.body("Contact information: panda@orange.com"));
        }});
    }

    public URI uri() {
        return server.uri();
    }

    public void stop() throws IOException {
        server.stop();
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        Yose yose = new Yose(port(args));
        yose.start();
        System.out.print("To play the game visit " + yose.uri());
    }
}
