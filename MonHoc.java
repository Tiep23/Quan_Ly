import java.io.Serializable;

public class MonHoc implements Serializable {
    private static int idCounter = 100; // Tự động tăng
    private int maMon;
    private String tenMon;
    private int soDVHT;
    private String loaiMon;

    public MonHoc(String tenMon, int soDVHT, String loaiMon) {
        this.maMon = idCounter++;
        this.tenMon = tenMon;
        this.soDVHT = soDVHT;
        this.loaiMon = loaiMon;
    }

    public int getMaMon() { return maMon; }
    public String getTenMon() { return tenMon; }
    public int getSoDVHT() { return soDVHT; }
    public String getLoaiMon() { return loaiMon; }

    @Override
    public String toString() {
        return maMon + " - " + tenMon + " - " + soDVHT + " - " + loaiMon;
    }
}

