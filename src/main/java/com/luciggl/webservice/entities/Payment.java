package com.luciggl.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Instant moment, Order order) {
        super();
        this.moment = moment;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getId() == payment.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
