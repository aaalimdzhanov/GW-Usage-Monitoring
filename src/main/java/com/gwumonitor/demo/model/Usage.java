package com.gwumonitor.demo.model;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "usage")
public class Usage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Column(name = "RESOURCE_ID")
    private long resourceId;
    @Column(name = "USAGE")
    private float usage;
    @Column(name = "ADD_DT")
    private LocalDateTime addDt;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;
    //======================================================================//



    public Usage() {

    }

    public Usage(long argCustomerId, long argResourceId, float argUsage, LocalDateTime argAddDt ){
        this.customerId = argCustomerId;
        this.resourceId = argResourceId;
        this.usage = argUsage;
        this.addDt = argAddDt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public float getUsage() {
        return usage;
    }

    public void setUsage(float usage) {
        this.usage = usage;
    }

    public LocalDateTime getAddDt() {
        return addDt;
    }

    public void setAddDt(LocalDateTime addDt) {
        this.addDt = addDt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
