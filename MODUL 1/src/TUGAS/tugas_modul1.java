package TUGAS;

import java.util.Scanner;

public class tugas_modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Data Pengguna
        String adminUsername = "admin";
        String adminPassword = "admin";
        String[] mahasiswaNIMs = {"202310370311199"};

        while (true) {
            System.out.println("library System");
            System.out.println("1.Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. exit");
            System.out.print("Choose option (1-3): ");

            int option = scanner.nextInt();
            scanner.nextLine(); //Membuang karakter newline

            switch (option) {
                case 1:
                    System.out.print("Enter your NIM: ");
                    String nim = scanner.nextLine();

                    //Validasi NIM untuk mahasiswa
                    if (isValidNIM(nim, 15) && isMahasiswa(nim, mahasiswaNIMs)) {
                        System.out.println("Succesfull Login as Student");
                    } else {
                        System.out.println("User Not Found");
                    }
                    break;

                case 2:
                    System.out.print("Enter your username (admin): ");
                    String adminUserInput = scanner.nextLine();
                    System.out.print("Enter your password (admin): ");
                    String adminPasswordInput = scanner.nextLine();

                    //validasi admin
                    if (adminUserInput.equals(adminUsername) && adminPasswordInput.equals(adminPassword)) {
                        System.out.println("Successfull Login as Admin");
                    } else {
                        System.out.println("Admin User Not Found");

                    }
                    break;

                case 3:
                    System.out.println("Existing Library System");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    //validasi panjang NIM
    private static boolean isValidNIM(String nim, int length) {
        return nim.length() == length;
    }

    //validasi apakah NIM merupakan NIM mahasiswa
    private static boolean isMahasiswa(String nim, String[] mahasiswaNIMs) {
        for (String mahasiswaNIM : mahasiswaNIMs) {
            if (mahasiswaNIM.equals(nim)) {
                return true;
            }
        }
        return false;
    }
}

