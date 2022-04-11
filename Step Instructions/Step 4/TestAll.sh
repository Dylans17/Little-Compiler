#!/bin/bash

for i in $(ls inputs/*); do
        f=${i##*/}
        ./Micro.sh ${i} > ${f/.micro/.out};
        diff -Naur -B -b -s ${f/.micro/.out} outputs/${f/.micro/.out};
done
