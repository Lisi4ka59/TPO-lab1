package com.lisi4ka.part3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Person {
    protected String name;
    protected Clothing clothing;
    protected int level;
}
