# -*- coding: utf-8 -*-
from collections import defaultdict
import pydot
import matplotlib.pyplot as plt
import matplotlib.image as mpimg

# Danh sách đỉnh
V = {
    "San Francisco", "Los Angeles", "Denver", "Chicago",
    "Detroit", "New York", "Washington"
}

# Danh sách cạnh ban đầu
E = {
    ("San Francisco", "Los Angeles"),
    ("San Francisco", "Denver"),
    ("Los Angeles", "Denver"),
    ("Denver", "Chicago"),
    ("Chicago", "Detroit"),
    ("Detroit", "New York"),
    ("New York", "Washington"),
    ("Chicago", "Washington"),
    ("Chicago", "New York"),
}

# Chuẩn hóa cạnh (vô hướng: mỗi cặp chỉ giữ 1 chiều)
E = {tuple(sorted(e)) for e in E}

# Xây dựng danh sách kề
adj = defaultdict(set)
for u, v in E:
    adj[u].add(v)
    adj[v].add(u)

# Hàm trả về các đỉnh kề
def neighbors(vertex: str):
    if vertex not in V:
        raise ValueError(f"Đỉnh '{vertex}' không tồn tại trong đồ thị.")
    return sorted(adj[vertex])

# Hàm tính bậc của đỉnh
def degree(vertex: str) -> int:
    return len(adj[vertex])

# In danh sách đỉnh hợp lệ
print("Các đỉnh hợp lệ:", ", ".join(sorted(V)))

# Nhập từ người dùng
s = input("Nhập tên của đỉnh: ").strip()
if s not in V:
    print(f"Đỉnh '{s}' không có trong đồ thị.")
else:
    nb = neighbors(s)
    print(f"Đỉnh kề với {s}: {', '.join(nb) if nb else '(không có)'}")
    print(f"Bậc của {s}: {degree(s)}")

# Tạo đồ thị vô hướng bằng pydot
G = pydot.Dot(graph_type="graph", rankdir="LR", splines="true", overlap="false")

# Vị trí đặt đỉnh (để điều khiển vị trí khi vẽ)
pos = {
    "San Francisco": (0, 2),
    "Los Angeles": (0.7, 0),
    "Denver": (3.2, 1.5),
    "Chicago": (6.6, 2.3),
    "Detroit": (8.1, 3.6),
    "New York": (10.7, 2.8),
    "Washington": (9.6, 1.2),
}

# Thêm nút
for v in V:
    x, y = pos.get(v, (0, 0))
    node = pydot.Node(
        v,
        shape="circle",
        style="filled",
        fillcolor="white",
        fontcolor="black",
        color="black",
        width="0.5",
        height="0.5",
        label=v,
        fontsize="14",
        fontname="Arial Bold",
        pos=f"{x},{y}!",
    )
    G.add_node(node)

# Thêm cạnh
for u, v in E:
    edge = pydot.Edge(u, v, penwidth="2")
    G.add_edge(edge)

# Xuất ảnh PNG
output_file = "us_cities_graph.png"
G.write_png(output_file)
print(f"Đã vẽ đồ thị: {output_file} (cùng thư mục script).")

# Hiển thị ảnh bằng matplotlib
img = mpimg.imread(output_file)
plt.figure(figsize=(8, 6))
plt.imshow(img)
plt.axis("off")
plt.show()
