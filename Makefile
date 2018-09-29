# Makefile
# #########################################################################
# CREATED: 2018-09-26
# UPDATED: 2018-09-29
# VERSION: 0.3.1
# AUTHOR:  wlharvey4
# ABOUT:   makefile for CCI-GsonExample program
# NOTES:
# CHANGE-LOG
# .........................................................................
# 2018-09-26 version 0.1.0
# - initial commit
# .........................................................................
# 2018-09-27 version 0.1.1
# - adjusted packages;
# - added code information
# .........................................................................
# 2018-09-28 version 0.2.0
# - refactored code to different packages and file names
# .........................................................................
# 2018-09-28 version 0.2.1
# - adjusted names of files to correspond with refactoring
# .........................................................................
# 2018-09-28T19:00 version 0.3.0
# - redid whole Makefile to be more explicit
# .........................................................................
# 2018-09-29T07:26 version 0.3.1
# - added FB
# -------------------------------------------------------------------------

MAIN := Main
CLASSPATH := .:gson-2.8.5.jar
PACKAGECC := challenges/fizzbuzz/java
PACKAGEMAIN := lang/java

.PHONY : default main Main IParams IExpected IResult ICC Params Result fizzbuzz Fizzbuzz FB clean

default : Main ParamsExpected IParams IExpected IResult ICC Params Result Fizzbuzz

main : Main
Main : $(PACKAGEMAIN)/Main.class

$(PACKAGEMAIN)/Main.class : $(PACKAGEMAIN)/Main.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/Main.java

ParamsExpected : $(PACKAGEMAIN)/ParamsExpected.class

$(PACKAGEMAIN)/ParamsExpected.class : $(PACKAGEMAIN)/ParamsExpected.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/ParamsExpected.java

IParams : $(PACKAGEMAIN)/IParams.class

$(PACKAGEMAIN)/IParams.class : $(PACKAGEMAIN)/IParams.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/IParams.java

IExpected : $(PACKAGEMAIN)/IExpected.class

$(PACKAGEMAIN)/IExpected.class : $(PACKAGEMAIN)/IExpected.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/IExpected.java

IResult : $(PACKAGEMAIN)/IResult.class

$(PACKAGEMAIN)/IResult.class : $(PACKAGEMAIN)/IResult.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/IResult.java

ICC : $(PACKAGEMAIN)/ICC.class

$(PACKAGEMAIN)/ICC.class : $(PACKAGEMAIN)/ICC.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/ICC.java

Params : $(PACKAGECC)/Params.class

$(PACKAGECC)/Params.class : $(PACKAGECC)/Params.java
	javac -classpath $(CLASSPATH) $(PACKAGECC)/Params.java

Result : $(PACKAGECC)/Result.class

$(PACKAGECC)/Result.class : $(PACKAGECC)/Result.java
	javac -classpath $(CLASSPATH) $(PACKAGECC)/Result.java

fizzbuzz: Fizzbuzz
Fizzbuzz : $(PACKAGECC)/Fizzbuzz.class

$(PACKAGECC)/Fizzbuzz.class : $(PACKAGECC)/Fizzbuzz.java $(PACKAGECC)/Result.class
	javac -classpath $(CLASSPATH) $(PACKAGECC)/Fizzbuzz.java

FB : $(PACKAGECC)/FB.class

$(PACKAGECC)/FB.class : $(PACKAGECC)/FB.java
	javac -classpath $(CLASSPATH) $(PACKAGECC)/FB.java

clean :
	rm -rfv *~ $(PACKAGEMAIN)/*{.class,~} $(PACKAGECC)/*{.class,~}
