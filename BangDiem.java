import java.io.Serializable;

public class BangDiem implements Serializable {
    private int maSV;
    private int maMon;
    private float diem;

    public BangDiem(int maSV, int maMon, float diem) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.diem = diem;
    }

    public int getMaSV() { return maSV; }
    public int getMaMon() { return maMon; }
    public float getDiem() { return diem; }

    @Override
    public String toString() {
        return maSV + " - " + maMon + " - " + diem;
    }
}
