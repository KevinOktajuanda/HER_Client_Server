/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevin.client2101082039.service;

import com.google.gson.Gson;
import com.kevin.client2101082039.model.Gaji;
import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author ASUS
 */
public class GajiService {
    private final String URL = "http://localhost:8090";
    
    public Gaji getGaji(Long kodeSlip){
        Gaji gaji = Unirest.get(URL+"/anggota/"+kodeSlip).asObject(Gaji.class).getBody();
        if (gaji!=null){
            return gaji;
        }
        return null;
    }
    
    public List<Gaji> getAllGaji(){
        List<Gaji> gajiList = Unirest.get(URL + "/gaji/")
                .asObject(new GenericType<List<Gaji>>(){})
                .getBody();
        return gajiList;
    }
    
    public Gaji saveGaji(Gaji gaji){
        HttpResponse<JsonNode> response = Unirest.post(URL + "/gaji/")
                .header("content-type","application/json")
                .body(gaji)
                .asJson();
        Gson gson = new Gson();
        Gaji a = gson.fromJson(response.getBody().toString(),Gaji.class);
        return a;
    }
    
    public Gaji updateGaji(Gaji gaji){
        HttpResponse<JsonNode> response = Unirest.put(URL+"/gaji/")
                   .header("content-type", "application/json")
                   .body(gaji)
                   .asJson();
        Gson gson = new Gson();
        Gaji a = gson.fromJson(response.getBody().toString(), Gaji.class);
        return a;
    }
    
    public void deleteGaji(Long slipGaji){
        Unirest.delete(URL+"/gaji/"+slipGaji).asEmpty();
    }
}

