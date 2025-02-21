package com.lisi4ka.part3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Professor extends Person {
    private University university;

    public Professor(String name, Clothing clothing, int level, University university) {
        super(name, clothing, level);
        this.university = university;
    }

    public void burstInto(Room room, Servant servant) {
        System.out.println(name + " пытается ворваться в " + room.getName() + "!");
        if (this.level > servant.getLevel()) {
            System.out.println(name + " ворвался в " + room.getName() + ", растолкав " + servant.getName() + "!");
        } else {
            System.out.println(servant.getName() + " остановил " + name + "!");
        }
    }

}
