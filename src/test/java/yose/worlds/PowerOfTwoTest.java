package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class PowerOfTwoTest {

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
    public void powerOfTwoOf2() throws IOException {
        response = request.get("/primeFactors?number=2");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"number\":2,"
                            		+ "\"decomposition\":[2]"
                            		+ "}");

    }
    @Test
    public void powerOfTwoOf16() throws IOException {
        response = request.get("/primeFactors?number=16");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"number\":16,"
                            		+ "\"decomposition\":[2,2,2,2]"
                            		+ "}");

    }
    
}
