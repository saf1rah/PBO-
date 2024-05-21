package TUGAS;

import java.util.Scanner;
class Student {
    public static String[] nama = new String[10];
    public static String[] fakultas = new String[10];
    public static String[] nim = new String[10];
    public static String[] prodi = new String[10];
    public static String[] bukuTerpinjam = new String[10];

    int checkStudent() {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan NIM Anda (input 99 untuk kembali): ");
        String input = scanString.nextLine();
        if (input.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return 0;
        }
        for (int i = 0; i < nim.length; i++) {
            if (input.equals(nim[i])) {
                System.out.println("Sukses login sebagai student\n");
                return 1;
            }
        }
        System.out.println("Nim tidak ditemukan\n");
        return 0;
    }

    void pinjamBuku(int j) {
        Scanner scanString = new Scanner(System.in);
        System.out.println("Input id buku yang ingin anda pinjam (input 99 untuk kembali)");
        System.out.print("Input: ");
        String idBuku = scanString.nextLine();
        if (idBuku.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return;
        }
        for (int i = 0; i < Main.idBuku.length; i++) {
            if (idBuku.equals(Main.idBuku[i])) {
                System.out.println("Buku id " + idBuku + " berhasil dipinjam");
                Main.stock[i] -= 1;
                bukuTerpinjam[j] = idBuku;
                return;
            }
        }
        System.out.println("Buku tidak ditemukan");
    }

    void displayBukuTerpinjam() {
        System.out.println("Buku terpinjam: ");
        for (int i = 0; i < bukuTerpinjam.length; i++) {
            if (bukuTerpinjam[i] == null) {
                break;
            } else {
                System.out.printf("%d. %s\n", i + 1, bukuTerpinjam[i]);
            }
        }
    }
}

class Admin {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "1";
    private static int studentCount = 0;

    int checkAdmin() {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Enter your username (admin): ");
        String user = scanString.nextLine();
        System.out.print("Enter your password (admin): ");
        String pass = scanString.nextLine();
        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("Sukses login sebagai admin\n");
            return 1;
        } else {
            System.out.println("Admin tidak ditemukan\n");
            return 0;
        }
    }

    void addStudent() {
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        Student.nama[studentCount] = scanString.nextLine();

        System.out.print("Masukkan fakultas mahasiswa: ");
        Student.fakultas[studentCount] = scanString.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        Student.nim[studentCount] = scanString.nextLine();
        while (Student.nim[studentCount].length() != 15) {
            System.out.print("Nim Harus 15 Digit!!!\nMasukkan NIM mahasiswa: ");
            Student.nim[studentCount] = scanString.nextLine();
        }

        System.out.print("Masukkan jurusan mahasiswa: ");
        Student.prodi[studentCount] = scanString.nextLine();

        System.out.print("Data Mahasiswa berhasil ditambahkan.\n");
        studentCount++;
    }

    void displayStudent() {
        for (int j = 0; j < studentCount; j++) {
            System.out.println("\nData mahasiswa ke " + (j + 1));
            System.out.println("Nama: " + Student.nama[j]);
            System.out.println("Fakultas: " + Student.fakultas[j]);
            System.out.println("NIM: " + Student.nim[j]);
            System.out.println("Prodi: " + Student.prodi[j]);
        }
    }
}

class Main {
    // data buku
    public static final String[] idBuku = {"388c-e681-9152", "ed90-be30-5cdb", "d95e-0c4a-9523"};
    public static final String[] namaBuku = {"title", "title", "title"};
    public static final String[] author = {"author", "author", "author"};
    public static final String[] category = {"Sejarah", "Sejarah", "Sejarah"};
    public static int[] stock = {4, 0, 2};

    void menuUtama() {
        System.out.println("\n==== Library System ====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Pilihan Anda: ");
    }

    void menuStudent() {
        System.out.println("\n==== Student Menu ====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void menuAdmin() {
        System.out.println("\n==== Admin Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Student");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void displayBook() {
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No. || Id Buku\t\t\t\t || Nama Buku\t\t || Author\t\t || Category\t || Stock\t || ");
        for (int i = 0; i < idBuku.length; i++) {
            System.out.printf("|| %d   || %s\t\t || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, idBuku[i], namaBuku[i], author[i], category[i], stock[i]);
        }
        System.out.println("===========================================================================================================================================");
    }

    public static void main(String[] args) {
        Student student = new Student();
        Admin admin = new Admin();
        Main main = new Main();

        while (true) {
            main.menuUtama();
            Scanner scanInt = new Scanner(System.in);
            int pilih = scanInt.nextInt();
            if (pilih == 1) {
                if (student.checkStudent() == 0) {
                    continue;
                }
                int j = 0;
                while (true) {
                    main.menuStudent();
                    pilih = scanInt.nextInt();
                    if (pilih == 1) {
                        student.displayBukuTerpinjam();
                    } else if (pilih == 2) {
                        main.displayBook();
                        student.pinjamBuku(j);
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (pilih == 2) {
                if (admin.checkAdmin() == 0) {
                    continue;
                }
                while (true) {
                    main.menuAdmin();
                    pilih = scanInt.nextInt();
                    if (pilih == 1) {
                        admin.addStudent();
                    } else if (pilih == 2) {
                        admin.displayStudent();
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}