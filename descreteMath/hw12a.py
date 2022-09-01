import itertools

a = ["u2-5", "u5-10", "u6-10", "u1-10", "u4-6", "u2-6", "u1-8", "u8-12", "u1-6"]

b = [
    ["u2-5", "u2-6", "u1-8", "u8-12", "u1-6"],
["u2-5", "u2-6", "u1-8", "u8-12", "u2-8"],
["u2-5", "u2-6", "u1-8", "u1-10", "u1-6"],
["u2-5", "u2-6", "u1-8", "u1-10", "u2-8"],
["u2-5", "u2-6", "u6-10", "u1-10", "u1-6"],
["u2-5", "u5-10", "u6-10", "u1-10"],
["u4-6", "u2-6", "u1-8", "u8-12", "u1-6"],
["u4-6", "u2-6", "u1-8", "u8-12", "u2-8"],
["u4-6", "u2-6", "u1-8", "u1-10", "u1-6"],
["u4-6", "u2-6", "u1-8", "u1-10", "u2-8"],
["u4-6", "u2-6", "u6-10", "u1-10", "u1-6"],
["u4-6", "u4-11", "u6-10"],
["u4-11", "u5-10", "u6-10"]

]

for i in range(len(b)):
    for j in range(len(b[i]) - 1, -1, -1):
        for u in a:
            if b[i][j] == u:
                del(b[i][j])
                break

for i in range(len(b) - 1, -1, -1):
    if len(b[i]) == 0:
        del(b[i])

b.sort()

b = list(k for k,_ in itertools.groupby(b))

for line in range(len(b)):
    print("ψ" + str(line + 1) + " " + str(b[line]).replace("'", ""))

for line in range(len(a)):
    print("")
    for pair in range(line, len(a)):
        print(len(a[line]) + len(a[pair]) - len(list(set(a[line]).intersection(a[pair]))), end="	")