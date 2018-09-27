MAIN := Main
CLASSPATH := .:gson-2.8.5.jar

.PHONY : default main clean

default : main

main : lang/java/Main.class

lang/java/Main.class : lang/java/Main.java lang/java/IA.java lang/java/AParams.java lang/java/AExpected.java \
	chall/enge/java/A.java chall/enge/java/Params.java chall/enge/java/Expected.java
	javac -classpath $(CLASSPATH) lang/java/Main.java

clean :
	rm -rfv *~ lang/java/*{.class,~} chall/enge/java/*{.class,~}
