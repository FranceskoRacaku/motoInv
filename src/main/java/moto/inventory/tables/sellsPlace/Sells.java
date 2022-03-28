package moto.inventory.tables.sellsPlace;
import javax.persistence.*;


@Entity
@Table
public class Sells {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer amountSold;
    private Integer motorId;
    private Integer userId;

    public Sells() {
    }

    public Sells(Integer id, Integer amountSold, Integer motorId, Integer userId) {
        this.id = id;
        this.amountSold = amountSold;
        this.motorId = motorId;
        this.userId = userId;
    }

    public Sells(Integer amountSold, Integer motorId, Integer userId) {
        this.amountSold = amountSold;
        this.motorId = motorId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Integer amountSold) {
        this.amountSold = amountSold;
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
        return "Sells{" +
                "id=" + id +
                ", amountSold=" + amountSold +
                ", motorId=" + motorId +
                ", userId=" + userId +
                '}';
    }
}
