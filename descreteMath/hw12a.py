a = [["u1-6"],
["u6-10"]]

b = [["u1-8", "u1-6"],
["u2-6", "u1-10"]]

#for i in b:
#    for j in a:
#        for u in j:
#            if not (u in i):
#                j.remove(u)

for line in range(len(a)):
    print("ψ" + str(line + 1) + " " + str(a[line]).replace("'", ""))

for line in range(len(a)):
    print("")
    for pair in range(line, len(a)):
        print(len(a[line]) + len(a[pair]) - len(list(set(a[line]).intersection(a[pair]))), end="	")