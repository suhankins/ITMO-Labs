while True:
    a = int(input().replace(" ", ""), 2)
    b = int(input().replace(" ", ""), 2)
    c = int(input().replace(" ", ""), 2)

    print("".join(str(bin(a + b + c)))[2:])