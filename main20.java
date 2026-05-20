import java.util.Scanner;

public class main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        antreanDLL20 antrean = new antreanDLL20(); // membuat DLL kosong untuk antrian pembeli
        pesananDLL20 pesanan = new pesananDLL20(); // membuat DLL kosong untuk pesanan

        int pilihan;
        do {
            System.out.println("\n===============================");
            System.out.println("= SISTEM ANTREAN ROYAL DELISH =");
            System.out.println("===============================");
            System.out.println("1. Tambah Antrean");
            System.out.println("2. Cetak Antrean");
            System.out.println("3. Hapus Antrean & Input Pesanan");
            System.out.println("4. Laporan Pesanan & Total Pendapatan");
            System.out.println("5. Batalkan Antrean"); // modifikasi menambah menu batal antrean
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt(); // baca pilihan angka dari user
            sc.nextLine();

            switch(pilihan) {
                case 1:
                    // ganti nama & HP sesuai kebutuhan demo
                    antrean.tambahAntrean("Ainra", "08224500000");
                    antrean.tambahAntrean("Danra", "08224511111");
                    antrean.tambahAntrean("Sanri", "08224522222");
                    antrean.tambahAntrean("Vania", "08422234556");
                    break;
                case 2:
                    antrean.cetakAntrean();
                    break;
                case 3:
                    antrean.cetakAntrean();
                    System.out.print("Masukkan nomor antrean yang dipanggil: ");
                    int nomorDipanggil = sc.nextInt();
                    sc.nextLine();

                    pembeli20 pembeli = antrean.hapusAntrean(nomorDipanggil); // hapus dari antrian, simpan data pembeli yang dipanggil
                    if (pembeli != null) {
                        System.out.println("\nInput pesanan untuk " + pembeli.namaPembeli + ": ");

                        System.out.print("Kode Pesanan : ");
                        int kodePesanan = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();

                        pesanan.tambahPesanan(kodePesanan, namaPesanan, harga); // simpan pesanan ke DLL pesanan
                        System.out.println(pembeli.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;
                case 4:
                    pesanan.laporanPesanan(); // cetak laporan semua pesanan + total pendapatan
                    break;
                case 5:
                    antrean.cetakAntrean(); // tampilkan antrean dulu biar user tahu mau batalkan nomor berapa
                    System.out.print("Masukkan nomor antrean yang ingin dibatalkan: ");
                    int nomorBatal = sc.nextInt(); // membaca nomor antrean yang ingin dibatalkan
                    sc.nextLine();
                    antrean.batalAntrean(nomorBatal);
                    break;
                case 0:
                    System.out.println("Terima kasih telah datang di Royal Delish.");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 0);
        sc.close();
    }
}