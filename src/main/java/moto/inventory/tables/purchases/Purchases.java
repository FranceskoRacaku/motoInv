package moto.inventory.tables.purchases;

import javax.persistence.*;


@Entity
@Table
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer amount;
    private Integer motorId;
    private Integer userId;


    public Purchases() {
    }

    public Purchases(Integer id,
                     Integer amount,
                     Integer motorId,
                     Integer userId) {
        this.id = id;
        this.amount = amount;
        this.motorId = motorId;
        this.userId = userId;
    }

    public Purchases(Integer amount, Integer motorId, Integer userId) {
        this.amount = amount;
        this.motorId = motorId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMotorId() {
        return motorId;
    }

    public void setMotorId(Integer motorId) {
        this.motorId = motorId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "id=" + id +
                ", amount=" + amount +
                ", userId=" + userId +
                ", motorId=" + motorId +
                '}';
    }
}