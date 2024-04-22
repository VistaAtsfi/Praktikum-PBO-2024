class Gaun {
    private String kode;
    private String nama;
    private double harga;
    private String warna; // Tambahkan atribut warna

    // Constructor overloading
    public Gaun(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    // Overloading constructor untuk Gaun dengan tambahan warna
    public Gaun(String kode, String nama, double harga, String warna) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.warna = warna;
    }

    // Method Getter dan Setter
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getWarna() { // Tambahkan getter untuk atribut warna
        return warna;
    }

    public void setWarna(String warna) { // Tambahkan setter untuk atribut warna
        this.warna = warna;
    }

    @Override
    public String toString() {
        return "Data Gaun{" +
                "Kode = '" + kode + '\'' +
                ", Nama = '" + nama + '\'' +
                ", Harga = " + harga +
                '}';
    }
}


class GaunPesta extends Gaun {
    private String model;

    public GaunPesta(String kode, String nama, double harga, String model) {
        super(kode, nama, harga);
        if (validateKode(model)) {
            this.model = model;
        } else {
            System.out.println("Model tidak valid. Model hanya boleh berupa huruf.");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (validateKode(model)) {
            this.model = model;
        } else {
            System.out.println("Model tidak valid. Model hanya boleh berupa huruf.");
        }
    }

    private boolean validateKode(String kode) {
        return kode.matches("[a-zA-Z]+");
    }

    @Override
    public String toString() {
        return "Data Gaun Pesta{" +
                "Kode = '" + getKode() + '\'' +
                ", Nama = '" + getNama() + '\'' +
                ", Harga = " + getHarga() +
                ", Model = '" + model + '\'' +
                '}';
    }
}

class GaunCasual extends Gaun {
    private String warna;

    public GaunCasual(String kode, String nama, double harga, String warna) {
        super(kode, nama, harga, warna);  //panggil constructor
        if (validateKode(warna)) {
            this.warna = warna;
        } else {
            System.out.println("Warna tidak valid. Warna hanya boleh berupa huruf.");
        }
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        if (validateKode(warna)) {
            this.warna = warna;
        } else {
            System.out.println("Warna tidak valid. Warna hanya boleh berupa huruf.");
        }
    }

    private boolean validateKode(String kode) {
        return kode.matches("[a-zA-Z]+");
    }

    @Override
    public String toString() {
        return "Data Gaun Casual{" +
                "Kode = '" + getKode() + '\'' +
                ", Nama = '" + getNama() + '\'' +
                ", Harga = " + getHarga() +
                ", Warna = '" + warna + '\'' +
                '}';
    }
}