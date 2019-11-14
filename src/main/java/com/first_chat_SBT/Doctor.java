package com.first_chat_SBT;

public class Doctor  extends Employee{
    private int mCategory;


    public Doctor(String fullName, long date, long salary, int category) {
        super(fullName, date, salary);
        mCategory = category;
    }
    public static void main (String[]args){
        Doctor Vaso = new Doctor("Vaso An", 225544, 5466, 6);
        Doctor Jivago = new Doctor("Jivago", 55544, 5654, 5464);
        System.out.println(Vaso.getSalaryUah() +" "+ Jivago.getmEmploymentDate());

    }
}

