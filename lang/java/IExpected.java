/* lang/java/IExpected.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-28
   VERSION: 0.1.3
   AUTHOR:  wlharvey4
   ABOUT:   Abstract class AExpected for concrete class Expected
   NOTES:
   ROOT:      CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   CHANGE-LOG:
   .........................................................................
   2018-09-26 version 0.1.0
   - initial commit
   .........................................................................
   2018-09-27 version 0.1.1
   - added code information
   .........................................................................
   2018-09-27T06:30 version 0.1.2
   - changed abstract class to interface;
   - changed name of file to IExpected;
   .........................................................................
   2018-09-28T18:35 version 0.1.3
   - refactored so that IExpect now extends IResult
   -------------------------------------------------------------------------
*/

package lang.java;

public interface IExpected extends IResult {}
