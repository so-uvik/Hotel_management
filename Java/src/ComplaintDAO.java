import java.util.List;
import java.util.ArrayList;

public class ComplaintDAO {
    private List<Complaint> complaintList = new ArrayList<>();

    public List<Complaint> getAllComplaints() {
        return complaintList;
    }
    public void addComplaint(Complaint complaint) {
        complaintList.add(complaint);
    }
}
