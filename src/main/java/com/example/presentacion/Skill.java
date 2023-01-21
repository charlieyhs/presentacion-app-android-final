package com.example.presentacion;

public class Skill {
    private String title;
    private String info;
    private String subTitle;
    private int imageResource;

    Skill(String title, String info,String subTitle, int imageResource){
        this.title = title;
        this.info = info;
        this.subTitle = subTitle;
        this.imageResource = imageResource;
    }

    public String getTitle(){
        return title;
    }

    public String getInfo(){
        return info;
    }

    public String getSubTitle(){
        return subTitle;
    }

    public int getImageResource(){
        return imageResource;
    }
}
