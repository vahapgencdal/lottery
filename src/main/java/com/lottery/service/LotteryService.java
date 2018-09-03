package com.lottery.service;

import com.lottery.model.Draw;
import com.lottery.model.DrawResult;

import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */
public interface LotteryService {
    List<Draw> drawDates();
    DrawResult getDrawResult(String date);
    void calculateMostNumbers(List<String> results);

}
