/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevin.client2101082039.model;

/**
 *
 * @author ASUS
 */
public class Gaji {
    private String kodeSlip;
    private Long anggotaId;
    private String tanggal;
    private int golongan;
    private double potongan;
    private double gajiBersih; 

    
    public void setKodeSlip(String kodeSlip) {
        this.kodeSlip = kodeSlip;
    }
    
    public String getKodeSlip() {
        return kodeSlip;
    }

    

    public Long getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Long anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }

    public double getPotongan() {
        return potongan;
    }

    public void setPotongan(double potongan) {
        this.potongan = potongan;
    }

    public double getGajiBersih() {
        return gajiBersih;
    }

    public void setGajiBersih(double gajiBersih) {
        this.gajiBersih = gajiBersih;
    }
    

}