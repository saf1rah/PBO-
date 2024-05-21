package org.example;

public class App {
    public static void main(String[] args) throws Exception {
        Balok balok = new Balok("balok");
        Kubus kubus = new Kubus("kubus");
        Tabung tabung = new Tabung("tabung");

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}