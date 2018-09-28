/* challenges/fizzbuzz/java/InputExpected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-28
   VERSION: 0.2.0
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
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class InputExpected implements IA {
    private Params params;
    private Expected expected;

    public InputExpected() {}
    public InputExpected(Params p, Expected e) {
	this.params = p;
	this.expected = e;
    }

    public Params getParams() {
	return this.params;
    }

    public Expected getExpected() {
	return this.expected;
    }

    public String toString() {
	return "A: \n\t" + getParams() + "\n\t" + getExpected();
    }
}
