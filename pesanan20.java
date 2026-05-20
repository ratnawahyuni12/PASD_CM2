public class pesanan20 { // cetakan untuk setiap pesanan
    int kodePesanan;
    String namaPesanan;
    int harga;
    pesanan20 next;  // ada next dan prev karena pakai double linked list
    pesanan20 prev;

    // konstruktor default
    public pesanan20() {

    }

    // konstruktor berparameter → dipakai saat input pesanan setelah pembeli dipanggil kasir
    public pesanan20(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.next = null;
        this.prev = null;
    }
}