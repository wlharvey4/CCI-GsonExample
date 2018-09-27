/* lang/java/IA.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-26
   VERSION: 0.1.2
   AUTHOR:  wlharvey4
   ABOUT:   Interface IA for implementing class A
   NOTES:
   ROOT:    CCI-GsonExample
   CLASSPATH: .:gson-2.8.5.jar
   CHANGE-LOG:
   .........................................................................
   2018-09-26 version 0.1.0
   - initial commit
   .........................................................................
   2018-09-27 version 0.1.1
   - updated packages;
   - add code information
   -------------------------------------------------------------------------
*/

package lang.java;

public interface IA {
    public IParams getParams();
    public IExpected getExpected();
}
