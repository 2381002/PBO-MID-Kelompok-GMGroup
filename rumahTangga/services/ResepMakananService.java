package rumahTangga.services;

import rumahTangga.entities.resepMakanan;

import java.util.ArrayList;

public interface ResepMakananService {
    void hapusResep();
    void editResepMakanan();
    void addResepMakanan();
    ArrayList<resepMakanan> getAll();
}
