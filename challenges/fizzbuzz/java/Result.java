/* challenges/fizzbuzz/java/Result.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.4
   AUTHOR:  wlharvey4
   ABOUT:   Concrete class representing a code challenge Result, which is
   	    equivalent to an Expected type
   ROOT:    CCI-GsonExample/
   CLASSPATH: .:gson-2.8.5.jar
   NOTES:
   CHANGE-LOG:
   .........................................................................
   2018-09-28T16:58 version 0.0.1
   - Initial
   .........................................................................
   2018-09-29T07:10 version 0.0.2
   - Implemented Result
   .........................................................................
   2018-09-29T08:00 version 0.0.3
   - use an Integer rather than int
   .........................................................................
   2018-09-29T08:50 version 0.0.4
   - changed constructor to one taking a String parameter;
   - added try-catch for IllegalArgumentException should something other than
     a FB type comes in; also converted string to all upper case;
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Result implements IResult {
    private Result result;

    public Result() {}

    public Result(String result) {
	try {
	    this.result = new FB_Result(FB.valueOf(result.toUpperCase()));
	} catch (IllegalArgumentException iae) {
	    System.err.println("ERROR: result: `" + result + "' does not have an FB value");
	    System.exit(-1);
	}
    }

    public Result(int result) {
	this.result = new Int_Result(result);
    }

    public Result result() {
	return this.result;
    }

    private class FB_Result extends Result {
	FB result;
	FB_Result(FB fb) {
	    this.result = fb;
	}
    }

    private class Int_Result extends Result{
	Integer result;
	Int_Result(int i) {
	    this.result = i;
	}
    }
}
