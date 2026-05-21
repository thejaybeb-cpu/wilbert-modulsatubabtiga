import java.util.ArrayList;

public class modulsatualternate {

    class Penulis {
        String nama;

        Penulis(String nama) {
            this.nama = nama;
        }
    }

    class Buku {
        String judul;
        int tahun;
        String sinopsis;
        Kategori kategori;
        ArrayList<Penulis> penulisList = new ArrayList<>();

        Buku(String judul, int tahun, String sinopsis, Kategori kategori) {
            this.judul = judul;
            this.tahun = tahun;
            this.sinopsis = sinopsis;
            this.kategori = kategori;
        }

        void tambahPenulis(Penulis p) {
            penulisList.add(p);
        }

        int hitungJumlahKataSinopsis() {
            String[] kata = sinopsis.split(" ");
            return kata.length;
        }

        int cekKesamaan(Buku bukuLain) {
            int skor = 0;
            int total = 5;

            if (this.judul.equalsIgnoreCase(bukuLain.judul))
                skor++;

            if (this.tahun == bukuLain.tahun)
                skor++;

            if (this.kategori.nama.equalsIgnoreCase(bukuLain.kategori.nama))
                skor++;

            if (this.sinopsis.equalsIgnoreCase(bukuLain.sinopsis))
                skor++;

            if (this.penulisList.size() == bukuLain.penulisList.size())
                skor++;

            return (skor * 100) / total;
        }

        Buku copy() {
            Buku salinan = new Buku(this.judul, this.tahun, this.sinopsis, this.kategori);

            for (Penulis p : penulisList) {
                salinan.tambahPenulis(p);
            }

            return salinan;
        }

        void bacaFile(String data) {
            String[] bagian = data.split(";");

            this.judul = bagian[0];
            this.tahun = Integer.parseInt(bagian[1]);
            this.sinopsis = bagian[2];
            this.kategori.nama = bagian[3];

            penulisList.clear();
            String[] penulisArray = bagian[4].split(",");

            for (String nama : penulisArray) {
                this.tambahPenulis(new Penulis(nama.trim()));
            }
        }

        String simpanFile() {
            String hasil = "";

            for (int i = 0; i < penulisList.size(); i++) {
                hasil += penulisList.get(i).nama;
                if (i < penulisList.size() - 1) {
                    hasil += ",";
                }
            }

            return judul + ";" +
                    tahun + ";" +
                    sinopsis + ";" +
                    kategori.nama + ";" +
                    hasil;
        }

        double hitungRoyalti(double harga) {
            return harga * 0.1;
        }

        double hitungRoyalti(double harga, double persen) {
            return harga * persen / 100;
        }

