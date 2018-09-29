/* lang/java/ICC.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED: 2018-09-29
   VERSION: 0.0.4
   AUTHOR:  wlharvey4
   ABOUT:   Interface for code challenges
   ROOT:    CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   NOTES:
   CHANGE-LOG:
   .........................................................................
   2018-09-28T16:44 version 0.0.1
   - Initial
   .........................................................................
   2018-09-28T19:36 version 0.0.2
   - refactored calculate to return void (implementation will store Result
     result in an instance variable instead
   .........................................................................
   2018-09-29T07:04 version 0.0.3
   - added required method IReturn return();
   .........................................................................
   2018-09-29T10:11 version 0.0.4
   - refactored return type of result() to be IResult instead of void;
   - refactored to require method IParams params();
   -------------------------------------------------------------------------
*/

package lang.java;

public interface ICC {
    public IResult calculate(IParams params);
    public IParams params();
    public IResult result();
}
