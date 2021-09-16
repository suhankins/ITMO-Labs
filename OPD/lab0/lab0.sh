#!/bin/bash
#prep
mkdir lab0
cd lab0
#Task 1
touch galvantula3
echo "weight=31.5 height=31.0 atk=8 def=6" > galvantula3

mkdir jigglypuff3
cd jigglypuff3
mkdir tentacool
touch larvitar
echo "Ходы\nAncientpower Body Slam Dark Pulse Double-Edge Earth Power Iron Defense\nIron Head Iron Tail Mud-Slap Outrage Sleep Talk Snore Spite Stealth\nRock Superpower Uproar" > larvitar
mkdir braviary
touch hitmonlee
echo "satk=11 sdef=8\nspd=1" > hitmonlee
mkdir spinarak
cd ..

mkdir krookodile8
cd krookodile8
mkdir jolteon
mkdir starmie
touch magcargo
echo "Развитые способности  Weak Armor" > magcargo
mkdir mareep
mkdir joltik
touch milotic
echo "Способности\nWater Sport Refresh Water Pulse Twister Recover Captivate Aqua Tail\nRain Dance Hydro Pump Attract Safeguard Aqua Ring" > milotic
cd ..

touch pelipper9
echo "satk=9\nsdef=7 spd=7" > pelipper9

mkdir samurott2
cd samurott2
touch cottonee
echo "Тип покемона  GRASS NONE" > cottonee
mkdir aggron
touch duskull
echo "Развитые\nспособности  Cursed Body" > duskull
mkdir yamask
touch mandibuzz
echo "Живет  Desert\nMountain" > mandibuzz
touch electivire
echo "Развитые способности  Motor Drive Vital\nSpirit" > electivire
cd ..

touch sawsbuck5
echo "Ходы  Bounce Giga Drain Last Resort Megahorn‡ Seed\nBomb Sleep Talk Snore Synthesis Worry Seed" > sawsbuck5
#Task 2
chmod 620 galvantula3

chmod 312 jigglypuff3
chmod 500 jigglypuff3/tentacool
chmod 440 jigglypuff3/larvitar
chmod 537 jigglypuff3/braviary
chmod 004 jigglypuff3/hitmonlee
chmod 375 jigglypuff3/spinarak

chmod 512 krookodile8
chmod 500 krookodile8/jolteon
chmod 512 krookodile8/starmie
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
#Task 3
ln galvantula3 samurott2/duskullgalvantula

#can't write into a directory if i can't even access it :/
chmod 700 jigglypuff3/tentacool
chmod 700 samurott2
chmod 700 samurott2/cottonee
chmod 700 samurott2/mandibuzz
chmod 700 samurott2/duskull
cp -r samurott2 jigglypuff3/tentacool
#changing all the copied stuff to how it's supposed to be
chmod 062 jigglypuff3/tentacool/samurott2/cottonee
chmod 062 jigglypuff3/tentacool/samurott2/mandibuzz
chmod 006 jigglypuff3/tentacool/samurott2/duskull
chmod 317 jigglypuff3/tentacool/samurott2
#changing all the original stuff to how it's supposed to be
chmod 062 samurott2/cottonee
chmod 062 samurott2/mandibuzz
chmod 006 samurott2/duskull
chmod 317 samurott2
chmod 500 jigglypuff3/tentacool

cp pelipper9 jigglypuff3/larvitarpelipper

#tbh i'm kinda surprised that it works
cp sawsbuck5 samurott2/yamask

cat krookodile8/magcargo krookodile8/milotic > galvantula3_49

#we need permission to write to krookodile8
chmod 700 krookodile8
ln -s pelipper9 krookodile8/magcargopelipper
chmod 512 krookodile8

ln -s jigglypuff3 Copy_2
#Task 4
#changing permissions again...
chmod 700 jigglypuff3
chmod 700 jigglypuff3/spinarak
chmod 700 jigglypuff3/tentacool/samurott2
chmod 700 jigglypuff3/tentacool/samurott2/cottonee
chmod 700 jigglypuff3/hitmonlee
chmod 700 krookodile8/mareep
chmod 700 krookodile8/joltik
chmod 700 samurott2
chmod 700 samurott2/cottonee
#find . -type f -name "*e" | wc -m > temp
#sort -nr temp
#and going back... again
chmod 375 jigglypuff3/spinarak
chmod 062 jigglypuff3/tentacool/samurott2/cottonee
chmod 317 jigglypuff3/tentacool/samurott2
chmod 004 jigglypuff3/hitmonlee
chmod 312 jigglypuff3
chmod 337 krookodile8/mareep
chmod 333 krookodile8/joltik
chmod 062 samurott2/cottonee
chmod 317 samurott2