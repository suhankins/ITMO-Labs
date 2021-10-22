#ISU number: 338925
#Eyes : 0 ":"
#Nose : 1 "<"
#Mouth: 6 "P"
#Smiley face: :<P
import re

regex = r":<P"

tests = ["blbalbal  balb :<Ps dfsdfs fs:(D@ XC:<DK:<P >SMAIJR: SO:<P) ):<><",
         "Lorem ipsum dolor sit amet, :-) consectetur :<P adipiscing elit. :)",
         "i really don't quite understand why we need 5 test :<",
         "how are you anyways?", "i'm doing good:<P"]

for test in tests:
    print(test)
    print(f"Found smiley faces: {len(re.findall(regex, test))}")
