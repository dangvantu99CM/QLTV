-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 09, 2021 lúc 04:28 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_thu_vien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL COMMENT 'Primary Key',
  `bo_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên sách',
  `bo_id_store` int(11) NOT NULL COMMENT 'Sách thuộc kho nào',
  `bo_author` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Tên tác giả',
  `bo_status` int(1) NOT NULL COMMENT 'Trạng thái sách (Đang dỗi, đã mượn hết...)',
  `bo_type` int(11) DEFAULT NULL COMMENT 'Thể loại sách (1-sách giáo trình, 2- sách tham khảo....)',
  `bo_number` int(11) NOT NULL COMMENT 'Số lượng cùng loại là bao nhiêu',
  `bo_date_limit` int(11) NOT NULL COMMENT 'Gioiw hạn ngày mượn kể từ ngày người dùng mượn sách (vd 7 ngày, 1 tháng , 1 kỳ...)',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'Ngày tạo',
  `update_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'Ngày cập nhật',
  `bo_price` double NOT NULL COMMENT 'Gía sách',
  `deleted_at` datetime DEFAULT NULL,
  `bo_borrow_number` int(11) NOT NULL DEFAULT 0,
  `bo_empty_number` int(11) NOT NULL DEFAULT 0,
  `bo_date_term` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `bo_name`, `bo_id_store`, `bo_author`, `bo_status`, `bo_type`, `bo_number`, `bo_date_limit`, `create_at`, `update_at`, `bo_price`, `deleted_at`, `bo_borrow_number`, `bo_empty_number`, `bo_date_term`) VALUES
