package com.lottery.model;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Draw {

    //date
    private String tarih;

    //dateview
    private String tarihView;


    @Override
    public String toString() {
        return "{" + "tarih='" + tarih + '\'' + ", tarihView='" + tarihView + '\'' + '}';
    }
}
