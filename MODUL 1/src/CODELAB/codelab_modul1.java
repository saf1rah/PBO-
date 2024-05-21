package CODELAB;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class codelab_modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");
        String gender = scanner.nextLine();

        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        String tanggalKelahiranStr = scanner.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalKelahiranStr, DateTimeFormatter.ISO_DATE);

        System.out.println("\n// output\n");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + (gender.equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan"));

        LocalDate hariIni = LocalDate.now();
        Period period = Period.between(tanggalLahir, hariIni);
        int usiadalamTahun = period.getYears();
        int usiadalamBulan = period.getMonths();
        System.out.println("Umur Anda: " + usiadalamTahun + "tahun" + usiadalamBulan + "bulan");

        scanner.close();
    }
}