/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevin.client2101082039.controller;

import com.kevin.client2101082039.model.Gaji;
import com.kevin.client2101082039.service.GajiService;
import com.mycompany.client2101082039.FormGaji;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class GajiController {
  private final GajiService gajiService;
    private final FormGaji formGaji;
    
    public GajiController(FormGaji formGaji){
        this.formGaji = formGaji;
        gajiService = new GajiService();
    }
    
    public void bersihForm(){
        formGaji.getTxtkodeSlip().setText("");
        formGaji.getTxtTanggal().setText("");
        formGaji.getTxtAnggotaId().setText("");
        formGaji.getTxtGolongan().setText("");
        
    }
    
    public void getkodeSlip(){
        Long id = Long.parseLong(formGaji.getTxtkodeSlip().getText());
        Gaji gaji = gajiService.getGaji(id);
        if(gaji!=null){
            formGaji.getTxtTanggal().setText(gaji.getTanggal());
            formGaji.getTxtAnggotaId().setText(gaji.getAnggotaId().toString());
            formGaji.getTxtGolongan().setText(gaji.getGolongan()+"");
            
        }else{
            JOptionPane.showMessageDialog(formGaji, "Data Tidak Ditemukan");
        }
    }
    
    public void saveAnggota() {
        Gaji gaji = new Gaji();
        gaji.setTanggal(formGaji.getTxtTanggal().getText());
        gaji.setAnggotaId(Long.parseLong(formGaji.getTxtAnggotaId().getText()));
        gaji.setGolongan(Integer.parseInt(formGaji.getTxtGolongan().getText()));
        gaji = gajiService.saveGaji(gaji);
        if (gaji != null) {
            formGaji.getTxtkodeSlip().setText(gaji.getKodeSlip().toString());
            JOptionPane.showMessageDialog(formGaji, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formGaji, "Entri Data Gagal");
        }
    }
    
    public void updateAnggota() {
        Gaji gaji = new Gaji();
        gaji.setTanggal(formGaji.getTxtTanggal().getText());
        gaji.setAnggotaId(Long.parseLong(formGaji.getTxtAnggotaId().getText()));
        gaji = gajiService.saveGaji(gaji);
        if (gaji != null) {
            formGaji.getTxtkodeSlip().setText(gaji.getKodeSlip().toString());
            JOptionPane.showMessageDialog(formGaji, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formGaji, "Update Data Gagal");
        }
    }
    
    public void deleteAnggota(){
        Long id = Long.parseLong(formGaji.getTxtkodeSlip().getText());
        gajiService.deleteGaji(id);
        JOptionPane.showMessageDialog(formGaji, "Delete Data Berhasil");
    }
    
    public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel) formGaji.getTabelgaji().getModel();
        tabelModel.setRowCount(0);
        List<Gaji> gajiList = gajiService.getAllGaji();
        for(Gaji gaji : gajiList){
            Object[] row = {
                gaji.getKodeSlip(),
                gaji.getTanggal(),
                gaji.getGolongan()
            };
            tabelModel.addRow(row);
        }
    }
}