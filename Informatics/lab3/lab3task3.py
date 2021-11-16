import time
import lab3task0
import lab3task1

print("Now testing my interpreter")
start_time = time.time()
for i in range(10):
    lab3task0.convert()
print("--- %s seconds ---" % (time.time() - start_time))

print("Now testing some other library")
start_time = time.time()
for i in range(10):
    lab3task1.convert()
print("--- %s seconds ---" % (time.time() - start_time))
