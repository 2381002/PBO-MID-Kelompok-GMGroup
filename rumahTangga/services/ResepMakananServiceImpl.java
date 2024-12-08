package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.inventarisRumah;
import rumahTangga.entities.resepMakanan;
import rumahTangga.repositories.anggotaKeluargaRepository;
import rumahTangga.repositories.resepMakananRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Component
public class ResepMakananServiceImpl implements ResepMakananService{

    resepMakananRepository resepMakananRepository;

    Scanner input = new Scanner(System.in);
    public ResepMakananServiceImpl(rumahTangga.repositories.resepMakananRepository resepMakananRepository)  {
        this.resepMakananRepository = resepMakananRepository;
    }

    @Override
    public void addResepMakanan() {
        resepMakanan makanan = new resepMakanan();
        System.out.print("Masukkan nama resep makanan:");
        input.nextLine();
        makanan.setNama(input.nextLine());
        System.out.print("Masukkan Deskripsi makanan:");
        makanan.setDeskripsi(input.nextLine());
        resepMakananRepository.add(makanan);
    }

    @Override
    public void editResepMakanan() {
        System.out.print("Masukkan nama makan:");
        input.nextLine();
        String nama = input.nextLine();
        resepMakanan makanan = carinama(nama);
        System.out.println("Masukan Nama Baru Makan : ");
        makanan.setNama(input.nextLine());
        System.out.println("Masukan Deskripsi Baru Makan : ");
        makanan.setDeskripsi(input.nextLine());
        resepMakananRepository.edit(makanan);
    }

    @Override
    public void hapusResep() {
        System.out.print("Masukkan nama makan:");
        input.nextLine();
        String nama = input.nextLine();
        resepMakanan makanan = carinama(nama);
        resepMakananRepository.remove(makanan.getId());
    }


    private resepMakanan carinama(String nama) {
        ArrayList<resepMakanan> listResep = resepMakananRepository.getAll();
        for (resepMakanan i:listResep) {
            if (Objects.equals(nama, i.getNama())) {
                return i;
            }
        }
        return new resepMakanan();
    }

    @Override
    public ArrayList<resepMakanan> getAll(){
        return resepMakananRepository.getAll();
    }
}