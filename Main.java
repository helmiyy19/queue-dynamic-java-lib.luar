import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StaticQueue<String> antrean = new StaticQueue<>(5);
        StaticStack<String> keranjang = new StaticStack<>(5);
        StaticStack<String> gudang = new StaticStack<>(10);

        int noPelanggan = 1;
        int noStok = 1;
        String dilayani = null;

        while (true) {
            System.out.println("SISTEM KASIR & GUDANG");
            System.out.println("Antrean   : " + antrean.show());
            System.out.println("Dilayani  : " + (dilayani == null ? "-" : dilayani));
            System.out.println("Keranjang : " + keranjang.show());
            System.out.println("Gudang    : " + gudang.show());
            System.out.println("1. Tambah antrean   2. Panggil pelanggan");
            System.out.println("3. Scan barang      4. Cancel barang");
            System.out.println("5. Tambah stok      0. Keluar");
            System.out.print("Pilih: ");
            String pilih = in.nextLine().trim();

            switch (pilih) {
                case "1":
                    if (antrean.enqueue("Pelanggan " + noPelanggan)) {
                        System.out.println("Pelanggan " + noPelanggan + " masuk antrean.");
                        noPelanggan++;
                    } else {
                        System.out.println("Antrean penuh!");
                    }
                    break;
                case "2":
                    String orang = antrean.dequeue();
                    if (orang == null) {
                        System.out.println("Antrean kosong");
                    } else {
                        dilayani = orang;
                        keranjang = new StaticStack<>(5); // keranjang di-reset
                        System.out.println("Melayani " + orang);
                    }
                    break;
                case "3":
                    if (dilayani == null) {
                        System.out.println("Panggil pelanggan dulu");
                    } else if (keranjang.isFull()) {
                        System.out.println("Keranjang penuh!");
                    } else {
                        String brg = gudang.pop();
                        if (brg == null) {
                            System.out.println("Gudang kosong");
                        } else {
                            keranjang.push(brg);
                            System.out.println("Scan: " + brg);
                        }
                    }
                    break;
                case "4":
                    String batal = keranjang.pop();
                    if (batal == null) {
                        System.out.println("Keranjang kosong");
                    } else {
                        gudang.push(batal);
                        System.out.println("Batal: " + batal);
                    }
                    break;
                case "5":
                    if (gudang.push("Box-Stok-" + noStok)) {
                        System.out.println("Box-Stok-" + noStok + " ditumpuk di gudang.");
                        noStok++;
                    } else {
                        System.out.println("Gudang penuh!");
                    }
                    break;
                case "0":
                    System.out.println("Selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
