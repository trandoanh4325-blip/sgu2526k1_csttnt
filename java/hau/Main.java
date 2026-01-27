import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DSSV dssv= new DSSV();
        Scanner sc = new Scanner(System.in);
        int chon;
        do{
            System.out.println("\n===== MENU QUAN LY SINH VIEN =====");
            System.out.println("1. Nhap N sinh vien vao dau danh sach");
            System.out.println("2. Xuat danh sach sinh vien");
            System.out.println("3. Them sinh vien (tu ban phim)");
            System.out.println("4. Them sinh vien (co tham so)");
            System.out.println("5. Tim sinh vien theo ma");
            System.out.println("6. Tim sinh vien theo ho");
            System.out.println("7. Xoa sinh vien");
            System.out.println("8. Thong ke gioi tinh");
            System.out.println("9. Thong ke theo do tuoi");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap so luong sinh vien: ");
                    int N = sc.nextInt();
                    sc.nextLine();
                    dssv.nhapN(N);
                    break;
                case 2:
                    dssv.xuat();
                    break;
                case 3:
                    dssv.them();
                    break;
                case 4:
                    SinhVien sv= new SinhVien("SV01", "Hoang", " Hau", "19/11/2006","Nam");
                    dssv.them(sv);
                    System.out.println("Da them sinh vien SV01");
                    break;
                case 5:
                    System.out.print("Nhap ma sinh vien can tim: ");
                    String ma=sc.nextLine();
                    SinhVien found=dssv.timKiem(ma);
                    if (found!=null){
                        System.out.println("Thong tin sinh vien tim thay:");
                        found.xuat();
                    }else {System.out.println("Khong tim thay sinh vien co ma: "+ma);}
                    break;
                case 6:
                    System.out.print("Nhap ho can tim: ");
                    String ho = sc.nextLine();
                    dssv.timTheoHo(ho);
                    break;
                case 7: 
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    String maXoa = sc.nextLine();
                    dssv.xoaSinhVien(maXoa);
                    break;
                case 8:
                    dssv.tkGioiTinh();
                    break;
                case 9:
                    dssv.tkTuoi();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (chon!=0);
    }
}
