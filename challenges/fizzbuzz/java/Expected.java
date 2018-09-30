/* challenges/test/java/Expected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-29
   VERSION: 0.2.6
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
   .........................................................................
   2018-09-29T08:53 version 0.2.4
   - refactored Expected constructor to convert incoming JsonElement into the
     appropriate Result type
   .........................................................................
   2018-09-29T09:25 version 0.2.5
   - refactored Scanner check into Result constructor
   - refactored toString() to return getExpected() instead of instance variable
     directly
   .........................................................................
   2018-09-29T17:50 version 0.2.6
   - cleaned up constructor code a bit;
   - refactored getExpected() to expected();
   - reformatted toString();
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import java.util.Scanner;
import com.google.gson.*;
import lang.java.*;

public class Expected implements IExpected {
    private Result expected;

    /* Expected is called from Main with a JsonElement */
    Gson gson = new Gson();

    public Expected() {}

    public Expected(JsonElement expected) {
	/* call the Result constructor with a String converted from JSON */
	this.expected = new Result(expected.getAsString());
    }

    public Result expected() {
	return this.expected;
    }

    public String toString() {
	return expected().toString();
    }
}
