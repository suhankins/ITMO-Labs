import networkx as nx

G = nx.Graph()

a = [("u1-6", "u2-8"),
("u1-10", "u4-11"),
("u1-8", "u4-11"),
("u1-6", "u4-11"),
("u2-8", "u4-11"),
("u2-6", "u4-11"),
("u2-5", "u4-11"),
("u2-5", "u4-6"),
("u1-8", "u5-10"),
("u1-6", "u5-10"),
("u2-8", "u5-10"),
("u2-6", "u5-10"),
("u4-6", "u5-10"),
("u1-8", "u6-10"),
("u2-8", "u6-10"),
("u8-12", "u1-10"),
("u4-11", "u8-12"),
("u5-10", "u8-12"),
("u6-10", "u8-12")]

G.add_edges_from(a)

result = list(nx.find_cliques(nx.complement(G)))

for line in range(len(result)):
    print("ψ" + str(line + 1) + " " + str(result[line]).replace("'", ""))

for line in range(len(result)):
    print("")
    for pair in range(line, len(result)):
        print(len(result[line]) + len(result[pair]) - len(list(set(result[line]).intersection(result[pair]))), end="	")