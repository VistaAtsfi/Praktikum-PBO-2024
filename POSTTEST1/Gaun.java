class Gaun {
    private String kode;
    private String nama;
    private double harga;

    public Gaun(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
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

    @Override
    public String toString() {
        return "Data Gaun{" +
                "Kode = '" + kode + '\'' +
                ", Nama = '" + nama + '\'' +
                ", Harga = " + harga +
                '}';
    }
}
