import random

words = ["ultimate", "special", "car", "beep", "boat", "destroyer", "road", "runner", "driver", "truck", "panic", "edition", "big", "small", "writable", "racer", "speed", "fast", "gun", "unreal", "sport", "wheels"]
vehicle = ["BOAT", "HOVERBOARD", "PLANE"]
fuel = ["ANTIMATTER", "ELECTRICITY", "MANPOWER"]

f = open("demo.txt", "w")
for i in range(random.randrange(25,75)):
    f.write("insert " + str(random.randrange(9999))) #KEY
    f.write("\n")
    f.write(random.choice(words) + " " + random.choice(words)) #NAME
    f.write("\n")
    f.write(str(random.randrange(-250,250) + random.random())) #X
    f.write("\n")
    f.write(str(random.randrange(-250,250))) #Y
    f.write("\n")
    f.write(str(random.randrange(1,100))) #POWER
    f.write("\n")
    f.write(str(random.randrange(1,20))) #WHEELS
    f.write("\n")
    f.write(random.choice(vehicle))
    f.write("\n")
    f.write(random.choice(fuel))
    f.write("\n")
f.close()
