package chuong2;
import java.util.Arrays;
import java.util.Scanner;

public class dssv{
    private sinhvien[] dssv =new sinhvien[0];
    int n;
    public dssv(){}    
    public dssv(int nn, sinhvien[] ds2){
        this.n=nn;
        this.dssv=Arrays.copyOf(ds2, nn);
    }
    public void nhap(){
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap so luong sinh vien:");
        n=sc.nextInt();
        sc.nextLine();
        dssv= new sinhvien[n];
         for(int i=0; i<n; i++){
            System.out.println("nhap thong tin sinh vien thu"+ (i+1));
            dssv[i]=new sinhvien();
            dssv[i].nhap();
        }
    }
    public void xuat() {
       System.out.println("danh sach sinh vien vua nhap la:");
        dssv[i].xuat();
       }
    
    public void them(){
            dssv=Arrays.copyOf(dssv,n+1);
            dssv[n]=new sinhvien();
            dssv[n].nhap();
            n++;
        }
    public void them(sinhvien x){
            dssv= Arrays.copyOf(dssv, n+1);
            dssv[n]=new sinhvien(x);
            n++;
        }
    public int timkiem(String masv){
            for(int i=0; i<n;i++){
                if(dssv[i].getmasv().equalsIgnoreCase(masv)) return i;
            }
            return -1;
        }
    public sinhvien timkiemsv(String masv) {
        int i = timkiem(masv);
        if (i != -1) return dssv[i];
        return null;
    }
    public void xoa(String masv){
        int i = timkiem(masv);
        if (i==-1){
            System.out.println("khong thay sinh vien can xoa: "+masv);
            return;
        }
         for(int j=i; j<n-1;j++){
            dssv[j]=dssv[j+1];         
        }
        n--;
        dssv=Arrays.copyOf(dssv, n);
        System.out.println("da xoa xinh vien co ma so: "+ masv);
    }
     public static void main(String[] args) {
      dssv dssv1=new dssv();
      Scanner sc = new Scanner(System.in);
      dssv1.nhap();
      dssv1.xuat();
      dssv1.them();       
      sc.close();
    }
}
