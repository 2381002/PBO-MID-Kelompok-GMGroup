package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.repositories.anggotaKeluargaRepository;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class RumahTanggaServiceImpl {
    anggotaKeluargaRepository anggotaKeluargaRepository;

    Scanner input = new Scanner(System.in);
    public RumahTanggaServiceImpl(rumahTangga.repositories.anggotaKeluargaRepository anggotaKeluargaRepository) {
        this.anggotaKeluargaRepository = anggotaKeluargaRepository;
    }

    public void addAnggotaKeluarga() {
        anggotaKeluarga anggota = new anggotaKeluarga();
        System.out.print("Masukkan nama anggota keluarga:");
        input.nextLine();
        anggota.setKeuangan(0);
        anggota.setNama(input.nextLine());
        anggotaKeluargaRepository.add(anggota);
    }

    public void addKeuangan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan keuangan anda:");
        anggota.setKeuangan(input.nextInt());
        anggotaKeluargaRepository.edit(anggota);
    }

    public void addKegiatan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan kegiatan anda:");
        anggota.setKegiatan(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
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

    public void editKeuangan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan keuangan baru anda:");
        anggota.setKeuangan(input.nextInt());
        anggotaKeluargaRepository.edit(anggota);
    }

    public void editKegiatan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan kegiatan baru anda:");
        anggota.setKegiatan(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
    }

    public void hapusAnggota() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggotaKeluargaRepository.remove(anggota.getId());
    }

    public void hapusKeuangan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggota.setKeuangan(0);
        anggotaKeluargaRepository.edit(anggota);
    }

    public void hapusKegiatan() {
        System.out.print("Masukkan nama anda:");
        input.nextLine();
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggota.setKegiatan(null);
        anggotaKeluargaRepository.edit(anggota);
    }

    anggotaKeluarga carinama(String nama) {
        anggotaKeluarga anggota = new anggotaKeluarga();
        ArrayList<anggotaKeluarga> listAnggota = anggotaKeluargaRepository.getAll();
        for (anggotaKeluarga i:listAnggota) {
            if (nama == i.getNama()) {
                anggota = i;
            }
        }
        return anggota;
    }
}
