package quoc;

import Javascript.chinh.LoaiSP;
import java.io.*;
import java.util.Scanner;


public class danhsachLoaiSP{
    private LoaiSP[] ds;
    private int n;

    //ham khoi tao
    public danhsachLoaiSP(){
        ds = new LoaiSP[0];
        n=0;
    }
    
    //ham khoi tao sao chep
    public danhsachLoaiSP(danhsachLoaiSP other){
        this.n = other.n;
        this.ds = new LoaiSP[n];
        for (int i=0; i<n; i++){
            LoaiSP l = other.ds[i];
            this.ds[i] = new LoaiSP(
                l.getMaLoai(),
                l.getTenLoai(),
                l.getMota(),
                l.getNgaytao()
            );
        }
    }
    
    //ham them
    public void them(LoaiSP loai){
        LoaiSP[] tam = new LoaiSP[n+1];
        for (int i=0; i<n; i++){
            tam[i] = ds[i];
        }
        tam[n]=loai;
        ds=tam;
        n++;
        }

    //xuat danh sach
    public void xuat(){
        for (int i=0; i<n; i++){
            ds[i].xuat();
            System.out.println("------------------");
        }
    }

    //tim kiem theo ma
    public int Timvitri(String ma){
        for (int i=0; i<n; i++){
            if(ds[i].getMaLoai().equalsIgnoreCase(ma)){
                return i;
            }
        }
        return -1;
    }

    public LoaiSP TimtheoMa(String ma){
        int vt = Timvitri(ma);
        if (vt!=-1) return ds[vt];
        return null;
    }

    //xoa theo ma
    public boolean xoa(String ma){
        int vt = Timvitri(ma);
        if (vt == -1) return false;
        for (int i=vt ; i<n-1 ; i++){
            ds[i]=ds[i+1];
        }
        n--;
        LoaiSP[] tam = new LoaiSP[n];
        for (int i=0;i<n;i++){
            tam[i]=ds[i];
        }
        ds=tam;
        return true;
    }

    //sua theo ma
    public boolean sua(String ma){
        int vt = Timvitri(ma);
        if (vt == -1) return false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten moi: ");
        ds[vt].setTenLoai(sc.nextLine());
        System.out.println("Nhap mo ta moi: ");
        ds[vt].setMota(sc.nextLine());
        System.out.println("Nhap ngay tao moi: ");
        ds[vt].setNgaytao(sc.nextLine());
        return true;
    }

    //ghi file
    public void Ghifile(String filename){
        try{
            FileWriter fw = new FileWriter(filename);
            for (int i=0;i<n; i++){
                fw.write(
                    ds[i].getMaLoai()+";"+
                    ds[i].getTenLoai()+";"+
                    ds[i].getMota()+";"+
                    ds[i].getNgaytao()+"\n"
                );
            }
            fw.close();
            System.out.println("ghi file thanh cong");
        }
        catch (IOException e){
            System.out.println("loi ghi file "+e.getMessage());
        }
    }

    //doc file
    public void Docfile(String filename){
        try{
            File f = new File(filename);
            if (!f.exists()){
System.out.println("file ko ton tai");
                return;
            }
            Scanner sc = new Scanner(f);
            n=0;
            ds=new LoaiSP[0];
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(";");
                if (parts.length==4){
                    LoaiSP loai = new LoaiSP(parts[0], parts[1], parts[2], parts[3]);
                    them(loai);
                }
            }
            sc.close();
            System.out.println("doc file thanh cong");
        }
        catch (Exception e){
            System.out.println("loi doc file"+e.getMessage());
        }
    }
}
