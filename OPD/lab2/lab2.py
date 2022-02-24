ARRAY = [
0x0700,     #4B5
0xF912,     #4B6
0x54A5,     #4B7
0xF900      #4B8
]

A = 0x04B5 #4A3
B = 0x0200 #4A4
L = 0xE000 #4A5
D = 0x0200 #4A6

AC = 0      #4A7
D = AC      #4A8
AC = 4      #4A9
L = AC      #4AA
AC = AC + A #4AB
B = AC      #4AC

while True:
    B -= 1
    print(B)
    AC = ARRAY[B - 0x4B6]      #4AD
    if (AC >= 32768):            #4AE
        AC = D
        AC = AC + 1              #4B1
        D = AC                   #4B0
    L -= 1
    print(hex(D))
    if (L >= 32768 or L == 0): #4B2
        print("Done!")
        exit()
