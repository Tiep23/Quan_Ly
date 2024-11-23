import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<SinhVien> sinhVienList = new ArrayList<>();
    private ArrayList<MonHoc> monHocList = new ArrayList<>();
    private ArrayList<BangDiem> bangDiemList = new ArrayList<>();

    public Main() {
        setTitle("Quản lý điểm sinh viên");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Sinh Viên", createSinhVienPanel());
        tabbedPane.add("Môn Học", createMonHocPanel());
        tabbedPane.add("Bảng Điểm", createBangDiemPanel());
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createSinhVienPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(new String[][] {}, new String[] { "Mã SV", "Họ Tên", "Địa Chỉ", "Ngày Sinh", "Lớp" });
        JButton addButton = new JButton("Thêm Sinh Viên");

        addButton.addActionListener(e -> {
            // Xử lý thêm sinh viên
            String hoTen = JOptionPane.showInputDialog("Nhập họ tên:");
            String diaChi = JOptionPane.showInputDialog("Nhập địa chỉ:");
            String ngaySinh = JOptionPane.showInputDialog("Nhập ngày sinh:");
            String lop = JOptionPane.showInputDialog("Nhập lớp:");
            try {
                SinhVien sv = new SinhVien(hoTen, diaChi, ngaySinh, lop);
                sinhVienList.add(sv);
                FileIO.writeToFile("SV.TXT", sinhVienList);
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createMonHocPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(new String[][] {}, new String[] { "Mã Môn", "Tên Môn", "Số ĐVHT", "Loại Môn" });
        JButton addButton = new JButton("Thêm Môn Học");

        addButton.addActionListener(e -> {
            // Xử lý thêm môn học
            String tenMon = JOptionPane.showInputDialog("Nhập tên môn:");
            int soDVHT = Integer.parseInt(JOptionPane.showInputDialog("Nhập số ĐVHT:"));
            String loaiMon = JOptionPane.showInputDialog("Nhập loại môn:");
            try {
                MonHoc mh = new MonHoc(tenMon, soDVHT, loaiMon);
                monHocList.add(mh);
                FileIO.writeToFile("MONHOC.TXT", monHocList);
                JOptionPane.showMessageDialog(this, "Thêm môn học thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createBangDiemPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable table = new JTable(new String[][] {}, new String[] { "Mã SV", "Mã Môn", "Điểm" });
        JButton addButton = new JButton("Nhập Điểm");

        addButton.addActionListener(e -> {
            // Xử lý nhập điểm
            int maSV = Integer.parseInt(JOptionPane.showInputDialog("Nhập mã SV:"));
            int maMon = Integer.parseInt(JOptionPane.showInputDialog("Nhập mã môn:"));
            float diem = Float.parseFloat(JOptionPane.showInputDialog("Nhập điểm:"));
            try {
                BangDiem bd = new BangDiem(maSV, maMon, diem);
                bangDiemList.add(bd);
                FileIO.writeToFile("BANGDIEM.TXT", bangDiemList);
                JOptionPane.showMessageDialog(this, "Nhập điểm thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        new Main();
    }
}
