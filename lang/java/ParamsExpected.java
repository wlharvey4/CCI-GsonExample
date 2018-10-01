/* lang/java/ParamsExpected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-10-01
   VERSION: 0.4.0
   AUTHOR:  wlharvey4
   ABOUT:   Receives and stores Params and Expected from JSON file
   ROOT:    CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   NOTES:
   CHANGE-LOG:
   .........................................................................
   2018-09-26 version 0.1.0
   - initial commit
   .........................................................................
   2018-09-26 version 0.1.1
   - adjusted packages
   .........................................................................
   2018-09-27T05:30 version 0.1.2
   - adjust packages again;
   - added code information;
   .........................................................................
   2018-09-28T13:30 version 0.2.0
   - created challenges.fizzbuzz.java.InputExpected
   .........................................................................
   2018-09-28T13:47 version 0.2.1
   - refactored IA to IE
   .........................................................................
   2018-09-28T16:00 version 0.3.0
   - refactored to package lang.java
   .........................................................................
   2018-09-28T16:23 version 0.3.1
   - refactored to package lang.java.ParamsExpected
   .........................................................................
   2018-09-28T16:32 version 0.3.2
   - refactored toString()
   .........................................................................
   2018-09-28T17:06 version 0.3.3
   - refactored IE to IParamsExpected
   - no longer implements any interface
   .........................................................................
   2018-09-29T17:43 version 0.3.4
   - reformated toString();
   .........................................................................
   2018-10-01T07:30 version 0.3.5
   - factored in Params() and Expected() from Main class
   .........................................................................
   2018-10-01T07:45 version 0.3.6
   - factored in the calling of ParamsExpected with a single JSON object
     containing both `params' and `expected' objects, and parsing the JSON
     here instead of in Main;
   .........................................................................
   2018-10-01T08:24 version 0.3.7
   - factored out checks for null into Params and Result classes;
   .........................................................................
   2018-10-0112:10 version 0.4.0
   - factored in Reflection; factored out references to challenges.fizzbuzz;
     code runs successfully using Reflection;
   -------------------------------------------------------------------------
*/

package lang.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ParamsExpected {
    private IParams params;
    private IExpected expected;

    private static final String PARAMS   = "Params";
    private static final String EXPECTED = "Expected";

    JsonElement paramsJson;	// JSON data object for "params" key
    JsonElement expectedJson;	// JSON data object for "expected" key

    Class<?> paramsClass;	// Reflected Class object for Params class
    Class<?> expectedClass;	// Reflected Class object for Expected class
    Constructor paramsConst;	// Reflected Constructor for Params class
    Constructor expectedConst;	// Reflected Constructor for Expected class

    public ParamsExpected() {}
    public ParamsExpected(JsonObject paramsExpectedJson) {
	// separate the two objects in the JSON data
	paramsJson   = paramsExpectedJson.get("params");
	expectedJson = paramsExpectedJson.get("expected");

	try {
	    /* using Reflection instantiate the Params and Expected classes
	       for the Code Challenge */
	    paramsClass   = Class.forName(Main.packageCC + ParamsExpected.PARAMS);
	    expectedClass = Class.forName(Main.packageCC + ParamsExpected.EXPECTED);
	    paramsConst   = paramsClass.getConstructor(JsonElement.class);
	    expectedConst = expectedClass.getConstructor(JsonElement.class);

	    this.params   = (IParams)   paramsConst.newInstance(paramsJson);
	    this.expected = (IExpected) expectedConst.newInstance(expectedJson);
	}
	catch (ClassNotFoundException cnfe) {
	    cnfe.printStackTrace();
	    System.exit(-1);
	}
	catch (NoSuchMethodException nsme) {
	    nsme.printStackTrace();
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

    // required getter method for params
    public IParams getParams() {
	return this.params;
    }

    // required getter method for expected
    public IExpected getExpected() {
	return this.expected;
    }

    public String toString() {
	return "ParamsExpected: \n\tParams: " + getParams() + "\n\tExpected: " + getExpected();
    }
}
