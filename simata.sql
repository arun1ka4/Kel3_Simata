-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Okt 2025 pada 09.21
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simata`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `jabatan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `id_user`, `jabatan`) VALUES
(1, 1, 'Koordinator Sistem'),
(2, 2, 'Supervisor Data'),
(3, 3, 'Manajer Operasional'),
(4, 4, 'Koordinator Verifikasi'),
(5, 5, 'Administrator Utama');

-- --------------------------------------------------------

--
-- Struktur dari tabel `habitat`
--

CREATE TABLE `habitat` (
  `id_habitat` int(11) NOT NULL,
  `nama_habitat` varchar(100) NOT NULL,
  `lokasi` varchar(150) DEFAULT NULL,
  `tipe_ekosistem` varchar(50) DEFAULT NULL,
  `luas_area` float DEFAULT NULL,
  `kondisi` enum('Baik','Rusak','Kritis') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `habitat`
--

INSERT INTO `habitat` (`id_habitat`, `nama_habitat`, `lokasi`, `tipe_ekosistem`, `luas_area`, `kondisi`) VALUES
(1, 'Hutan Rimba Raya', 'Kalimantan Tengah', 'Hutan Tropis', 2500.75, 'Baik'),
(2, 'Savana Sumba', 'Nusa Tenggara Timur', 'Savana', 1800.5, 'Rusak'),
(3, 'Hutan Bakau Delta Mahakam', 'Kalimantan Timur', 'Mangrove', 950.25, 'Baik'),
(4, 'Pegunungan Jayawijaya', 'Papua', 'Pegunungan', 3200.6, 'Kritis'),
(5, 'Danau Toba Area', 'Sumatera Utara', 'Perairan', 2100.4, 'Baik'),
(6, 'Taman Nasional Baluran', 'Jawa Timur', 'Savana', 1500.2, 'Rusak'),
(7, 'Hutan Lindung Kerinci', 'Jambi', 'Hutan Tropis', 2800.75, 'Baik'),
(8, 'Pantai Pangumbahan', 'Jawa Barat', 'Pesisir', 400.3, 'Kritis'),
(9, 'Gunung Leuser Reserve', 'Aceh', 'Hutan Pegunungan', 3100.9, 'Baik'),
(10, 'Taman Nasional Ujung Kulon', 'Banten', 'Hutan Hujan', 1200.6, 'Baik'),
(11, 'Sungai Kapuas Delta', 'Kalimantan Barat', 'Rawa', 870.45, 'Rusak'),
(12, 'Danau Sentani', 'Papua', 'Perairan', 760.2, 'Kritis'),
(13, 'Kawasan Tesso Nilo', 'Riau', 'Hutan Tropis', 1900.7, 'Rusak'),
(14, 'Bukit Barisan Selatan', 'Lampung', 'Pegunungan', 2450.8, 'Baik'),
(15, 'Gunung Merbabu Area', 'Jawa Tengah', 'Pegunungan', 1350.5, 'Rusak'),
(16, 'Cagar Alam Lore Lindu', 'Sulawesi Tengah', 'Hutan Tropis', 2600.1, 'Baik'),
(17, 'Pulau Komodo', 'Nusa Tenggara Timur', 'Savana', 1200.6, 'Baik'),
(18, 'Pantai Parangtritis', 'Yogyakarta', 'Pesisir', 300.2, 'Rusak'),
(19, 'Hutan Mangrove Bali', 'Bali', 'Mangrove', 500.15, 'Kritis'),
(20, 'Gunung Rinjani Area', 'Nusa Tenggara Barat', 'Pegunungan', 2700.9, 'Baik'),
(21, 'Taman Nasional Kutai', 'Kalimantan Timur', 'Hutan Tropis', 3100.4, 'Rusak'),
(22, 'Taman Nasional Wasur', 'Papua Selatan', 'Savana', 1950.6, 'Kritis'),
(23, 'Hutan Lindung Bukit Tigapuluh', 'Riau', 'Hutan Tropis', 2250.2, 'Baik'),
(24, 'Danau Maninjau', 'Sumatera Barat', 'Perairan', 950.5, 'Baik'),
(25, 'Pantai Teluk Penyu', 'Cilacap', 'Pesisir', 320.45, 'Rusak'),
(26, 'Gunung Bromo Area', 'Jawa Timur', 'Pegunungan', 1550.8, 'Kritis'),
(27, 'Hutan Bakau Serangan', 'Bali', 'Mangrove', 610.3, 'Baik'),
(28, 'Cagar Alam Ruteng', 'Flores', 'Hutan Hujan', 1850.2, 'Rusak'),
(29, 'Taman Nasional Sebangau', 'Kalimantan Tengah', 'Rawa Gambut', 3400.75, 'Baik'),
(30, 'Gunung Halimun-Salak', 'Jawa Barat', 'Pegunungan', 2450.6, 'Kritis'),
(31, 'Pulau Weh Area', 'Aceh', 'Pesisir', 470.1, 'Baik'),
(32, 'Sungai Mahakam Hulu', 'Kalimantan Timur', 'Rawa', 890.45, 'Rusak'),
(33, 'Hutan Meratus', 'Kalimantan Selatan', 'Hutan Pegunungan', 3000.5, 'Baik'),
(34, 'Pantai Tanjung Tinggi', 'Bangka Belitung', 'Pesisir', 520.25, 'Baik'),
(35, 'Gunung Kerinci Area', 'Jambi', 'Pegunungan', 2700.6, 'Kritis'),
(36, 'Hutan Mangrove Kuala Langsa', 'Aceh', 'Mangrove', 780.3, 'Rusak'),
(37, 'Taman Nasional Lorentz', 'Papua', 'Hutan Tropis', 4000.9, 'Baik'),
(38, 'Savana Baluran Timur', 'Jawa Timur', 'Savana', 1100.75, 'Kritis'),
(39, 'Cagar Alam Gunung Simpang', 'Jawa Barat', 'Hutan Hujan', 1450.2, 'Baik'),
(40, 'Pantai Lasiana', 'Kupang', 'Pesisir', 360.5, 'Rusak');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` int(11) NOT NULL,
  `jenis_laporan` enum('Pengamatan','Pemeliharaan') NOT NULL,
  `tanggal_verifikasi` date NOT NULL,
  `status` enum('Disetujui','Ditolak') NOT NULL,
  `keterangan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `laporan`
--

INSERT INTO `laporan` (`id_laporan`, `jenis_laporan`, `tanggal_verifikasi`, `status`, `keterangan`) VALUES
(1, 'Pemeliharaan', '2025-03-17', 'Disetujui', 'Pemeliharaan rutin berjalan lancar tanpa kendala.'),
(2, 'Pengamatan', '2025-02-05', 'Disetujui', 'Data pengamatan burung berhasil diverifikasi.'),
(3, 'Pengamatan', '2025-01-23', 'Ditolak', 'Lokasi pengamatan tidak sesuai koordinat sistem.'),
(4, 'Pemeliharaan', '2025-01-09', 'Disetujui', 'Kegiatan pembersihan area savana selesai.'),
(5, 'Pemeliharaan', '2025-03-02', 'Ditolak', 'Laporan pemeliharaan belum lengkap bukti dokumentasi.'),
(6, 'Pengamatan', '2025-02-28', 'Disetujui', 'Observasi komodo telah dikonfirmasi oleh pengawas.'),
(7, 'Pengamatan', '2025-03-11', 'Disetujui', 'Hasil pengamatan gajah menunjukkan pola pergerakan baru.'),
(8, 'Pemeliharaan', '2025-01-21', 'Disetujui', 'Pemangkasan vegetasi liar selesai dilakukan.'),
(9, 'Pengamatan', '2025-02-19', 'Ditolak', 'Laporan pengamatan dikembalikan untuk revisi data satwa.'),
(10, 'Pemeliharaan', '2025-02-22', 'Disetujui', 'Kegiatan perbaikan pagar habitat telah selesai.'),
(11, 'Pengamatan', '2025-01-13', 'Disetujui', 'Data observasi primata sudah divalidasi oleh ahli.'),
(12, 'Pemeliharaan', '2025-02-08', 'Ditolak', 'Tidak ditemukan bukti hasil pemeliharaan.'),
(13, 'Pengamatan', '2025-01-31', 'Disetujui', 'Laporan burung cendrawasih diterima oleh admin sistem.'),
(14, 'Pemeliharaan', '2025-03-06', 'Disetujui', 'Pemeliharaan air kolam dan rawa berhasil dilakukan.'),
(15, 'Pengamatan', '2025-03-01', 'Ditolak', 'Pengamatan duplikat dari laporan sebelumnya.'),
(16, 'Pemeliharaan', '2025-01-28', 'Disetujui', 'Pembersihan habitat laut dilakukan dengan hasil baik.'),
(17, 'Pemeliharaan', '2025-10-10', 'Disetujui', 'Laporan diverifikasi ulang oleh tim pusat'),
(18, 'Pemeliharaan', '2025-02-12', 'Disetujui', 'Pemeliharaan hutan mangrove berjalan efektif.'),
(19, 'Pengamatan', '2025-01-16', 'Ditolak', 'Bukti visual tidak sesuai jenis satwa dilaporkan.'),
(20, 'Pemeliharaan', '2025-03-08', 'Disetujui', 'Penanaman ulang vegetasi hutan berhasil.'),
(21, 'Pengamatan', '2025-03-20', 'Disetujui', 'Laporan pengamatan diterima tanpa revisi.'),
(22, 'Pemeliharaan', '2025-01-18', 'Ditolak', 'Kegiatan tidak terdokumentasi dengan baik.'),
(23, 'Pengamatan', '2025-02-15', 'Disetujui', 'Satwa endemik berhasil terpantau kembali.'),
(24, 'Pemeliharaan', '2025-02-27', 'Disetujui', 'Pemeliharaan savana menghasilkan peningkatan vegetasi.'),
(25, 'Pengamatan', '2025-03-05', 'Disetujui', 'Laporan pengamatan valid dan akurat.'),
(26, 'Pemeliharaan', '2025-02-03', 'Ditolak', 'Kegiatan belum disetujui karena bukti kurang lengkap.'),
(27, 'Pengamatan', '2025-01-25', 'Disetujui', 'Pengamatan satwa nokturnal telah diverifikasi.'),
(28, 'Pemeliharaan', '2025-01-30', 'Disetujui', 'Pembersihan area hutan selesai tepat waktu.'),
(29, 'Pengamatan', '2025-03-12', 'Disetujui', 'Laporan disetujui oleh kepala lapangan.'),
(30, 'Pemeliharaan', '2025-02-18', 'Ditolak', 'Hasil pemeliharaan tidak sesuai target laporan.'),
(31, 'Pengamatan', '2025-02-10', 'Disetujui', 'Hasil pengamatan satwa laut dinilai akurat.'),
(32, 'Pemeliharaan', '2025-01-05', 'Disetujui', 'Kegiatan pemeliharaan ekosistem berjalan lancar.'),
(33, 'Pengamatan', '2025-02-24', 'Ditolak', 'Kesalahan waktu pengamatan terdeteksi di sistem.'),
(34, 'Pemeliharaan', '2025-03-13', 'Disetujui', 'Perawatan fasilitas pengamatan telah rampung.'),
(35, 'Pengamatan', '2025-01-19', 'Disetujui', 'Observasi burung jalak bali sesuai catatan populasi.'),
(36, 'Pemeliharaan', '2025-03-10', 'Disetujui', 'Pemeliharaan area rawa berhasil menambah keanekaragaman flora.'),
(37, 'Pengamatan', '2025-02-07', 'Ditolak', 'Koordinat lokasi tidak sesuai GPS lapangan.'),
(38, 'Pemeliharaan', '2025-02-20', 'Disetujui', 'Pemeliharaan area pegunungan disetujui pengawas.'),
(39, 'Pengamatan', '2025-01-27', 'Disetujui', 'Pengamatan penyu di pantai terlaksana dengan baik.'),
(40, 'Pemeliharaan', '2025-03-04', 'Disetujui', 'Pengecekan kembali ekosistem hutan berjalan sesuai rencana.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemeliharaan`
--

CREATE TABLE `pemeliharaan` (
  `id_pemeliharaan` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_habitat` int(11) NOT NULL,
  `tanggal_pemeliharaan` date NOT NULL,
  `kegiatan_pemeliharaan` text DEFAULT NULL,
  `hasil_pemeliharaan` text DEFAULT NULL,
  `status_verifikasi` enum('Menunggu','Disetujui','Ditolak') DEFAULT 'Menunggu'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pemeliharaan`
--

INSERT INTO `pemeliharaan` (`id_pemeliharaan`, `id_user`, `id_habitat`, `tanggal_pemeliharaan`, `kegiatan_pemeliharaan`, `hasil_pemeliharaan`, `status_verifikasi`) VALUES
(1, 8, 1, '2025-01-12', 'Pembersihan area hutan', 'Area bersih dan aman untuk satwa', 'Disetujui'),
(2, 12, 1, '2025-02-05', 'Pengecekan kondisi pohon besar', 'Beberapa pohon perlu pemangkasan', 'Menunggu'),
(3, 17, 2, '2025-03-10', 'Pengisian air kolam rawa', 'Air kolam kembali penuh', 'Disetujui'),
(4, 23, 2, '2025-03-18', 'Pembersihan vegetasi liar', 'Tumbuhan liar telah dibersihkan', 'Ditolak'),
(5, 10, 3, '2025-04-02', 'Perawatan area pantai', 'Sampah plastik sudah dibersihkan', 'Disetujui'),
(6, 25, 3, '2025-04-15', 'Pengecekan sumber air payau', 'Kadar salinitas stabil', 'Menunggu'),
(7, 9, 4, '2025-05-01', 'Perbaikan jalur pejalan petugas', 'Jalur aman digunakan kembali', 'Disetujui'),
(8, 19, 4, '2025-05-12', 'Penanaman pohon pinus baru', 'Penanaman berhasil dilakukan', 'Menunggu'),
(9, 7, 5, '2025-05-25', 'Pemantauan padang rumput', 'Rumput tumbuh dengan baik', 'Disetujui'),
(10, 14, 5, '2025-06-01', 'Pembersihan area savana dari sampah', 'Area kembali bersih', 'Ditolak'),
(11, 11, 6, '2025-06-15', 'Pengecekan kondisi air sungai', 'Air jernih dan debit stabil', 'Disetujui'),
(12, 21, 6, '2025-06-28', 'Pembersihan endapan lumpur', 'Arus sungai kembali lancar', 'Menunggu'),
(13, 13, 7, '2025-07-05', 'Pengecekan rumput di sabana', 'Kondisi rumput dalam batas normal', 'Disetujui'),
(14, 22, 7, '2025-07-13', 'Perbaikan pagar pengaman sabana', 'Pagar sudah diperkuat', 'Disetujui'),
(15, 15, 8, '2025-07-22', 'Pembersihan pantai dari sampah', 'Pantai bersih dan siap dipantau', 'Menunggu'),
(16, 6, 8, '2025-07-30', 'Pengecekan tanaman mangrove', 'Tanaman tumbuh baik', 'Disetujui'),
(17, 16, 9, '2025-08-08', 'Pemangkasan semak di hutan tropis', 'Akses pengamatan lebih mudah', 'Menunggu'),
(18, 24, 9, '2025-08-14', 'Perbaikan papan informasi habitat', 'Papan baru sudah terpasang', 'Disetujui'),
(19, 18, 10, '2025-08-21', 'Pemantauan vegetasi gunung', 'Vegetasi stabil dan tidak rusak', 'Disetujui'),
(20, 20, 10, '2025-08-29', 'Perbaikan jalur konservasi', 'Jalur aman dan siap dilalui', 'Ditolak'),
(21, 9, 11, '2025-09-05', 'Pengisian air kolam rawa kecil', 'Kondisi habitat stabil', 'Menunggu'),
(22, 14, 11, '2025-09-11', 'Pembersihan daun kering', 'Habitat lebih rapi dan aman', 'Disetujui'),
(23, 10, 12, '2025-09-18', 'Perawatan area hutan bakau', 'Bakau tumbuh dengan baik', 'Disetujui'),
(24, 23, 12, '2025-09-26', 'Pengecekan kondisi lumpur bakau', 'Kelembaban cukup untuk satwa', 'Ditolak'),
(25, 19, 13, '2025-10-03', 'Pembersihan area pantai berbatu', 'Sampah laut sudah dibersihkan', 'Disetujui'),
(26, 17, 13, '2025-10-10', 'Pengecekan sarang burung laut', 'Sarang dalam kondisi aman', 'Menunggu'),
(27, 8, 14, '2025-10-15', 'Penanaman vegetasi baru di gunung', 'Tanaman berhasil tumbuh', 'Disetujui'),
(28, 12, 14, '2025-10-21', 'Perbaikan jalur pendakian konservasi', 'Akses sudah dibuka kembali', 'Menunggu'),
(29, 21, 15, '2025-10-28', 'Pembersihan semak liar', 'Area lebih terbuka untuk satwa', 'Disetujui'),
(30, 25, 15, '2025-11-05', 'Pengecekan lubang satwa', 'Lubang dihuni secara alami', 'Ditolak'),
(31, 13, 16, '2025-11-12', 'Pemantauan area sungai dangkal', 'Arus lancar dan jernih', 'Disetujui'),
(32, 11, 16, '2025-11-19', 'Perbaikan tanggul kecil', 'Air tidak meluap lagi', 'Disetujui'),
(33, 18, 17, '2025-11-25', 'Penanaman pohon di savana kering', 'Tingkat erosi berkurang', 'Menunggu'),
(34, 7, 17, '2025-12-02', 'Pembersihan sarang serangga pengganggu', 'Area aman untuk satwa kecil', 'Disetujui'),
(35, 6, 18, '2025-12-09', 'Pemantauan rawa dangkal', 'Habitat masih layak', 'Disetujui'),
(36, 22, 18, '2025-12-16', 'Pengecekan kadar air rawa', 'Tingkat air stabil', 'Menunggu'),
(37, 16, 19, '2025-12-22', 'Perbaikan jalur konservasi gunung', 'Jalur aman dilalui petugas', 'Disetujui'),
(38, 20, 19, '2025-12-29', 'Pemantauan vegetasi pegunungan', 'Vegetasi sehat dan alami', 'Ditolak'),
(39, 15, 20, '2026-01-05', 'Pembersihan area padang rumput', 'Area kembali hijau', 'Disetujui'),
(40, 9, 20, '2026-01-11', 'Pengecekan sumur air alami', 'Air cukup untuk satwa', 'Menunggu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengamatan`
--

CREATE TABLE `pengamatan` (
  `id_pengamatan` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_satwa` int(11) NOT NULL,
  `id_habitat` int(11) NOT NULL,
  `tanggal_pengamatan` date NOT NULL,
  `jumlah_teramati` int(5) DEFAULT NULL,
  `perilaku_satwa` text DEFAULT NULL,
  `kondisi_lingkungan` text DEFAULT NULL,
  `catatan_tambahan` text DEFAULT NULL,
  `status_verifikasi` enum('Menunggu','Disetujui','Ditolak') DEFAULT 'Menunggu'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengamatan`
--

INSERT INTO `pengamatan` (`id_pengamatan`, `id_user`, `id_satwa`, `id_habitat`, `tanggal_pengamatan`, `jumlah_teramati`, `perilaku_satwa`, `kondisi_lingkungan`, `catatan_tambahan`, `status_verifikasi`) VALUES
(1, 8, 1, 9, '2025-01-12', 2, 'Berjalan di jalur hutan pegunungan', 'Hutan lebat dengan vegetasi padat', 'Jejak kaki ditemukan dekat sungai kecil', 'Disetujui'),
(2, 14, 2, 7, '2025-01-20', 4, 'Berkelompok di tepi sungai', 'Hutan tropis lembab', 'Populasi tampak sehat', 'Menunggu'),
(3, 9, 3, 19, '2025-02-02', 3, 'Bergelantungan di pohon bakau', 'Hutan mangrove dengan akar padat', 'Satu individu membawa anak', 'Disetujui'),
(4, 15, 4, 17, '2025-02-10', 2, 'Berkubang di tanah savana', 'Savana kering dengan semak rendah', 'Individu tampak tenang', 'Menunggu'),
(5, 7, 5, 20, '2025-02-22', 1, 'Terbang di atas lereng gunung', 'Pegunungan berawan dengan pohon tinggi', 'Terlihat berpasangan', 'Disetujui'),
(6, 18, 6, 11, '2025-03-01', 5, 'Berenang di rawa dangkal', 'Rawa dengan air keruh dan vegetasi padat', 'Perilaku makan terpantau', 'Disetujui'),
(7, 20, 7, 17, '2025-03-08', 3, 'Berjemur di bebatuan panas', 'Savana kering dengan suhu tinggi', 'Komodo tampak agresif', 'Menunggu'),
(8, 10, 8, 16, '2025-03-16', 2, 'Berlari di bawah tajuk pepohonan', 'Hutan tropis lebat', 'Tampak soliter', 'Disetujui'),
(9, 12, 9, 15, '2025-03-23', 5, 'Menari di dahan pohon tinggi', 'Hutan pegunungan lembab', 'Suara khas terdengar', 'Disetujui'),
(10, 23, 10, 13, '2025-04-01', 2, 'Berburu di semak hutan tropis', 'Hutan Riau dengan kelembaban tinggi', 'Satu individu dewasa', 'Menunggu'),
(11, 6, 11, 8, '2025-04-08', 4, 'Bertelur di pasir pantai', 'Pesisir bersih dengan ombak tenang', 'Telur ditemukan', 'Disetujui'),
(12, 19, 12, 24, '2025-04-15', 3, 'Berenang di tepi danau', 'Perairan tenang dan jernih', 'Populasi kecil terpantau', 'Disetujui'),
(13, 11, 13, 10, '2025-04-22', 1, 'Bertengger di cabang tinggi', 'Hutan hujan dengan kelembaban tinggi', 'Burung tampak sehat', 'Menunggu'),
(14, 25, 14, 35, '2025-05-01', 2, 'Berlari di lereng gunung', 'Pegunungan berkabut', 'Individu muda terlihat', 'Disetujui'),
(15, 17, 15, 2, '2025-05-10', 6, 'Berlarian di padang savana', 'Rumput kering dan sedikit pohon', 'Populasi besar terlihat', 'Menunggu'),
(16, 22, 16, 8, '2025-05-20', 3, 'Bertelur di pantai malam hari', 'Pesisir berpasir putih', 'Telur sebagian menetas', 'Disetujui'),
(17, 13, 17, 5, '2025-05-28', 4, 'Berenang di danau dalam', 'Perairan jernih dengan vegetasi air', 'Populasi stabil', 'Menunggu'),
(18, 9, 18, 20, '2025-06-05', 1, 'Mendaki lereng gunung mencari makan', 'Pegunungan terbuka dengan batuan besar', 'Individu tunggal', 'Disetujui'),
(19, 24, 19, 10, '2025-06-12', 2, 'Terbang dari pohon ke pohon', 'Hutan hujan tropis', 'Burung aktif di pagi hari', 'Disetujui'),
(20, 21, 20, 29, '2025-06-20', 7, 'Berenang di air gambut', 'Rawa gambut Kalimantan Tengah', 'Arwana berwarna cerah', 'Menunggu'),
(21, 16, 21, 32, '2025-07-01', 3, 'Berendam di air keruh', 'Rawa Kalimantan Timur', 'Moncong muncul ke permukaan', 'Disetujui'),
(22, 14, 22, 3, '2025-07-08', 2, 'Berjalan di akar mangrove', 'Hutan bakau rapat', 'Individu sedang berburu', 'Disetujui'),
(23, 8, 23, 9, '2025-07-15', 2, 'Bergelantungan di pohon besar', 'Hutan pegunungan Aceh', 'Suara nyaring terdengar', 'Disetujui'),
(24, 10, 24, 37, '2025-07-22', 1, 'Bertengger di pohon tinggi', 'Hutan tropis Papua', 'Individu terlihat tenang', 'Menunggu'),
(25, 7, 25, 14, '2025-08-01', 3, 'Berjalan cepat di hutan', 'Pegunungan Lampung lembab', 'Burung mencari makan', 'Disetujui'),
(26, 20, 26, 26, '2025-08-09', 2, 'Berjalan di lereng gunung', 'Pegunungan Jawa Timur', 'Suhu dingin', 'Menunggu'),
(27, 18, 27, 13, '2025-08-18', 1, 'Memanjat pohon tinggi', 'Hutan tropis Riau', 'Hewan soliter', 'Disetujui'),
(28, 11, 28, 37, '2025-08-25', 5, 'Menari di antara pepohonan', 'Hutan tropis Papua', 'Populasi stabil', 'Disetujui'),
(29, 12, 29, 8, '2025-09-01', 6, 'Bertelur di pasir pantai', 'Pesisir alami dengan ombak sedang', 'Telur ditemukan', 'Menunggu'),
(30, 23, 30, 31, '2025-09-08', 1, 'Mendekati pantai untuk bernafas', 'Pesisir dengan ombak tenang', 'Individu besar teramati', 'Disetujui'),
(31, 9, 31, 33, '2025-09-15', 2, 'Terbang rendah di hutan pegunungan', 'Hutan sejuk dan lembab', 'Burung berburu mangsa', 'Disetujui'),
(32, 25, 32, 24, '2025-09-22', 3, 'Berenang di perairan danau', 'Air tenang dan jernih', 'Pasangan ikan tampak aktif', 'Menunggu'),
(33, 15, 33, 19, '2025-10-01', 1, 'Bertengger di akar mangrove', 'Hutan bakau Bali', 'Burung tampak sehat', 'Disetujui'),
(34, 22, 34, 2, '2025-10-08', 2, 'Berburu di padang rumput', 'Savana terbuka', 'Individu dewasa aktif', 'Disetujui'),
(35, 6, 35, 30, '2025-10-15', 4, 'Terbang di sekitar pegunungan', 'Pegunungan lembab', 'Burung aktif siang hari', 'Menunggu'),
(36, 17, 36, 36, '2025-10-22', 3, 'Bertengger di pohon bakau', 'Hutan mangrove Aceh', 'Populasi sedikit menurun', 'Ditolak'),
(37, 24, 37, 37, '2025-10-29', 2, 'Terbang di kanopi hutan tropis', 'Hutan lebat dan lembab', 'Burung tampak jinak', 'Disetujui'),
(38, 13, 38, 40, '2025-11-05', 5, 'Meniru suara manusia', 'Pesisir padat penduduk', 'Burung populer di masyarakat', 'Menunggu'),
(39, 19, 39, 39, '2025-11-12', 2, 'Melompat di semak belukar', 'Hutan hujan dataran tinggi', 'Hewan aktif siang hari', 'Disetujui'),
(40, 21, 40, 2, '2025-11-20', 5, 'Terbang mencari biji rumput', 'Savana terbuka NTT', 'Populasi stabil', 'Ditolak');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas_lapangan`
--

CREATE TABLE `petugas_lapangan` (
  `id_petugas_lapangan` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `wilayah_tugas` varchar(100) NOT NULL,
  `alat_pengamatan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `petugas_lapangan`
--

INSERT INTO `petugas_lapangan` (`id_petugas_lapangan`, `id_user`, `wilayah_tugas`, `alat_pengamatan`) VALUES
(1, 6, 'Taman Nasional Ujung Kulon', 'Teropong Satwa'),
(2, 7, 'Cagar Alam Rawa Danau', 'Binokular'),
(3, 8, 'Taman Nasional Halimun Salak', 'Kamera Trap'),
(4, 9, 'Hutan Lindung Wonosadi', 'GPS Handheld'),
(5, 10, 'Taman Nasional Baluran', 'Dron Kamera'),
(6, 11, 'Hutan Mangrove Bedul', 'Teropong'),
(7, 12, 'Hutan Kota Malabar', 'Perekam Suara Satwa'),
(8, 13, 'Taman Nasional Bromo Tengger', 'Binokular Digital'),
(9, 14, 'Gunung Ciremai', 'Kamera DSLR'),
(10, 15, 'Cagar Alam Pangandaran', 'Dron Mini'),
(11, 16, 'Hutan Lindung Bukit Barisan', 'Kamera Trap'),
(12, 17, 'Taman Nasional Meru Betiri', 'Teropong Satwa'),
(13, 18, 'Gunung Leuser', 'Sensor Suhu & Kamera'),
(14, 19, 'Taman Nasional Komodo', 'GPS Kamera'),
(15, 20, 'Pulau Menjangan', 'Binokular Digital'),
(16, 21, 'Taman Nasional Wasur', 'Kamera Trap 4K'),
(17, 22, 'Hutan Mangrove Surabaya', 'Dron Pengintai'),
(18, 23, 'Gunung Gede Pangrango', 'Kamera DSLR'),
(19, 24, 'Taman Nasional Kerinci Seblat', 'Perekam Gerak Satwa'),
(20, 25, 'Taman Nasional Kutai', 'Teropong Digital');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas_pemeliharaan`
--

CREATE TABLE `petugas_pemeliharaan` (
  `id_petugas_pemeliharaan` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `keahlian` varchar(100) NOT NULL,
  `sertifikasi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `petugas_pemeliharaan`
--

INSERT INTO `petugas_pemeliharaan` (`id_petugas_pemeliharaan`, `id_user`, `keahlian`, `sertifikasi`) VALUES
(1, 26, 'Pemeliharaan Flora & Fauna', 'Konservasi Alam Tingkat I'),
(2, 27, 'Teknik Irigasi Habitat', 'Sertifikat Pengelolaan Ekosistem'),
(3, 28, 'Pakan Satwa Liar', 'Manajemen Nutrisi Satwa'),
(4, 29, 'Perawatan Area Konservasi', 'Konservasi Habitat Dasar'),
(5, 30, 'Pengelolaan Kebersihan Habitat', 'Petugas Habitat Tersertifikasi'),
(6, 31, 'Pemantauan Ekosistem', 'Ekologi dan Lingkungan Hidup'),
(7, 32, 'Pemeliharaan Vegetasi', 'Pertanian Hutan Lestari'),
(8, 33, 'Perawatan Infrastruktur', 'Sertifikat Pemeliharaan Lapangan'),
(9, 34, 'Pengelolaan Air Habitat', 'Teknisi Irigasi Satwa'),
(10, 35, 'Penyelamatan Satwa', 'Sertifikat Responder Satwa'),
(11, 36, 'Kesehatan Satwa', 'Veterinary Conservation Level 1'),
(12, 37, 'Pemantauan Populasi', 'Sertifikat Observasi Lingkungan'),
(13, 38, 'Manajemen Sampah Habitat', 'Sertifikat Green Ranger'),
(14, 39, 'Pemeliharaan Kolam Habitat', 'Konservasi Air dan Lahan'),
(15, 40, 'Rehabilitasi Satwa', 'Pusat Rehabilitasi Satwa Liar');

-- --------------------------------------------------------

--
-- Struktur dari tabel `satwa`
--

CREATE TABLE `satwa` (
  `id_satwa` int(11) NOT NULL,
  `nama_satwa` varchar(100) NOT NULL,
  `nama_latin` varchar(100) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `status_konservasi` varchar(50) DEFAULT NULL,
  `deskripsi` text DEFAULT NULL,
  `foto_satwa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `satwa`
--

INSERT INTO `satwa` (`id_satwa`, `nama_satwa`, `nama_latin`, `kategori`, `status_konservasi`, `deskripsi`, `foto_satwa`) VALUES
(1, 'Harimau Sumatera', 'Panthera tigris sumatrae', 'Mamalia', 'Kritis', 'Kucing besar endemik Sumatera yang terancam punah.', 'harimau_sumatera.jpg'),
(2, 'Gajah Sumatera', 'Elephas maximus sumatranus', 'Mamalia', 'Kritis', 'Subspesies gajah Asia yang hidup di hutan Sumatera.', 'gajah_sumatera.jpg'),
(3, 'Orangutan Kalimantan', 'Pongo pygmaeus', 'Primata', 'Kritis', 'Primata besar dengan rambut coklat kemerahan khas Kalimantan.', 'orangutan_kalimantan.jpg'),
(4, 'Badak Jawa', 'Rhinoceros sondaicus', 'Mamalia', 'Kritis', 'Salah satu badak paling langka di dunia, hidup di Ujung Kulon.', 'badak_jawa.jpg'),
(5, 'Elang Jawa', 'Nisaetus bartelsi', 'Burung', 'Terancam', 'Burung pemangsa endemik Jawa, simbol langka fauna Indonesia.', 'elang_jawa.jpg'),
(6, 'Bekantan', 'Nasalis larvatus', 'Primata', 'Rentan', 'Monyet berhidung panjang khas Kalimantan.', 'bekantan.jpg'),
(7, 'Komodo', 'Varanus komodoensis', 'Reptil', 'Rentan', 'Kadal raksasa endemik Pulau Komodo dan sekitarnya.', 'komodo.jpg'),
(8, 'Kucing Merah Kalimantan', 'Catopuma badia', 'Mamalia', 'Kritis', 'Kucing liar langka dari Kalimantan dengan warna merah bata.', 'kucing_merah.jpg'),
(9, 'Burung Cendrawasih', 'Paradisaea apoda', 'Burung', 'Rentan', 'Burung surga dari Papua dengan bulu indah.', 'cendrawasih.jpg'),
(10, 'Tarsius Sulawesi', 'Tarsius tarsier', 'Primata', 'Rentan', 'Primata kecil bermata besar, aktif di malam hari.', 'tarsius.jpg'),
(11, 'Anoa Dataran Rendah', 'Bubalus depressicornis', 'Mamalia', 'Kritis', 'Mamalia endemik Sulawesi yang menyerupai kerbau kecil.', 'anoa.jpg'),
(12, 'Kukang Jawa', 'Nycticebus javanicus', 'Primata', 'Kritis', 'Primata kecil nokturnal dengan gerak lambat.', 'kukang.jpg'),
(13, 'Burung Jalak Bali', 'Leucopsar rothschildi', 'Burung', 'Kritis', 'Burung putih endemik Bali yang sangat langka.', 'jalak_bali.jpg'),
(14, 'Lutung Jawa', 'Trachypithecus auratus', 'Primata', 'Rentan', 'Monyet berwarna hitam keemasan yang hidup di hutan Jawa.', 'lutung.jpg'),
(15, 'Rusa Timor', 'Rusa timorensis', 'Mamalia', 'Rentan', 'Rusa asli Indonesia bagian timur.', 'rusa_timor.jpg'),
(16, 'Burung Maleo', 'Macrocephalon maleo', 'Burung', 'Terancam', 'Burung endemik Sulawesi yang unik karena menanam telurnya di pasir panas.', 'maleo.jpg'),
(17, 'Biawak Air Asia', 'Varanus salvator', 'Reptil', 'Tidak Terancam', 'Reptil besar yang hidup di daerah rawa dan sungai.', 'biawak.jpg'),
(18, 'Banteng Jawa', 'Bos javanicus', 'Mamalia', 'Terancam', 'Kerbau liar yang menjadi nenek moyang sapi Bali.', 'banteng.jpg'),
(19, 'Burung Rangkong Gading', 'Rhinoplax vigil', 'Burung', 'Kritis', 'Burung besar dengan paruh gading khas.', 'rangkong.jpg'),
(20, 'Ikan Arwana Merah', 'Scleropages formosus', 'Ikan', 'Terancam', 'Ikan hias mahal endemik Kalimantan Barat.', 'arwana.jpg'),
(21, 'Tapir Asia', 'Tapirus indicus', 'Mamalia', 'Rentan', 'Hewan herbivora dengan moncong panjang dari Sumatera.', 'tapir.jpg'),
(22, 'Buaya Muara', 'Crocodylus porosus', 'Reptil', 'Rentan', 'Reptil besar yang hidup di sungai dan pesisir.', 'buaya_muara.jpg'),
(23, 'Owa Jawa', 'Hylobates moloch', 'Primata', 'Kritis', 'Primata kecil bersuara khas endemik Jawa Barat.', 'owa.jpg'),
(24, 'Kakatua Raja', 'Probosciger aterrimus', 'Burung', 'Rentan', 'Burung besar hitam dengan jambul merah dari Papua.', 'kakatua_raja.jpg'),
(25, 'Burung Kasuari', 'Casuarius casuarius', 'Burung', 'Rentan', 'Burung besar tidak bisa terbang dari Papua.', 'kasuari.jpg'),
(26, 'Biawak Komodo', 'Varanus komodoensis', 'Reptil', 'Rentan', 'Reptil terbesar di dunia yang hidup di NTT.', 'biawak_komodo.jpg'),
(27, 'Kuskus Beruang', 'Ailurops ursinus', 'Mamalia', 'Rentan', 'Mamalia pemanjat endemik Sulawesi Utara.', 'kuskus.jpg'),
(28, 'Burung Cendrawasih Kuning', 'Paradisaea minor', 'Burung', 'Rentan', 'Burung surga dari Papua dengan warna kuning indah.', 'cendrawasih_kuning.jpg'),
(29, 'Penyu Hijau', 'Chelonia mydas', 'Reptil', 'Terancam', 'Penyu laut yang sering dijumpai di pantai Indonesia.', 'penyu_hijau.jpg'),
(30, 'Penyu Belimbing', 'Dermochelys coriacea', 'Reptil', 'Kritis', 'Penyu terbesar di dunia.', 'penyu_belimbing.jpg'),
(31, 'Burung Enggang', 'Buceros rhinoceros', 'Burung', 'Rentan', 'Burung dengan paruh besar dari Kalimantan.', 'enggang.jpg'),
(32, 'Ikan Napoleon', 'Cheilinus undulatus', 'Ikan', 'Terancam', 'Ikan karang besar berwarna biru-hijau.', 'napoleon.jpg'),
(33, 'Burung Kakatua Putih', 'Cacatua alba', 'Burung', 'Rentan', 'Kakatua endemik Maluku Utara.', 'kakatua_putih.jpg'),
(34, 'Rusa Bawean', 'Axis kuhlii', 'Mamalia', 'Kritis', 'Rusa kecil endemik Pulau Bawean.', 'rusa_bawean.jpg'),
(35, 'Burung Nuri Kepala Hitam', 'Lorius lory', 'Burung', 'Rentan', 'Burung berwarna-warni dari Papua.', 'nuri_kepala_hitam.jpg'),
(36, 'Burung Murai Batu', 'Copsychus malabaricus', 'Burung', 'Tidak Terancam', 'Burung penyanyi populer di Indonesia.', 'murai_batu.jpg'),
(37, 'Burung Jalak Suren', 'Gracupica contra', 'Burung', 'Tidak Terancam', 'Burung dengan suara keras dan bulu hitam putih.', 'jalak_suren.jpg'),
(38, 'Burung Beo', 'Gracula religiosa', 'Burung', 'Tidak Terancam', 'Burung yang dapat meniru suara manusia.', 'beo.jpg'),
(39, 'Kancil', 'Tragulus javanicus', 'Mamalia', 'Tidak Terancam', 'Mamalia kecil pemakan tumbuhan.', 'kancil.jpg'),
(40, 'Burung Pipit', 'Lonchura punctulata', 'Burung', 'Tidak Terancam', 'Burung kecil pemakan biji-bijian.', 'pipit.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_telp` varchar(20) DEFAULT NULL,
  `role` enum('admin','petugas_lapangan','petugas_pemeliharaan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `username`, `password`, `email`, `no_telp`, `role`) VALUES
(1, 'Rina Setiawan', 'rina_admin', 'Rina@2025', 'rina.admin@simata.id', '081234567801', 'admin'),
(2, 'Bagus Hidayat', 'bagus_admin', 'Bagus#321', 'bagus.admin@simata.id', '081234567802', 'admin'),
(3, 'Maya Putri', 'maya_admin', 'Maya!456', 'maya.admin@simata.id', '081234567803', 'admin'),
(4, 'Andi Kurniawan', 'andi_admin', 'Andi_789', 'andi.admin@simata.id', '081234567804', 'admin'),
(5, 'Nia Pratiwi', 'nia_admin', 'Nia@Admin1', 'nia.admin@simata.id', '081234567805', 'admin'),
(6, 'Budi Santoso', 'budi_lapangan', 'Budi#Lap01', 'budi.lapangan@simata.id', '081234567806', 'petugas_lapangan'),
(7, 'Dewi Lestari', 'dewi_lapangan', 'DewiLap02!', 'dewi.lapangan@simata.id', '081234567807', 'petugas_lapangan'),
(8, 'Fajar Pratama', 'fajar_lapangan', 'Fajar@03', 'fajar.lapangan@simata.id', '081234567808', 'petugas_lapangan'),
(9, 'Tika Rahma', 'tika_lapangan', 'Tika#04', 'tika.lapangan@simata.id', '081234567809', 'petugas_lapangan'),
(10, 'Rudi Hartono', 'rudi_lapangan', 'Rudi@05', 'rudi.lapangan@simata.id', '081234567810', 'petugas_lapangan'),
(11, 'Sinta Amalia', 'sinta_lapangan', 'SintaLap06!', 'sinta.lapangan@simata.id', '081234567811', 'petugas_lapangan'),
(12, 'Agus Saputra', 'agus_lapangan', 'Agus#07', 'agus.lapangan@simata.id', '081234567812', 'petugas_lapangan'),
(13, 'Lina Marlina', 'lina_lapangan', 'LinaLap08@', 'lina.lapangan@simata.id', '081234567813', 'petugas_lapangan'),
(14, 'Hendra Wijaya', 'hendra_lapangan', 'Hendra_09', 'hendra.lapangan@simata.id', '081234567814', 'petugas_lapangan'),
(15, 'Wulan Pertiwi', 'wulan_lapangan', 'Wulan@10', 'wulan.lapangan@simata.id', '081234567815', 'petugas_lapangan'),
(16, 'Rizky Maulana', 'rizky_lapangan', 'Rizky#11', 'rizky.lapangan@simata.id', '081234567816', 'petugas_lapangan'),
(17, 'Citra Dewanti', 'citra_lapangan', 'CitraLap12!', 'citra.lapangan@simata.id', '081234567817', 'petugas_lapangan'),
(18, 'Yoga Firmansyah', 'yoga_lapangan', 'Yoga@13', 'yoga.lapangan@simata.id', '081234567818', 'petugas_lapangan'),
(19, 'Anisa Oktavia', 'anisa_lapangan', 'Anisa#14', 'anisa.lapangan@simata.id', '081234567819', 'petugas_lapangan'),
(20, 'Bayu Kurnia', 'bayu_lapangan', 'BayuLap15@', 'bayu.lapangan@simata.id', '081234567820', 'petugas_lapangan'),
(21, 'Fitri Ayuningtyas', 'fitri_lapangan', 'Fitri!16', 'fitri.lapangan@simata.id', '081234567821', 'petugas_lapangan'),
(22, 'Ardi Nugroho', 'ardi_lapangan', 'Ardi@17', 'ardi.lapangan@simata.id', '081234567822', 'petugas_lapangan'),
(23, 'Sari Widya', 'sari_lapangan', 'Sari#18', 'sari.lapangan@simata.id', '081234567823', 'petugas_lapangan'),
(24, 'Ilham Fauzi', 'ilham_lapangan', 'Ilham_19', 'ilham.lapangan@simata.id', '081234567824', 'petugas_lapangan'),
(25, 'Mega Rosita', 'mega_lapangan', 'MegaLap20!', 'mega.lapangan@simata.id', '081234567825', 'petugas_lapangan'),
(26, 'Rico Saputra', 'rico_pemeliharaan', 'Rico@21', 'rico.pemeliharaan@simata.id', '081234567826', 'petugas_pemeliharaan'),
(27, 'Ayu Puspa', 'ayu_pemeliharaan', 'Ayu#22', 'ayu.pemeliharaan@simata.id', '081234567827', 'petugas_pemeliharaan'),
(28, 'Galih Ramadhan', 'galih_pemeliharaan', 'Galih@23', 'galih.pemeliharaan@simata.id', '081234567828', 'petugas_pemeliharaan'),
(29, 'Mila Anggraini', 'mila_pemeliharaan', 'Mila#24', 'mila.pemeliharaan@simata.id', '081234567829', 'petugas_pemeliharaan'),
(30, 'Tono Prasetyo', 'tono_pemeliharaan', 'Tono@25', 'tono.pemeliharaan@simata.id', '081234567830', 'petugas_pemeliharaan'),
(31, 'Putri Andriana', 'putri_pemeliharaan', 'Putri#26', 'putri.pemeliharaan@simata.id', '081234567831', 'petugas_pemeliharaan'),
(32, 'Eko Yulianto', 'eko_pemeliharaan', 'Eko@27', 'eko.pemeliharaan@simata.id', '081234567832', 'petugas_pemeliharaan'),
(33, 'Lestari Utami', 'lestari_pemeliharaan', 'Lestari#28', 'lestari.pemeliharaan@simata.id', '081234567833', 'petugas_pemeliharaan'),
(34, 'Rangga Putra', 'rangga_pemeliharaan', 'Rangga@29', 'rangga.pemeliharaan@simata.id', '081234567834', 'petugas_pemeliharaan'),
(35, 'Cahyo Adi', 'cahyo_pemeliharaan', 'Cahyo#30', 'cahyo.pemeliharaan@simata.id', '081234567835', 'petugas_pemeliharaan'),
(36, 'Salsa Dewi', 'salsa_pemeliharaan', 'Salsa@31', 'salsa.pemeliharaan@simata.id', '081234567836', 'petugas_pemeliharaan'),
(37, 'Wahyu Nugraha', 'wahyu_pemeliharaan', 'Wahyu#32', 'wahyu.pemeliharaan@simata.id', '081234567837', 'petugas_pemeliharaan'),
(38, 'Novi Kurniasih', 'novi_pemeliharaan', 'Novi@33', 'novi.pemeliharaan@simata.id', '081234567838', 'petugas_pemeliharaan'),
(39, 'Dimas Aditya', 'dimas_pemeliharaan', 'Dimas#34', 'dimas.pemeliharaan@simata.id', '081234567839', 'petugas_pemeliharaan'),
(40, 'Farah Amelia', 'farah_pemeliharaan', 'Farah@35', 'farah.pemeliharaan@simata.id', '081234567840', 'petugas_pemeliharaan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD KEY `fk_admin_user` (`id_user`);

--
-- Indeks untuk tabel `habitat`
--
ALTER TABLE `habitat`
  ADD PRIMARY KEY (`id_habitat`);

--
-- Indeks untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`);

--
-- Indeks untuk tabel `pemeliharaan`
--
ALTER TABLE `pemeliharaan`
  ADD PRIMARY KEY (`id_pemeliharaan`),
  ADD KEY `fk_pemeliharaan_user` (`id_user`),
  ADD KEY `fk_pemeliharaan_habitat` (`id_habitat`);

--
-- Indeks untuk tabel `pengamatan`
--
ALTER TABLE `pengamatan`
  ADD PRIMARY KEY (`id_pengamatan`),
  ADD KEY `fk_pengamatan_user` (`id_user`),
  ADD KEY `fk_pengamatan_satwa` (`id_satwa`),
  ADD KEY `fk_pengamatan_habitat` (`id_habitat`);

--
-- Indeks untuk tabel `petugas_lapangan`
--
ALTER TABLE `petugas_lapangan`
  ADD PRIMARY KEY (`id_petugas_lapangan`),
  ADD KEY `fk_petugas_user` (`id_user`);

--
-- Indeks untuk tabel `petugas_pemeliharaan`
--
ALTER TABLE `petugas_pemeliharaan`
  ADD PRIMARY KEY (`id_petugas_pemeliharaan`),
  ADD KEY `fk_petugas_pemeliharaan_user` (`id_user`);

--
-- Indeks untuk tabel `satwa`
--
ALTER TABLE `satwa`
  ADD PRIMARY KEY (`id_satwa`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `habitat`
--
ALTER TABLE `habitat`
  MODIFY `id_habitat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `laporan`
--
ALTER TABLE `laporan`
  MODIFY `id_laporan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `pemeliharaan`
--
ALTER TABLE `pemeliharaan`
  MODIFY `id_pemeliharaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `pengamatan`
--
ALTER TABLE `pengamatan`
  MODIFY `id_pengamatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `satwa`
--
ALTER TABLE `satwa`
  MODIFY `id_satwa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `pemeliharaan`
--
ALTER TABLE `pemeliharaan`
  ADD CONSTRAINT `fk_pemeliharaan_habitat` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`),
  ADD CONSTRAINT `fk_pemeliharaan_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `pengamatan`
--
ALTER TABLE `pengamatan`
  ADD CONSTRAINT `fk_pengamatan_habitat` FOREIGN KEY (`id_habitat`) REFERENCES `habitat` (`id_habitat`),
  ADD CONSTRAINT `fk_pengamatan_satwa` FOREIGN KEY (`id_satwa`) REFERENCES `satwa` (`id_satwa`),
  ADD CONSTRAINT `fk_pengamatan_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `petugas_lapangan`
--
ALTER TABLE `petugas_lapangan`
  ADD CONSTRAINT `fk_petugas_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `petugas_pemeliharaan`
--
ALTER TABLE `petugas_pemeliharaan`
  ADD CONSTRAINT `fk_petugas_pemeliharaan_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
