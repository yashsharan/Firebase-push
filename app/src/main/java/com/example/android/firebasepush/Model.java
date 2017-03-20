package com.example.android.firebasepush;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by yash sharan on 20-03-2017.
 */

public class Model {

    private String name;
    private String number;

    public Model(String name, String number) {
        this.number = number;
        this.name = name;
    }

    public Model()
    {
        //Needed for Firebase
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public HashMap<String,Object> toMap(){

        HashMap<String,Object> map = new HashMap<>();
        map.put("Name",this.name);
        map.put("Number",this.number);
        return map;

    }
}
