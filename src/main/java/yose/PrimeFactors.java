package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class PrimeFactors {
    private final Gson gson;

    public PrimeFactors(Gson gson) {
        this.gson = gson;
    }

    public void decompose(Request request, Response response) throws Exception {
    	int number = Integer.parseInt(request.parameter("number"));
  
        response.contentType(JSON).body(gson.toJson(new Decompose(number)));
    }


    /*
     * {
     *  "number" : 16,
     *  "decomposition" : [ 2, 2, 2, 2 ]
    * }
    */
    public class Decompose {
     
        public int number = 2;
        public int[] decomposition;
        
        public Decompose(int nb) {
        	number = nb;
        	decomposition = new int[1];
        	decomposition[0] = 2;
        }
    } 
}
