public class pesananDLL20 {
    pesanan20 head;
    pesanan20 tail;

    // konstruktor
    pesananDLL20() {
        this.head = null;
        this.tail = null;
    }

    // menambah pesanan
    void tambahPesanan(int kodePesanan, String namaPesanan, int harga) {
        pesanan20 baru = new pesanan20(kodePesanan, namaPesanan, harga);

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
    }

    // sorting (bubble sort)
    void sortByNama() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            pesanan20 current = head;
            while (current.next != null) { // selama ada yang dibandingkan
                if (current.namaPesanan.compareToIgnoreCase(current.next.namaPesanan) > 0) {
                    // tukar data, bukan pointer
                    int tempKode = current.kodePesanan;   // simpan data current ke variabel sementara
                    String tempNama = current.namaPesanan;
                    int tempHarga = current.harga;

                    current.kodePesanan = current.next.kodePesanan; // isi current dengan data next
                    current.namaPesanan = current.next.namaPesanan;
                    current.harga = current.next.harga;

                    current.next.kodePesanan = tempKode; // isi next dengan data lama current (dari temp)
                    current.next.namaPesanan = tempNama;
                    current.next.harga = tempHarga;

                    swapped = true; // tanda ada pertukaran (looping juga)
                }
                current = current.next; // geser ke pasangan berikutnya
            }
        } while (swapped); // ulangi pass sampai tidak ada pertukaran (sudah terurut)
    }

    // laporan pesanan
    void laporanPesanan() {
        if (head == null) {
            System.out.println("Belum ada pesanan!");
            return;
        }

        sortByNama(); // urutkan dulu sebelum dicetak

        pesanan20 current = head;
        int total = 0; // akumulator total pendapatan
        System.out.println("\n================================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("================================================");
        System.out.printf("%-15s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        System.out.println("================================================");
        while (current != null) {
            System.out.printf("%-15d %-20s %-10d%n", current.kodePesanan, current.namaPesanan, current.harga);
            total += current.harga; // tambahkan harga tiap pesanan ke total
            current = current.next; // lanjut ke pesanan berikutnya
        }
        System.out.println("================================================");
        System.out.println("TOTAL PENDAPATAN : Rp" + total);
    }
}