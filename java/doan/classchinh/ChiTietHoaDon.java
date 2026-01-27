package doan.classchinh;
import java.util.Scanner;

public class ChiTietHoaDon {
    private String machitiethoadon;
    private String mahoadon;
    private String masanpham;
    private int soluong;     


    public ChiTietHoaDon(String machitiethoadon, String mahoadon, String masanpham, int soluong){
        this.machitiethoadon = machitiethoadon;
        this.mahoadon = mahoadon;
        this.masanpham = masanpham;
        this.soluong = soluong;

    }

    public ChiTietHoaDon(){
        machitiethoadon = "";
        mahoadon = "";
        masanpham = "";
        soluong = 0;

    }

    public ChiTietHoaDon(ChiTietHoaDon cthd ){
        this.machitiethoadon = cthd.machitiethoadon;
        this.mahoadon = cthd.mahoadon;
        this.masanpham = cthd.masanpham;
        this.soluong = cthd.soluong;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ma chi tiet hoa don: ");
        machitiethoadon = sc.nextLine();
        System.out.print("nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("nhap ma san pham: ");
        masanpham = sc.nextLine();
        System.out.print("nhap so luong san pham: ");
        soluong = sc.nextInt();
    }

    public void xuat(){
        System.out.printf("%-10s %-10s %-10s %-10d %-10.2f\n", machitiethoadon, mahoadon, masanpham, soluong );
    }
    
    public String getmachitiethoadon(){
        return machitiethoadon;
    }
    public void setmachitiethoadon(String machitiethoadon){
        this.machitiethoadon = machitiethoadon;
    }
    public String getmahoadon(){
        return mahoadon;
    }
    public void setmahoadon(String mahoadon){
        this.mahoadon = mahoadon;
    }
    public String getmasanpham(){
        return masanpham;
    }
    public void setmasanpham(String masanpham){
        this.masanpham = masanpham;
    }
    public int getsoluong(){
        return soluong;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }

}
