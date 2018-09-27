/* lang/java/Main.java
   =========================================================================
   CREATED: 2018-09-26T12:30
   UDPATED: 2018-09-27T08:40
   VERSION: 0.1.6
   AUTHOR:  wlharvey4
   ABOUT:   Example setup for reading in JSON objects of "params" objects of
   arbitrary construction and initializing an A object (i.e., InputExpected)
   using JSON elements instead of Strings
   NOTES:   Main must be run from the ROOT directory (CCI-GsonExample/)
   COMPONENTS:
     lang.java.Main.java      --- main method
     lang.java.IA.java        --- main interface
     lang.java.AParams.java   --- abstract utility class
     lang.java.AExpected.java --- abstract utility class

     challenges.test.java.A.java        --- main class
     challenges.test.java.Params.java   --- utility class
     challenges.test.java.Expected.java --- utility class

   ROOT:        CCI-GsonExample
   CLASSPATH:   .:gson-2.8.5.jar
   compilation: javac -classpath $CLASSPATH lang/java/Main.java
   usage: ? java lang/java/Main "{\"params\":{\"n\":1,\"m\":2},\"expected\":3}"
   CHANGE-LOG:
   .........................................................................
   2018-09-26T12:30 version 0.1.0
   - first working version;
   .........................................................................
   2018-09-26T18:00 version 0.1.1
   - moved files into packages;
   .........................................................................
   2018-09-26T19:30 version 0.1.2
   - updated packages and importing;
   - created Makefile;
   - program compiles successfully with Makefile; cleans successfully;
   .........................................................................
   2018-09-27T05:51 version 0.1.3
   - adjusted packages again;
   - adjusted code comments;
   .........................................................................
   2018-09-27T06:36 version 0.1.4
   - removed unnecessary import of packages in own package directory;
   .........................................................................
   2018-09-27T07:00 version 0.1.5
   - added import of File, IOException;
   - added ROOT directory and static initialization;
   - added cc and ccName;
   - added private no-arg constructor;
   .........................................................................
   2018-09-27T08:40 version 0.1.6
   - added File computations and exceptions
   -------------------------------------------------------------------------
*/

package lang.java;

import java.io.File;
import java.io.IOException;
import com.google.gson.*;
import challenges.test.java.*;

public class Main {

    private Main() {}

    private static File ROOT;
    static {
	try {
	    ROOT = new File("./").getCanonicalFile();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
    }

    private static String cc; 	  // code challenge from command-line
    private static String ccName; // upper-cased code challenge name
    private static File   ccJSON; // code challenge JSON data file

    /* Initialize class variables using code challenge from command line */
    private static void ccJSON(String cc) throws IOException {
	Main.cc = cc;
	Main.ccName = Main.cc.substring(0,1).toUpperCase() + Main.cc.substring(1);

	Main.ccJSON = new File(new File(new File(Main.ROOT, "challenges"), Main.cc), Main.cc + ".json");
	if (!(Main.ccJSON.canRead()||Main.ccJSON.exists())) {
	    throw new IOException("ERROR: FILE NOT FOUND OR NOT READABLE: " + Main.ccJSON );
	}
    }

    /* 
       Example args[0] := {"params":{"n":1,"m":2},"expected":3}
    */
    public static void main(String[] args) {
	try { Main.ccJSON(args[0]); }
	catch (IOException ioe) { ioe.printStackTrace(); System.exit(-1); }
	catch (NullPointerException | ArrayIndexOutOfBoundsException mce) {
	    System.err.println("USAGE: $java lang/java/Main <code-challenge>");
	    mce.printStackTrace();
	    System.exit(0);
	}
	
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
