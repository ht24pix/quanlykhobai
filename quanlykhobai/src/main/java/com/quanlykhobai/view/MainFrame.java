package com.quanlykhobai.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.springframework.stereotype.Component;
import java.awt.*;

	@Component // Quan trọng: Đánh dấu để Spring Boot tự động quản lý class này
	public class MainFrame extends JFrame {

	    public MainFrame() {
	        // Cài đặt các thông số cơ bản cho cửa sổ
	        setTitle("Hệ thống Quản lý Hợp đồng & Kho bãi");
	        setSize(1024, 768); // Kích thước cửa sổ
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tắt app khi bấm nút X
	        setLocationRelativeTo(null); // Hiển thị ở chính giữa màn hình

	        // Thêm một dòng chữ đơn giản ra giữa màn hình để test
	        JLabel label = new JLabel("Kết nối MySQL thành công! Đang chờ thiết kế UI...", SwingConstants.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        add(label);
	    }
	}

