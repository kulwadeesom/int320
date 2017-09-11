##
# Plot T(n) against input size in log-log scale
# 
# Usage: python plot_sorting.py <RUNNING-TIME-RESULTS-FILE>
#
# Author: kulwadee.som@sit.kmutt.ac.th
#
##

import matplotlib.pyplot as plt
import sys

filename = sys.argv[1]
f = open(filename)
# x-axis: data size
X = f.readline().split(":")[1].split()
X = list(map(int, X))
# time unit of Y
tunit = f.readline().split(":")[1]
algorithms = []
runTimes = []
# sorting time of each algorithm
for line in f.readlines():
	algo, Ts = line.split(":")
	algorithms.append(algo.strip())
	runTime = list(map(float, Ts.split()))
	runTimes.append(runTime)

# plot graph
for i in range(len(runTimes)):
	plt.plot(X, runTimes[i], marker='o', label=algorithms[i])
plt.yscale('log', basey=2)
plt.xscale('log', basex=2)
plt.legend(loc='upper left')
plt.xlabel('Input size (N)')
plt.ylabel('T(N) %s' % (tunit))
plt.title('Running time of sorting algorithms (log-log plot)')
plt.savefig(filename.split('.')[0] + '.png')
plt.show()	
