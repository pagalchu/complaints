package com.sv.complaints.dtos;

public class ComplaintDto {

    public String complaintType;
    public String complaintLocation;
    public String complaint;

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintLocation() {
        return complaintLocation;
    }

    public void setComplaintLocation(String complaintLocation) {
        this.complaintLocation = complaintLocation;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
