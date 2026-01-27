package thu;

import java.util.Scanner;
public class bai4a {
    private int maso;
    private String hoten;
    private int diem1, diem2, diem3;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ma so sinh vien");
        maso = sc.nextInt();
        sc.nextLine();
        System.out.println("ho va ten");
        hoten = sc.nextLine();
        System.out.println("diem mon 1: ");
        diem1 = sc.nextInt();
        System.out.println("diem mon 2: ");
        diem2 = sc.nextInt();
        System.out.println("diem mon 3: ");
        diem3 = sc.nextInt();
        sc.close();
    }
    public void xuat(){
        System.out.println("MSSV: "+maso);
        System.out.println("ho va ten"+hoten);
        System.out.println("diem mon 1"+diem1);
        System.out.println("diem mon 2"+diem2);
        System.out.println("diem mon 3"+diem3);
        System.out.println("diemtrungbinh: " +diemtrungbinh());
        System.out.println("xeploai" +xeploai());

    }
    public float diemtrungbinh(){
    return (diem1+diem2+diem3)/3;
     }
    public String xeploai() {
        float dtb = diemtrungbinh();
         if (dtb >=8){
            return "loai gioi";
        }
        if (dtb >=6.5 && dtb <8){
            return "loai kha.";
        }
        else{
          return "loai trung binh";
        }
    }
public static void main(String[] args){
    bai4a bai4 =new bai4a();
    bai4.nhap();
    bai4.xuat();
 } 
}