build:
	rm -rf classes/*.class
	javac src/*.java -d classes/
play:
	java -cp '.:classes/' src.GameDriver
