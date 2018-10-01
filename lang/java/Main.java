/* lang/java/Main.java
   =========================================================================
   CREATED: 2018-09-26T12:30
   UDPATED: 2018-10-01T08:45
   VERSION: 0.2.8
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
   .........................................................................
   2018-09-27T13:40 version 0.1.7
   - added FileReader;
   - added package variables;
   - changed name of class method to ccInit from ccJSON;
   - added try-with-resource opening of json data file;
   - added Gson, JsonParser, JsonElement, JsonArray
   - added catch-blocks of all exceptions
   - commented out former code in preparation for new code iterating over data
   .........................................................................
   2018-09-28T13:15 version 0.2.0
   - implemented full JSON iterator and successfully iterated through fizzbuzz.json
     printing each params and expected values;
   .........................................................................
   2018-09-28T16:30 version 0.2.1
   - changed package lang.java.InputExpected to lang.java.ParamsExpected
   .........................................................................
   2018-09-29T14:25 version 0.2.2
   - refactored names of params and expected into paramsJson and expectedJson;
   - refactored calls to Params and Expected out of the call to ParamsExpected
     because these will have to be reflected calls in the future;
   - created new object Fizzbuzz cc by calling Fizzbuzz's constructor with
     ParamExpected's method to getParams(); also called cc's method result(),
     but it only returns a null value at this point; nevertheless everything
     still compiles and runs successfully;
   .........................................................................
   2018-09-29T17:40 verion 0.2.3
   - reformatted print statement for Result;
   .........................................................................
   2018-09-30T14:24 version 0.2.4
   - added call to equals() and printed result; code is functioning
   .........................................................................
   2018-09-30T14:45 version 0.2.5
   - refactored try-with-resources block, Gson calls;
   - added comments to calls to Params and Expected constructors;
   - refactored Fizzbuzz type to ICC type; marked three areas that will need
     reflection for code to work dynamically
   .........................................................................
   2018-10-01T07:30 version 0.2.6
   - Factored out Params() and Expected() into ParamsExpected();
   .........................................................................
   2018-10-01T07:45 version 0.2.7
   - Factored out parsing of objJson into ParamsExpected; called ParamsExpected()
     with a single line of JSON data containing both `params' and `expected'
     objects;
   .........................................................................
   2018-10-01T08:45 version 0.2.8
   - Combined creation of array and array iterator, since no need for array
   -------------------------------------------------------------------------
*/

package lang.java;

import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

import challenges.fizzbuzz.java.*;	// <== Main does not have knowledge of this package

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
    private static String packageLang = "lang.java."; // package designation for Main
    private static String packageCC; // package designation based upon cc from command-line
    private static File   ccJSON; // code challenge JSON data file

    /* Initialize class variables using code challenge from command line */
    private static void ccInit(String cc) throws IOException {
	Main.cc = cc;
	Main.ccName = Main.cc.substring(0,1).toUpperCase() + Main.cc.substring(1);
	Main.packageCC = "challenges." + Main.cc + ".java.";

	Main.ccJSON = new File(new File(new File(Main.ROOT, "challenges"), Main.cc), Main.cc + ".json");
	if (!(Main.ccJSON.canRead()||Main.ccJSON.exists())) {
	    throw new IOException("ERROR: FILE NOT FOUND OR NOT READABLE: " + Main.ccJSON );
	}
    }

    /* 
       Example args[0] := {"params":{"n":1,"m":2},"expected":3}
    */
    public static void main(String[] args) {
	try { Main.ccInit(args[0]); }
	catch (IOException ioe) { ioe.printStackTrace(); System.exit(-1); }
	catch (NullPointerException | ArrayIndexOutOfBoundsException mce) {
	    System.err.println("USAGE: $java lang/java/Main <code-challenge>");
	    mce.printStackTrace();
	    System.exit(0);
	}

	try (FileReader ccJsonData = new FileReader(Main.ccJSON)) {

	    Gson gson = new Gson();
	    JsonParser  parser;
	    JsonObject  paramsExpectedJson;
	    Iterator<JsonElement> iterJson;

	    parser   = new JsonParser();
	    iterJson = parser.parse(ccJsonData).getAsJsonArray().iterator();

	    while (iterJson.hasNext()) {
		paramsExpectedJson = iterJson.next().getAsJsonObject();

		ParamsExpected pe  = new ParamsExpected(paramsExpectedJson);
		System.out.println(pe);

		ICC cc = new Fizzbuzz(pe.getParams());		// <== Main DOES NOT have knowledge of Fizzbuzz

		System.out.println(ccName + "(" + cc.params() + ") = Result: " + cc.result());
		System.out.println("Expected: " + pe.getExpected());
		System.out.println("Result Equals Expected?: " + cc.result().equals(pe.getExpected()));
		System.out.println();
	    }

	}
	catch (JsonIOException jioe) {
	    jioe.printStackTrace();
	    System.exit(-1);
	}
	catch (JsonSyntaxException jse) {
	    jse.printStackTrace();
	    System.exit(-1);
	}
	catch (JsonParseException jpe) {
	    jpe.printStackTrace();
	    System.exit(-1);
	}
	catch (IOException ioe) {
	    ioe.printStackTrace();
	    System.exit(-1);
	}
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
