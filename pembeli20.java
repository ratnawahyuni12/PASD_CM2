public class pembeli20 {
    int nomorAntrean;
    String namaPembeli;
    String noHp;
    pembeli20 next;  // ada next dan prev karena pakai double linked list
    pembeli20 prev;

    // konstruktor default
    public pembeli20() {
    
    }

    // konstruktor berparameter
    public pembeli20(int nomorAntrean, String namaPembeli, String noHp) {
        this.nomorAntrean = nomorAntrean;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.next = null;
        this.prev = null;
    }
}