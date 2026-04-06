"""
Buổi 4: Tìm kiếm trong không gian trạng thái
"""

import pprint
import os

# ============================================================================
# Bài 1. Biễu diễn đồ thị
# ============================================================================

print("=" * 80)
print("BÀI 1: BIỂU DIỄN ĐỒ THỊ")
print("=" * 80)

# 1. Danh sách kề
ADJ = {
    'A': ['C', 'E', 'D', 'F'],
    'B': [],
    'C': ['H'],
    'D': ['H', 'E'],
    'E': ['K', 'I'],
    'F': ['I', 'G'],
    'G': [],
    'H': ['K'],
    'I': ['B','K'],
    'K': ['B']
}

print("\n1. Danh sách kề:")
pprint.pprint(ADJ)

# 2. Thao tác duyệt đồ thị
print("\n" + "=" * 80)
print("2. THAO TÁC DUYỆT ĐỒ THỊ")
print("=" * 80)

print("\n(a) Liệt kê các đỉnh trong đồ thị")
print("Các đỉnh của đồ thị: ", end=" ")
V = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K']
for v in V:
    print(v, end=" ")
print()

print("\n(b) Liệt kê tất cả các cạnh đồ thị hiển thị dạng danh sách kề")
print("Danh sách kề của đồ thị: ")

def HienThiDoThi(G):
    for dinh in sorted(G):
        print(f"+ Đỉnh {dinh}: ", end="")
        for ke in sorted(G[dinh]):
            print(f"{ke}, ", end="")
        print()

HienThiDoThi(ADJ)

print("\n(c) Cho hai đỉnh A, B. Hỏi hai đỉnh A, B có kề nhau không?")

def LaKe(G, a, b):
    """
    input: G, a, b
    return: 
    + -1: đỉnh a, hay b không tồn tại
    +  0: đỉnh a, b tồn tại và a không kề b
    +  1: đỉnh a, b tồn tại và a, b kề nhau
    """
    result = None
    if a not in G or b not in G:
        result = -1
    elif b in G[a]:
        result = 1
    else:
        result = 0
    return result

a = "L"; b = "R"; print(f"{a} kề {b}: {LaKe(ADJ, a, b)}")
a = "A"; b = "R"; print(f"{a} kề {b}: {LaKe(ADJ, a, b)}")
a = "E"; b = "D"; print(f"{a} kề {b}: {LaKe(ADJ, a, b)}")
a = "D"; b = "E"; print(f"{a} kề {b}: {LaKe(ADJ, a, b)}")

print("\n(d) Cho một đỉnh A. Hỏi danh sách các đỉnh kề với A")

def LayKe(G, a):
    """
    input: G, a
    return: 
    + None: nếu a không tồn tại
    + []  : a không kề với bất kỳ đỉnh nào
    + [x, y, ...]: mảng các đỉnh kề với a
    """
    result = None
    if a not in G:
        result = None
    else:
        result = sorted(G[a])
    return result

a = "P"; print(f"Danh sách kề với đỉnh {a}: {LayKe(ADJ, a)}")
a = "A"; print(f"Danh sách kề với đỉnh {a}: {LayKe(ADJ, a)}")
a = "B"; print(f"Danh sách kề với đỉnh {a}: {LayKe(ADJ, a)}")
a = "D"; print(f"Danh sách kề với đỉnh {a}: {LayKe(ADJ, a)}")

# 3. Đọc và lưu đồ thị
print("\n" + "=" * 80)
print("3. ĐỌC VÀ LƯU ĐỒ THỊ")
print("=" * 80)

print("\n1. Lưu đồ thị xuống tập tin")

def LuuDoThi(file_path, G, verbose=True):
    """
    Lưu đồ thị xuống file
    return:
    + True: lưu thành công
    + False: lưu thất bại
    """
    try:
        with open(file_path, "wt", encoding="utf-8") as file:
            file.write(f"{len(G)}\n")
            for dinh in sorted(G):
                file.write(f"{dinh}: {' '.join(sorted(G[dinh]))} \n")
        
        if verbose:
            print(f"Lưu đồ thị thành công xuống tập tin: {file_path}")
        return True
    except:
        if verbose:
            print(f"Lưu đồ thị thất bại!")
        return False

LuuDoThi("dske1.txt", ADJ, verbose=True)

# Hiển thị nội dung file
print("\nNội dung file dske1.txt:")
with open("dske1.txt", "rt", encoding="utf-8") as file:
    lines = file.readlines()
    for line in lines:
        print(line, end="")

