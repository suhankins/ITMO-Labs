#ISU number: 338925
#var 21
#JSON to YAML

import yaml
import json

def convert():
    f = open("schedule.json", encoding='unicode_escape')
    text = json.loads(f.read())
    f.close()

    text = yaml.dump(text)

    f = open("librarySchedule.yml", mode="w")
    f.write(text)
    f.close()

if __name__ == '__main__':
    convert()
