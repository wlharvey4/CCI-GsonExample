/* challenges/test/java/Expected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-29
   VERSION: 0.2.3
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
   .........................................................................
   2018-09-28 version 0.2.1
   - refactored toString()
   .........................................................................
   2018-09-29 version 0.2.2
   - removed static from instance variable
   .........................................................................
   2018-09-29 version 0.2.3
   - convert Expected to a Result instead of String
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import com.google.gson.*;
import lang.java.*;

public class Expected implements IExpected {
    private Result expected;

    Gson gson = new Gson();

    /* no args constructor */
    public Expected() {}

    /*
       fromJson() method can accept a JsonElement as well as a String;
       the idea is to convert the JsonElement into a Result type
       (either a FB enum or an int)
    */
    public Expected(JsonElement expected) {
	this.expected = gson.fromJson(expected, Result.class);
    }

    public Result getExpected() {
	return this.expected;
    }

    public String toString() {
	return "Expected:\t" + this.expected;
    }
}
