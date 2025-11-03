-- phpMyAdmin SQL Dump
-- Database: simata_db
-- Struktur database yang sesuai dengan implementasi kode Java

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- --------------------------------------------------------
-- DROP DATABASE IF EXISTS
-- --------------------------------------------------------

DROP DATABASE IF EXISTS `simata_db`;
CREATE DATABASE IF NOT EXISTS `simata_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `simata_db`;

-- --------------------------------------------------------
-- Struktur dari tabel `user`
-- --------------------------------------------------------

CREATE TABLE `user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(100) NOT NULL,
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(100) DEFAULT NULL,
  `no_telp` VARCHAR(20) DEFAULT NULL,
  `role` ENUM('Admin', 'Petugas Lapangan', 'Petugas Pemeliharaan') NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `admin`
-- --------------------------------------------------------

CREATE TABLE `admin` (
  `id_admin` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `jabatan` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id_admin`),
  FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `petugas_lapangan`
-- --------------------------------------------------------

CREATE TABLE `petugas_lapangan` (
  `id_petugas_lapangan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `wilayah_tugas` VARCHAR(200) DEFAULT NULL,
  `alat_pengamatan` TEXT DEFAULT NULL,
  PRIMARY KEY (`id_petugas_lapangan`),
  FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `petugas_pemeliharaan`
-- --------------------------------------------------------

CREATE TABLE `petugas_pemeliharaan` (
  `id_petugas_pemeliharaan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `keahlian` TEXT DEFAULT NULL,
  `sertifikasi` TEXT DEFAULT NULL,
  PRIMARY KEY (`id_petugas_pemeliharaan`),
  FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `habitat`
-- --------------------------------------------------------

CREATE TABLE `habitat` (
  `id_habitat` INT(11) NOT NULL AUTO_INCREMENT,
  `nama_habitat` VARCHAR(100) NOT NULL,
  `lokasi` VARCHAR(200) DEFAULT NULL,
  `tipe_ekosistem` VARCHAR(100) DEFAULT NULL,
  `luas_area` DECIMAL(10,2) DEFAULT NULL,
  `kondisi` ENUM('Baik', 'Sedang', 'Buruk') DEFAULT 'Baik',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_habitat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `satwa`
-- --------------------------------------------------------

CREATE TABLE `satwa` (
  `id_satwa` INT(11) NOT NULL AUTO_INCREMENT,
  `nama_satwa` VARCHAR(100) NOT NULL,
  `nama_latin` VARCHAR(100) DEFAULT NULL,
  `kategori` VARCHAR(50) DEFAULT NULL,
  `status_konservasi` ENUM('CR', 'EN', 'VU', 'NT', 'LC') DEFAULT 'LC' COMMENT 'CR=Critically Endangered, EN=Endangered, VU=Vulnerable, NT=Near Threatened, LC=Least Concern',
  `deskripsi` TEXT DEFAULT NULL,
  `foto_satwa` VARCHAR(255) DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_satwa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `pengamatan`
-- --------------------------------------------------------

CREATE TABLE `pengamatan` (
  `id_pengamatan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_petugas_lapangan` INT(11) NOT NULL,
  `id_habitat` INT(11) NOT NULL,
  `id_satwa` INT(11) NOT NULL,
  `tanggal_pengamatan` DATE NOT NULL,
  `jumlah_teramati` INT(11) DEFAULT 0,
  `perilaku_satwa` TEXT DEFAULT NULL,
  `kondisi_lingkungan` TEXT DEFAULT NULL,
  `catatan_tambahan` TEXT DEFAULT NULL,
  `status_verifikasi` ENUM('Menunggu', 'Diverifikasi', 'Ditolak') DEFAULT 'Menunggu',
  `tanggal_verifikasi` DATE DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pengamatan`),
  FOREIGN KEY (`id_petugas_lapangan`) REFERENCES `petugas_lapangan`(`id_petugas_lapangan`) ON DELETE CASCADE,
  FOREIGN KEY (`id_habitat`) REFERENCES `habitat`(`id_habitat`) ON DELETE CASCADE,
  FOREIGN KEY (`id_satwa`) REFERENCES `satwa`(`id_satwa`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `pemeliharaan`
-- --------------------------------------------------------

CREATE TABLE `pemeliharaan` (
  `id_pemeliharaan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_petugas_pemeliharaan` INT(11) NOT NULL,
  `id_satwa` INT(11) NOT NULL,
  `tanggal_pemeliharaan` DATE NOT NULL,
  `kegiatan` TEXT NOT NULL,
  `hasil_pemeliharaan` TEXT DEFAULT NULL,
  `status_verifikasi` ENUM('Menunggu', 'Diverifikasi', 'Ditolak') DEFAULT 'Menunggu',
  `tanggal_verifikasi` DATE DEFAULT NULL,
  `keterangan` TEXT DEFAULT NULL,
  `verified_by` INT(11) DEFAULT NULL COMMENT 'ID Admin yang memverifikasi',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pemeliharaan`),
  FOREIGN KEY (`id_petugas_pemeliharaan`) REFERENCES `petugas_pemeliharaan`(`id_petugas_pemeliharaan`) ON DELETE CASCADE,
  FOREIGN KEY (`id_satwa`) REFERENCES `satwa`(`id_satwa`) ON DELETE CASCADE,
  FOREIGN KEY (`verified_by`) REFERENCES `admin`(`id_admin`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- Struktur dari tabel `laporan` (Optional - tidak digunakan di kode saat ini)
-- --------------------------------------------------------

CREATE TABLE `laporan` (
  `id_laporan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pengamatan` INT(11) DEFAULT NULL,
  `jenis_laporan` ENUM('Lapangan', 'Pemeliharaan') NOT NULL,
  `tanggal_verifikasi` DATE DEFAULT NULL,
  `status` ENUM('Menunggu', 'Diverifikasi', 'Ditolak') DEFAULT 'Menunggu',
  `keterangan` TEXT DEFAULT NULL,
  `verified_by` INT(11) DEFAULT NULL COMMENT 'ID Admin yang memverifikasi',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_laporan`),
  FOREIGN KEY (`id_pengamatan`) REFERENCES `pengamatan`(`id_pengamatan`) ON DELETE CASCADE,
  FOREIGN KEY (`verified_by`) REFERENCES `admin`(`id_admin`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
-- INSERT DATA SAMPLE
-- --------------------------------------------------------

-- Insert User Admin dengan password MD5
INSERT INTO `user` (`nama`, `username`, `password`, `email`, `no_telp`, `role`) VALUES
('Admin Utama', 'admin', MD5('admin123'), 'admin@simata.com', '081234567890', 'Admin'),
('Rina Setiawan', 'rina_admin', MD5('rina123'), 'rina.admin@simata.id', '081234567801', 'Admin'),
('Bagus Hidayat', 'bagus_admin', MD5('bagus123'), 'bagus.admin@simata.id', '081234567802', 'Admin');

-- Insert Admin
INSERT INTO `admin` (`id_user`, `jabatan`) VALUES
(1, 'Kepala Admin'),
(2, 'Koordinator Sistem'),
(3, 'Supervisor Data');

-- Insert User Petugas Lapangan
INSERT INTO `user` (`nama`, `username`, `password`, `email`, `no_telp`, `role`) VALUES
('Budi Santoso', 'budi_lapangan', MD5('budi123'), 'budi.lapangan@simata.id', '081234567806', 'Petugas Lapangan'),
('Dewi Lestari', 'dewi_lapangan', MD5('dewi123'), 'dewi.lapangan@simata.id', '081234567807', 'Petugas Lapangan'),
('Fajar Pratama', 'fajar_lapangan', MD5('fajar123'), 'fajar.lapangan@simata.id', '081234567808', 'Petugas Lapangan');

-- Insert Petugas Lapangan
INSERT INTO `petugas_lapangan` (`id_user`, `wilayah_tugas`, `alat_pengamatan`) VALUES
(4, 'Kalimantan Timur', 'Kamera, GPS, Binocular'),
(5, 'Kalimantan Tengah', 'Teropong, Kamera Trap'),
(6, 'Sumatera Utara', 'Dron, GPS Tracker');

-- Insert User Petugas Pemeliharaan
INSERT INTO `user` (`nama`, `username`, `password`, `email`, `no_telp`, `role`) VALUES
('Rico Saputra', 'rico_pemeliharaan', MD5('rico123'), 'rico.pemeliharaan@simata.id', '081234567826', 'Petugas Pemeliharaan'),
('Ayu Puspa', 'ayu_pemeliharaan', MD5('ayu123'), 'ayu.pemeliharaan@simata.id', '081234567827', 'Petugas Pemeliharaan'),
('Galih Ramadhan', 'galih_pemeliharaan', MD5('galih123'), 'galih.pemeliharaan@simata.id', '081234567828', 'Petugas Pemeliharaan');

-- Insert Petugas Pemeliharaan
INSERT INTO `petugas_pemeliharaan` (`id_user`, `keahlian`, `sertifikasi`) VALUES
(7, 'Perawatan Primata', 'Sertifikat Konservasi Satwa'),
(8, 'Pemeliharaan Flora & Fauna', 'Konservasi Alam Tingkat I'),
(9, 'Teknik Irigasi Habitat', 'Pengelolaan Ekosistem');

-- Insert Sample Habitat
INSERT INTO `habitat` (`nama_habitat`, `lokasi`, `tipe_ekosistem`, `luas_area`, `kondisi`) VALUES
('Hutan Lindung Kutai', 'Kalimantan Timur', 'Hutan Hujan Tropis', 2500.50, 'Baik'),
('Taman Nasional Tanjung Puting', 'Kalimantan Tengah', 'Hutan Rawa Gambut', 4150.00, 'Baik'),
('Hutan Rimba Raya', 'Kalimantan Tengah', 'Hutan Tropis', 2500.75, 'Baik'),
('Savana Sumba', 'Nusa Tenggara Timur', 'Savana', 1800.50, 'Sedang'),
('Hutan Bakau Delta Mahakam', 'Kalimantan Timur', 'Mangrove', 950.25, 'Baik'),
('Pegunungan Jayawijaya', 'Papua', 'Pegunungan', 3200.60, 'Buruk'),
('Danau Toba Area', 'Sumatera Utara', 'Perairan', 2100.40, 'Baik'),
('Taman Nasional Baluran', 'Jawa Timur', 'Savana', 1500.20, 'Sedang'),
('Hutan Lindung Kerinci', 'Jambi', 'Hutan Tropis', 2800.75, 'Baik'),
('Pantai Pangumbahan', 'Jawa Barat', 'Pesisir', 400.30, 'Buruk');

-- Insert Sample Satwa
INSERT INTO `satwa` (`nama_satwa`, `nama_latin`, `kategori`, `status_konservasi`, `deskripsi`, `foto_satwa`) VALUES
('Orangutan Kalimantan', 'Pongo pygmaeus', 'Mamalia', 'CR', 'Primata endemik Kalimantan yang terancam punah', 'orangutan.jpg'),
('Bekantan', 'Nasalis larvatus', 'Mamalia', 'EN', 'Monyet endemik Kalimantan dengan hidung panjang', 'bekantan.jpg'),
('Harimau Sumatera', 'Panthera tigris sumatrae', 'Mamalia', 'CR', 'Kucing besar endemik Sumatera yang terancam punah', 'harimau_sumatera.jpg'),
('Gajah Sumatera', 'Elephas maximus sumatranus', 'Mamalia', 'CR', 'Subspesies gajah Asia yang hidup di hutan Sumatera', 'gajah_sumatera.jpg'),
('Badak Jawa', 'Rhinoceros sondaicus', 'Mamalia', 'CR', 'Salah satu badak paling langka di dunia', 'badak_jawa.jpg'),
('Elang Jawa', 'Nisaetus bartelsi', 'Burung', 'EN', 'Burung pemangsa endemik Jawa', 'elang_jawa.jpg'),
('Komodo', 'Varanus komodoensis', 'Reptil', 'VU', 'Kadal raksasa endemik Pulau Komodo', 'komodo.jpg'),
('Kucing Merah Kalimantan', 'Catopuma badia', 'Mamalia', 'CR', 'Kucing liar langka dari Kalimantan', 'kucing_merah.jpg'),
('Burung Cendrawasih', 'Paradisaea apoda', 'Burung', 'VU', 'Burung surga dari Papua dengan bulu indah', 'cendrawasih.jpg'),
('Tarsius Sulawesi', 'Tarsius tarsier', 'Primata', 'VU', 'Primata kecil bermata besar', 'tarsius.jpg');

-- Insert Sample Pengamatan
INSERT INTO `pengamatan` (`id_petugas_lapangan`, `id_habitat`, `id_satwa`, `tanggal_pengamatan`, `jumlah_teramati`, `perilaku_satwa`, `kondisi_lingkungan`, `catatan_tambahan`, `status_verifikasi`) VALUES
(1, 1, 1, '2025-01-15', 2, 'Mencari makan di pohon tinggi', 'Hutan lebat dengan cuaca cerah', 'Terlihat 1 induk dengan anak', 'Menunggu'),
(1, 2, 2, '2025-01-20', 5, 'Berkelompok di tepi sungai', 'Hutan rawa dengan kelembaban tinggi', 'Populasi tampak sehat', 'Diverifikasi'),
(2, 1, 1, '2025-02-10', 3, 'Bergelantungan di kanopi', 'Hutan primer yang masih alami', 'Suara vokalisasi terdengar', 'Menunggu'),
(2, 3, 3, '2025-02-15', 1, 'Berburu di semak belukar', 'Hutan lebat dengan jejak mangsa', 'Jejak harimau ditemukan', 'Menunggu'),
(3, 7, 4, '2025-03-01', 2, 'Minum di tepi danau', 'Danau tenang dengan vegetasi rapat', 'Kondisi gajah sehat', 'Diverifikasi');

-- Insert Sample Pemeliharaan
INSERT INTO `pemeliharaan` (`id_petugas_pemeliharaan`, `id_satwa`, `tanggal_pemeliharaan`, `kegiatan`, `hasil_pemeliharaan`, `status_verifikasi`) VALUES
(1, 1, '2025-01-12', 'Pembersihan area habitat orangutan', 'Area bersih dan aman untuk satwa', 'Diverifikasi'),
(2, 2, '2025-02-05', 'Pengecekan kondisi pohon makanan bekantan', 'Beberapa pohon perlu pemangkasan', 'Menunggu'),
(3, 3, '2025-03-10', 'Pemantauan jalur migrasi harimau', 'Jalur masih aman dan tidak terganggu', 'Menunggu'),
(1, 4, '2025-03-18', 'Pembersihan kolam minum gajah', 'Air kolam kembali jernih', 'Diverifikasi'),
(2, 5, '2025-04-02', 'Perawatan area habitat badak', 'Vegetasi tumbuh dengan baik', 'Menunggu');

COMMIT;

-- --------------------------------------------------------
-- INFORMASI LOGIN DEFAULT
-- --------------------------------------------------------
-- Admin:
--   Username: admin
--   Password: admin123
--
-- Petugas Lapangan:
--   Username: budi_lapangan
--   Password: budi123
--
-- Petugas Pemeliharaan:
--   Username: rico_pemeliharaan
--   Password: rico123
-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
