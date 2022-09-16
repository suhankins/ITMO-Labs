line = input()
indexTable = {
    "ю": "C0",
    "а": "C1",
    "б": "C2",
    "ц": "C3",
    "д": "C4",
    "е": "C5",
    "ф": "C6",
    "г": "C7",
    "х": "C8",
    "и": "C9",
    "й": "CA",
    "к": "CB",
    "л": "CC",
    "м": "CD",
    "н": "CE",
    "о": "CF",
    
    "п": "D0",
    "я": "D1",
    "р": "D2",
    "с": "D3",
    "т": "D4",
    "у": "D5",
    "ж": "D6",
    "в": "D7",
    "ь": "D8",
    "ы": "D9",
    "з": "DA",
    "ш": "DB",
    "э": "DC",
    "щ": "DD",
    "ч": "DE",
    "ъ": "DF",

    "Ю": "E0",
    "А": "E1",
    "Б": "E2",
    "Ц": "E3",
    "Д": "E4",
    "Е": "E5",
    "Ф": "E6",
    "Г": "E7",
    "Х": "E8",
    "И": "E9",
    "Й": "EA",
    "К": "EB",
    "Л": "EC",
    "М": "ED",
    "Н": "EE",
    "О": "EF",
        
    "П": "F0",
    "Я": "F1",
    "Р": "F2",
    "С": "F3",
    "Т": "F4",
    "У": "F5",
    "Ж": "F6",
    "В": "F7",
    "Ь": "F8",
    "Ы": "F9",
    "З": "FA",
    "Ш": "FB",
    "Э": "FC",
    "Щ": "FD",
    "Ч": "FE",
    "Ъ": "FF"
}

line = list(line)
print(hex(len(line)))
result = []
for i in line:
    if i in indexTable:
        result.append(indexTable[i])
    else:
        result.append(str(hex(ord(i))).replace("0x", ""))

for i in range(0, len(result), 2):
    temp = result[i]
    if (i+1 >= len(result)):
        result.append("00")
    result[i] = result[i+1]
    result[i+1] = temp

ptr = 0x555

for i in range(0, len(result), 2):
    #print(hex(ptr), end=" ")
    print(result[i] + result[i+1], end=", ")
    ptr = ptr + 1
