#ISU number: 338925
#Eyes : 0 ":"
#Nose : 1 "<"
#Mouth: 6 "P"
#Smiley face: :<P
import re

regex = r":<P"

tests = ["blbalbal  balb :<P fs:(D@ XC:<DK :<P >SMAIJR: SO:<P) ):<><", #3
         "Lorem ipsum sit, :-) consectetur :<P adipiscing elit. :)", #1
         "i really don't quite understand why we need 5 test :<", #0
         "how are you anyways?", #0
         "i'm doing good:<P"] #1

for test in tests:
    print(test)
    print(f"Found smiley faces: {len(re.findall(regex, test))}")
