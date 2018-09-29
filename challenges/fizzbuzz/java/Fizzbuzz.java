/* challenge/fizzbuzz/java/Fizzbuzz.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED:
   VERSION: 0.0.1
   AUTHOR:  wlharvey4
   ABOUT:   fizzbuzz challenge in Java
   ROOT:    CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   NOTES:
   CHANGE-LOG:
   .........................................................................
   2018-09-28T16:40 version 0.0.1
   - Initial
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Fizzbuzz implements ICC {
    private Params params;

    public Fizzbuzz() {}
    public Fizzbuzz(Params p) {
	this.params = p;
    }

    public Result calculate(IParams params) {
	return new Result();
    }
}
