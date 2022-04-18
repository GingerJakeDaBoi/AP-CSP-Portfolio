import os
import psutil
from time import time, sleep

while True:
    sleep(10 - time() % 10)
    load1, load5, load15 = psutil.getloadavg()
    cpu_usage = (load15/os.cpu_count()) * 100

    print('CPU usage is: ', psutil.cpu_percent(4))


    print("--------------------------------------------------------")
    print('RAM % used:', psutil.virtual_memory()[2])

    print("========================================================")