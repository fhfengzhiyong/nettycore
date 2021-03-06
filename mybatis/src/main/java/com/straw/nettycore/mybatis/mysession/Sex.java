package com.straw.nettycore.mybatis.mysession;

/**
 * @author fengzy
 * @date 3/6/2018
 */
public enum Sex {
    MALE(3,"男"),FEMALE(4,"女");
    private int id;
    private String name;

    Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Sex getSex(int id){
        System.out.println("sex value ........");
        if (id==1){
            return MALE;
        }else if (id==2){
            return FEMALE;
        }else{
            return null;
        }
    }
}
