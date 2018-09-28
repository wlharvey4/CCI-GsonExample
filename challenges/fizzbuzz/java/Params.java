/* challenges/fizzbuzz/java/Params.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-28
   VERSION: 0.2.1
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
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import com.google.gson.*;
import lang.java.*;

public class Params implements IParams {
    private static int n;

    public Params() {}

    Gson gson = new Gson();

    /* Constructor with one parameter of type JsonElement */
    public Params(JsonElement params) {
	CCParams ccp = gson.fromJson(params, CCParams.class);
	/* once the params has been parsed, this code extracts the params
	   using the methods provided by CCParam */
	this.n = ccp.getN();
    }

    /* this should probably be a generic array */
    public static int[] getParams() {
	return new int[]{n};
    }

    public String toString() {
	int[] ps = getParams();
	return "Params\tn: " + ps[0];
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
