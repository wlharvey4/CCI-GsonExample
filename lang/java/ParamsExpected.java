/* lang/java/ParamsExpected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-10-01
   VERSION: 0.3.5
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
   -------------------------------------------------------------------------
*/

package lang.java;

import com.google.gson.JsonElement;
import challenges.fizzbuzz.java.*;	// <== ParamsExpected DOES NOT have knowledge of this package

public class ParamsExpected {
    private IParams params;
    private IExpected expected;

    public ParamsExpected() {}
    public ParamsExpected(JsonElement paramsJson, JsonElement expectedJson) {

	this.params   = new Params(paramsJson);		// <== Main DOES NOT have knowledge
	this.expected = new Expected(expectedJson);	// <== of these two types, so need reflection here

    }

    public IParams getParams() {
	return this.params;
    }

    public IExpected getExpected() {
	return this.expected;
    }

    public String toString() {
	return "ParamsExpected: \n\tParams: " + getParams() + "\n\tExpected: " + getExpected();
    }
}
