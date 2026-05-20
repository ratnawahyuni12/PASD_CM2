public class antreanDLL20 {
    pembeli20 head;
    pembeli20 tail;
    int counterAntrean; // menghitung otomatis nomor antrean

    // konstruktor → dijalankan saat objek antrean pertama kali dibuat
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

        pembeli20 current = head;
        System.out.println("\n===============================");
        System.out.println("= DAFTAR ANTREAN PEMBELI =");
        System.out.println("===============================");
        System.out.printf("%-15s %-15s %-15s%n", "No Antrian", "Nama", "No HP");
        while (current != null) {
            System.out.printf("%-15d %-15s %-15s%n", current.nomorAntrean, current.namaPembeli, current.noHp);
            current = current.next;
        }
    }

    // menghapus antrean (dipanggil kasir)
    pembeli20 hapusAntrean(int nomorAntrean) {
        if (head == null) {
            System.out.println("Antrean kosong!");
            return null;
        }

        pembeli20 current = head;
        while (current != null) {
            if (current.nomorAntrean == nomorAntrean) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Pembeli " + current.namaPembeli + " dipanggil ke kasir.");
                return current;
            }
            current = current.next;
        }

        System.out.println("Nomor antrean tidak ditemukan!");
        return null;
    }

    // membatalkan antrean
    void batalAntrean(int nomorAntrean) {
        if (head == null) {
            System.out.println("Antrean kosong!");
            return;
        }

        pembeli20 current = head;
        while (current != null) {
            if (current.nomorAntrean == nomorAntrean) {
                // reconnect pointer
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                // konfirmasi pembatalan
                System.out.println("\n============================================");
                System.out.println("Antrean nomor " + current.nomorAntrean + " atas nama " + current.namaPembeli + " telah DIBATALKAN.");
                System.out.println("============================================");

                // cetak antrean terbaru setelah pembatalan
                cetakAntrean();
                return;
            }
            current = current.next;
        }

        System.out.println("Nomor antrean tidak ditemukan!");
    }
}