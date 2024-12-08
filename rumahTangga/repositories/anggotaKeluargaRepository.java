package rumahTangga.repositories;

import rumahTangga.entities.anggotaKeluarga;

import java.util.ArrayList;

public interface anggotaKeluargaRepository {
    ArrayList<anggotaKeluarga> getAll();

    void add(anggotaKeluarga anggotaKeluarga);

    Boolean remove(Integer id);

    Boolean edit(anggotaKeluarga anggotaKeluarga);
}