import pyperclip

while True:
    a = int(input().replace(" ", ""), 2)
    b = int(input().replace(" ", ""), 2)
    c = ""
    if a < b:
        c = " ".join(str(bin((a + 256) - b))[2:])
        print("lower")
    else:
        c = " ".join(str(bin(a - b))[2:])
        print("more")
    print(c)
    pyperclip.copy(c)