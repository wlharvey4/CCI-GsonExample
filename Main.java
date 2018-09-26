/* Main.java
   =======================================================
   CREATED: 2018-09-26T12:30
   UDPATED:
   VERSION: 0.1.0
   AUTHOR: wlharvey4
   ABOUT: Example setup for reading in JSON objects of "params" objects of arbitrary construction
          and initializing an A object (i.e., InputExpected) using JSON elements instead of Strings
   COMPONENTS:
     Main.java: main method
     A.java: main class
     Params.java: utility class
     Expected.java: utility class
     IA.java: main interface
     AParams.java: abstract utility class
     AExpected.java: abstract utility class
   CLASSPATH: .:<path-to-gson->
   compilation: javac Main.java
   usage: ?java Main "{\"params\":{\"n\":1,\"m\":2},\"expected\":3}"
   CHANGE-LOG:
   .......................................................
   2018-09-26T12:30 VERSION 0.1.0
   - first working version
   -------------------------------------------------------
*/

import com.google.gson.*;

public class Main {
    /* args[0] := {"params":{"n":1,"m":2},"expected":3}
    */
    public static void main(String[] args) {
	Gson gson = new Gson();

	JsonParser parser = new JsonParser();
	JsonElement elements = parser.parse(args[0]);
	JsonObject paramsExpected = elements.getAsJsonObject();

	JsonElement params = paramsExpected.get("params");
	JsonElement expected = paramsExpected.get("expected");

	System.out.println("Params: " + params);
	System.out.println("Expected: " + expected);

	/* Params and Expected need to be implemented to receive some
	   Json objects and convert them into Java objects according
	   to the requirements of the code challenge.
	*/
	A a = new A(new Params(params), new Expected(expected));
	System.out.println(a);
    }

    private class Args {
	String params;
	String expected;
    }
}

/* Produces:

?java Main "{\"params\":{\"n\":1,\"m\":2},\"expected\":3}"
Params: {"n":1,"m":2}
Expected: 3
A:
        Params  n: 1, m: 2
        Expected expected: 3
*/
