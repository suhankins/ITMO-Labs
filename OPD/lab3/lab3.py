#the higher - the more precise the result is, but it will take longer to calculate
upper = 16
bottom = upper * -1
f = open("result.csv", "w")
f.write("X,Y,Z,A,B\n")

def prog(S,A,B):
    if S >= 0:
        return A
    elif S <= A:
        return A
    else:
        if add(S, S) and sub(S*2, B):
            return S * 2 - B
        else:
            return "ERROR"

def lab3(X,Y,Z,A,B):
    R = 0
    temp = prog(X,A,B)
    if temp == "ERROR":
        return
    if add(R, temp):
        R = R + temp
    else:
        return
    temp = prog(Y,A,B)
    if temp == "ERROR":
        return
    if add(R, temp):
        R = R + temp
    else:
        return
    temp = prog(Z,A,B)
    if temp == "ERROR":
        return
    if add(R, temp):
        R = R + temp
    else:
        return
    f.write("{},{},{},{},{}\n".format(X,Y,Z,A,B))
    #print("{}\t{}\t{}".format(X,A,B))

def add(A,B):
    if A + B < bottom or A + B > upper:
        return False
    return True

def sub(A,B):
    return add(A,B * -1)

#Case 2 and 3
#for A in range(bottom, 0):
#    for X in range(A+1, 0):
#        for B in range(bottom, upper + 1):
#            lab3(X,1,1,A,B)

#Case 4 and 5
#for A in range(bottom, 0):
#    for X in range(A+1, 0):
#        for Z in range(A+1, 0):
#            for B in range(bottom, upper + 1):
#                lab3(X,1,Z,A,B)

#Case 4 and 5
for A in range(bottom, -1):
    for X in range(A+1, 0):
        for Y in range(A+1, 0):
            for Z in range(A+1, 0):
                for B in range(bottom, upper + 1):
                    lab3(X,Y,Z,A,B)

f.close()

