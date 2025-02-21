package com.lisi4ka.part3;

public class Scene {
    public static void main(String[] args) {
        University kruxUniversity = new University("Круксванский университет");
        Clothing professorClothing = new Clothing("выцветший синий", "балахон с поясом");
        Clothing servantClothing = new Clothing("черный", "костюм");

        Professor professor1 = new Professor("Первый профессор", professorClothing, 5, kruxUniversity);
        Professor professor2 = new Professor("Второй профессор", professorClothing, 4, kruxUniversity);
        Servant servant = new Servant("Лакей", servantClothing, 3);

        Door door = new Door();
        Room room = new Room("Комната заседаний");

        Noise noise = new Noise();
        Shout shout = new Shout();

        noise.makeNoise();
        shout.shout();
        door.open();

        professor1.burstInto(room, servant);
        professor2.burstInto(room, servant);

        servant.tryToStop(professor1);
        servant.tryToStop(professor2);
    }
}