print("\n\n2. Đọc đồ thị từ tập tin")

def DocDoThi(file_path, verbose=True):
    """
    return:
    + None: đọc thất bại
    + <>None: trả về đồ thị
    """
    result = None
    
    if os.path.exists(file_path) == False:
        result = None
    else:
        G = {}
        with open(file_path, "rt", encoding="utf-8") as file:
            n = int(file.readline())
            for _ in range(n):
                line = file.readline().strip()
                if line == "":
                    continue

                left, right = line.split(":")
                dinh = left.strip()

                if right.strip() == "":
                    G[dinh] = []
                else:
                    G[dinh] = right.strip().split()
            
        if verbose:
            print(f"Đọc đồ thị thành công từ tập tin: {file_path}")

        result = G
    return result

G1 = DocDoThi("dske1.txt", verbose=True)
G1_sorted = {dinh: sorted(G1[dinh]) for dinh in sorted(G1)}
pprint.pprint(G1_sorted)

# ============================================================================
# Bài 2. Tìm kiếm đường đi trên đồ thị
# ============================================================================

print("\n\n" + "=" * 80)
print("BÀI 2: TÌM KIẾM ĐƯỜNG ĐI TRÊN ĐỒ THỊ")
print("=" * 80)

# 1. Tìm kiếm theo chiều rộng (BFS)
print("\n1. TÌM KIẾM THEO CHIỀU RỘNG (BFS)")
print("-" * 80)

def BFS(G, start, goal):
    """
    return: 
    + mảng chứa đường đi từ a --> b, nếu rỗng là không có đường đi
    + None: đỉnh a, b không hợp lệ
    """
    result = None
    
    if G.get(start) is None or G.get(goal) is None:
        result = None
    else:
        path = {}     # path[a]=b nghĩa là muốn đi tới đỉnh b phải qua a
        s_open   = []
        s_closed = []
        
        # đưa start vào open
        s_open.append(start)    
        path[start] = None
        while len(s_open) > 0:
            u = s_open.pop(0)      # lấy đỉnh đầu tiên trong OPEN (FIFO)
            s_closed.append(u)    # đưa vào CLOSED

            # nếu đã tới đích thì dừng
            if u == goal:
                break

            # duyệt các đỉnh kề của u
            for v in sorted(G[u]):
                if v not in s_open and v not in s_closed:
                    s_open.append(v)
                    path[v] = u     
    return path

path_bfs = BFS(ADJ, "A", "B")
print("\nBFS từ A tới B:")
print("Path dict:")
pprint.pprint(path_bfs)

def find_path(path, start, goal):
    """
    Cho mảng truy hồi đường, tìm danh sách đỉnh từ start --> goal
    """
    result = []
    
    if path is None or goal not in path:
        return []

    cur = goal
    while cur is not None:
        result.append(cur)
        cur = path[cur]

    result.reverse()
    return result

path_list = find_path(path_bfs, 'A', 'B')
print(f"\nĐường đi từ A tới B (BFS): {path_list}")

# 2. Tìm kiếm theo chiều sâu (DFS)
print("\n\n2. TÌM KIẾM THEO CHIỀU SÂU (DFS)")
print("-" * 80)

def DFS(G, start, goal):
    """
    return: 
    + mảng chứa đường đi từ a --> b, nếu rỗng là không có đường đi
    + None: đỉnh a, b không hợp lệ
    """
    result = None
    
    if G.get(start) is None or G.get(goal) is None:
        result = None
    else:
        path = {}     # path[a]=b nghĩa là muốn đi tới đỉnh b phải qua a
        s_open   = []
        s_closed = []
        
        # đưa start vào open
        s_open.append(start)    
        path[start] = None
        
        while len(s_open) > 0:
            u = s_open.pop()        # lấy đỉnh ở ĐỈNH STACK (LIFO)
            s_closed.append(u)     # đưa vào CLOSED

            # nếu đã tới đích thì dừng
            if u == goal:
                break

            # duyệt các đỉnh kề của u
            for v in sorted(G[u]):
                if v not in s_open and v not in s_closed:
                    s_open.append(v)
                    path[v] = u

    return path

path_dfs = DFS(ADJ, "A", "B")
print("\nDFS từ A tới B:")
print("Path dict:")
pprint.pprint(path_dfs)

path_list_dfs = find_path(path_dfs, 'A', 'B')
print(f"\nĐường đi từ A tới B (DFS): {path_list_dfs}")

print("\n" + "=" * 80)
print("KẾT THÚC")
print("=" * 80)