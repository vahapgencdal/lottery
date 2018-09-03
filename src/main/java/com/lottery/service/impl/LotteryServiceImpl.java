package com.lottery.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.lottery.model.Draw;
import com.lottery.model.DrawResult;
import com.lottery.model.Response;
import com.lottery.service.LotteryService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Ş
 *
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */
@Component
public class LotteryServiceImpl implements LotteryService {

    @Override
    public List<Draw> drawDates() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://www.millipiyango.gov.tr/sonuclar/listCekilisleriTarihleri.php?tur=sayisal", String.class);

        response = response.replace("ï»¿", "");

        ObjectMapper objectMapper = new ObjectMapper();

        List<Draw> draws = null;
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, Draw.class);
            draws=objectMapper.readValue(response, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return draws;
    }

    @Override
    public DrawResult getDrawResult(String date) {
        RestTemplate restTemplate = new RestTemplate();
        Response response=new Response();
        String url="http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/"+date+".json";
       try {
            response = restTemplate.getForObject(url, Response.class);
       }catch (Exception e){
       }
        return response.getData();
    }

    @Override
    public void calculateMostNumbers(List<String> results) {
        Map<String,Integer> nums=new HashMap<>();
        for (int i=1;i<50;i++){
            if(i<10)
                nums.put("0"+i,0);
            else
                nums.put(i+"",0);
        }

        results.parallelStream().forEach(drawResult -> {
            Arrays.stream(drawResult.split("#")).forEach(val->{
                nums.put(val,nums.get(val)+1);
            });
        });


        Map<String, Integer> result = nums.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        result.forEach((s, integer) -> {
            System.out.println(s+":"+integer+" ");
        });
    }


}
