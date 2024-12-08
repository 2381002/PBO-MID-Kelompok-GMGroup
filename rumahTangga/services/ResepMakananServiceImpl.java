package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.resepMakanan;
import rumahTangga.repositories.anggotaKeluargaRepository;
import rumahTangga.repositories.resepMakananRepository;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class ResepMakananServiceImpl {
    resepMakananRepository resepMakananRepository;

    Scanner input = new Scanner(System.in);
    public ResepMakananServiceImpl(resepMakananRepository) {
        this.resepMakananRepository = rumahTangga.repositories.resepMakananRepository;
    }

    public void addAnggotaKeluarga() {
        anggotaKeluarga anggota = new anggotaKeluarga();
        System.out.print("Masukkan nama anggota keluarga:");
        input.nextLine();
        anggota.setKeuangan(0);
        anggota.setNama(input.nextLine());
        anggotaKeluargaRepository.add(anggota);
    }


    public void editAnggotaKeluarga() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan nama baru anda:");
        anggota.setNama(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
    }


    public void hapusAnggota() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggotaKeluargaRepository.remove(anggota.getId());
    }

    resepMakanan carinama(String nama) {
        resepMakanan resep = new resepMakanan();
        ArrayList<resepMakanan> listResep = resepMakananRepository.getAll();
        for (resepMakanan i:listResep) {
            if (nama == i.getNama()) {
                resep = i;
            }
        }
        return resep;
    }
}
