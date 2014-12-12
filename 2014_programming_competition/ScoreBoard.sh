#!/bin/bash

echo -e "|================================Scoreboard=====================================|\r"
echo -e "* Team				Prob1	Prob2	Prob3	Prob4	Prob5	Score	*\r"

while read line
do
echo -n "* "
echo -n ${line}
	cat /home/${line}/score.file | tr "\n" " "
echo -e "\t*\r"
done < /root/Desktop/teams.txt

echo "|===============================================================================|"
