/*              Vista Mellyna Atsfi
                    2209106096
                 Praktikum PBO C1
                    POSTTEST 5
    Sistem Pendataan Gaun di Toko ViElyttire
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public final class Main {                                                           //class final
     private static final ArrayList<Gaun> daftarGaun = new ArrayList<>();            //atribut final
     private static final Scanner scanner = new Scanner(System.in);
 
     public static void main(String[] args) {
         int pilihan;
 
         do {
             System.out.println("~*~*~*~*~*~*~*~* Selamat Datang di Toko ViElyttire ~*~*~*~*~*~*~*~*");
             System.out.println("1. Tambah Data Gaun");
             System.out.println("2. Lihat Semua Data Gaun");
             System.out.println("3. Ubah Data Gaun");
             System.out.println("4. Hapus Data Gaun");
             System.out.println("5. Keluar");
             System.out.println("~*~*~*~*~*~**~*~*~*~*~*~*~*~**~*~*~*~*~*~*~*~**~*~*~*~*~*~*~*~**~*~*");
             System.out.print("Pilih menu (1-5): ");
             pilihan = scanner.nextInt();
 
             switch (pilihan) {
                 case 1:
                     tambahGaun();
                     break;
                 case 2:
                     lihatSemuaGaun();
                     break;
                 case 3:
                     ubahDataGaun();
                     break;
                 case 4:
                     hapusGaun();
                     break;
                 case 5:
                     System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                     System.out.println("* Program selesai. Sampai jumpa! *");
                     System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                     break;
                 default:
                     System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
                     System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
             }
 
         } while (pilihan != 5);
     }
 
     private static void tambahGaun() {
         System.out.print("Masukkan kode gaun: ");
         String kode;
         boolean kodeValid = false;
 
         // Lakukan loop sampai kode gaun yang valid dimasukkan
         do {
             kode = scanner.next();
 
             // Validasi apakah kode gaun hanya berisi angka dan unik
             if (kode.matches("\\d+") && !isKodeGaunDuplicate(kode)) {
                 kodeValid = true;
             } else {
                 System.out.println("Kode gaun tidak valid atau sudah digunakan. Masukkan kode gaun yang berbeda: ");
             }
         } while (!kodeValid);
 
         System.out.print("Masukkan nama gaun: ");
         String nama = scanner.next();
 
         scanner.nextLine();
         System.out.print("Masukkan harga gaun: ");
         double harga = scanner.nextDouble();
         System.out.println("Pilih jenis gaun (1. Gaun Casual, 2. Gaun Pesta): ");
         int jenis = scanner.nextInt();
 
         if (jenis == 1) {
             System.out.print("Masukkan warna gaun casual: ");
             String warna = scanner.next();
             GaunCasual gaunBaru = new GaunCasual(kode, nama, harga, warna);
             daftarGaun.add(gaunBaru);
 
             scanner.nextLine();
 
         } else if (jenis == 2) {
             System.out.print("Masukkan model gaun pesta: ");
             String model = scanner.next();
             GaunPesta gaunBaru = new GaunPesta(kode, nama, harga, model);
             daftarGaun.add(gaunBaru);
         } else {
             System.out.println("Pilihan tidak valid.");
         }
 
         System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
         System.out.println("Gaun berhasil ditambahkan!");
     }
 
     // Method untuk memeriksa apakah kode gaun sudah digunakan sebelumnya
     private static boolean isKodeGaunDuplicate(final String kode) {               //method final
         for (Gaun gaun : daftarGaun) {
             if (gaun.getKode().equals(kode)) {
                 return true;
             }
         }
         return false;
     }
 
     private static void lihatSemuaGaun() {
         if (daftarGaun.isEmpty()) {
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*");
             System.out.println("Belum ada data gaun.");
         } else {
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~ Daftar Gaun ~*~*~*~*~*~*~*~*~*~*~*~*");
             for (Gaun gaun : daftarGaun) {
                 System.out.println(gaun);
             }
             System.out.println("-----------------------------------------------");
         }
     }
 
     private static void ubahDataGaun() {
         System.out.print("Masukkan kode gaun yang akan diubah: ");
         String kode = scanner.next();
 
         boolean gaunDitemukan = false;
         for (Gaun gaun : daftarGaun) {
             if (gaun.getKode().equals(kode)) {
                 System.out.print("Masukkan nama gaun baru: ");
                 String namaBaru = scanner.next();
                 System.out.print("Masukkan harga gaun baru: ");
                 double hargaBaru = scanner.nextDouble();
 
                 gaun.setNama(namaBaru);
                 gaun.setHarga(hargaBaru);
 
                 gaunDitemukan = true;
                 System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
                 System.out.println("Data gaun berhasil diubah!");
                 break;
             }
         }
 
         if (!gaunDitemukan) {
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
             System.out.println("Gaun dengan kode " + kode + " tidak ditemukan.");
         }
     }
 
     private static void hapusGaun() {
         System.out.print("Masukkan kode gaun yang akan dihapus: ");
         String kode = scanner.next();
 
         Gaun gaunHapus = null;
         for (Gaun gaun : daftarGaun) {
             if (gaun.getKode().equals(kode)) {
                 gaunHapus = gaun;
                 break;
             }
         }
 
         if (gaunHapus != null) {
             daftarGaun.remove(gaunHapus);
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
             System.out.println("Data gaun berhasil dihapus!");
         } else {
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
             System.out.println("Gaun dengan kode " + kode + " tidak ditemukan.");
         }
     }
 }
 
 abstract class Gaun {                                                                   //abstract class
     private String kode;
     private String nama;
     private double harga;
     private String warna; 
 
     public Gaun(String kode, String nama, double harga) {
         this.kode = kode;
         this.nama = nama;
         this.harga = harga;
     }
 
     public Gaun(String kode, String nama, double harga, String warna) {
         this.kode = kode;
         this.nama = nama;
         this.harga = harga;
         this.warna = warna;
     }
 
     public String getKode() {
         return kode;
     }
 
     public void setKode(String kode) {
         this.kode = kode;
     }
 
     public String getNama() {
         return nama;
     }
 
     public void setNama(String nama) {
         this.nama = nama;
     }
 
     public double getHarga() {
         return harga;
     }
 
     public void setHarga(double harga) {
         this.harga = harga;
     }
 
     public String getWarna() {
         return warna;
     }
 
     public void setWarna(String warna) {
         this.warna = warna;
     }
 
     public abstract boolean validateKode(String kode);                                      //abstract method
 }
 
 class GaunPesta extends Gaun {
     private String model;
 
     public GaunPesta(String kode, String nama, double harga, String model) {
         super(kode, nama, harga);
         if (validateKode(model)) {
             this.model = model;
         } else {
             System.out.println("Model tidak valid. Model hanya boleh berupa huruf.");
         }
     }
 
     public String getModel() {
         return model;
     }
 
     public void setModel(String model) {
         if (validateKode(model)) {
             this.model = model;
         } else {
             System.out.println("Model tidak valid. Model hanya boleh berupa huruf.");
         }
     }
 
     @Override
     public boolean validateKode(String kode) {
         return kode.matches("[a-zA-Z]+");
     }
 
     @Override
     public String toString() {
         return "Data Gaun Pesta{" +
                 "Kode = '" + getKode() + '\'' +
                 ", Nama = '" + getNama() + '\'' +
                 ", Harga = " + getHarga() +
                 ", Model = '" + model + '\'' +
                 '}';
     }
 }
 
 class GaunCasual extends Gaun {
     private String warna;
 
     public GaunCasual(String kode, String nama, double harga, String warna) {
         super(kode, nama, harga, warna);  //panggil constructor
         if (validateKode(warna)) {
             this.warna = warna;
         } else {
             System.out.println("Warna tidak valid. Warna hanya boleh berupa huruf.");
         }
     }
 
     public String getWarna() {
         return warna;
     }
 
     public void setWarna(String warna) {
         if (validateKode(warna)) {
             this.warna = warna;
         } else {
             System.out.println("Warna tidak valid. Warna hanya boleh berupa huruf.");
         }
     }
 
     @Override
     public boolean validateKode(String kode) {
         return kode.matches("[a-zA-Z]+");
     }
 
     @Override
     public String toString() {
         return "Data Gaun Casual{" +
                 "Kode = '" + getKode() + '\'' +
                 ", Nama = '" + getNama() + '\'' +
                 ", Harga = " + getHarga() +
                 ", Warna = '" + warna + '\'' +
                 '}';
     }
 }
 