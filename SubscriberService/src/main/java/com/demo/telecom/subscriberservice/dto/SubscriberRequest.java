package com.demo.telecom.subscriberservice.dto;

import java.util.Date;

public class SubscriberRequest {


    String subId;
    String userName;
    long availableData;
    Date validityFrom;
    Date validityTo;
    double callBalance;
    String region;

    public SubscriberRequest() {
    }

    public SubscriberRequest(String subId, String userName, long availableData, Date validityFrom, Date validityTo, double callBalance, String region) {
        this.subId = subId;
        this.userName = userName;
        this.availableData = availableData;
        this.validityFrom = validityFrom;
        this.validityTo = validityTo;
        this.callBalance = callBalance;
        this.region = region;
    }

    @Override
    public String toString() {
        return "SubscriberRequest{" +
                "subId='" + subId + '\'' +
                ", userName='" + userName + '\'' +
                ", availableData=" + availableData +
                ", validityFrom=" + validityFrom +
                ", validityTo=" + validityTo +
                ", callBalance=" + callBalance +
                ", region='" + region + '\'' +
                '}';
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getAvailableData() {
        return availableData;
    }

    public void setAvailableData(long availableData) {
        this.availableData = availableData;
    }

    public Date getValidityFrom() {
        return validityFrom;
    }

    public void setValidityFrom(Date validityFrom) {
        this.validityFrom = validityFrom;
    }

    public Date getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(Date validityTo) {
        this.validityTo = validityTo;
    }

    public double getCallBalance() {
        return callBalance;
    }

    public void setCallBalance(double callBalance) {
        this.callBalance = callBalance;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
