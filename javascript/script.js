
const adminEmail = "hoangdanghau19@gmail.com";
const adminPassword = "123";

// Hàm đăng ký user mới
function register() {
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    if (email && password) {
        localStorage.setItem("userEmail", email);
        localStorage.setItem("userPassword", password);
        alert("Đăng ký thành công! Giờ bạn có thể đăng nhập.");
    } else {
        alert("Vui lòng nhập đầy đủ email và mật khẩu để đăng ký.");
    }
}
// Hàm đăng nhập
function login() {
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const errorMsg = document.getElementById("error");
    // Lấy thông tin người dùng đã đăng ký (nếu có)
    const savedEmail = localStorage.getItem("userEmail");
    const savedPassword = localStorage.getItem("userPassword");
    // Nếu là Admin
    if (email === adminEmail && password === adminPassword) {
        window.location.href = "Admin.html";
        return;
    }
    // Nếu là User đã đăng ký
    if (email === savedEmail && password === savedPassword) {
        window.location.href = "User.html";
        return;
    }
    // Sai thông tin
    errorMsg.style.display = "block";
}
document.getElementById("searchBox").addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        window.location.href = "Search.html";
    }
});





ublic void docTuFile(String tenFile) {
        try {
            Scanner sc = new Scanner(new File(tenFile));
            HoaDon[] temp = new HoaDon[0];
            while (sc.hasNext()) {
                String mahoadon = sc.next();
                String ngaylap = sc.next();
                double tongtien = sc.nextDouble();
                String makhachhang = sc.next();
                String manhanvien = sc.next();
                sc.nextLine();

                HoaDon hd = new HoaDon(mahoadon, ngaylap, tongtien, makhachhang, manhanvien);

                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = hd;
            }
            sc.close();
            ds = temp;
            n = ds.length;
            System.out.println("Doc file thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    public void ghiFile(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            for (HoaDon hd : ds) {
                if (hd != null) {
                    pw.println(hd.getMaHoaDon() + " " + hd.getNgaylap() + " " + hd.getTongTien() + " " + hd.getMaKhachHang() + " "
                             + hd.getMaNhanVien());
                }
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }