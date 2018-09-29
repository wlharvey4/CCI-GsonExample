/* challenges/fizzbuzz/java/Result.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.5
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
   .........................................................................
   2018-09-29T09:28 version 0.0.5
   - refactored constructor to test incoming String for whether it is an
     Integer or String, and create the correct type using a Scanner;
   - refactored to add toString() methods to main class and subclasses
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import java.util.Scanner;
import lang.java.*;

public class Result implements IResult {
    private Result result;

    public Result() {}

    /* need a Scanner to check whether the incoming result is an Integer;
       if not, it will be an FB enum.
    */
    Scanner intScanner;

    public Result(String result) {
	intScanner = new Scanner(result);
	if (intScanner.hasNextInt()) {
	    this.result = new Result(intScanner.nextInt());
	} else {
	    try {
		this.result = new FB_Result(FB.valueOf(result.toUpperCase()));
	    } catch (IllegalArgumentException iae) {
		System.err.println("ERROR: result: `" + result + "' does not have an FB value");
		System.exit(-1);
	    }
	}
    }

    public Result(int result) {
	this.result = new Int_Result(result);
    }

    public Result result() {
	return this.result;
    }

    public String toString() {
	return "Result:\t" + result();
    }

    private class FB_Result extends Result {
	FB result;
	FB_Result(FB fb) {
	    this.result = fb;
	}
	public String toString() {
	    return result.toString();
	}
    }

    private class Int_Result extends Result{
	Integer result;
	Int_Result(int i) {
	    this.result = i;
	}
	public String toString() {
	    return result.toString();
	}
    }
}
