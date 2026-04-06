import os

def solve_graph_coloring_bai5(file_path):
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            lines = f.read().strip().split('\n')
    except FileNotFoundError:
        print(f"Lỗi: Không tìm thấy file dữ liệu '{file_path}'!")
        print("Vui lòng kiểm tra lại xem file đã được tạo và đặt đúng chỗ chưa.")
        return

    if not lines or not lines[0]:
        return

    n = int(lines[0].strip())

    # Tạo danh sách kề
    adj = {}
    for line in lines[1:]:
        parts = line.strip().split()
        if len(parts) == 2:
            u, v = parts[0], parts[1]
            if u not in adj: adj[u] = set()
            if v not in adj: adj[v] = set()
            adj[u].add(v)
            adj[v].add(u)
        
    vertices = sorted(list(adj.keys()), key=lambda x: (-len(adj[x]), x))


    def greedy_coloring():
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
        return colors
    
    def is_safe(v, color, assignment):
        """Kiểm tra xem tô màu 'color' cho bang 'v' có bị trùng với hàng xóm không"""
        for neighbor in adj.get(v, []):
            if neighbor in assignment and assignment[neighbor] == color:
                return False
        return True

    def backtrack(idx, k, assignment):
        """Hàm đệ quy vét cạn thử tô k màu"""
        if idx == len(vertices):
            return True
            
        v = vertices[idx]
        for c in range(1, k + 1):
            if is_safe(v, c, assignment):
                assignment[v] = c 
                if backtrack(idx + 1, k, assignment):
                    return True
                del assignment[v]
        return False

    def optimal_coloring():
        for k in range(1, n + 1):
            assignment = {}
            if backtrack(0, k, assignment):
                colors = [[] for _ in range(k)]
                for v, c in assignment.items():
                    colors[c-1].append(v)
                return [sorted(group) for group in colors]

    
    greedy_result = greedy_coloring()
    print(f"Số màu cần dùng: {len(greedy_result)}")
    for i, group in enumerate(greedy_result):
        print(f"Màu {i+1}: " + " ".join(group))

    optimal_result = optimal_coloring()
    if optimal_result:
        print(f"Số màu tối ưu tuyệt đối: {len(optimal_result)}")
        for i, group in enumerate(optimal_result):
            print(f"Màu {i+1}: " + " ".join(group))

if __name__ == "__main__":
    # Tự động dò đường dẫn tới thư mục chứa file code hiện tại
    current_dir = os.path.dirname(os.path.abspath(__file__))
    
    # Ghép với tên file dữ liệu "tomau.inp"
    file_path = os.path.join(current_dir, "tomau.inp")
    
    print(f"Đang phân tích dữ liệu từ: {file_path}\n")
    solve_graph_coloring_bai5(file_path)