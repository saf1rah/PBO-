package CODELAB;

import java.util.ArrayList;
import java.util.Scanner;

public class codelab_modul2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        int pilih;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampilkan data mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan anda: ");
            pilih = input.nextInt();
            input.nextLine(); // consume newline

            switch (pilih) {
                case 1:
                    Mahasiswa tambahkanMahasiswa = new Mahasiswa();
                    tambahkanMahasiswa.tambahData();
                    daftarMahasiswa.add(tambahkanMahasiswa);
                    break;
                case 2:
                    menampilkanDataMahasiswa(daftarMahasiswa);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Maaf inputan anda salah");
                    break;
            }
        } while (pilih != 3);
    }

    private static void menampilkanDataMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa) {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("\nBelum ada data mahasiswa.");
        } else {
            System.out.println("\nData Mahasiswa:");
            Mahasiswa tambahkanMahasiswa = new Mahasiswa();
            tambahkanMahasiswa.tampilUniversitas();
            for (Mahasiswa mahasiswa : daftarMahasiswa) {
                mahasiswa.tampilDataMahasiswa();
            }
        }
    }
}

class Mahasiswa {
    String nama;
    long nim;
    String jurusan;

    void tambahData() {
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        nama = inp.nextLine();
        System.out.print("Masukkan Nim mahasiswa: ");
        nim = inp.nextLong();
        long length = String.valueOf(nim).length();
        while (length != 15) {
            System.out.println("Nim harus 15 digit!!!");
            System.out.print("Masukkan Nim mahasiswa: ");
            nim = inp.nextLong();
            length = String.valueOf(nim).length();
        }
        inp.nextLine(); // consume newline
        System.out.print("Masukkan jurusan mahasiswa: ");
        jurusan = inp.nextLine();
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    void tampilDataMahasiswa() {
        System.out.println("Nama: " + nama + ", NIM: " + nim + ", Jurusan: " + jurusan);
    }

    void tampilUniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }
}
