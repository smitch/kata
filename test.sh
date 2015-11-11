#! /bin/bash

file="6lengthwordlist.txt"

echo -n "" > $file
for word in `cat wordlist.txt`; do
  if [ `echo -n $word | wc -c` == 6 ]; then
    echo $word >> $file
  fi
done
