# Makefile
# ##########################################################################
# CREATED: 2018-09-26
# UPDATED: 2018-09-27
# VERSION: 0.1.1
# AUTHOR:  wlharvey4
# ABOUT:   makefile for CCI-GsonExample program
# NOTES:
# CHANGE-LOG
# ..........................................................................
# 2018-09-26 version 0.1.0
# - initial commit
# ..........................................................................
# 2018-09-27 version 0.1.1
# - adjusted packages;
# - added code information
# --------------------------------------------------------------------------

MAIN := Main
CLASSPATH := .:gson-2.8.5.jar
PACKAGEA := challenges/test/java
PACKAGEMAIN := lang/java

.PHONY : default main clean

default : main

main : $(PACKAGEMAIN)/Main.class

lang/java/Main.class : $(PACKAGEMAIN)/Main.java $(PACKAGEMAIN)/IA.java $(PACKAGEMAIN)/IParams.java $(PACKAGEMAIN)/IExpected.java \
	$(PACKAGEA)/A.java $(PACKAGEA)/Params.java $(PACKAGEA)/Expected.java
	javac -classpath $(CLASSPATH) $(PACKAGEMAIN)/Main.java

clean :
	rm -rfv *~ $(PACKAGEMAIN)/*{.class,~} $(PACKAGEA)/*{.class,~}