(1, 'giai tich1111', 1, 'Nguyễn Văn Cừ', 1, 1, 0, 7, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 70000, NULL, 0, 0, NULL),
(2, 'eeeeeeeee', 1, 'Nguyễn Văn Aaaaaaaa', 1, 1, 0, 7, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 50000, '2021-01-05 12:02:57', 0, 0, NULL),
(3, 'Phương trình vi eeee', 5, 'Trần Triển', 1, 1, 30, 30, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 50000, NULL, 0, 0, NULL),
(4, 'xác suất', 2, 'Nguyễn Nhưeeeee', 1, 1, 0, 7, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 35000, NULL, 0, 0, NULL),
(5, 'Tiếng Anh cao cấpppp', 1, 'Đặng Văn Tú', 1, 1, 50, 7, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 100000, '2021-01-09 21:43:55', 0, 0, NULL),
(6, 'wwww', 1, 'Trần Hiểueee', 1, 1, 10099999, 1, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 80000, NULL, 0, 0, NULL),
(7, 'Linuxeeeee', 2, 'Alex-distribution', 1, 1, 50, 7, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 50000, NULL, 0, 0, NULL),
(8, 'AI', 2, 'Alexender- đại đế -pro', 1, 2, 50, 3, '2020-12-27 10:01:05', '2020-12-27 10:01:05', 120000, NULL, 0, 0, NULL),
(9, 'Test Them', 1, 'qwe', 1, 1, 100, 7, '2021-01-01 10:16:56', '2021-01-01 10:16:56', 70000, '2021-01-09 17:54:49', 0, 0, NULL),
(10, 'Giáo trình', 4, 'aaa', 1, 1, 10, 7, '2021-01-01 11:02:31', '2021-01-01 11:02:31', 10000, NULL, 0, 0, NULL),
(11, 'testtttt', 1, 'aaaaaa', 1, 1, 55, 7, '2021-01-09 05:36:01', '2021-01-09 05:36:01', 234, NULL, 0, 0, NULL),
(12, 'da theeee', 1, '123qwe', 1, 1, 30, 7, '2021-01-09 10:41:51', '2021-01-09 10:41:51', 30000, NULL, 0, 0, NULL),
(13, 'qwerrrr', 6, '1qwe', 1, 1, 432, 7, '2021-01-09 10:50:41', '2021-01-09 10:50:41', 12333, NULL, 0, 0, NULL),
(14, 'daTheeee', 2, 'rrr', 1, 1, 66, 7, '2021-01-09 10:54:32', '2021-01-09 10:54:32', 56, '2021-01-09 17:58:18', 0, 0, NULL),
(15, 'theeeee', 1, '1111', 1, 1, 67, 7, '2021-01-09 14:47:30', '2021-01-09 14:47:30', 222, NULL, 0, 0, NULL),
(16, 'eeeeeeee', 4, 'eeeeeee', 1, 1, 67, 43, '2021-01-09 15:19:45', '2021-01-09 15:19:45', 45, NULL, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `faculty`
--

CREATE TABLE `faculty` (
  `id` int(11) NOT NULL,
  `fac_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên khoa',
  `sch_id` int(11) NOT NULL COMMENT 'Khoa đó là của Trường nào trong ĐHQGHN',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày tạo',
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày cập nhật',
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `faculty`
--

INSERT INTO `faculty` (`id`, `fac_name`, `sch_id`, `create_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Toán-Cơ-Tin Học', 1, '2020-11-03 09:07:08', '2020-11-03 09:07:08', NULL),
(2, 'Sinh Học', 1, '2020-11-03 09:07:08', '2020-11-03 09:07:08', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `majors`
--

CREATE TABLE `majors` (
  `id` int(11) NOT NULL,
  `maj_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên ngàng',
  `fac_id` int(11) NOT NULL COMMENT 'thuộc khoa nào',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày tạo',
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày cập nhật',
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `majors`
--

INSERT INTO `majors` (`id`, `maj_name`, `fac_id`, `create_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Máy tính & Khoa học thông tin', 1, '2020-11-03 09:07:47', '2020-11-03 09:07:47', NULL),
(2, 'Quốc tế sinh học', 2, '2020-11-03 09:07:47', '2020-11-03 09:07:47', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `school`
--

CREATE TABLE `school` (
  `id` int(11) NOT NULL,
  `sch_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên trường',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày tạo',
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày cập nhật',
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `school`
--

INSERT INTO `school` (`id`, `sch_name`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Đại học khoa học tự nhiên', '2020-11-03 09:06:33', '2020-11-03 09:06:33', NULL),
(2, 'Đại học khoa học xã hội và nhân văn', '2020-11-03 09:06:33', '2020-11-03 09:06:33', NULL),
(3, 'Đại học công nghệ', '2020-11-05 14:25:38', '2020-11-05 14:25:38', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `store`
--

CREATE TABLE `store` (
  `id` int(11) NOT NULL,
  `st_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên kho',
  `st_position` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Vị trí kho',
  `st_status` int(1) NOT NULL DEFAULT 1 COMMENT 'Trạng thái kho (đang còn chỗ , hết chỗ cho sách vào...)',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày tạo',
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày cập nhật',
  `st_max_slot` int(11) NOT NULL COMMENT 'Sô lượng slot tối đa',
  `st_slot_current` int(11) NOT NULL DEFAULT 0 COMMENT 'Số lượng slot đã được sử dụng',
  `st_slot_empty` int(11) NOT NULL DEFAULT 0 COMMENT 'số lượng slot còn trống',
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `store`
--

INSERT INTO `store` (`id`, `st_name`, `st_position`, `st_status`, `created_at`, `updated_at`, `st_max_slot`, `st_slot_current`, `st_slot_empty`, `deleted_at`) VALUES
(1, 'Kho_A', '2', 1, '2020-12-26 15:39:39', '2020-12-26 15:39:39', 50, -4, 54, NULL),
(2, 'Kho_B', '2', 1, '2020-12-26 15:39:39', '2020-12-26 15:39:39', 100, -2, 0, NULL),
(3, 'test', 'Tay', 1, '2021-01-01 10:09:32', '2021-01-01 10:09:32', 100, 0, 100, NULL),
(4, 'BB', 'abc', 1, '2021-01-01 10:11:15', '2021-01-01 10:11:15', 1000, 1, 999, NULL),
(5, 'ccc', 'ccc', 1, '2021-01-01 10:11:45', '2021-01-01 10:11:45', 123, 0, 2, NULL),
(6, 'qwe123eeeeee', 'qwe123', 1, '2021-01-01 10:14:25', '2021-01-01 10:14:25', 1111, 0, 1111, NULL),
(7, 'ê', 'hàaada', 1, '2021-01-01 15:42:03', '2021-01-01 15:42:03', 111, 0, 111, NULL),
(8, 'them moi', 'moi vao', 1, '2021-01-02 04:29:02', '2021-01-02 04:29:02', 5555, 0, 5555, NULL),
(9, 'tesssaaa', '123aaass', 1, '2021-01-09 10:13:52', '2021-01-09 10:13:52', 100, 0, 100, NULL),
(10, 'hhh', 'qwe123', 1, '2021-01-09 10:19:31', '2021-01-09 10:19:31', 5555, 0, 100, NULL),
(11, 'tttt', 'ert', 1, '2021-01-09 10:22:13', '2021-01-09 10:22:13', 777, 0, 777, NULL),
(12, 'Sao Mộc', 'abc', 1, '2021-01-09 13:13:48', '2021-01-09 13:13:48', 1000, 0, 1000, NULL),
(13, 'aa', '3432', 1, '2021-01-09 14:46:38', '2021-01-09 14:46:38', 23, 0, 23, NULL),
(14, 'adđ', 'add', 1, '2021-01-09 14:47:44', '2021-01-09 14:47:44', 123, 0, 123, NULL),
(15, 'addss', 'sss', 1, '2021-01-09 14:50:54', '2021-01-09 14:50:54', 123, 0, 123, NULL),
(16, 'fgh', 'ghf', 1, '2021-01-09 15:20:52', '2021-01-09 15:20:52', 5453, 0, 5453, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `us_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Tên người dùng',
  `us_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ĐỊA chỉ (Có thể có hoặc không)',
  `us_gender` int(1) DEFAULT NULL COMMENT 'Giois tính',
  `us_code_student` int(11) NOT NULL COMMENT 'Mã sinh viên',
  `us_mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'địa chỉ mail',
  `us_phone_number` int(11) DEFAULT NULL COMMENT 'Số điện thaoij (có thế có hoặc không)',
  `us_role` int(1) NOT NULL COMMENT 'quyền trong ứng dụng',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày tạo',
  `update_at` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'ngày cập nhật',
  `fac_id` int(11) NOT NULL COMMENT 'sv khoa nào?',
  `us_nien_khoa` datetime DEFAULT NULL COMMENT 'Niên khóa (có hoặc không)',
  `us_pass_word` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Mật khẩu',
  `maj_id` int(11) NOT NULL COMMENT 'sv ngành nào',
  `sch_id` int(11) NOT NULL COMMENT 'sv trường nào',
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `us_name`, `us_address`, `us_gender`, `us_code_student`, `us_mail`, `us_phone_number`, `us_role`, `create_at`, `update_at`, `fac_id`, `us_nien_khoa`, `us_pass_word`, `maj_id`, `sch_id`, `deleted_at`) VALUES
(21, 'Alexender_dai_de', '', -1, 17000746, 'vantund2017@gmail.com', 355339648, 2, '2020-12-27 09:33:40', '2020-12-27 09:33:40', 1, NULL, '12345678', 1, 1, '2020-12-28 22:56:39'),
(22, 'Trần Tiẻu', '', -1, 17000746, 'vantund2017@gmail.com', 355339648, 2, '2020-12-27 09:33:40', '2020-12-27 09:33:40', 1, NULL, '12345678', 1, 1, '2020-12-28 20:35:30'),
(23, 'MinhHanh', '', -1, 17000999, 'hanh@gmail.com', 924234, 2, '2020-12-27 09:35:10', '2020-12-27 09:35:10', 2, NULL, '12345678', 2, 1, '2020-12-29 23:17:05'),
(24, 'test', '', -1, 7777, 'test@gmail.com', -1, 2, '2020-12-27 09:40:56', '2020-12-27 09:40:56', 1, NULL, '7777', 2, 1, NULL),
(25, 'test', NULL, NULL, 111, 'ad', NULL, 1, '2020-12-28 15:51:50', '2020-12-28 15:51:50', 1, NULL, '1234', 1, 1, NULL),
(26, 'DANGVANTU', NULL, NULL, 17000746, 'vantund2017@gmail.com', NULL, 2, '2020-12-29 16:20:37', '2020-12-29 16:20:37', 1, NULL, '12345678', 1, 1, NULL),
(27, 'NguyenA', NULL, NULL, 17000746, 'A@gmail.com', NULL, 2, '2020-12-29 16:22:06', '2020-12-29 16:22:06', 2, NULL, '12345', 2, 1, '2020-12-29 23:22:54'),
(28, 'AAA', NULL, NULL, 178888, 'van@gmail.com', NULL, 2, '2021-01-01 13:33:57', '2021-01-01 13:33:57', 1, NULL, '12345678', 1, 1, NULL),
(29, 'AAA', NULL, NULL, 178888, 'van@gmail.com', NULL, 2, '2021-01-01 13:33:57', '2021-01-01 13:33:57', 1, NULL, '12345678', 1, 1, NULL),
(30, 'ABC', NULL, NULL, 123, '123@gmail.com', NULL, 2, '2021-01-01 13:34:52', '2021-01-01 13:34:52', 1, NULL, '123', 1, 1, NULL),
(31, 'AD', NULL, NULL, 888, '2@gmail.com', NULL, 2, '2021-01-01 13:35:37', '2021-01-01 13:35:37', 1, NULL, '123', 1, 1, NULL),
(32, 'AD1223', NULL, NULL, 7777, 'ad@gmail.com', NULL, 2, '2021-01-01 13:36:41', '2021-01-01 13:36:41', 1, NULL, '1234', 1, 1, NULL),
(33, 'testAD', NULL, NULL, 666, 'ed@gmail.com', NULL, 2, '2021-01-01 13:38:20', '2021-01-01 13:38:20', 1, NULL, '12345', 1, 1, NULL),
(34, 'Tesssss', NULL, NULL, 888, 'ad@gmail.com', NULL, 2, '2021-01-01 15:12:33', '2021-01-01 15:12:33', 1, NULL, '1234', 1, 1, NULL),
(35, 'Testeeee', NULL, NULL, 123456, 'er@gmail.com', NULL, 2, '2021-01-02 01:39:14', '2021-01-02 01:39:14', 1, NULL, '123', 1, 1, NULL),
(36, 'Testeeee', NULL, NULL, 123456, 'er@gmail.com', NULL, 2, '2021-01-02 01:39:14', '2021-01-02 01:39:14', 1, NULL, '123', 1, 1, NULL),
(37, 'TuEz', NULL, NULL, 12345678, 'tuez@gmail.com', NULL, 2, '2021-01-02 02:26:01', '2021-01-02 02:26:01', 1, NULL, '1234', 1, 1, NULL),
(38, 'dangvantu', NULL, NULL, 998877, 'dangvantu99@gmail.com', NULL, 2, '2021-01-02 02:32:36', '2021-01-02 02:32:36', 1, NULL, '99', 1, 1, NULL),
(39, 'awe', NULL, NULL, 17000746, 'ad@gmail.com', NULL, 2, '2021-01-09 11:52:38', '2021-01-09 11:52:38', 1, NULL, '12345678', 1, 1, NULL),
(40, 'test', NULL, NULL, 1234, 'test@gmail.com', NULL, 2, '2021-01-09 11:57:28', '2021-01-09 11:57:28', 1, NULL, '12345678', 1, 1, NULL),
(41, 'haha', NULL, NULL, 12345, 'ez@gmail.com', NULL, 2, '2021-01-09 12:00:43', '2021-01-09 12:00:43', 1, NULL, '12345678', 1, 1, NULL),
(42, 'dangTest', NULL, NULL, 1234, 'te@gmail.com', NULL, 2, '2021-01-09 12:03:58', '2021-01-09 12:03:58', 1, NULL, '1234', 1, 1, NULL),
(43, 'dangTestssssss', NULL, NULL, 17000, 'tt@gmail.com', NULL, 2, '2021-01-09 12:05:13', '2021-01-09 12:05:13', 1, NULL, '1234', 1, 1, NULL),
(44, 'hhhh', NULL, NULL, 1234, 'ad@gmail.com', NULL, 2, '2021-01-09 12:07:57', '2021-01-09 12:07:57', 1, NULL, '1234', 1, 1, NULL),
(45, 'toi dang test', NULL, NULL, 123, 'ad@gmail.com', NULL, 2, '2021-01-09 12:11:48', '2021-01-09 12:11:48', 1, NULL, '123', 1, 1, NULL),
(46, 'tudv', NULL, NULL, 222, 'tudv@gmail.com', NULL, 2, '2021-01-09 12:12:42', '2021-01-09 12:12:42', 1, NULL, '222', 1, 1, NULL),
(47, 'test22', NULL, NULL, 21199, 'tudv@gmail.com', NULL, 2, '2021-01-09 12:15:36', '2021-01-09 12:15:36', 1, NULL, '1234', 1, 1, NULL),
(48, 'minhHanh1999', NULL, NULL, 122133, 'hanh@gmail.com', NULL, 2, '2021-01-09 12:33:11', '2021-01-09 12:33:11', 2, NULL, '1234', 2, 1, NULL),
(49, 'NhatLinh', NULL, NULL, 6996, 'linh@gmail.com', NULL, 2, '2021-01-09 12:34:45', '2021-01-09 12:34:45', 1, NULL, '1234', 1, 1, NULL),
(50, 'testRR', NULL, NULL, 5555, 'tr@gmail.com', NULL, 2, '2021-01-09 12:36:20', '2021-01-09 12:36:20', 1, NULL, '1234', 1, 1, NULL),
(51, 'testHHH', NULL, NULL, 333, 'hang@gmail.com', NULL, 2, '2021-01-09 12:37:45', '2021-01-09 12:37:45', 1, NULL, '1234', 1, 1, NULL),
(52, 'testJJKKKK', NULL, NULL, 13454, 'te@gmail.com', NULL, 2, '2021-01-09 12:39:32', '2021-01-09 12:39:32', 1, NULL, '1234', 1, 1, NULL),
(53, 'uyt', NULL, NULL, 879, 'yut@gmail.com', NULL, 2, '2021-01-09 12:41:38', '2021-01-09 12:41:38', 1, NULL, '1234', 1, 1, NULL),
(54, 'tyur', NULL, NULL, 6547, 'va@gmail.com', NULL, 2, '2021-01-09 12:44:53', '2021-01-09 12:44:53', 1, NULL, '1234', 1, 1, NULL),
(55, 'hhhhjjjkkkk', NULL, NULL, 6578, 'ert@gmail.com', NULL, 2, '2021-01-09 12:45:59', '2021-01-09 12:45:59', 1, NULL, '1234', 1, 1, NULL),
(56, 'CuocDoi', NULL, NULL, 9785, 'cuocdoi@gmail.com', NULL, 2, '2021-01-09 12:48:45', '2021-01-09 12:48:45', 1, NULL, '1234', 1, 1, NULL),
(57, 'LamHetMinh', NULL, NULL, 6782, 'hetSuc@gmail.com', NULL, 2, '2021-01-09 12:51:26', '2021-01-09 12:51:26', 1, NULL, '1234', 1, 1, NULL),
(58, 'téttt1000', NULL, NULL, 6566, 'tehg@gmail.com', NULL, 2, '2021-01-09 12:56:09', '2021-01-09 12:56:09', 1, NULL, '1234', 1, 1, NULL),
(59, 'ToiTesst2000', NULL, NULL, 6573, 'er@gmail.com', NULL, 2, '2021-01-09 12:57:31', '2021-01-09 12:57:31', 1, NULL, '1234', 1, 1, NULL),
(60, 'qwe1234', NULL, NULL, 556677, 'ert@gmail.com', NULL, 2, '2021-01-09 12:59:13', '2021-01-09 12:59:13', 1, NULL, '1234', 1, 1, NULL),
(61, 'Admin', NULL, NULL, 1991, 'admin@gmail.com', NULL, 1, '2021-01-09 13:54:40', '2021-01-09 13:54:40', 1, NULL, '12345678', 1, 1, NULL),
(62, 'HomNat', NULL, NULL, 98678, 'night@gmail.com', NULL, 2, '2021-01-09 15:22:34', '2021-01-09 15:22:34', 1, NULL, '12345678', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_book`
--

CREATE TABLE `user_book` (
  `id` int(11) NOT NULL,
  `us_id` int(11) NOT NULL,
  `bo_id` int(11) NOT NULL,
  `date_borrow` datetime NOT NULL DEFAULT current_timestamp(),
  `date_pay` datetime DEFAULT NULL,
  `status` int(1) NOT NULL,
  `VND_recoup` double DEFAULT 0,
  `delete_at` datetime DEFAULT NULL,
  `create_at` datetime NOT NULL DEFAULT current_timestamp(),
  `update_at` datetime NOT NULL DEFAULT current_timestamp(),
  `so_ngay_qua_han` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user_book`
--

INSERT INTO `user_book` (`id`, `us_id`, `bo_id`, `date_borrow`, `date_pay`, `status`, `VND_recoup`, `delete_at`, `create_at`, `update_at`, `so_ngay_qua_han`) VALUES
(1, 22, 8, '2020-11-27 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(2, 23, 6, '2020-10-27 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(3, 24, 5, '2020-12-27 18:15:35', NULL, 2, 12000, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', 6),
(4, 24, 1, '2021-01-18 18:15:35', NULL, 1, 0, '2021-01-09 16:17:54', '2020-12-27 18:15:35', '2020-12-27 18:15:35', 0),
(5, 23, 7, '2020-12-02 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(6, 22, 3, '2020-12-25 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(7, 23, 5, '2020-12-29 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(8, 21, 6, '2020-12-30 18:15:35', NULL, 1, 0, NULL, '2020-12-27 18:15:35', '2020-12-27 18:15:35', NULL),
(9, 24, 8, '2021-01-01 16:23:36', NULL, 2, 10000, '2021-01-09 22:18:32', '2021-01-01 16:23:36', '2021-01-01 16:23:36', 5),
(10, 26, 8, '2021-01-01 18:56:22', NULL, 2, 10000, '2021-01-09 20:43:10', '2021-01-01 18:56:22', '2021-01-01 18:56:22', 5),
(11, 26, 5, '2021-01-01 18:57:04', NULL, 2, 2000, NULL, '2021-01-01 18:57:04', '2021-01-01 18:57:04', 1),
(12, 33, 8, '2021-01-01 20:38:25', NULL, 2, 10000, '2021-01-09 22:06:41', '2021-01-01 20:38:25', '2021-01-01 20:38:25', 5),
(13, 26, 5, '2021-01-01 22:21:28', NULL, 2, 0, NULL, '2021-01-01 22:21:28', '2021-01-01 22:21:28', 0),
(14, 38, 6, '2021-01-02 14:25:13', NULL, 2, 10000, '2021-01-09 08:58:03', '2021-01-02 14:25:13', '2021-01-02 14:25:13', 5),
(15, 38, 7, '2021-01-02 14:28:55', NULL, 2, 2000, '2021-01-09 20:41:32', '2021-01-02 14:28:55', '2021-01-02 14:28:55', 1),
(16, 38, 6, '2021-01-02 14:30:01', NULL, 2, 12000, '2021-01-09 20:34:15', '2021-01-02 14:30:01', '2021-01-02 14:30:01', 6),
(17, 38, 5, '2021-01-02 14:30:47', NULL, 2, 2000, '2021-01-09 20:32:15', '2021-01-02 14:30:47', '2021-01-02 14:30:47', 1),
(18, 37, 8, '2021-01-02 14:34:56', NULL, 2, 8000, '2021-01-09 22:04:14', '2021-01-02 14:34:56', '2021-01-02 14:34:56', 4),
(19, 26, 5, '2021-01-02 14:39:59', NULL, 2, 0, NULL, '2021-01-02 14:39:59', '2021-01-02 14:39:59', 0),
(20, 26, 1, '2021-01-02 14:40:39', NULL, 2, 2000, '2021-01-09 20:44:08', '2021-01-02 14:40:39', '2021-01-02 14:40:39', 1),
(21, 30, 3, '2021-01-04 22:55:11', NULL, 1, 0, '2021-01-09 22:08:16', '2021-01-04 22:55:11', '2021-01-04 22:55:11', 0),
(22, 26, 1, '2021-01-09 16:18:24', NULL, 1, 0, NULL, '2021-01-09 16:18:24', '2021-01-09 16:18:24', 0),
(23, 47, 1, '2021-01-09 19:15:47', NULL, 1, 0, '2021-01-09 20:35:41', '2021-01-09 19:15:47', '2021-01-09 19:15:47', 0),
(24, 58, 1, '2021-01-09 19:56:15', NULL, 1, 0, '2021-01-09 20:40:32', '2021-01-09 19:56:15', '2021-01-09 19:56:15', 0),
(25, 60, 5, '2021-01-09 19:59:19', NULL, 1, 0, '2021-01-09 20:37:18', '2021-01-09 19:59:19', '2021-01-09 19:59:19', 0),
(26, 56, 12, '2021-01-09 20:07:31', NULL, 1, 0, '2021-01-09 20:41:57', '2021-01-09 20:07:31', '2021-01-09 20:07:31', 0),
(27, 60, 8, '2021-01-09 20:08:39', NULL, 1, 0, '2021-01-09 20:44:26', '2021-01-09 20:08:39', '2021-01-09 20:08:39', 0),
(28, 61, 6, '2021-01-09 21:44:05', NULL, 1, 0, NULL, '2021-01-09 21:44:05', '2021-01-09 21:44:05', 0),
(29, 61, 7, '2021-01-09 22:09:06', NULL, 1, 0, NULL, '2021-01-09 22:09:06', '2021-01-09 22:09:06', 0),
(30, 38, 8, '2021-01-09 22:09:21', NULL, 1, 0, NULL, '2021-01-09 22:09:21', '2021-01-09 22:09:21', 0),
(31, 59, 10, '2021-01-09 22:09:46', NULL, 1, 0, NULL, '2021-01-09 22:09:46', '2021-01-09 22:09:46', 0),
(32, 49, 11, '2021-01-09 22:10:12', NULL, 1, 0, NULL, '2021-01-09 22:10:12', '2021-01-09 22:10:12', 0),
(33, 61, 4, '2021-01-09 22:10:37', NULL, 1, 0, NULL, '2021-01-09 22:10:37', '2021-01-09 22:10:37', 0),
(34, 62, 4, '2021-01-09 22:22:40', NULL, 1, 0, '2021-01-09 22:23:14', '2021-01-09 22:22:40', '2021-01-09 22:22:40', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`bo_name`,`bo_id_store`,`bo_author`,`bo_status`,`bo_type`,`bo_number`,`bo_date_limit`,`create_at`,`update_at`),
  ADD KEY `bo_id_author` (`bo_author`),
  ADD KEY `bo_id_store` (`bo_id_store`);

--
-- Chỉ mục cho bảng `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`fac_name`,`sch_id`,`create_at`,`updated_at`),
  ADD KEY `id_2` (`id`,`fac_name`,`sch_id`,`create_at`,`updated_at`),
  ADD KEY `sch_id` (`sch_id`);

--
-- Chỉ mục cho bảng `majors`
--
ALTER TABLE `majors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`maj_name`,`fac_id`,`create_at`,`updated_at`),
  ADD KEY `fac_id` (`fac_id`);

--
-- Chỉ mục cho bảng `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`sch_name`,`created_at`,`updated_at`);

--
-- Chỉ mục cho bảng `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`st_name`,`st_position`,`st_status`,`created_at`,`updated_at`,`st_max_slot`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`us_name`,`us_address`,`us_gender`,`us_code_student`,`us_mail`,`us_phone_number`,`us_role`,`create_at`,`update_at`),
  ADD KEY `sch_id` (`fac_id`),
  ADD KEY `us_nien_khoa` (`us_nien_khoa`,`us_pass_word`,`maj_id`),
  ADD KEY `sch_id_2` (`sch_id`),
  ADD KEY `maj_id` (`maj_id`);

--
-- Chỉ mục cho bảng `user_book`
--
ALTER TABLE `user_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`,`us_id`,`bo_id`,`date_borrow`,`date_pay`,`status`,`VND_recoup`,`delete_at`,`create_at`,`update_at`),
  ADD KEY `us_id` (`us_id`),
  ADD KEY `bo_id` (`bo_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key', AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `majors`
--
ALTER TABLE `majors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `school`
--
ALTER TABLE `school`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `store`
--
ALTER TABLE `store`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT cho bảng `user_book`
--
ALTER TABLE `user_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_3` FOREIGN KEY (`bo_id_store`) REFERENCES `store` (`id`);

--
-- Các ràng buộc cho bảng `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`sch_id`) REFERENCES `school` (`id`);

--
-- Các ràng buộc cho bảng `majors`
--
ALTER TABLE `majors`
  ADD CONSTRAINT `majors_ibfk_1` FOREIGN KEY (`fac_id`) REFERENCES `faculty` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`sch_id`) REFERENCES `school` (`id`),
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`fac_id`) REFERENCES `faculty` (`id`),
  ADD CONSTRAINT `user_ibfk_3` FOREIGN KEY (`maj_id`) REFERENCES `majors` (`id`);

--
-- Các ràng buộc cho bảng `user_book`
--
ALTER TABLE `user_book`
  ADD CONSTRAINT `user_book_ibfk_1` FOREIGN KEY (`us_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_book_ibfk_2` FOREIGN KEY (`bo_id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
