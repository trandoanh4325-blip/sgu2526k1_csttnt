package thu;
import java.util.Scanner;

public class CSHOCVIEN {
    private String maHV;
    private String hoTen;
    private String lop;
    private float diemMon1, diemMon2, diemMon3;

    // Hàm thiết lập không tham số
    public CSHOCVIEN() {
        maHV = "";
        hoTen = "";
        lop = "";
        diemMon1 = diemMon2 = diemMon3 = 0;
    }

    // Hàm thiết lập có tham số
    public CSHOCVIEN(String maHV, String hoTen, String Lop, float diemMon1, float diemMon2, float diemMon3) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.lop = Lop;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoc vien: ");
        maHV = sc.nextLine();
        System.out.print("Nhap ho ten hoc vien: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap diem mon 1: ");
        diemMon1 = sc.nextFloat();
        System.out.print("Nhap diem mon 2: ");
        diemMon2 = sc.nextFloat();
        System.out.print("Nhap diem mon 3: ");
        diemMon3 = sc.nextFloat();
    }

    public void xuat() {
        System.out.println("Ma hoc vien:" + maHV);
        System.out.println("Ho ten hoc vien:" + hoTen);
        System.out.println("Lop:" + lop);
        System.out.println("Diem mon 1:" + diemMon1);
        System.out.println("Diem mon 2:" + diemMon2);
        System.out.println("Diem mon 3:" + diemMon3);
    }

    public float diemTB() {
        return (diemMon1 + diemMon2 + diemMon3) / 3;
    }

    public String xepLoai() {
        float dtb = diemTB();
         if (dtb < 5)
            return "Yeu";
        else if (dtb < 6.5)
            return "Trung binh";
        else if (dtb < 7.5)
            return "Kha";
        else if (dtb < 9)
            return "Gioi";
        else
            return "Xuat sac";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Hàm thiết lập tham số có sẵn
        CSHOCVIEN hv1 = new CSHOCVIEN("001", "Nguyễn Minh Triết", "124C2", 0f, 2f, 1f);
        hv1.xuat();
        System.out.println("Diem trung binh:" + hv1.diemTB());
        System.out.println("Xep loai:" + hv1.xepLoai());

        // Hàm thiết lập không tham số và nhập từ bàn phím
        CSHOCVIEN hv2 = new CSHOCVIEN();
        hv2.nhap();
        hv2.xuat();
        System.out.println("Diem trung binh:" + hv2.diemTB());
        System.out.println("Xep loai:" + hv2.xepLoai());
        sc.close();
    }
}

