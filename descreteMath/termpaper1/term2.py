for i in range(64):
    print(str(i) + "\t", end="")
    x = str(bin(i))[2:]
    x = (6 - len(x)) * "0" + x
    x = "\t".join(x)
    print(x + "\t", end="")
    
    x = (i - 1) % 57
    x = str(bin(x))[2:]
    x = (6 - len(x)) * "0" + x
    x = "\t".join(x)
    print(x)