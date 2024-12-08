package rumahTangga.views;

import org.springframework.stereotype.Component;
import rumahTangga.entities.RumahTangga;
import rumahTangga.services.RumahTanggaService;

import java.util.Scanner;

@Component
public class RumahTanggaTerminalViewImpl implements RumahTanggaView {
    public static Scanner scanner = new Scanner(System.in);
    private final RumahTanggaService rumahTanggaService;

    public RumahTanggaTerminalViewImpl(RumahTanggaService rumahTanggaService) {
        this.rumahTanggaService = rumahTanggaService;
    }

    public String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showRumahTanggaList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showMenuAddRumahTangga();
                    break;
                case "2":
                    showMenuRemoveRumahTangga();
                    break;
                case "3":
                    showMenuEditRumahTangga();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public void showMenuRemoveRumahTangga() {
        System.out.println("MENGHAPUS RUMAH TANGGA");
        var number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            return; // batal
        }
        try {
            boolean success = rumahTanggaService.removeRumahTangga(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus rumah tangga: " + number);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan nomor yang benar.");
        }
    }

    public void showMenuAddRumahTangga() {
        System.out.println("MENAMBAH RUMAH TANGGA");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            return; // batal
        } else {
            rumahTanggaService.addRumahTangga(todo);
            System.out.println("Berhasil menambahkan rumah tangga: " + todo);
        }
    }

    public void showMenuEditRumahTangga() {
        System.out.println("MENGEDIT RUMAH TANGGA");
        String selectedTodo = input("Masukkan nomor rumah tangga (x jika batal)");
        if (selectedTodo.equals("x")) {
            return;
        }
        String newTodo = input("Masukkan todo yang baru (x jika batal)");
        if (newTodo.equals("x")) {
            return;
        }
        try {
            boolean isEditTodoSuccess = rumahTanggaService.editRumahTangga(Integer.valueOf(selectedTodo), newTodo);
            if (isEditTodoSuccess) {
                System.out.println("Berhasil mengedit rumah tangga");
            } else {
                System.out.println("Gagal mengedit rumah tangga");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid . Harap masukkan nomor yang benar.");
        }
    }

    public void showRumahTanggaList() {
        System.out.println("RUMAH TANGGA LIST");
        RumahTangga[] rumahTanggaList = rumahTanggaService.getRumahTanggaList();
        for (var i = 0; i < rumahTanggaList.length; i++) {
            var rumahTangga = rumahTanggaList[i];
            if (rumahTangga != null) {
                System.out.println((i + 1) + ". " + rumahTangga.getTodo());
            }
        }
    }

    @Override
    public void run() {
        showMainMenu();
    }
}