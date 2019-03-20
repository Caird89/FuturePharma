package com.example.a5in5;

public class Result {
    private  String resultId;
    private  String userName;
    private  String topic;
    private  String q1;
    private  String q2;
    private  String q3;
    private  String q4;
    private  String q5;
    private  int score;

    //contructors
    public Result(){

    }
    public Result(String resultId, String userName, String topic,String q1, String q2, String q3, String q4, String q5, int score){

        this.resultId = resultId;
        this.userName=userName;
        this.topic=topic;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
        this.q4=q4;
        this.q5=q5;
        this.score=score;

    }

    public String getresultId (){
        return resultId;
    }
    public String getq1 (){
        return q1;
    }
    public String getq2 (){
        return q2;
    }
    public String getq3 (){
        return q3;
    }
    public String getq4 (){
        return q4;
    }
    public String getq5 (){
        return q5;
    }
    public String getuserName(){
        return  userName;
    }
    public String gettopic(){
        return  topic;
    }
    public  int  getscore(){
        return score;
    }
}
