package rumahTangga.services;

import rumahTangga.entities.inventarisRumah;

import java.util.ArrayList;

public interface InventarisRumahService {
    void addInventory();
    void editBarang();
    ArrayList<inventarisRumah> getAll();
    void hapusBarang();
}
