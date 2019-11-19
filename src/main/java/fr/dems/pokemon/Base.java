package fr.dems.pokemon;

public class Base {
    private int HP;
    private int Attack;
    private int Defense;
    private int SpAttack;
    private int spDefense;
    private int Speed;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getSpAttack() {
        return SpAttack;
    }

    public void setSpAttack(int spAttack) {
        SpAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    @Override
    public String toString() {
        return "Base{" +
                "HP=" + HP +
                ", Attack=" + Attack +
                ", Defense=" + Defense +
                ", SpAttack=" + SpAttack +
                ", spDefense=" + spDefense +
                ", Speed=" + Speed +
                '}';
    }
}
