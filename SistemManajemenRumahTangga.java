import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemenRumahTangga {

    // Menyimpan data
    static ArrayList<String> anggotaKeluarga = new ArrayList<>();
    static ArrayList<String> pemasukan = new ArrayList<>();
    static ArrayList<String> pengeluaran = new ArrayList<>();
    static ArrayList<String> jadwal = new ArrayList<>();
    static ArrayList<String> inventaris = new ArrayList<>();
    static ArrayList<String> resep = new ArrayList<>();
    static ArrayList<String> pengingat = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat datang di Sistem Manajemen Rumah Tangga!");

        while (true) {
            System.out.print("Masukkan role (admin/user) atau 'keluar' untuk keluar: ");
            String role = scanner.nextLine();

            if (role.equalsIgnoreCase("admin")) {
                adminMenu();
            } else if (role.equalsIgnoreCase("user")) {
                userMenu();
            } else if (role.equalsIgnoreCase("keluar")) {
                System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                break; // Keluar dari aplikasi
            } else {
                System.out.println("Role tidak valid!");
            }
        }

        scanner.close();
    }

    // Menu untuk admin
    private static void adminMenu() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Manajemen Anggota Keluarga");
            System.out.println("2. Manajemen Keuangan");
            System.out.println("3. Jadwal Kegiatan");
            System.out.println("4. Inventaris Rumah");
            System.out.println("5. Resep Masakan");
            System.out.println("6. Pengingat Tugas");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageFamilyMembers();
                    break;
                case 2:
                    manageFinancials();
                    break;
                case 3:
                    manageSchedule();
                    break;
                case 4:
                    manageInventory();
                    break;
                case 5:
                    manageRecipes();
                    break;
                case 6:
                    manageReminders();
                    break;
                case 7:
                    System.out.println("Keluar dari menu admin.");
                    return; // Keluar dari menu admin dan kembali ke pemilihan role
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }

    // Menu untuk user
    private static void userMenu() {
        while (true) {
            System.out.println("\nMenu User:");
            System.out.println("1. Lihat Anggota Keluarga");
            System.out.println("2. Lihat Keuangan");
            System.out.println("3. Lihat Jadwal Kegiatan");
            System.out.println("4. Lihat Inventaris Rumah");
            System.out.println("5. Lihat Resep Masakan");
            System.out.println("6. Lihat Pengingat Tugas");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewFamilyMembers();
                    break;
                case 2:
                    viewFinancials();
                    break;
                case 3:
                    viewSchedule();
                    break;
                case 4:
                    viewInventory();
                    break;
                case 5:
                    viewRecipes();
                    break;
                case 6:
                    viewReminders();
                    break;
                case 7:
                    System.out.println("Keluar dari menu user.");
                    return; // Keluar dari menu user dan kembali ke pemilihan role
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }

    // Manajemen anggota keluarga
    private static void manageFamilyMembers() {
        while (true) {
            System.out.println("\nManajemen Anggota Keluarga:");
            System.out.println("1. Tambah Anggota Keluarga");
            System.out.println("2. Lihat Anggota Keluarga");
            System.out.println("3. Edit Anggota Keluarga");
            System.out.println("4. Hapus Anggota Keluarga");
            System.out.println("5. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String name = scanner.nextLine();
                    anggotaKeluarga.add(name);
                    System.out.println("Anggota keluarga ditambahkan: " + name);
                    break;
                case 2:
                    viewFamilyMembers();
                    break;
                case 3:
                    editFamilyMember();
                    break;
                case 4:
                    deleteFamilyMember();
                    break;
                case 5:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }



    private static void editFamilyMember() {
        viewFamilyMembers();
        System.out.print("Masukkan indeks anggota keluarga yang ingin diedit (0-" + (anggotaKeluarga.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < anggotaKeluarga.size()) {
            System.out.print("Masukkan nama baru: ");
            String newName = scanner.nextLine();
            anggotaKeluarga.set(index, newName);
            System.out.println("Anggota keluarga diubah menjadi: " + newName);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    private static void deleteFamilyMember() {
        viewFamilyMembers();
        System.out.print("Masukkan indeks anggota keluarga yang ingin dihapus (0-" + (anggotaKeluarga.size() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < anggotaKeluarga.size()) {
            String removedMember = anggotaKeluarga.remove(index);
            System.out.println("Anggota keluarga dihapus: " + removedMember);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    // Manajemen keuangan
    private static void manageFinancials() {
        while (true) {
            System.out.println("\nManajemen Keuangan:");
            System.out.println("1. Tambah Pendapatan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Edit Pendapatan/Pengeluaran");
            System.out.println("4. Hapus Pendapatan/Pengeluaran");
            System.out.println("5. Lihat Keuangan");
            System.out.println("6. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah pendapatan: ");
                    String incomeAmount = scanner.nextLine();
                    pemasukan.add(incomeAmount);
                    System.out.println("Pendapatan ditambahkan: " + incomeAmount);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah pengeluaran: ");
                    String expenseAmount = scanner.nextLine();
                    pengeluaran.add(expenseAmount);
                    System.out.println("Pengeluaran ditambahkan: " + expenseAmount);
                    break;
                case 3:
                    editFinancials();
                    break;
                case 4:
                    deleteFinancials();
                    break;
                case 5:
                    viewFinancials();
                    break;
                case 6:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }

    private static void editFinancials() {
        System.out.println("Pendapatan:");
        for (int i = 0; i < pemasukan.size(); i++) {
            System.out.println(i + ". " + pemasukan.get(i));
        }
        System.out.println("Pengeluaran:");
        for (int i = 0; i < pengeluaran.size(); i++) {
            System.out.println(i + ". " + pengeluaran.get(i));
        }
        System.out.print("Masukkan indeks yang ingin diedit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < pemasukan.size()) {
            System.out.print("Masukkan jumlah baru: ");
            String newAmount = scanner.nextLine();
            pemasukan.set(index, newAmount);
            System.out.println("Pendapatan diubah menjadi: " + newAmount);
        } else if (index >= pemasukan.size() && index < pemasukan.size() + pengeluaran.size()) {
            index -= pemasukan.size();
            System.out.print("Masukkan jumlah baru: ");
            String newAmount = scanner.nextLine();
            pengeluaran.set(index, newAmount);
            System.out.println("Pengeluaran diubah menjadi: " + newAmount);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    private static void deleteFinancials() {
        System.out.println("Pendapatan:");
        for (int i = 0; i < pemasukan.size(); i++) {
            System.out.println(i + ". " + pemasukan.get(i));
        }
        System.out.println("Pengeluaran:");
        for (int i = 0; i < pengeluaran.size(); i++) {
            System.out.println(i + ". " + pengeluaran.get(i));
        }
        System.out.print("Masukkan indeks yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < pemasukan.size()) {
            String removedIncome = pemasukan.remove(index);
            System.out.println("Pendapatan dihapus: " + removedIncome);
        } else if (index >= pemasukan.size() && index < pemasukan.size() + pengeluaran.size()) {
            index -= pemasukan.size();
            String removedExpense = pengeluaran.remove(index);
            System.out.println("Pengeluaran dihapus: " + removedExpense);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }



    // Manajemen jadwal
    private static void manageSchedule() {
        while (true) {
            System.out.println("\nJadwal Kegiatan:");
            System.out.println("1. Tambah Jadwal");
            System.out.println("2. Lihat Jadwal");
            System.out.println("3. Hapus Jadwal");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan kegiatan: ");
                    String activity = scanner.nextLine();
                    jadwal.add(activity);
                    System.out.println("Jadwal ditambahkan: " + activity);
                    break;
                case 2:
                    viewSchedule();
                    break;
                case 3:
                    deleteSchedule();
                    break;
                case 4:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }



    private static void deleteSchedule() {
        viewSchedule();
        System.out.print("Masukkan indeks jadwal yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < jadwal.size()) {
            String removedActivity = jadwal.remove(index);
            System.out.println("Jadwal dihapus: " + removedActivity);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    // Manajemen inventaris
    private static void manageInventory() {
        while (true) {
            System.out.println("\nInventaris Rumah:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Inventaris");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String item = scanner.nextLine();
                    inventaris.add(item);
                    System.out.println("Barang ditambahkan: " + item);
                    break;
                case 2:
                    viewInventory();
                    break;
                case 3:
                    deleteInventoryItem();
                    break;
                case 4:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }


    private static void deleteInventoryItem() {
        viewInventory();
        System.out.print("Masukkan indeks barang yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < inventaris.size()) {
            String removedItem = inventaris.remove(index);
            System.out.println("Barang dihapus: " + removedItem);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    // Manajemen resep
    private static void manageRecipes() {
        while (true) {
            System.out.println("\nResep Masakan:");
            System.out.println("1. Tambah Resep");
            System.out.println("2. Lihat Resep");
            System.out.println("3. Hapus Resep");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan resep: ");
                    String recipe = scanner.nextLine();
                    resep.add(recipe);
                    System.out.println("Resep ditambahkan: " + recipe);
                    break;
                case 2:
                    viewRecipes();
                    break;
                case 3:
                    deleteRecipe();
                    break;
                case 4:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }



    private static void deleteRecipe() {
        viewRecipes();
        System.out.print("Masukkan indeks resep yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < resep.size()) {
            String removedRecipe = resep.remove(index);
            System.out.println("Resep dihapus: " + removedRecipe);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }

    // Manajemen pengingat
    private static void manageReminders() {
        while (true) {
            System.out.println("\nPengingat Tugas:");
            System.out.println("1. Tambah Pengingat");
            System.out.println("2. Lihat Pengingat");
            System.out.println("3. Hapus Pengingat");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan pengingat: ");
                    String reminder = scanner.nextLine();
                    pengingat.add(reminder);
                    System.out.println("Pengingat ditambahkan: " + reminder);
                    break;
                case 2:
                    viewReminders();
                    break;
                case 3:
                    deleteReminder();
                    break;
                case 4:
                    return; // Kembali ke menu admin
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }

    private static void deleteReminder() {
        viewReminders();
        System.out.print("Masukkan indeks pengingat yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < pengingat.size()) {
            String removedReminder = pengingat.remove(index);
            System.out.println("Pengingat dihapus: " + removedReminder);
        } else {
            System.out.println("Indeks tidak valid!");
        }
    }
}
