/* challenges/fizzbuzz/java/Params.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-10-01
   VERSION: 0.2.5
   AUTHOR:  wlharvey4
   ABOUT:   Receives Params from JSON and converts them into Java
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
   2018-09-27 version 0.1.2
   - adjusted packages again;
   - added code information
   .........................................................................
   2018-09-28T13:20 version 0.2.0
   - created challenges.fizzbuzz.java.Params
   .........................................................................
   2018-09-28T14:00 version 0.2.1
   - refactored name ccParams to CCParams;
   - modified comments
   .........................................................................
   2018-09-28T16:30 version 0.2.2
   - refactored toString()
   .........................................................................
   2018-09-29T14:30 version 0.2.3
   - removed static from instance variable n;
   - refactored getParams() into n()
   - also refactored toString() in accordance with n();
   .........................................................................
   2018-09-29T17:53 version 0.2.4
   - reformatted toString()
   .........................................................................
   2018-10-01T08:35 version 0.2.5
   - factored in check for null after parsing from ParamsExpected, and before
     that from Main;
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import com.google.gson.*;
import lang.java.*;

public class Params implements IParams {
    private int n;

    public Params() {}

    Gson gson = new Gson();

    /* Constructor with one parameter of type JsonElement */
    public Params(JsonElement params) {
	try {
	    CCParams ccp = gson.fromJson(params, CCParams.class);
	    /* once the params has been parsed, this code extracts the params
	       using the methods provided by CCParam */
	    if (ccp == null)
		throw new IllegalStateException("ERROR: the parsing of params: " + params + " returned null");
	    this.n = ccp.getN();
	}
	catch (IllegalStateException ise) {
	    ise.printStackTrace();
	    System.exit(-1);
	}
    }

    /* this should probably be a generic array */
    public int n() {
	return this.n;
    }

    public String toString() {
	return "n = " + n();
    }

    /* this is used by gson.fromJson to parse the incoming params
       and provide a method to extract the params */
    private class CCParams {
	private int n;

	public int getN() {
	    return n;
	}
    }
}
