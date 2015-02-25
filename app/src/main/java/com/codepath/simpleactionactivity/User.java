package com.codepath.simpleactionactivity;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public int age;
    public String favoriteDrink;

    public String getAgeString(){
        return String.valueOf(age);
    }

    public boolean canDrink() {
        return this.age > 21;
    }
}
