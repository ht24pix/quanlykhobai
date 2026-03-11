package com.quanlykhobai;

	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.builder.SpringApplicationBuilder;
	import org.springframework.context.ConfigurableApplicationContext;

	import com.formdev.flatlaf.FlatLightLaf;
	import com.quanlykhobai.view.MainFrame; // Sẽ tạo ở bước dưới

	import javax.swing.*;
	import java.awt.*;

	@SpringBootApplication
	public class WarehouseSwingApp {

	    public static void main(String[] args) {
	        // 1. Cài đặt giao diện FlatLaf cho giống Windows 11/MacOS (Phải gọi trước khi mở UI)
	        try {
	            UIManager.setLookAndFeel(new FlatLightLaf());
	        } catch (Exception ex) {
	            System.err.println("Không thể khởi tạo giao diện FlatLaf");
	        }

	        // 2. Khởi động Spring Boot và tắt chế độ Headless (cho phép chạy UI)
	        ConfigurableApplicationContext context = new SpringApplicationBuilder(WarehouseSwingApp.class)
	                .headless(false)
	                .run(args);

	        // 3. Hiển thị giao diện Swing một cách an toàn trên Event Dispatch Thread
	        EventQueue.invokeLater(() -> {
	            // Lấy MainFrame đã được Spring quản lý (Bean) ra để hiển thị
	            MainFrame mainFrame = context.getBean(MainFrame.class);
	            mainFrame.setVisible(true);
	        });
	    }
	}

