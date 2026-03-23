package SESSION12.SESSION12_05.Repositon;

import SESSION12.SESSION12_05.Entity.Bneed;

import java.util.List;

public interface BneedReposition {
    List<Bneed> getBneed();
    boolean addBneed(Bneed bneed);
    boolean updateBneed(Bneed bneed);
    boolean dischargePatient(String id);
    double calculateFee(String id);
    Bneed findById(String id);
}
