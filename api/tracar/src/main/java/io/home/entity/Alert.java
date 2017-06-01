package io.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Alert implements Serializable{

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String aid;
    @Id
    private String Vin;

    private String Rin;
    private String alert;
    private String priority;


    public Alert() {
        this.aid = UUID.randomUUID().toString();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getRin() {
        return Rin;
    }

    public void setRin(String rin) {
        Rin = rin;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "aid='" + aid + '\'' +
                ", Vin='" + Vin + '\'' +
                ", Rin='" + Rin + '\'' +
                ", alert='" + alert + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
