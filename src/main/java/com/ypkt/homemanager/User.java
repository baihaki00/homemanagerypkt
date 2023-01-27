package com.ypkt.homemanager;

public class User {
    private Employer employer;
    private Employee employee;

    public User(Employer employer, Employee employee) {
        this.employer = employer;
        this.employee = employee;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Employee getEmployee() {
        return employee;
    }
}
