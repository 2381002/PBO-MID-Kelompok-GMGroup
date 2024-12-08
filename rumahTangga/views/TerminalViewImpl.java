package rumahTangga.views;

import org.springframework.stereotype.Component;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.inventarisRumah;
import rumahTangga.entities.resepMakanan;
import rumahTangga.services.AnggotaKeluargaService;
import rumahTangga.services.InventarisRumahService;
import rumahTangga.services.ResepMakananService;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class TerminalViewImpl implements TerminalView{
    AnggotaKeluargaService anggotaKeluargaService;
    InventarisRumahService inventarisRumahService;
    ResepMakananService resepMakananService;

    public TerminalViewImpl(AnggotaKeluargaService anggotaKeluargaService, InventarisRumahService inventarisRumahService, ResepMakananService resepMakananService) {
        this.anggotaKeluargaService = anggotaKeluargaService;
        this.inventarisRumahService = inventarisRumahService;
        this.resepMakananService = resepMakananService;
    }



    Scanner input = new Scanner(System.in);
    private void adminMenu(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("ADMIN MENU : ");
            System.out.println("1. Menu Manajemen Anggota Keluarga");
            System.out.println("2. Menu Manajemen Inventaris Rumah");
            System.out.println("3. Menu Manajemen Resep Makanan");
            System.out.println("4. Keluar");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    menuManajemenAnggotaKeluarga();
                    break;
                case 2:
                    menuManajemenInventarisRumah();
                    break;
                case 3:
                    menuManajemenResepMakanan();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    private void userMenu(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("USER MENU : ");
            System.out.println("1. Lihat Anggota Keluarga");
            System.out.println("2. Lihat Keuangan");
            System.out.println("3. Lihat Inventaris Rumah");
            System.out.println("4. Lihat Resep Masakan");
            System.out.println("5. Lihat Jadwal Kegiatan");
            System.out.println("6. Keluar");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    showAnggotaKeluarga();
                    break;
                case 2:
                    showKeuangan();
                    break;
                case 3:
                    showInventarisRumah();
                    break;
                case 4:
                    showResepMakanan();
                    break;
                case 5:
                    showJadwalKegiatan();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    private void menuManajemenAnggotaKeluarga(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Tambah Anggota Keluarga");
            System.out.println("2. Edit Anggota Keluarga");
            System.out.println("3. Hapus Anggota Keluarga");
            System.out.println("4. Tambah Kegiatan Keluarga");
            System.out.println("5. Edit Kegiatan Keluarga");
            System.out.println("6. Hapus Kegiatan Keluarga");
            System.out.println("7. Tambah Keuangan Keluarga");
            System.out.println("8. Edit Keuangan Keluarga");
            System.out.println("9. Hapus Keuangan Keluarga");
            System.out.println("10. Exit");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    anggotaKeluargaService.addAnggotaKeluarga();
                    break;
                case 2:
                    anggotaKeluargaService.editAnggotaKeluarga();
                    break;
                case 3:
                    anggotaKeluargaService.hapusAnggota();
                    break;
                case 4:
                    anggotaKeluargaService.addKegiatan();
                    break;
                case 5:
                    anggotaKeluargaService.editKegiatan();
                    break;
                case 6:
                    anggotaKeluargaService.hapusKegiatan();
                    break;
                case 7:
                    anggotaKeluargaService.addKeuangan();
                    break;
                case 8:
                    anggotaKeluargaService.editKeuangan();
                    break;
                case 9:
                    anggotaKeluargaService.hapusKeuangan();
                    break;
                case 10:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }


    private void menuManajemenInventarisRumah(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Tambah Inventaris Barang");
            System.out.println("2. Edit Inventaris Barang");
            System.out.println("3. Hapus Inventaris Barang");
            System.out.println("4. Exit");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    inventarisRumahService.addInventory();
                    break;
                case 2:
                    inventarisRumahService.editBarang();
                    break;
                case 3:
                    inventarisRumahService.hapusBarang();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    private void menuManajemenResepMakanan(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Tambah Resep Makan");
            System.out.println("2. Edit Resep Makan");
            System.out.println("3. Hapus Resep Makan");
            System.out.println("4. Exit");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    resepMakananService.addResepMakanan();
                    break;
                case 2:
                    resepMakananService.editResepMakanan();
                    break;
                case 3:
                    resepMakananService.hapusResep();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    // Panel User
    private void showAnggotaKeluarga(){
        ArrayList<anggotaKeluarga> keluarga = anggotaKeluargaService.getAll();
        int num = 1;
        for (anggotaKeluarga anggota : keluarga){
            System.out.println(num +". " + anggota.getNama());
        }

    }

    private void showKeuangan(){
        ArrayList<anggotaKeluarga> keluarga = anggotaKeluargaService.getAll();
        int num = 1;
        int total = 0;
        for (anggotaKeluarga anggota : keluarga){
            System.out.println(num +". " + anggota.getKeuangan());
            total += anggota.getKeuangan();
        }
        System.out.println("Total Keuangan : " + total);
    }

    private void showJadwalKegiatan(){
        ArrayList<anggotaKeluarga> keluarga = anggotaKeluargaService.getAll();
        int num = 1;
        for (anggotaKeluarga anggota : keluarga){
            System.out.println(num +". " + anggota.getKegiatan());
        }
    }

    private void showInventarisRumah(){
        ArrayList<inventarisRumah> listBrg = inventarisRumahService.getAll();
        int num = 1;
        for (inventarisRumah i : listBrg){
            System.out.println(num +". " + i.getNama() + ", sejumlah : " + i.getJumlah());
        }
    }

    private void showResepMakanan(){
        ArrayList<resepMakanan> listResep = resepMakananService.getAll();
        int num = 1;
        for (resepMakanan i : listResep){
            System.out.println(num +". " + i.getNama() + ", adalah : " + i.getDeskripsi());
        }
    }


    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("SELECT ACCOUNT : ");
            System.out.println("1. ADMIN");
            System.out.println("2. USER");
            System.out.println("3. Exit");
            System.out.print("Masukan Pilihan Anda : ");
            int selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
}