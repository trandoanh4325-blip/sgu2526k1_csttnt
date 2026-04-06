import sys

def solve_knight_tour():
    # 1. Nhập dữ liệu từ bàn phím
    print("Nhập N x0 y0 (cách nhau khoảng trắng): ", end="")
    try:
        # Lấy dữ liệu người dùng gõ vào
        inp = input().strip().split()
        if len(inp) != 3:
            print("Vui lòng nhập đúng 3 số!")
            return
        n, x0, y0 = map(int, inp)
    except ValueError:
        print("Dữ liệu không hợp lệ (vui lòng chỉ nhập số)!")
        return
    except EOFError:
        return

    # 2. BÍ QUYẾT TOÁN HỌC (Định lý Schwenk)
    # Bàn cờ NxN chỉ có chu trình đóng khi N chẵn và N > 4
    if n % 2 != 0 or n in (2, 4):
        print(0)
        return

    # Khởi tạo bàn cờ toàn số 0
    board = [[0] * n for _ in range(n)]
    
    # 8 hướng di chuyển của con mã
    moves = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2), (2, -1), (2, 1)]
    
    # Đánh dấu bước đầu tiên
    board[x0][y0] = 1 

    def get_degree(r, c):
        """Đếm số đường có thể nhảy tiếp từ ô (r, c)"""
        count = 0
        for dr, dc in moves:
            nr, nc = r + dr, c + dc
            if 0 <= nr < n and 0 <= nc < n and board[nr][nc] == 0:
                count += 1
        return count

    def solve(r, c, step):
        # NẾU ĐÃ ĐI KÍN BÀN CỜ (Đã đặt xong bước thứ N*N)
        if step == n * n + 1:
            # KIỂM TRA ĐIỀU KIỆN ĐÓNG: Từ ô cuối có nhảy về ô xuất phát (x0, y0) được không?
            for dr, dc in moves:
                if r + dr == x0 and c + dc == y0:
                    return True
            return False

        # TÌM CÁC BƯỚC ĐI TIẾP THEO HỢP LỆ
        next_moves = []
        for dr, dc in moves:
            nr, nc = r + dr, c + dc
            if 0 <= nr < n and 0 <= nc < n and board[nr][nc] == 0:
                degree = get_degree(nr, nc)
                next_moves.append((degree, nr, nc))

        # HEURISTIC WARNSDORFF: Sắp xếp ưu tiên ô có ít đường đi tiếp nhất lên đầu
        next_moves.sort(key=lambda x: x[0])

        # THỬ ĐI VÀ QUAY LUI (Backtracking)
        for _, nr, nc in next_moves:
            board[nr][nc] = step       # Thử đặt chân xuống
            if solve(nr, nc, step + 1): # Đi tiếp bước sau
                return True            # Nếu thành công thì báo về
            board[nr][nc] = 0          # Nếu đi vào ngõ cụt thì nhấc chân lên (QUAY LUI)

        return False

    # 3. Chạy thuật toán và in kết quả
    if solve(x0, y0, 2):
        print(1)
        for row in board:
            # In ra các giá trị cách nhau bởi khoảng trắng, canh lề phải 3 ký tự
            print(" ".join(f"{val:3}" for val in row))
    else:
        print(0)


# --- CHẠY CHƯƠNG TRÌNH ---
if __name__ == "__main__":
    solve_knight_tour()