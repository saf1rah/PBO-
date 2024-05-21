package modul5;

import java.util.ArrayList;
import java.util.Scanner;


    public class codelab5 {
        public static void main(String[] args) {
            // Membuat objek ArrayList untuk menyimpan nama mahasiswa
            ArrayList<String> mahasiswa = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);


            while (true) {
                try {
                    // Meminta user untuk menginputkan nama
                    System.out.print("Masukkan nama ke-" + (mahasiswa.size() + 1) + ": ");
                    String input = scanner.nextLine();

                    // Mengecek apakah input kosong
                    if (input.trim().isEmpty()) {
                        // Melemparkan IllegalArgumentException jika input kosong
                        throw new IllegalArgumentException("Nama tidak boleh kosong!");
                    }

                    // Memeriksa apakah user ingin berhenti menginput
                    if (input.equalsIgnoreCase("selesai")) {
                        break;
                    }

                    // Menambahkan nama ke ArrayList
                    mahasiswa.add(input);
                } catch (IllegalArgumentException e) {
                    // Menangkap dan menampilkan pesan kesalahan
                    System.out.println(e.getMessage());
                }
            }

            // Menampilkan semua data yang sudah ada di ArrayList
            System.out.println("Daftar mahasiswa yang diinputkan:");
            for (String nama : mahasiswa) {
                System.out.println("- " + nama);
            }

            // Menutup scanner
            scanner.close();
        }
    }



