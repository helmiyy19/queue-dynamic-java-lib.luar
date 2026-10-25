import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DynamicQueue<String> antrean = new DynamicQueue<>();
        DynamicStack<String> keranjang = new DynamicStack<>();
        DynamicStack<String> gudang = new DynamicStack<>();

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
            String pilih = scanner.nextLine().trim();

            switch (pilih) {
                case "1":
                    antrean.enqueue("Pelanggan " + noPelanggan);
                    System.out.println("Pelanggan " + noPelanggan + " masuk antrean.");
                    noPelanggan++;
                    break;
                case "2":
                    String orang = antrean.dequeue();
                    if (orang == null) {
                        System.out.println("Antrean kosong");
                    } else {
                        dilayani = orang;
                        keranjang = new DynamicStack<>();
                        System.out.println("Melayani " + orang);
                    }
                    break;
                case "3":
                    if (dilayani == null) {
                        System.out.println("Panggil pelanggan dulu");
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
                    gudang.push("Box-Stok-" + noStok);
                    System.out.println("Box-Stok-" + noStok + " ditumpuk di gudang.");
                    noStok++;
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
