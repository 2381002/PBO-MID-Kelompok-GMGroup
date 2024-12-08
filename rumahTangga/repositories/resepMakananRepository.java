package rumahTangga.repositories;

import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.resepMakanan;

import java.util.ArrayList;

public interface resepMakananRepository {
    ArrayList<resepMakanan> getAll();

    void add(resepMakanan resepMakanan);

    Boolean remove(Integer id);

    Boolean edit(resepMakanan resepMakanan);
}
