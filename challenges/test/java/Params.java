/* challenges/test/java/Params.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-27
   VERSION: 0.1.2
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
   -------------------------------------------------------------------------
*/

package challenges.test.java;

import com.google.gson.*;
import lang.java.*;

public class Params implements IParams {
    private static int n;
    private static int m;

    public Params() {}

    Gson gson = new Gson();

    /* params := JSON string */
    public Params(JsonElement params) {
	/* this code interprets JSON based upon needs of code challenge */
	ccParams ccp = gson.fromJson(params, ccParams.class);
	n = ccp.getN();
	m = ccp.getM();
    }

    public static int[] getParams() {
	return new int[]{n,m};
    }

    public String toString() {
	int[] ps = getParams();
	return "Params\tn: " + ps[0] + ", m: " + ps[1];
    }

    private class ccParams {
	private int n;
	private int m;

	public int getN() {
	    return n;
	}
	public int getM() {
	    return m;
	}
    }
}
