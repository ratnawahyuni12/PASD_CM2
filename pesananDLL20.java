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
            while (current.next != null) {
                if (current.namaPesanan.compareToIgnoreCase(current.next.namaPesanan) > 0) {
                    // tukar data, bukan pointer
                    int tempKode = current.kodePesanan;
                    String tempNama = current.namaPesanan;
                    int tempHarga = current.harga;

                    current.kodePesanan = current.next.kodePesanan;
                    current.namaPesanan = current.next.namaPesanan;
                    current.harga = current.next.harga;

                    current.next.kodePesanan = tempKode;
                    current.next.namaPesanan = tempNama;
                    current.next.harga = tempHarga;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // laporan pesanan
    void laporanPesanan() {
        if (head == null) {
            System.out.println("Belum ada pesanan!");
            return;
        }

        sortByNama();

        pesanan20 current = head;
        int total = 0;
        System.out.println("\n================================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("================================================");
        System.out.printf("%-15s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        System.out.println("================================================");
        while (current != null) {
            System.out.printf("%-15d %-20s %-10d%n", current.kodePesanan, current.namaPesanan, current.harga);
            total += current.harga;
            current = current.next;
        }
        System.out.println("================================================");
        System.out.println("TOTAL PENDAPATAN : Rp" + total);
    }
}