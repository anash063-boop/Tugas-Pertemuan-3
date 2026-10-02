package com.mycompany.rekeningbank;


import com.mycompany.rekeningbank.RekeningBank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amaymon
 */
public class MainBank {
    
        private static void cetakSaldo(RekeningBank rekening) {
        System.out.println(rekening.getNamaPemilik() + " ("
                + rekening.getNoRekening() + ") -> Saldo: Rp "
                + (long) rekening.getSaldo());
    }

    public static void main(String[] args) {

        RekeningBank rek1 = new RekeningBank("1001", "Anas", 500000);
        RekeningBank rek2 = new RekeningBank("1002", "Ibrahim", 200000);

        System.out.println("=== SALDO AWAL ===");
        cetakSaldo(rek1);
        cetakSaldo(rek2);

        System.out.println("\n=== TRANSFER VALID (Rp 150.000) ===");
        rek1.transfer(150000, rek2);

        System.out.println("\n=== TRANSFER MELEBIHI SALDO (Rp 1.000.000) ===");
        rek1.transfer(1000000, rek2);

        System.out.println("\n=== BUAT REKENING SALDO AWAL < 50.000 ===");
        RekeningBank rek3 = new RekeningBank("1003", "Cici", 20000);
        cetakSaldo(rek3);

        System.out.println("\n=== SALDO AKHIR ===");
        cetakSaldo(rek1);
        cetakSaldo(rek2);
        cetakSaldo(rek3);

        System.out.println("\nTotal rekening dibuat: "
                + RekeningBank.getTotalRekening());
    }   
}
