import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Student studentName;

    @OneToOne(cascade = CascadeType.ALL)
    private Course course;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
