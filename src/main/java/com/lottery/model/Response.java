package com.lottery.model;

import lombok.Data;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 * @date 2.09.2018
 * @description TODO: Class Description
 */
@Data
public class Response {
    private boolean success;
    private DrawResult data;

}
