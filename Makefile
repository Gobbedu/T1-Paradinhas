all: QuebraDeBarreira.jar

QuebraDeBarreira.jar:
	javac -d . gui.java
	jar cvmf MANIFEST.MF QuebraDeBarreira.jar *.class
	make clean

clean:
	-rm -f *.class 

purge: clean
	-rm -f QuebraDeBarreira.jar
