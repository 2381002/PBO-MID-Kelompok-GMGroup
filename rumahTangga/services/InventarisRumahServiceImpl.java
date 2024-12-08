package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.inventarisRumah;
import rumahTangga.entities.resepMakanan;
import rumahTangga.repositories.InventarisRumahRepository;
import rumahTangga.repositories.resepMakananRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Component
public class InventarisRumahServiceImpl implements InventarisRumahService{
    InventarisRumahRepository inventarisRumahRepository;


    Scanner input = new Scanner(System.in);

    public InventarisRumahServiceImpl(InventarisRumahRepository inventarisRumahRepository) {
        this.inventarisRumahRepository = inventarisRumahRepository;
    }

    @Override
    public void addInventory() {
        inventarisRumah brg = new inventarisRumah();
        System.out.print("Masukkan nama barang:");
        brg.setNama(input.nextLine());
        System.out.print("Masukkan Jumlah barang :");
        brg.setJumlah(input.nextInt());
        inventarisRumahRepository.add(brg);
    }

    @Override
    public void editBarang() {
        System.out.print("Masukkan nama Barang:");
        String nama = input.nextLine();
        inventarisRumah brg = carinama(nama);
        System.out.println("Masukan Nama Baru Barang : ");
        brg.setNama(input.nextLine());
        System.out.println("Masukan Jumlah Baru Barang : ");
        brg.setJumlah(input.nextInt());
        inventarisRumahRepository.edit(brg);
    }

    @Override
    public void hapusBarang() {
        System.out.print("Masukkan nama Barang:");
        String nama = input.nextLine();
        inventarisRumah brg = carinama(nama);
        inventarisRumahRepository.remove(brg.getId());
    }


    private inventarisRumah carinama(String nama) {
        ArrayList<inventarisRumah> listbrg = inventarisRumahRepository.getAll();
        for (inventarisRumah i:listbrg) {
            if (Objects.equals(nama, i.getNama())) {
                return i;
            }
        }
        return new inventarisRumah();
    }

    @Override
    public ArrayList<inventarisRumah> getAll(){
        return inventarisRumahRepository.getAll();
    }
}