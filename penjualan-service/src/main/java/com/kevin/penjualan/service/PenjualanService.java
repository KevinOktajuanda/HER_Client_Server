/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kevin.penjualan.service;

import com.kevin.penjualan.vo.Pelanggan;
import com.kevin.penjualan.vo.ResponseTemplateVO;
import com.kevin.penjualan.entity.Penjualan;
import com.kevin.penjualan.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ASUS
 */
@Service
public class PenjualanService {

    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Penjualan savePenjualan(Penjualan penjualan) {
        double total = 0.0;
        double harga = penjualan.getHarga();
        double jumlah = penjualan.getJumlah();
        total = harga*jumlah;
        penjualan.setTotal(total);


        double tDiskon = 0.0;
        double diskonPersen = penjualan.getDiskonPersen();
        tDiskon = diskonPersen*total;
        penjualan.setTDiskon(tDiskon);

        double Tppn = 0.0;
        double ppnPersen = penjualan.getPpnPersen();
        Tppn = ppnPersen*(total-tDiskon);
        penjualan.setTppn(Tppn);

        double totalBayar = 0.0;
        totalBayar = total - tDiskon + Tppn;
        penjualan.setTotalBayar(totalBayar);

        return penjualanRepository.save(penjualan);
    }

    public ResponseTemplateVO getPenjualan(Long penjualanId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Penjualan penjualan = penjualanRepository.findByPenjualanId(penjualanId);
//        Pelanggan pelanggan = restTemplate.getForObject("http://localhost:8888/pelangggan/" 
//              + penjualan.getPelangganId(), Pelanggan.class);
//        vo.setPelanggan(pelanggan);
        Pelanggan pelanggan = restTemplate.getForObject("http://localhost:9005/pelanggan/"
                + penjualan.getPelangganId(), Pelanggan.class);
        vo.setPenjualan(penjualan);
        vo.setPelanggan(pelanggan);
        return vo;
    }
}
