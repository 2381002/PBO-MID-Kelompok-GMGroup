package rumahTangga.services;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.repositories.anggotaKeluargaRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Component
public class AnggotaKeluargaServiceImpl implements AnggotaKeluargaService {
    anggotaKeluargaRepository anggotaKeluargaRepository;

    Scanner input = new Scanner(System.in);
    public AnggotaKeluargaServiceImpl(rumahTangga.repositories.anggotaKeluargaRepository anggotaKeluargaRepository) {
        this.anggotaKeluargaRepository = anggotaKeluargaRepository;
    }

    @Override
    public void addAnggotaKeluarga() {
        anggotaKeluarga anggota = new anggotaKeluarga();
        System.out.print("Masukkan nama anggota keluarga:");
        anggota.setNama(input.nextLine());
        anggota.setKeuangan(0);
        anggotaKeluargaRepository.add(anggota);
    }
    @Override
    public void addKeuangan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan keuangan anda:");
        anggota.setKeuangan(input.nextInt());
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void addKegiatan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan kegiatan anda:");
        anggota.setKegiatan(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void editAnggotaKeluarga() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan nama baru anda:");
        anggota.setNama(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void editKeuangan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan keuangan baru anda:");
        anggota.setKeuangan(input.nextInt());
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void editKegiatan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        System.out.print("Masukkan kegiatan baru anda:");
        anggota.setKegiatan(input.nextLine());
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void hapusAnggota() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggotaKeluargaRepository.remove(anggota.getId());
    }
    @Override
    public void hapusKeuangan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggota.setKeuangan(0);
        anggotaKeluargaRepository.edit(anggota);
    }
    @Override
    public void hapusKegiatan() {
        System.out.print("Masukkan nama anda:");
        String nama = input.nextLine();
        anggotaKeluarga anggota = carinama(nama);
        anggota.setKegiatan(null);
        anggotaKeluargaRepository.edit(anggota);
    }

    anggotaKeluarga carinama(String nama) {
        ArrayList<anggotaKeluarga> listAnggota = anggotaKeluargaRepository.getAll();
        for (anggotaKeluarga i:listAnggota) {
            if (Objects.equals(nama, i.getNama())) {
                return i;
            }
        }
        return new anggotaKeluarga();
    }

    @Override
    public ArrayList<anggotaKeluarga> getAll(){
        return anggotaKeluargaRepository.getAll();
    }
}