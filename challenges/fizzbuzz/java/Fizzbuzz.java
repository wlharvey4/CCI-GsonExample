/* challenge/fizzbuzz/java/Fizzbuzz.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.6
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
   .........................................................................
   2018-09-29T10:13 version 0.0.5
   - refactored to have calculate() return an IResult type;
   - refactored to have constructor call the calculate() method directly and
     assign return value to instance variable result;
   - refactored to have getParams() be called params() and be required through
     interface ICC;
     .........................................................................
   2018-09-29T14:10 version 0.0.6
   - refactored instance variables to hold Params and Result instead of IParams
     and IResult; needed to cast constructor argument IParams into Params;
     the instance method getters return IParams and IResult though;
   - refactored calculate() to not accept a parameter, but use its own instance
     variable;
   - implemented calculate() to obtain the param n;
   -------------------------------------------------------------------------
*/

package challenges.fizzbuzz.java;

import lang.java.*;

public class Fizzbuzz implements ICC {
    private Params params;
    private Result result;

    public Fizzbuzz() {}

    /* constructor must accept an IParams, but then cast it into a local
       Params for storage and use;
    */
    public Fizzbuzz(IParams p) {
	this.params = (Params)p;
	this.result = this.calculate();
    }

    public Result calculate() {
	System.err.println("calculating " + params);
	int n = params.n();
	System.err.println(n);
	return new Result();
    }

    public IParams params() {
	return this.params;
    }
    public IResult result() {
	return this.result;
    }
}
