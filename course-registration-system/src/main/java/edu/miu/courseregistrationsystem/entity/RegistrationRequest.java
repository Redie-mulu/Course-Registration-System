package edu.miu.courseregistrationsystem.entity;

public class RegistrationRequest {

    private int priorityNumber;
    private String registration_status;

    public RegistrationRequest(){
    }

    public RegistrationRequest(int priorityNumber, String registration_status) {
        this.priorityNumber = priorityNumber;
        this.registration_status = registration_status;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public String getRegistration_status() {
        return registration_status;
    }

    public void setRegistration_status(String registration_status) {
        this.registration_status = registration_status;
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "priorityNumber=" + priorityNumber +
                ", registration_status='" + registration_status + '\'' +
                '}';
    }
}
