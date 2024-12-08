package rumahTangga.entities;

public class anggotaKeluarga {
    private String nama;
    private Integer id;

    public anggotaKeluarga() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(final String nama) {
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    private Integer keuangan;

    public Integer getKeuangan() {
        return keuangan;
    }

    public void setKeuangan(Integer keuangan) {
        this.keuangan = keuangan;
    }

    private String kegiatan;

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }


}