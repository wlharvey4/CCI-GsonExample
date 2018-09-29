/* challenges/fizzbuzz/java/Result.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.2
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
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Result implements IResult {
    private Result result;

    public Result() {}

    public Result(FB result) {
	this.result = new FB_Result(result);
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
	int result;
	Int_Result(int i) {
	    this.result = i;
	}
    }
}
