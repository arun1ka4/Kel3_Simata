package Model;

/**
 * Abstract class untuk menerapkan konsep Abstraction
 * Class ini mendefinisikan atribut umum hewan dan method abstrak
 */
public abstract class Hewan {
    protected int idSatwa;
    protected String namaSatwa;
    protected String namaLatin;
    protected String kategori;
    protected String statusKonservasi;
    protected String deskripsi;
    protected String fotoSatwa;

    // Getter dan Setter
    public int getIdSatwa() { return idSatwa; }
    public void setIdSatwa(int idSatwa) { this.idSatwa = idSatwa; }

    public String getNamaSatwa() { return namaSatwa; }
    public void setNamaSatwa(String namaSatwa) { this.namaSatwa = namaSatwa; }

    public String getNamaLatin() { return namaLatin; }
    public void setNamaLatin(String namaLatin) { this.namaLatin = namaLatin; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getStatusKonservasi() { return statusKonservasi; }
    public void setStatusKonservasi(String statusKonservasi) { this.statusKonservasi = statusKonservasi; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getFotoSatwa() { return fotoSatwa; }
    public void setFotoSatwa(String fotoSatwa) { this.fotoSatwa = fotoSatwa; }

    // Method abstrak → wajib diimplementasikan oleh class turunannya
    public abstract boolean tambahSatwa();
    public abstract boolean updateSatwa();
}
