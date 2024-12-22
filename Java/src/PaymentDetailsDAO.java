import java.util.List;
import java.util.ArrayList;


public class PaymentDetailsDAO {
    List<PaymentDetails> paymentDetailsList = new ArrayList<>();


    public void addPaymentDetails(PaymentDetails pd) {
        paymentDetailsList.add(pd);
    }

    public List<PaymentDetails> getAllBookings() {
        return paymentDetailsList;
    }
}
