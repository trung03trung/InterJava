package QLTV;

import java.util.Arrays;

public class QLMuonSach {
    BanDoc banDoc;
    MuonSach[] muonSach;

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public MuonSach[] getMuonSach() {
        return muonSach;
    }

    public void setMuonSach(MuonSach[] muonSach) {
        this.muonSach = muonSach;
    }

    @Override
    public String toString() {
        return "QLMuonSach{" +
                "banDoc=" + banDoc +
                ", muonSach=" + Arrays.toString(muonSach) +
                '}';
    }
}
