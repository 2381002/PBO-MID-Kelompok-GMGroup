package rumahTangga.services;

import rumahTangga.entities.anggotaKeluarga;

import java.util.ArrayList;

public interface AnggotaKeluargaService {
    void hapusKegiatan();
    void hapusKeuangan();
    void hapusAnggota();
    void editKegiatan();
    void editKeuangan();
    void editAnggotaKeluarga();
    void addKegiatan();
    void addKeuangan();
    void addAnggotaKeluarga();
    ArrayList<anggotaKeluarga> getAll();
}