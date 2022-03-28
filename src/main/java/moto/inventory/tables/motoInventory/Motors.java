//package moto.inventory.tables.motoInventory;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class Motors {
//
//    @Id
////    @SequenceGenerator(
////            name= "motors_sequence",
////            sequenceName = "motors_sequence",
////            allocationSize = 1
////    )
//    @GeneratedValue(strategy = GenerationType.AUTO)
////    @GeneratedValue(
////            strategy = GenerationType.SEQUENCE,
////            generator = "motors_sequence"
////            )
//
//    private Integer id;
//    private String vin;
//    private String make;
//    private String type;
//
//    public Motors (){
//    }
//
//    public Motors(Integer id, String vin, String make, String type) {
//        this.id = id;
//        this.vin = vin;
//        this.make = make;
//        this.type = type;
//    }
//
//    public Motors(String vin, String make, String type) {
//        this.vin = vin;
//        this.make = make;
//        this.type = type;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getVin() {
//        return vin;
//    }
//
//    public void setVin(String vin) {
//        this.vin = vin;
//    }
//
//    public String getMake() {
//        return make;
//    }
//
//    public void setMake(String make) {
//        this.make = make;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Motors{" +
//                "id=" + id +
//                ", vin='" + vin + '\'' +
//                ", make='" + make + '\'' +
//                ", type='" + type + '\'' +
//                '}';
//    }
//}
