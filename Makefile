sort:
	javac dsa/sorting/*.java
	java -cp . dsa.sorting.SortingExperiment > sorting.txt
	python plot_sorting.py sorting.txt
