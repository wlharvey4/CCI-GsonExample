/* challenges/test/java/A.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-27
   VERSION: 0.1.2
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
   -------------------------------------------------------------------------
*/

package challenges.test.java;

import lang.java.*;
import challenges.test.java.*;

public class A implements IA {
    private Params params;
    private Expected expected;

    public A() {}
    public A(Params p, Expected e) {
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
