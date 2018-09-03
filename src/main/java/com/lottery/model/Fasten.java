package com.lottery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fasten {
    private String oid;
    private Double kisiBasinaDusenIkramiye;
    private Long kisiSayisi;
    private String tur;
}
