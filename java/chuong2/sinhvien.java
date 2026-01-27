package chuong2;
import java.util.Scanner;

public class sinhvien{
    private String masv;
    private String ho;
    private String ten;
    private String ngaysinh;
    private String sex;
    private String diachi;
    private String age;
    private String sdt;
    //hàm không có tham số
    public sinhvien(){
      masv="";
      ho="";
      ten="";
      ngaysinh="";
      sex="";
      diachi="";
      age="";
      sdt="";   }
    //hàm có tham số
    public sinhvien(String masv, String ho, String ten, String ngaysinh, String sex, String diachi, String age, String sdt){
     this.masv=masv;
     this.ho=ho;
     this.ten=ten;
     this.ngaysinh=ngaysinh;
     this.sex=sex;
     this.diachi=diachi;
     this.age=age;
     this.sdt=sdt;
    }
 public void nhap(){
    Scanner sc= new Scanner(System.in);
   System.out.print("nhap ma so sinh vien");
   masv= sc.nextLine();
   System.out.print("nhap ho la ");
   ho= sc.nextLine();
   System.out.print("nhap ten la");
   ten=sc.nextLine();
   System.out.print("nhap ngay sinh la");
   ngaysinh=sc.nextLine();
   System.out.print("nhap gioi tinh");
   sex=sc.nextLine();
   System.out.print("nhap dia chi: ");
   diachi=sc.nextLine();
   System.out.print("nhap tuoi:");
   age=sc.nextLine();
   System.out.print("nhap so dien thoai: ");
   sdt=sc.nextLine();
 }
 public void xuat(){
  System.out.println("ma so sinh vien la: "+masv);
  System.out.println("ho la: "+ho);
  System.out.println("ten la: "+ten);
  System.out.println("ngay sinh la: "+ngaysinh);
  System.out.println("gioi tinh la: "+sex);
  System.out.println("dia chi la: "+diachi);
  System.out.println("tuoi la: "+age);
  System.out.println("so dien thoai la: "+sdt);
 }
  public String getmasv(){
   return masv;
  } 
  public void setmasv(String masv){
   this.masv=masv;
  }
  public  String getho(){
   return ho;
  }
  public void setho(String ho){
   this.ho=ho;
  }
  public String getten(){
   return ten;
  }
  public void setten(String ten){
   this.ten=ten;
  }
  public String getngaysinh(){
   return ngaysinh;
  }
  public void setngaysinh(String ngaysinh){
   this.ngaysinh=ngaysinh; 
 }
   public String getsex(){
      return sex;
   }
   public void setsex(String sex){
      this.sex=sex;
   }
  public String getdiachi(){
   return diachi;
  }
  public void setdiachi(String diachi){
   this.diachi=diachi;
  }
  public String getage(){
   return age;
  }
  public void setage(String age){
   this.age=age;
  }
  public String getsdt(){
   return sdt;
  }
  public void setsdt(String sdt){
   this.sdt=sdt;
  }
  public sinhvien(sinhvien sv1){
   masv=sv1.masv;
   ho=sv1.ho;
   ten=sv1.ten;
   ngaysinh=sv1.ngaysinh;
   sex=sv1.sex;
   diachi=sv1.diachi;
   age=sv1.age;
   sdt=sv1.sdt;
  }
  public static void main(String[] args) {
    sinhvien sv1 = new sinhvien(maso ="01", ho="nguyen", ten="anh", ngaysinh="");

    sv1.nhap();
    sv1.xuat();
    }
}
