while True:
    a = str(bin(int(input())))[2:]
    a = "0" * (16 - len(a)) + a
    x = []
    for i in range(0, len(a)):
        x.append(a[i])
        if (i % 4 == 3 and not i == 1):
            x.append(".")

    print("\t".join(x))
