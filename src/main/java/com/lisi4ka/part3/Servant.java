package com.lisi4ka.part3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Servant extends Person {
    public Servant(String name, Clothing clothing, int level) {
        super(name, clothing, level);
    }

    public void tryToStop(Professor professor) {
        System.out.println(name + " пытается остановить " + professor.getName() + "!");
        if (this.level < professor.getLevel()) {
            System.out.println(name + " не смог остановить " + professor.getName() + "!");
        } else {
            System.out.println(name + " успешно остановил " + professor.getName() + "!");
        }
    }

}
