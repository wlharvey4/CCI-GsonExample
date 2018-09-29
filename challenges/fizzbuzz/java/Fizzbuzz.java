/* challenge/fizzbuzz/java/Fizzbuzz.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED:
   VERSION: 0.0.2
   AUTHOR:  wlharvey4
   ABOUT:   fizzbuzz challenge in Java
   ROOT:    CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   NOTES:
   CHANGE-LOG:
   .........................................................................
   2018-09-28T16:40 version 0.0.1
   - Initial
   .........................................................................
   2018-09-28T19:36 version 0.0.2
   - changed calculate to return void, but set an instance variable Result
     result
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Fizzbuzz implements ICC {
    private Params params;
    private Result result;

    public Fizzbuzz() {}
    public Fizzbuzz(Params p) {
	this.params = p;
    }

    public void calculate(IParams params) {
	this.result = new Result();
    }
}
