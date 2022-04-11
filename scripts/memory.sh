#!/bin/bash

time = date+%m-%d-%Y
cd ~/Telemetrics/Memory/
touch ~/Telemetrics/Memory/mem.txt
echo free -h | grep Mem: > ~/Telemetrics/Memory/mem.txt
mv mem.txt $time


