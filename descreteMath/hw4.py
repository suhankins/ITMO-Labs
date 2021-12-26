a = int(input().replace(" ", ""), 2)
b = int(input().replace(" ", ""), 2)

print(" ".join(str(bin(a + b))[-8:]))