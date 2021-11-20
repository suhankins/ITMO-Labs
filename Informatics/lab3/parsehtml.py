import re
import json

file = open("schedule.txt", encoding="utf-8").read()

spanRegex = r"(?<=<span>)(.*)(?=<\/span)"
ddRegex = r"(?<=<dd>)(.*)(?=<\/dd)"
lessonsRegex = r"(?<=<td class=\"lesson-format\">)(.*)(?=<\/td>)"
divRegex = r"(?<=<div>)(.*)(?=<\/div>)"
namesRegex = r"[А-я]+ [А-я]+ [А-я]+" #worked in my example *shrug*

spans = re.findall(spanRegex, file)
dds = re.findall(ddRegex, file)
lessonsFormats = re.findall(lessonsRegex, file)
divs = re.findall(divRegex, file)
names = re.findall(namesRegex, file)

toJson = {}
toJson["weekday"] = spans[0]
toJson["lessons"] = []
print("Weekday: " + toJson["weekday"])

lessonsCount = len(divs)
for i in range(lessonsCount):
    toJson["lessons"].append({})
    print("====")
    print(spans[i * 3 + 1]) #time
    toJson["lessons"][-1]["time"] = spans[i * 3 + 1]
    print(spans[i * 3 + 2]) #place
    toJson["lessons"][-1]["place"] = spans[i * 3 + 2]
    print(dds[i * 2])       #room
    toJson["lessons"][-1]["room"] = dds[i * 2]
    print(dds[i * 2 + 1])   #name
    toJson["lessons"][-1]["name"] = dds[i * 2 + 1]
    print(divs[i])          #groups
    toJson["lessons"][-1]["groups"] = divs[i]
    print(lessonsFormats[i]) #format
    toJson["lessons"][-1]["format"] = lessonsFormats[i]
    print(names[i])         #teacher
    toJson["lessons"][-1]["teacher"] = names[i]

result = json.dumps(toJson, ensure_ascii=False)
f = open("schedule.json", "w")
f.write(result)
f.close()
