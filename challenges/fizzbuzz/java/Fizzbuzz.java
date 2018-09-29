/* challenge/fizzbuzz/java/Fizzbuzz.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.4
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
     .........................................................................
   2018-09-29T07:04 version 0.0.3
   - added required Result result();
   .........................................................................
   2018-09-29T10:04 version 0.0.4
   - corrected using interface parameters instead of local parameters:
     IParams and IResult;
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Fizzbuzz implements ICC {
    private IParams params;
    private IResult result;

    public Fizzbuzz() {}
    public Fizzbuzz(IParams p) {
	this.params = p;
    }

    public void calculate(IParams params) {
	this.result = new Result();
    }

    public IResult result() {
	return result;
    }
}
