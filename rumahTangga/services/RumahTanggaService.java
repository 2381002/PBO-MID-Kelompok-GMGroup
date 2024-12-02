package rumahTangga.services;

import rumahTangga.entities.RumahTangga;

public interface RumahTanggaService {
    RumahTangga[] getRumahTanggaList();
    void addRumahTangga(String todo);
    Boolean removeRumahTangga(Integer number);
    Boolean editRumahTangga(Integer number, String todo);
}