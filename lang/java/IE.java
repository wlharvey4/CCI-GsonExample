/* lang/java/IE.java
   =========================================================================
   CREATED: 2018-09-26
   UPDATED: 2018-09-28
   VERSION: 0.2.`
   AUTHOR:  wlharvey4
   ABOUT:   Interface IE for implementing class InputExpected
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
   .........................................................................
   2018-09-28T13:45 version 0.2.0
   - changed name of class to IE (interface for InputExpected)
   .........................................................................
   2018-09-28T14:04 version 0.2.1
   - changed name of file to lang/java/IE.java (from IA.java)
   -------------------------------------------------------------------------
*/

package lang.java;

public interface IE {
    public IParams getParams();
    public IExpected getExpected();
}
