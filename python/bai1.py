V={"San francisco","los Angeles","Denver","Chicago","Detroit","New york","Washington"}
E={("San Francisco","Los Angeles"),("San francisco","Denver"),("Los Angeles","Denver"),("Denver","Chicago"),("Chicago","Detroit"),("Detroit","New York"),("New York","Washington"),("Chicago","Washington"),("Chicago","New York"),}
#chuan hoa moi canh, de tranh trung lap
E={tuple(sorted(e)) for e in E}
#xay dung danh sach ke
from collections import defaultdict 
adj=defaultdict(set)
for u,v in E:
    adj[u].add(v)
    adj[v].add(u)
#ham tien ich
def neighbors(vertex: str):

    if vertex not in V:
     raise ValueError(f"dinh '{vertex}' khong ton tai trong do thi")
    return sorted(adj [vertex])
def degree(vertex: str) -> int:

    return len(adj[vertex])
print("cac dinh hop le:",",".join(sorted(V)))
s= input("nhap ten cua dinh:").strip()
if s not in V: 
    print(f"dinh '{s}' khong co trong do thi")
else:
    nb = neighbors(s)
    print(f"dinh ke voi {s}: {','.join(nb) if nb else '(khong co)'}")
    print(f"bac cua {s}: {degree(s)}")