        void tampilkan() {
            System.out.println("Judul     : " + judul);
            System.out.println("Tahun     : " + tahun);
            System.out.println("Sinopsis  : " + sinopsis);
            System.out.println("Jumlah kata sinopsis : " + hitungJumlahKataSinopsis());

            System.out.print("Penulis   : ");
            for (int i = 0; i < penulisList.size(); i++) {
                System.out.print(penulisList.get(i).nama);
                if (i < penulisList.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
            System.out.println("Kategori  : " + kategori.nama);
            System.out.println("--------------------------");
        }
    }

    class Kategori {
        String nama;
        ArrayList<Buku> bukuList = new ArrayList<>();

        Kategori(String nama) {
            this.nama = nama;
        }

        void tambahBuku(Buku b) {
            bukuList.add(b);
        }

        void tampilkanBuku() {
            System.out.println("\n=== KATEGORI " + nama.toUpperCase() + " ===");
            for (Buku b : bukuList) {
                b.tampilkan();
            }
        }
    }

    public static void main(String[] args) {

        modulsatualternate p = new modulsatualternate();

        Kategori teknologi = p.new Kategori("Teknologi");
        Kategori filsafat = p.new Kategori("Filsafat");
        Kategori sejarah = p.new Kategori("Sejarah");
        Kategori agama = p.new Kategori("Agama");
        Kategori psikologi = p.new Kategori("Psikologi");
        Kategori politik = p.new Kategori("Politik");
        Kategori fiksi = p.new Kategori("Fiksi");

        // TEKNOLOGI
        Buku b1 = p.new Buku("Pemrograman Jawa", 2020,
                "Buku ini menjelaskan dasar dasar pemrograman Java bagi pemula secara lengkap", teknologi);
        b1.tambahPenulis(p.new Penulis("Budi"));
        b1.tambahPenulis(p.new Penulis("Dayandra"));
        b1.tambahPenulis(p.new Penulis("Tuko"));
        teknologi.tambahBuku(b1);

        Buku b2 = p.new Buku("AI Dasar", 2021,
                "Buku ini membahas konsep dasar kecerdasan buatan dalam kehidupan modern", teknologi);
        b2.tambahPenulis(p.new Penulis("Andi"));
        teknologi.tambahBuku(b2);

        // FILSAFAT
        Buku f1 = p.new Buku("Pengantar Filsafat", 2010,
                "Buku ini menjelaskan konsep dasar filsafat serta pemikiran para tokoh terkenal", filsafat);
        f1.tambahPenulis(p.new Penulis("Albert"));
        filsafat.tambahBuku(f1);

        // SEJARAH
        Buku s1 = p.new Buku("Sejarah Dunia", 2005,
                "Buku ini menjelaskan perjalanan sejarah dunia dari masa kuno hingga modern", sejarah);
        s1.tambahPenulis(p.new Penulis("Darmawan"));
        sejarah.tambahBuku(s1);

        // AGAMA
        Buku a1 = p.new Buku("Ajaran Agape", 2001,
                "Buku ini membahas makna kasih agape dalam kehidupan manusia dan iman", agama);
        a1.tambahPenulis(p.new Penulis("Setiawan"));
        agama.tambahBuku(a1);

        // PSIKOLOGI
        Buku p1 = p.new Buku("Psikologi Mahasigma", 2010,
                "Buku ini menjelaskan konsep psikologi manusia dalam menghadapi tantangan kehidupan", psikologi);
        p1.tambahPenulis(p.new Penulis("Helmi"));
        psikologi.tambahBuku(p1);

        // POLITIK
        Buku po1 = p.new Buku("Politik Indonesia", 2015,
                "Buku ini membahas sistem politik Indonesia serta dinamika pemerintahan modern", politik);
        po1.tambahPenulis(p.new Penulis("Anton"));
        politik.tambahBuku(po1);

        // FIKSI
        Buku fi1 = p.new Buku("Sejarah Kerajaan Ngawi", 2003,
                "Cerita fiksi tentang kerajaan kuno yang memiliki kekuatan misterius besar", fiksi);
        fi1.tambahPenulis(p.new Penulis("Arman"));
        fiksi.tambahBuku(fi1);

        teknologi.tampilkanBuku();
        filsafat.tampilkanBuku();
        sejarah.tampilkanBuku();
        agama.tampilkanBuku();
        psikologi.tampilkanBuku();
        politik.tampilkanBuku();
        fiksi.tampilkanBuku();

        //CEK TINGKAT KESAMAAN
        System.out.println("\nContoh cek kesamaan buku:");
        System.out.println("Kesamaan b1 dan b2 = " + b1.cekKesamaan(b2) + "%");

        //BUAT SALINAN
        Buku salinan = b1.copy();
        System.out.println("\nContoh buku hasil copy:");
        salinan.tampilkan();

        //BACA DN SIMPAN
        String data = b1.simpanFile();
        System.out.println("\nIsi data:");
        System.out.println(data);

        Buku bukuBaru = p.new Buku("", 0, "", teknologi);
        bukuBaru.bacaFile(data);

        System.out.println("\nHasil baca:");
        bukuBaru.tampilkan();

        //ROYALTY
        System.out.println("\nContoh hitung royalti:");
        System.out.println("Royalti 10% : " + b1.hitungRoyalti(100000));
        System.out.println("Royalti custom : " + b1.hitungRoyalti(100000, 20));
    }
}