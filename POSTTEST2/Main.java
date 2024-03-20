/*              Vista Mellyna Atsfi
                    2209106096
                 Praktikum PBO C1
                    POSTTEST 2
    Sistem Pendataan Gaun di Toko ViElyttire
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class Main {
    private static ArrayList<Gaun> daftarGaun = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
 
     public static void main(String[] args) {
         int pilihan;
 
         do {
             System.out.println("~*~*~*~*~*~*~*~* Selamat Datang di Toko ViElyttire ~*~*~*~*~*~*~*~*");
             System.out.println("1. Tambah Data Gaun");
             System.out.println("2. Lihat Semua Data Gaun");
             System.out.println("3. Ubah Data Gaun");
             System.out.println("4. Hapus Data Gaun");
             System.out.println("5. Keluar");
             System.out.println("~*~*~*~*~*~**~*~*~*~");
             System.out.print("Pilih menu (1-5): ");
             System.out.println("~*~*~*~*~*~**~*~*~*~");
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
         String kode = scanner.next();
         System.out.print("Masukkan nama gaun: ");
         String nama = scanner.next();
         System.out.print("Masukkan harga gaun: ");
         double harga = scanner.nextDouble();
 
         Gaun gaunBaru = new Gaun(kode, nama, harga);
         daftarGaun.add(gaunBaru);
 
         System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
         System.out.println("Gaun berhasil ditambahkan!");
     }
 
     private static void lihatSemuaGaun() {
         if (daftarGaun.isEmpty()) {
             System.out.println("~*~*~*~*~*~*~*~*~*~*~*");
             System.out.println("Belum ada data gaun.");
         } else {
             System.out.println("~*~*~*~*~*~*~*~*~ Daftar Gaun ~*~*~*~*~*~*~*~*");
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