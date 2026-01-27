import java.util.*;

public class SinhVien{
    private String ma;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    
    public SinhVien(){
        this.ma="";
        this.ho="";
        this.ten="";
        this.ngaySinh="";
        this.gioiTinh="";
    }
    public SinhVien(String ma, String ho, String ten, String ngaySinh, String gioiTinh ){
        this.ma=ma;
        this.ho=ho;
        this.ten=ten;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
    }
    public SinhVien(SinhVien sv){
        this.ma=sv.ma;
        this.ho=sv.ho;
        this.ten=sv.ten;
        this.ngaySinh=sv.ngaySinh;
        this.gioiTinh=sv.gioiTinh;
    }
    public String getMa(){
        return ma;
    }
    public void setMa(String ma){
        this.ma=ma;
    }

    public String getHo(){
        return ho;
    }
    public void setHo(String ho){
        this.ho=ho;
    }

    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten=ten;
    }

    public String getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh){
        this.ngaySinh=ngaySinh;
    }

    public String getGioiTinh(){
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh=gioiTinh;
    }

    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        ma = sc.nextLine();
        System.out.print("Nhap ho sinh vien: ");
        ho= sc.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        ten=sc.nextLine();
        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        ngaySinh=sc.nextLine();
        System.out.print("Nhap gioi tinh (Nam/Nu): ");
        gioiTinh=sc.nextLine();
    }

    public void xuat(){
        System.out.printf("%-10s %-15s %-10s %-12s %-5s\n", ma, ho, ten, ngaySinh, gioiTinh);
    }
}