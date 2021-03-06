package com.wewe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Author: fei2
 * Date:  18-9-12 上午11:29
 * Description:
 * Refer To:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;
    private Integer age;

}
