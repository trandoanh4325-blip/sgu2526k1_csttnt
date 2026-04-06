import os

def solve_graph_coloring_text(file_path):
    try:
        with open(file_path, 'r') as f:
            lines = f.read().splitlines()
    except FileNotFoundError:
        print("Không tìm thấy file!")
        return

    if not lines:
        return

    # Lấy số lượng thành phố
    n = int(lines[0].strip())

    # Tạo từ điển để lưu bản đồ các thành phố nối nhau
    adj = {}

    # Đọc các cạnh (mỗi dòng gồm 2 thành phố bằng CHỮ)
    for line in lines[1:]:
        parts = line.split()
        if len(parts) == 2:
            # Ở đây ta KHÔNG DÙNG int() nữa để nó hiểu là chữ
            u, v = parts[0], parts[1]
            if u not in adj: adj[u] = set()
            if v not in adj: adj[v] = set()
            adj[u].add(v)
            adj[v].add(u)

    # Lấy danh sách tên tất cả các bang
    vertices = list(adj.keys())

    # THUẬT TOÁN WELSH-POWELL
    vertices.sort(key=lambda x: (-len(adj[x]), x))

    colors = []
    uncolored = set(vertices)

    while uncolored:
        current_color_group = []
        for v in vertices:
            if v in uncolored:
                if all(c not in adj[v] for c in current_color_group):
                    current_color_group.append(v)  
                    uncolored.remove(v)            

        colors.append(sorted(current_color_group))

    # In kết quả
    print(f"Số màu k cần tô: {len(colors)}")
    for i, group in enumerate(colors):
        print(f"Màu {i+1}: " + " ".join(group))

# Chạy chương trình
if __name__ == "__main__":
    # Tự động dò tìm thư mục đang đứng
    current_dir = os.path.dirname(os.path.abspath(__file__))
    file_path = os.path.join(current_dir, "tomau.inp")
    
    print(f"Đang đọc dữ liệu từ file: {file_path}")
    solve_graph_coloring_text(file_path)