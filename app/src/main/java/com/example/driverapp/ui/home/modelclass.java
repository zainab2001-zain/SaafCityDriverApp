package com.example.driverapp.ui.home;

public class modelclass {
    private int complintno;
    private String status;
    private String Date;
    public String Time;

    modelclass(int c_no,String status){
        this.complintno = c_no;
        this.status = status;
    }


    public int getComplintno() {
        return complintno;
    }
    public String getDate(){ return Date;}
    public String getTime(){return Time;}
    public String getStatus() {return status;}
}
