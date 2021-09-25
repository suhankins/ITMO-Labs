#!/bin/bash

#Variant 916

#////////////Prep////////////
mkdir lab0
cd lab0

#////////////Task 1////////////
touch galvantula3
echo 'weight=31.5 height=31.0 atk=8 def=6' > galvantula3

mkdir jigglypuff3
cd jigglypuff3
mkdir tentacool

touch larvitar
echo 'Ходы' > larvitar
echo 'Ancientpower Body Slam Dark Pulse Double-Edge Earth Power Iron Defense' >> larvitar
echo 'larvitar Iron Head Iron Tail Mud-Slap Outrage Sleep Talk Snore Spite Stealth' >> larvitar
echo 'Rock Superpower Uproar' >> larvitar

mkdir braviary
touch hitmonlee
echo 'satk=11 sdef=8' > hitmonlee
echo 'spd=1' >> hitmonlee
mkdir spinarak
cd ..

mkdir krookodile8
cd krookodile8
mkdir jolteon
mkdir starmie
touch magcargo
echo 'Развитые способности  Weak Armor' > magcargo
mkdir mareep
mkdir joltik
touch milotic
echo 'Способности' > milotic
echo 'Water Sport Refresh Water Pulse Twister Recover Captivate Aqua Tail' >> milotic
echo 'Rain Dance Hydro Pump Attract Safeguard Aqua Ring' >> milotic
cd ..

touch pelipper9
echo 'satk=9' > pelipper9
echo 'sdef=7 spd=7' >> pelipper9

mkdir samurott2
cd samurott2
touch cottonee
echo 'Тип покемона  GRASS NONE' > cottonee
mkdir aggron
touch duskull
echo 'Развитые' > duskull
echo 'способности  Cursed Body' >> duskull
mkdir yamask
touch mandibuzz
echo 'Живет  Desert' > mandibuzz 
echo 'Mountain' >> mandibuzz
touch electivire
echo 'Развитые способности  Motor Drive Vital' > electivire
echo 'Spirit' >> electivire
cd ..

touch sawsbuck5
echo 'Ходы  Bounce Giga Drain Last Resort Megahorn‡ Seed' > sawsbuck5 
echo 'Bomb Sleep Talk Snore Synthesis Worry Seed' >> sawsbuck5

#////////////Task 2////////////
chmod u=rw,g=w,o= galvantula3

chmod u=wx,g=x,o=w jigglypuff3
chmod 500 jigglypuff3/tentacool
chmod 440 jigglypuff3/larvitar
chmod u=rx,g=wx,o=rwx jigglypuff3/braviary
chmod u=,g=,o=r jigglypuff3/hitmonlee
chmod u=wx,g=rwx,o=rx jigglypuff3/spinarak

chmod u=rx,g=x,o=w krookodile8
chmod 500 krookodile8/jolteon
chmod u=rx,g=x,o=w krookodile8/starmie
chmod 620 krookodile8/magcargo
chmod 337 krookodile8/mareep
chmod 333 krookodile8/joltik
chmod 620 krookodile8/milotic

chmod 422 pelipper9

chmod 317 samurott2
chmod 062 samurott2/cottonee
chmod 524 samurott2/aggron
chmod 006 samurott2/duskull
chmod 737 samurott2/yamask
chmod 062 samurott2/mandibuzz
chmod 400 samurott2/electivire

chmod 400 sawsbuck5

#////////////Task 3////////////
ln galvantula3 samurott2/duskullgalvantula

#FIX: Permission denied
chmod 700 jigglypuff3/tentacool
chmod 700 samurott2
chmod 700 samurott2/cottonee
chmod 700 samurott2/mandibuzz
chmod 700 samurott2/duskull
cp -r samurott2 jigglypuff3/tentacool
#Changing all the copied stuff to how it's supposed to be
chmod 062 jigglypuff3/tentacool/samurott2/cottonee
chmod 062 jigglypuff3/tentacool/samurott2/mandibuzz
chmod 006 jigglypuff3/tentacool/samurott2/duskull
chmod 317 jigglypuff3/tentacool/samurott2
#Changing all the original stuff to how it's supposed to be
chmod 062 samurott2/cottonee
chmod 062 samurott2/mandibuzz
chmod 006 samurott2/duskull
chmod 317 samurott2
chmod 500 jigglypuff3/tentacool

cp pelipper9 jigglypuff3/larvitarpelipper

cp sawsbuck5 samurott2/yamask

cat krookodile8/magcargo krookodile8/milotic > galvantula3_49

#FIX: Permission denied
chmod 700 krookodile8
ln -s pelipper9 krookodile8/magcargopelipper
chmod 512 krookodile8

ln -s jigglypuff3 Copy_2

#////////////Task 4////////////
#1
#second grep is used to avoid printing krookodile8/starmie as it is not a file
wc -m * */* */*/* */*/*/* 2> /dev/null | grep 'e$' | grep -v ' 0 ' | sort

#2
#second grep is used to avoid printing directories
ls -R -t -1 -o 2> /dev/null | grep 'jo' | grep -v '/' 

#3
cat -n jigglypuff3/larvitar | sort -k 2
#ERROR: cannot open jigglypuff3/hitmonlee
cat -n jigglypuff3/hitmonlee 2> /dev/null | sort -k 2

#4
#ERROR: Permission denied
ls -R samurott2 2> /tmp/lab0log | grep -v "\.:" | grep -v "\./" | sort

#5
ls -R -1 -o -r 2> /dev/null | grep -v "\.:" | grep -v "\./" | grep -v "total" | grep "." | head -n 3 | sort -k 2

#6
cat jigglypuff3/larvitar 2> /dev/null | grep -v -i "r$"
cat jigglypuff3/hitmonlee 2> /dev/null | grep -v -i "r$"
cat krookodile8/magcargo 2> /dev/null | grep -v -i "r$"
cat krookodile8/milotic 2> /dev/null | grep -v -i "r$"
cat samurott2/cottonee 2> /dev/null | grep -v -i "r$"

#////////////Task 5////////////
#FIX: Permission denied
chmod 600 sawsbuck5
rm sawsbuck5

#FIX: Permission denied
chmod 600 samurott2/mandibuzz
rm samurott2/mandibuzz

#FIX: Permission denied
chmod 700 krookodile8
rm krookodile8/magcargopelipp*
#changing it back
chmod 512 krookodile8

#FIX: No such file or directory
chmod 700 samurott2
rm samurott2/duskullgalvantu*
#changing it back
chmod 317 samurott2

#FIX: Search or write permission needed
chmod 700 krookodile8
chmod 700 krookodile8/starmie
rmdir krookodile8/starmie
#changing it back
chmod 512 krookodile8

#FIX: Permission denied
chmod -R 700 krookodile8
rm -r krookodile8