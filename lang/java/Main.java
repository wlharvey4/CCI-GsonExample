/* lang/java/Main.java
   =========================================================================
   CREATED: 2018-09-26T12:30
   UDPATED: 2018-10-01T13:00
   VERSION: 0.3.2
   AUTHOR:  wlharvey4
   ABOUT:   Example setup for reading in JSON objects of "params" objects of
   	    arbitrary construction and initializing an A object (i.e., InputExpected)
   	    using JSON elements instead of Strings
   USAGE:   ? java lang/java/Main <cc>; or alternatively
            ? make run CC=<cc>
   ROOT:    CCI-GsonExample/
   CLASSPATH: .:gson-2.8.5.jar
   COMPILATION: javac -classpath $CLASSPATH lang/java/Main.java

   NOTES:   Main must be run from the ROOT directory (CCI-GsonExample/)
   	    Main can be run using the Makefile as `make run CC=<code-challenge>'

   COMPONENTS:
     package lang.java:
     ------------------
     lang.java.Main.java      --- main method (test runnr)
     lang.java.ICC.java       --- code challenge interface; 3 required methods:
     				  IResult calculate(); (setter)
				  IParams params();    (getter)
				  IResult result();    (getter)
     lang.java.ParamsExpected --- code to store JSON data params and expected
     lang.java.IParams.java   --- interface utility to parse and store params
     lang.java.IResult.java   --- interface utility to parse and store result
     lang.java.IExpected.java --- interface utility to parse and store expected;
     				  concrete implementation is a subclass of Result;

     package challenges.<cc>.java:
     -----------------------------
     challenges.<cc>.java.<CC>.java     --- Code Challenge class implements ICC
     challenges.<cc>.java.Params.java   --- utiltiy class implements IParams
     challenges.<cc>.java.Result.java   --- utiltiy class implements IResult
     challenges.<cc>.java.Expected.java --- utility class extends Result, 
					    implemnets IExpected

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
   .........................................................................
   2018-10-01T09:15 version 0.2.9
   - cleaned up code and comments
   .........................................................................
   2018-10-01T10:10 version 0.3.0
   - successfully used reflection to instantiate code challenge and run tests;
   - cleaned up and refactored code substantially;
   .........................................................................
   2018-10-01T12:10 version 0.3.1
   - refactored packageCC to be protected so ParamsExpected can access it;
   - made some small code changes;
   .........................................................................
   2018-10-01T13:00 version 0.3.2
   - create ccPackageName in ccInit() code;
   - moved creation of Params and Expected package names into Main's
     ccInit(), using protected keyword for proper access privilege;
   -------------------------------------------------------------------------
*/

package lang.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.google.gson.*;

public class Main {

    private Main() {}		       		 // this class should not be instantiated

    private   static File   ROOT;      		 // the ROOT of the module: CCI-GsonExample/
    private   static String packageLang = "lang.java."; // package designation for Main and interfaces

    // these names are used by Reflection code
    private   static String cc;			 // code challenge from command-line
    private   static String ccName;		 // upper-cased code challenge name
    private   static String ccPackage;		 // package designation based upon cc from command-line
    private   static String ccPackageName;       // fully qualified Code Challenge package name
    protected static String paramsPackageName;   // fully qualified Params package name
    protected static String expectedPackageName; // fully qualified Expected package name
    private   static File   ccJSON;    		 // code challenge JSON data file

    static {
	try { ROOT = new File("./").getCanonicalFile();  }
	catch (IOException ioe) { ioe.printStackTrace(); }
    }

    /* Static method to initialize class variables using Code Challenge from command line */
    private static void ccInit(String cc) throws IOException {
	Main.cc                  = cc;
	Main.ccName              = cc.substring(0,1).toUpperCase() + cc.substring(1);
	Main.ccPackage           = "challenges." + cc + ".java.";
	Main.ccPackageName       = Main.ccPackage + Main.ccName;
	Main.paramsPackageName   = Main.ccPackage + "Params";
	Main.expectedPackageName = Main.ccPackage + "Expected";

	Main.ccJSON    = new File(new File(new File(Main.ROOT, "challenges"), Main.cc), Main.cc + ".json");

	if (!(Main.ccJSON.canRead()||Main.ccJSON.exists())) {
	    throw new IOException("ERROR: FILE NOT FOUND OR NOT READABLE: " + Main.ccJSON );
	}
    }

    public static void main(String[] args) {
	ICC            icc;		// Code Challenge Interface; contains two required methods:
					// (1) IParams params() and (2) IResult result()
					// and a constructor with a required parameter IParams
	Class<?>       ccClass;		// reflected Class of Code Challenge
	Constructor    constr;		// reflected Constructor of Code Challenge
	ParamsExpected paramsExpected;	// holds parsed JSON data for Code Challenge to use

	JsonParser     parser;		// parses the JSON data object found in <cc>.json
	Iterator<JsonElement> iterJson; // Iterator of an Array of JSON objects (peJson)
	
	/* make sure there is a Code Challenge name given on the command line;
	   if so, initialize Code Challenge variables; */
	try { Main.ccInit(args[0]); } // args[0] is the code challenge name, i.e. `fizzbuzz'
	catch (IOException ioe) { ioe.printStackTrace(); System.exit(-1); }
	catch (NullPointerException | ArrayIndexOutOfBoundsException mce) {
	    System.err.println("USAGE: $java lang/java/Main <code-challenge>");
	    mce.printStackTrace();
	    System.exit(0);
	}

	try { // wrap the Reflection calls
	    ccClass = Class.forName(Main.ccPackageName);
	    constr = ccClass.getConstructor(IParams.class);

	    try (FileReader ccJsonData = new FileReader(Main.ccJSON)) { // wrap the I/O calls
		parser   = new JsonParser();
		/* obtain an Iterator over an Array of JSON data objects */
		iterJson = parser.parse(ccJsonData).getAsJsonArray().iterator();

		// iterate over the JSON Array of params and expected values
		while (iterJson.hasNext()) {
		    /* obtain the corresponding Params and Expected values for next
		       Code Challenge invocation */
		    paramsExpected = new ParamsExpected(iterJson.next().getAsJsonObject());
		    System.out.println(paramsExpected);

		    /* use the Reflection Constructor to instantiate a call to the
		       code challenge with a new set of parameters; this is the HEART
		       of the solution. */
		    icc = (ICC) constr.newInstance(paramsExpected.getParams());

		    System.out.println(ccName + "(" + icc.params() + ") = Result: " + icc.result());
		    System.out.println("Expected: " + paramsExpected.getExpected());
		    System.out.println("Result Equals Expected?: " +
				       icc.result().equals(paramsExpected.getExpected()));
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
	catch (ClassNotFoundException | NoSuchMethodException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
	catch (
	       InstantiationException   |
	       IllegalAccessException   |
	       IllegalArgumentException |
	       InvocationTargetException constr_exc
	       ) {
	    constr_exc.printStackTrace();
	    System.exit(-1);
	}
    }

    private class Args {
	String params;
	String expected;
    }
}
