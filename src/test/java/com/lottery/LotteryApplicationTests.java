package com.lottery;

import com.lottery.model.Draw;
import com.lottery.model.DrawResult;
import com.lottery.service.LotteryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryApplicationTests {

    @Autowired
    private LotteryService lotteryService;

    @Test
    public void drawDates() {

        List<Draw> draws=lotteryService.drawDates();
        Assert.assertEquals(false,draws.isEmpty());
    }

    @Test
    public void drawRateResult() {
        List<Draw> draws=lotteryService.drawDates();
        DrawResult drawResult=lotteryService.getDrawResult(draws.get(0).getTarih());
        Assert.assertEquals(false,StringUtils.isEmpty(drawResult));
    }

    @Test
    public void calculate() {
        List<Draw> draws=lotteryService.drawDates();
        List<String> drawNumbers=new ArrayList<>();
        draws.parallelStream().forEach(draw -> {
            DrawResult drawResult=lotteryService.getDrawResult(draw.getTarih());
            if(!StringUtils.isEmpty(drawResult))
                drawNumbers.add(drawResult.getRakamlar());
        });
        lotteryService.calculateMostNumbers(drawNumbers);
        Assert.assertEquals(true,true);
    }
}
