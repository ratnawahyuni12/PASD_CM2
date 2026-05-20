public class pembeli20 { // cetakan untuk setiap pembeli yang masuk antrian
    int nomorAntrean;
    String namaPembeli;
    String noHp;
    pembeli20 next;  // ada next dan prev karena pakai double linked list
    pembeli20 prev;

    // konstruktor default
    public pembeli20() {
    
    }

    // konstruktor berparameter → dipakai saat membuat node baru dengan data langsung
    public pembeli20(int nomorAntrean, String namaPembeli, String noHp) {
        this.nomorAntrean = nomorAntrean;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.next = null;
        this.prev = null;
    }
}