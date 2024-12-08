package rumahTangga.repositories;

import rumahTangga.entities.inventarisRumah;

import java.util.ArrayList;

public interface InventarisRumahRepository {
    ArrayList<inventarisRumah> getAll();
    void add(inventarisRumah rumah);
    Boolean remove(Integer id);
    Boolean edit(inventarisRumah rumah);
}
