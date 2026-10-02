/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rekeningbank;

/**
 *
 * @author Amaymon
 */
public class RekeningBank {
    
    private String noRekening;
    private String namaPemilik;
    private double saldo;

    private static int totalRekening = 0;

    public RekeningBank(String noRekening, String namaPemilik, double saldoAwal) {
        this.noRekening = noRekening;
        this.namaPemilik = namaPemilik;

        if (saldoAwal >= 50000) {
            this.saldo = saldoAwal;
        } else {
            System.out.println("ERROR: Saldo awal minimal Rp 50.000. Saldo diset ke Rp 0.");
            this.saldo = 0;
        }

        totalRekening++;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("ERROR: Saldo tidak boleh negatif.");
        }
    }

    public void transfer(double nominal, RekeningBank tujuan) {
        if (tujuan == null) {
            System.out.println("GAGAL: Rekening tujuan tidak valid.");
            return;
        }

        if (tujuan == this) {
            System.out.println("GAGAL: Tidak dapat transfer ke rekening sendiri.");
            return;
        }

        if (nominal <= 0) {
            System.out.println("GAGAL: Nominal transfer harus lebih dari 0.");
            return;
        }

        if (nominal > saldo) {
            System.out.println("GAGAL: Saldo tidak cukup. Saldo " + namaPemilik
                    + " = Rp " + (long) saldo + ", nominal = Rp " + (long) nominal);
            return;
        }

        saldo -= nominal;
        tujuan.saldo += nominal;

        System.out.println("BERHASIL: " + namaPemilik + " mentransfer Rp "
                + (long) nominal + " ke " + tujuan.namaPemilik);
    }

    public String getNoRekening() {
        return noRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }
    
    public static int getTotalRekening() {
        return totalRekening;
    }
}
