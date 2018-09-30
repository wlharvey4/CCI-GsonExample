/* challenges/fizzbuzz/java/Result.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-30
   VERSION: 0.2.0
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
   .........................................................................
   2018-09-29T15:55 version 0.1.0
   - added a constructor with an FB argument to aid Fizzbuzz.calculate()
   .........................................................................
   2018-09-29T17:55 version 0.1.1
   - reformatted toString()
   .........................................................................
   2018-09-30T09:00 version 0.2.0
   - refactored Result instance variable to FizzbuzzResult interface, which has
     two concrete implementations: FB_Result and Int_Result, so that when
     Result.result() is called, a FizzbuzzResult type will be returned.
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import java.util.Scanner;
import lang.java.*;

public class Result implements IResult {
    private FizzbuzzResult result;

    public Result() {}

    /* need a Scanner to check whether the incoming result is an Integer;
       if not, it will be an FB enum.
    */
    Scanner intScanner;

    public Result(String result) {
	intScanner = new Scanner(result);
	if (intScanner.hasNextInt()) {
	    this.result = new Int_Result(intScanner.nextInt());
	} else {
	    try {
		this.result = new FB_Result(FB.valueOf(result.toUpperCase()));
	    } catch (IllegalArgumentException iae) {
		System.err.println("ERROR: result: `" + result + "' does not have an FB value");
		System.exit(-1);
	    }
	}
    }

    public Result(FB result) {
	this.result = new FB_Result(result);
    }

    public Result(int result) {
	this.result = new Int_Result(result);
    }

    public FizzbuzzResult result() {
	return this.result;
    }

    public String toString() {
	return result().toString();
    }

    private interface FizzbuzzResult {
	public boolean equals(FizzbuzzResult that);
	public boolean equals(FB_Result that);
	public boolean equals(Int_Result that);
    }

    private class FB_Result implements FizzbuzzResult {
	private FB result;
	private FB_Result() {}
	private FB_Result(FB fb) {
	    this.result = fb;
	}
	public String toString() {
	    return result.toString();
	}
	public boolean equals(FizzbuzzResult that) {
	    return true;
	}
	public boolean equals(FB_Result that) {
	    return true;
	}
	public boolean equals(Int_Result that) {
	    return true;
	}
    }

    private class Int_Result implements FizzbuzzResult {
	private Integer result;
	private Int_Result() {}
	private Int_Result(int i) {
	    this.result = i;
	}
	public String toString() {
	    return result.toString();
	}
	public boolean equals(FizzbuzzResult that) {
	    return true;
	}
	public boolean equals(FB_Result that) {
	    return true;
	}
	public boolean equals(Int_Result that) {
	    return true;
	}
    }
}
