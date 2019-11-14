package com.first_chat_SBT;

public class Employee {
    private String mFullName;
    private long mEmploymentDate;
    private long mSalary;

    public Employee (String fullName, long date, long salary) {
        mFullName = fullName;
        mEmploymentDate = date;
        mSalary = salary;
    }
    public double getSalaryUah() {
        return mSalary / 100;
    }

    public String getmFullName() {
        return mFullName;
    }

    public long getmEmploymentDate() {
        return mEmploymentDate;
    }

    public long getmSalary() {
        return mSalary;
    }
}
