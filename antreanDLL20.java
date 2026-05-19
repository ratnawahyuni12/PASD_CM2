public class antreanDLL20 {
    pembeli20 head;
    pembeli20 tail;
    int counterAntrean;

    // konstruktor
    public antreanDLL20() {
        this.head = null;
        this.tail = null;
        this.counterAntrean = 1;
    }

    // menambah antrian
    void tambahAntrean(String namaPembeli, String noHp) {
        pembeli20 baru = new pembeli20(counterAntrean, namaPembeli, noHp);
        counterAntrean++;

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }

        System.out.println("Berhasil menambahkan antrean nomor " + baru.nomorAntrean);
    }

    // mencetak antrean
    void cetakAntrean() {
        if (head == null) {
            System.out.println("Antrean kosong");
            return;
        }

        pembeli20 current = head; //
        System.out.println("\n===============================");
        System.out.println("= DAFTAR ANTREAN PEMBELI =");
        System.out.println("===============================");
        System.out.printf("%-15s %-15s %-15s%n", "No Antrian", "Nama", "No HP");
        while (current != null) {
            System.out.printf("%-15d %-15s %-15s%n", current.nomorAntrean, current.namaPembeli, current.noHp);
            current = current.next; //
        }
    }

    // menghapus antrean
    pembeli20 hapusAntrean(int nomorAntrean) {
        if (head == null) {
            System.out.println("Antrean kosong!");
            return null;
        }

        pembeli20 current = head; //
        while (current != null) {
            if (current.nomorAntrean == nomorAntrean) {
                // reconnect pointer prev dan next
                if (current.prev != null) {
                    current.prev.next = current.next; //
                } else {
                    head = current.next;  // node yang dihapus adalah head
                }

                if (current.next != null) {
                    current.next.prev = current.prev; //
                } else {
                    tail = current.prev;  // node yang dihapus adalah tail
                }

                System.out.println("Pembeli " + current.namaPembeli + " dipanggil ke kasir.");
                return current;
            }
            current = current.next; //
        }

        System.out.println("Nomor antrean tidak ditemukan!");
        return null;
    }
}