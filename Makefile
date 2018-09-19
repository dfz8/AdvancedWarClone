build:
	rm -rf classes/*
	javac src/*.java -d classes/
play:
	java -cp '.:classes/' src.GameDriver
