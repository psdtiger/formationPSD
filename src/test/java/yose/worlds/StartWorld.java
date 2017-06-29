package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;
import static org.junit.Assert.*;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class StartWorld {

    YoseDriver yose = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void firstWebPageChallenge() throws IOException {
        //yose.home().displaysGreeting("Hello Yose");
    }

    @Test
    public void firstWebServiceChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }
    
    @Test
    public void shareWebPageChallenge() throws IOException {
        
    	response = request.get("/");

    	assertTrue(response.bodyText().contains("<a id=\"repository-link\" href=\"https://github.com/OrangePSDPanda/formationPSD/tree/master\">Hello Yose repository of Panda</a>"));
    }
    
    @Test
    public void contactInfoWebPageChallenge() throws IOException {
        
    	response = request.get("/");
    	assertTrue(response.bodyText().contains("<a id=\"contact-me-link\" href=\"./contact\">Contact</a>"));
    }
    
    @Test
    public void pingWebPageChallenge() throws IOException {
        
    	response = request.get("/");
    	assertTrue(response.bodyText().contains("<a id=\"ping-challenge-link\" href=\"https://damp-dawn-19948.herokuapp.com/ping\">Ping challenge</a>"));
    }
}
