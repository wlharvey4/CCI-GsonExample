# Makefile
# #########################################################################
# CREATED: 2018-09-26
# UPDATED: 2018-10-01
# VERSION: 0.3.4
# AUTHOR:  wlharvey4
# ABOUT:   makefile for CCI-GsonExample program
# USAGE:   make TARGET | make run CC=<CODE-CHALLENGE>
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
# .........................................................................
# 2018-09-29T08:56 version 0.3.2
# - added Expected
# .........................................................................
# 2018-09-29T18:30 version 0.3.3
# - added variable CC and target run $(CC)
# .........................................................................
# 2018-10-01T15:05 version 0.3.4
# - made main compilation and run targets silent
# -------------------------------------------------------------------------

MAIN := Main
CLASSPATH := .:gson-2.8.5.jar
PACKAGECC := challenges/fizzbuzz/java
PACKAGEMAIN := lang/java
CC ?= fizzbuzz

.PHONY : default main Main IParams IExpected IResult ICC Params Result fizzbuzz Fizzbuzz FB clean run

default : Main ParamsExpected IParams IExpected IResult ICC Params Result Expected Fizzbuzz

main : Main
Main : $(PACKAGEMAIN)/Main.class

$(PACKAGEMAIN)/Main.class : $(PACKAGEMAIN)/Main.java
	@javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/Main.java

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

Expected : $(PACKAGECC)/Expected.class

$(PACKAGECC)/Expected.class : $(PACKAGECC)/Expected.java
	javac -classpath $(CLASSPATH) $(PACKAGECC)/Expected.java

fizzbuzz: Fizzbuzz
Fizzbuzz : $(PACKAGECC)/Fizzbuzz.class

$(PACKAGECC)/Fizzbuzz.class : $(PACKAGECC)/Fizzbuzz.java $(PACKAGECC)/Result.class
	javac -classpath $(CLASSPATH) $(PACKAGECC)/Fizzbuzz.java

FB : $(PACKAGECC)/FB.class

$(PACKAGECC)/FB.class : $(PACKAGECC)/FB.java
	javac -classpath $(CLASSPATH) $(PACKAGECC)/FB.java

clean :
	rm -rfv *~ $(PACKAGEMAIN)/*{.class,~} $(PACKAGECC)/*{.class,~}

run : default
	@java -classpath $(CLASSPATH) lang/java/Main $(CC)
