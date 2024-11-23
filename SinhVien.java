import java.io.Serializable;

public class SinhVien implements Serializable {
    private static int idCounter = 10000; // Tự động tăng
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String ngaySinh;
    private String lop;

    public SinhVien(String hoTen, String diaChi, String ngaySinh, String lop) {
        this.maSV = idCounter++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public int getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public String getDiaChi() { return diaChi; }
    public String getNgaySinh() { return ngaySinh; }
    public String getLop() { return lop; }

    @Override
    public String toString() {
        return maSV + " - " + hoTen + " - " + diaChi + " - " + ngaySinh + " - " + lop;
    }
}
