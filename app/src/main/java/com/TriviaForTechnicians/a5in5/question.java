package com.TriviaForTechnicians.a5in5;

public class question  {
    private  String questionId;
    private  String topic;
    private  String question;
    private  String  answerA;
    private  String  answerB;
    private  String  answerC;
    private  String  answerD;
    private String reason;
    private  int  currect;
    //contructors
    public question (){

    }
    public question(String questionId, String question, String topic,String AnswerA, String  AnswerB, String  AnswerC, String  AnswerD, String reason,int  Currect){

        this.questionId = questionId;
        this.question   = question;
        this.topic      = topic;
        this.answerA    = AnswerA;
        this.answerB    = AnswerB;
        this.answerC    = AnswerC;
        this.answerD    = AnswerD;
        this.currect    = Currect;
        this.reason      =reason;

    }

    public String getquestionId (){
        return questionId;
    }
    public String getanswerA (){
        return answerA;
    }
    public String getanswerB (){
        return answerB;
    }
    public String getanswerC (){
        return answerC;
    }
    public String getanswerD (){
        return answerD;
    }
    public String getreason(){
        return  reason;
    }
    public String getquestion(){
        return  question;
    }
    public String gettopic(){
        return  topic;
    }
    public   int  getcurrect(){
        return currect;
    }
}
