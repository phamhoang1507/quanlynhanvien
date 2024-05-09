-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 27, 2023 lúc 03:54 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlnhanvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbcalam`
--

CREATE TABLE `tbcalam` (
  `macalam` varchar(10) NOT NULL,
  `tencalam` varchar(50) NOT NULL,
  `batdau` int(10) NOT NULL,
  `ketthuc` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbcalam`
--

INSERT INTO `tbcalam` (`macalam`, `tencalam`, `batdau`, `ketthuc`) VALUES
('CL1', 'Ca Sáng', 7, 11),
('CL2', 'Ca Trưa ', 11, 15),
('CL3', 'Ca Tối', 15, 19),
('CL4', 'Ca Đêm', 19, 23);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbchucvu`
--

CREATE TABLE `tbchucvu` (
  `loainv` varchar(20) NOT NULL,
  `tenloai` varchar(50) NOT NULL,
  `dongia` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbchucvu`
--

INSERT INTO `tbchucvu` (`loainv`, `tenloai`, `dongia`) VALUES
('BV', 'Bảo Vệ', 25000.00),
('KT', 'Kiểm Toán', 40000.00),
('LC', 'Lao Công', 30000.00),
('NVC', 'Nhân Viên Cũ', 30000.00),
('NVM', 'Nhân Viên Mới', 25000.00),
('QL', 'Quản Lý', 100000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbcongviec`
--

CREATE TABLE `tbcongviec` (
  `manv` varchar(15) NOT NULL,
  `macalam` varchar(10) NOT NULL,
  `ngaylam` date NOT NULL,
  `ghichu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbcongviec`
--

INSERT INTO `tbcongviec` (`manv`, `macalam`, `ngaylam`, `ghichu`) VALUES
('NV01', 'CL1', '2023-11-16', 'Ngủ Quên Lúc Coi Xe'),
('NV02', 'CL1', '2023-11-15', 'Không Có '),
('NV03', 'CL1', '2023-11-15', 'Làm Lau Dọn Bàn Ghế'),
('NV03', 'CL2', '2023-11-17', 'Mới Vào Còn Chậm Chạp'),
('NV03', 'CL3', '2023-11-14', 'Không Có'),
('NV04', 'CL4', '2023-11-14', 'Làm Rất Tốt'),
('NV04', 'CL4', '2023-11-15', 'Làm Rất Tốt'),
('NV05', 'CL3', '2023-11-15', 'Thái độ tích cực với nhân viên'),
('NV06', 'CL2', '2023-11-15', 'Ngủ gật trong giờ làm'),
('NV06', 'CL4', '2023-11-16', 'Chưa biết việc'),
('NV07', 'CL1', '2023-11-16', 'Ăn trong giờ làm'),
('NV07', 'CL3', '2023-11-14', 'Bắt nạt nhân viên mới'),
('NV09', 'CL1', '2023-11-15', 'Lau dọn sạch sẽ'),
('NV09', 'CL2', '2023-11-16', 'Lau dọn thêm phòng khách'),
('NV09', 'CL3', '2023-11-17', 'Dọn nhà vệ sinh chưa sạch'),
('NV10', 'CL1', '2023-11-16', 'Lười làm'),
('NV10', 'CL4', '2023-11-15', 'Thái độ với khách hàng'),
('NV10', 'CL4', '2023-11-16', 'Không có'),
('NV11', 'CL2', '2023-11-15', 'Không có'),
('NV12', 'CL2', '2023-11-01', 'Không tập trung'),
('NV12', 'CL4', '2023-11-04', 'Nhiệt tình dắt xe cho khách'),
('NV13', 'CL2', '2023-11-09', 'Chưa biết sắp xếp thời gian'),
('NV13', 'CL3', '2023-11-16', 'Quản lý tốt'),
('NV14', 'CL1', '2023-11-13', 'Chưa giao tiếp tốt'),
('NV14', 'CL3', '2023-11-02', 'Thiếu sự hiểu biết'),
('NV15', 'CL1', '2023-11-04', 'Con sai sót trong nhập số liệu'),
('NV15', 'CL2', '2023-11-16', 'Không cẩn thận'),
('NV16', 'CL1', '2023-11-07', 'Bỏ bê công việc'),
('NV16', 'CL4', '2023-11-08', 'Gây sự với đồng nghiệp'),
('NV17', 'CL1', '2023-11-21', 'Không có'),
('NV17', 'CL2', '2023-11-28', 'Chưa hoàn thành báo cáo đúng hạn'),
('NV18', 'CL1', '2023-11-10', 'Hoàn thành tốt nhiệm vụ được giao'),
('NV18', 'CL4', '2023-11-24', 'Có ý thức tăng ca'),
('NV19', 'CL3', '2023-11-25', 'Làm vỡ đồ của công ty'),
('NV19', 'CL3', '2023-11-26', 'Dọn dẹp còn bẩn'),
('NV20', 'CL3', '2023-11-13', 'Còn chậm chạp'),
('NV20', 'CL3', '2023-11-19', 'Chưa hòa đồng'),
('NV20', 'CL4', '2023-11-19', 'Không');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbluong`
--

CREATE TABLE `tbluong` (
  `manv` varchar(15) NOT NULL,
  `loainv` varchar(20) NOT NULL,
  `sogiolam` int(3) NOT NULL,
  `luong` decimal(14,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbluong`
--

INSERT INTO `tbluong` (`manv`, `loainv`, `sogiolam`, `luong`) VALUES
('NV01', 'BV', 4, 100000.00),
('NV02', 'KT', 4, 160000.00),
('NV03', 'NVM', 12, 300000.00),
('NV04', 'QL', 8, 800000.00),
('NV05', 'QL', 4, 400000.00),
('NV06', 'NVM', 8, 200000.00),
('NV07', 'NVC', 8, 240000.00),
('NV09', 'LC', 12, 360000.00),
('NV10', 'QL', 12, 1200000.00),
('NV11', 'KT', 4, 160000.00),
('NV12', 'BV', 8, 200000.00),
('NV13', 'QL', 8, 800000.00),
('NV14', 'NVM', 8, 200000.00),
('NV15', 'KT', 8, 320000.00),
('NV16', 'NVC', 8, 240000.00),
('NV17', 'NVC', 8, 240000.00),
('NV18', 'NVC', 8, 240000.00),
('NV19', 'LC', 8, 240000.00),
('NV20', 'NVM', 12, 300000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbnhanvien`
--

CREATE TABLE `tbnhanvien` (
  `manv` varchar(15) NOT NULL,
  `tennv` varchar(50) NOT NULL,
  `loainv` varchar(20) NOT NULL,
  `ngaysinh` varchar(15) NOT NULL,
  `sodienthoai` varchar(10) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `macalam` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbnhanvien`
--

INSERT INTO `tbnhanvien` (`manv`, `tennv`, `loainv`, `ngaysinh`, `sodienthoai`, `diachi`, `macalam`) VALUES
('NV01', 'Trần Lê Phương Linh', 'BV', '10-10-2003', '0339949411', 'Thái Bình', 'CL1'),
('NV02', 'Nguyễn Hiền Thảo', 'KT', '04/02/2002', '0339219141', 'Thái Bình', 'CL2'),
('NV03', 'Nguyễn Thanh Phương', 'NVM', '10/01/2004', '0229449512', 'Nam Định', 'CL3'),
('NV04', 'Phạm Đình Hà', 'QL', '09/02/2007', '0339941451', 'Thái Bình', 'CL4'),
('NV05', 'Phạm Đình Luân', 'QL', '10/11/2006', '0225349512', 'Thái Bình', 'CL3'),
('NV06', 'Nguyễn Thị Thảo', 'NVM', '21/02/2001', '0225326512', 'Thái Bình', 'CL4'),
('NV07', 'Trần Minh Huy', 'NVC', '09/10/2003', '0846735627', 'Hải Dương', 'CL2'),
('NV09', 'Vũ Thị Nga', 'LC', '03/05/2004', '0946372817', 'Thái Bình', 'CL1'),
('NV10', 'Nguyễn Thị Hương', 'QL', '20/03/2003', '0983526154', 'Thái Bình', 'CL2'),
('NV11', 'Trần Thị Mai', 'KT', '08/03/2004', '0936272618', 'Quảng Ninh', 'CL3'),
('NV12', 'Phạm Quang Minh', 'BV', '09/05/2003', '0984563724', 'Thái Bình', 'CL2'),
('NV13', 'Nguyễn Văn Đức', 'QL', '03/08/2002', '0846735627', 'Hải Dương', 'CL2'),
('NV14', 'Lê Thanh Tùng', 'NVM', '03/05/2004', '0974638732', 'Hải Dương', 'CL2'),
('NV15', 'Nguyễn Quỳnh Anh', 'KT', '08/04/2003', '0983526154', 'Thái Bình', 'CL1'),
('NV16', 'Bùi Thị Mai', 'NVC', '08/03/2004', '0936272618', 'Quảng Ninh', 'CL4'),
('NV17', 'Đoàn Thị Mai Linh', 'NVC', '09/10/2003', '0846735627', 'Hải Dương', 'CL4'),
('NV18', 'Hoàng Minh Ánh', 'NVC', '09/11/2002', '0974638732', 'Thái Bình', 'CL3'),
('NV19', 'Vũ Trung Kiên', 'LC', '19/01/2004', '0976573829', 'Hải Dương', 'CL3'),
('NV20', 'Nguyễn Kiên Trung', 'NVM', '09/04/2002', '0983674683', 'Thái Bình', 'CL4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbtaikhoan`
--

CREATE TABLE `tbtaikhoan` (
  `taikhoan` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL,
  `quyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbtaikhoan`
--

INSERT INTO `tbtaikhoan` (`taikhoan`, `matkhau`, `quyen`) VALUES
('1', '4', 1),
('2', '2', 2),
('3', '3', 1),
('phamhoang', 'tanthanh12', 1),
('user', '1', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbcalam`
--
ALTER TABLE `tbcalam`
  ADD PRIMARY KEY (`macalam`);

--
-- Chỉ mục cho bảng `tbchucvu`
--
ALTER TABLE `tbchucvu`
  ADD PRIMARY KEY (`loainv`);

--
-- Chỉ mục cho bảng `tbcongviec`
--
ALTER TABLE `tbcongviec`
  ADD PRIMARY KEY (`manv`,`macalam`,`ngaylam`),
  ADD KEY `manv` (`manv`,`macalam`),
  ADD KEY `macalam` (`macalam`);

--
-- Chỉ mục cho bảng `tbluong`
--
ALTER TABLE `tbluong`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `loainv` (`loainv`);

--
-- Chỉ mục cho bảng `tbnhanvien`
--
ALTER TABLE `tbnhanvien`
  ADD PRIMARY KEY (`manv`),
  ADD KEY `loainv` (`loainv`,`macalam`),
  ADD KEY `loainv_2` (`loainv`,`macalam`),
  ADD KEY `macalam` (`macalam`);

--
-- Chỉ mục cho bảng `tbtaikhoan`
--
ALTER TABLE `tbtaikhoan`
  ADD PRIMARY KEY (`taikhoan`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbcongviec`
--
ALTER TABLE `tbcongviec`
  ADD CONSTRAINT `tbcongviec_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `tbnhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbcongviec_ibfk_2` FOREIGN KEY (`macalam`) REFERENCES `tbcalam` (`macalam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tbluong`
--
ALTER TABLE `tbluong`
  ADD CONSTRAINT `tbluong_ibfk_1` FOREIGN KEY (`manv`) REFERENCES `tbnhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbluong_ibfk_2` FOREIGN KEY (`loainv`) REFERENCES `tbchucvu` (`loainv`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tbnhanvien`
--
ALTER TABLE `tbnhanvien`
  ADD CONSTRAINT `tbnhanvien_ibfk_1` FOREIGN KEY (`macalam`) REFERENCES `tbcalam` (`macalam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbnhanvien_ibfk_2` FOREIGN KEY (`loainv`) REFERENCES `tbchucvu` (`loainv`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
