package rumahTangga.repositories;

import rumahTangga.entities.RumahTangga;

public interface RumahTanggaRepository {
    RumahTangga[] getAll();
    void add(RumahTangga rumahTangga);
    Boolean remove(Integer id);
    Boolean edit(RumahTangga rumahTangga);
}