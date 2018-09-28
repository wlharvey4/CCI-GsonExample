/* challenges/test/java/Expected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-28
   VERSION: 0.2.0
   AUTHOR:  wlharvey4
   ABOUT:   Receives Expected as JSON and converts to Java
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
   - adjusted packages again
   - added code information
   .........................................................................
   2018-09-28 version 0.2.0
   - creaed challenges.fizzbuzz.java.Expected
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import com.google.gson.*;
import lang.java.*;

public class Expected implements IExpected {
    private static String expected;
    Gson gson = new Gson();

    /* no args constructor */
    public Expected() {}

    /* expected: JSON Element
       fromJson method can accept a JsonElement as well as a String
    */
    public Expected(JsonElement expected) {
	this.expected = gson.fromJson(expected, String.class);
    }

    public String getExpected() {
	return this.expected;
    }

    public String toString() {
	return "Expected expected: " + this.expected;
    }
}
