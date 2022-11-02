# Question: https://leetcode.com/problems/word-frequency/
# Created on: 2022-11-03

#!/usr/bin/bash

declare -A freq

while read -r line; do
	IFS=' ' read -r -a temp <<< "$line"
	for word in "${temp[@]}"
	do
		if [[ -z "${freq[$word]}" ]]; then
			freq[$word]=1
		else
			freq[$word]=$((freq[$word] + 1))
		fi
	done
done < words.txt

for key in "${!freq[@]}"; do
	echo "$key ${freq[$key]}"
done | sort -rn -k2

