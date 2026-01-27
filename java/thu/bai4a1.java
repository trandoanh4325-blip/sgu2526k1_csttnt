package thu;
import java.util.Scanner;

public class bai4a1 {
    private int maso;
    private String hoten;
    private int diem1, diem2, diem3;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so sinh vien: ");
        maso = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap ho va ten: ");
        hoten = sc.nextLine();
        System.out.print("Diem mon 1: ");
        diem1 = sc.nextInt();
        System.out.print("Diem mon 2: ");
        diem2 = sc.nextInt();
        System.out.print("Diem mon 3: ");
        diem3 = sc.nextInt();
    }

    public void xuat() {
        System.out.println("MSSV: " + maso);
        System.out.println("Ho va ten: " + hoten);
        System.out.println("Diem mon 1: " + diem1);
        System.out.println("Diem mon 2: " + diem2);
        System.out.println("Diem mon 3: " + diem3);
        System.out.println("Diem trung binh: " + diemTrungBinh());
        System.out.println("Xep loai: " + xepLoai());
    }

    public float diemTrungBinh() {
        return (diem1 + diem2 + diem3) / 3; // chia cho 3 để có float
    }

    public String xepLoai() {
        float dtb = diemTrungBinh();
        if (dtb >= 8) {
            return "Gioi";
        } else if (dtb >= 6.5) {
            return "Kha";
        } else {
            return "Trung binh";
        }
    }

    // Hàm main đặt trong class khác hoặc tách riêng
    public static void main(String[] args) {
        bai4a1 sv = new bai4a1();
        sv.nhap();
        sv.xuat();
    }
}