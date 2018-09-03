package com.lottery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DrawResult {
    private String oid;
    private Long hafta;
    private String buyukIkramiyeKazananIl;
    private String cekilisTarihi;
    private String cekilisTuru;
    private String rakamlar;
    private String rakamlarNumaraSirasi;
    private Boolean devretti;
    private Long devirSayisi;
    private List<Fasten> bilenKisiler;
    private List<CityAndState> buyukIkrKazananIlIlceler;
    private Long kibrisHasilati;
    private Double devirTutari;
    private Long kolonSayisi;
    private Double kdv;
    private Double toplamHasilat;
    private Double hasilat;
    private Double sov;
    private Double ikramiyeEH;
    private Double buyukIkramiye;
    private Double haftayaDevredenTutar;
}
