/* lang/java/ICC.java
   =========================================================================
   CREATED: 2018-09-28
   UPDATED:
   VERSION: 0.0.2
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
   -------------------------------------------------------------------------
*/

package lang.java;

public interface ICC {
    public void calculate(IParams params);
}
