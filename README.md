# 🦁 SISTEM MONITORING SATWA DAN HABITAT (SIMATA)

> **SIMATA** adalah aplikasi berbasis desktop/web yang berfungsi untuk mendata dan memantau satwa serta habitatnya secara terintegrasi.  
> Sistem ini membantu petugas dalam mencatat, mengelola, serta melaporkan hasil observasi lapangan secara digital dengan mudah dan efisien.

---

## 📝 Deskripsi Program
SIMATA dikembangkan untuk mendukung kegiatan konservasi dengan menyediakan sistem pencatatan satwa dan habitat yang modern.  
Melalui sistem ini, proses dokumentasi, pemantauan, hingga verifikasi laporan dapat dilakukan secara terpusat oleh berbagai peran pengguna seperti **Admin**, **Petugas Lapangan**, dan **Petugas Pemeliharaan**.

---

## 🔧 Fitur Utama

### 👤 **Login**
Pengguna dapat mengakses akun masing-masing dengan username dan password untuk menjaga keamanan sistem.

---

### 🛠️ **Fitur Admin**
Admin memiliki akses penuh terhadap sistem, dengan 5 menu utama:

#### 1. Kelola Akun
Mengatur seluruh akun pengguna, termasuk admin, petugas lapangan, dan petugas pemeliharaan.  
Fitur:
- ➕ **Buat** akun baru berdasarkan peran.
- ✏️ **Edit** data akun pengguna.
- 🗑️ **Hapus** akun dari sistem.
- 🔍 **Lihat Detail** untuk menampilkan informasi lengkap pengguna.

#### 2. Kelola Satwa
Mengelola seluruh data satwa yang tercatat di sistem.  
Fitur:
- ➕ **Tambah** data satwa baru.
- ✏️ **Edit** informasi satwa.
- 🗑️ **Hapus** data satwa.
- 🖼️ **Lihat Foto** untuk menampilkan gambar satwa lebih jelas.

#### 3. Kelola Habitat
Mengatur informasi habitat dari setiap satwa.  
Fitur:
- ➕ **Tambah** data habitat baru.
- ✏️ **Edit** informasi habitat.
- 🗑️ **Hapus** habitat dari sistem.

#### 4. Laporan Lapangan
Melihat dan memverifikasi laporan dari **petugas lapangan**.  
Fitur:
- ✅ **Verifikasi** laporan pengamatan.
- 🔍 **Lihat Detail** untuk menampilkan data lengkap laporan.

#### 5. Laporan Pemeliharaan
Melihat dan memverifikasi laporan dari **petugas pemeliharaan**.  
Fitur:
- ✅ **Verifikasi** laporan pemeliharaan.
- 🔍 **Lihat Detail** laporan secara lengkap.

---

### 🌿 **Petugas Lapangan**
Bertugas untuk membuat laporan hasil pengamatan satwa di lapangan.  
Fitur:
- 🔎 **Filter berdasarkan tanggal pengamatan**
- ➕ **Buat** laporan baru
- ✏️ **Edit** laporan
- 🗑️ **Hapus** laporan
- 🔍 **Lihat Detail** laporan

---

### 🧰 **Petugas Pemeliharaan**
Bertanggung jawab atas pemeliharaan habitat dan kondisi satwa.  
Fitur:
- 🔎 **Filter berdasarkan tanggal pemeliharaan**
- ➕ **Buat** laporan baru
- ✏️ **Edit** laporan
- 🗑️ **Hapus** laporan
- 🔍 **Lihat Detail** laporan

---

## 🧩 Penerapan OOP
SIMATA dibangun dengan konsep **Object-Oriented Programming (OOP)** yang meliputi:
- **Encapsulation:** Pengelolaan data melalui class dan atribut privat.
- **Inheritance:** Pewarisan class umum seperti `User` ke class `Admin`, `PetugasLapangan`, dan `PetugasPemeliharaan`.
- **Polymorphism:** Implementasi method yang dapat berperilaku berbeda sesuai dengan peran pengguna.
- **Abstraction:** Penyederhanaan kompleksitas sistem dengan class abstrak untuk entitas utama seperti `Satwa` dan `Habitat`.

---

## 🗂️ Struktur Folder / Package

---

## 📚 Library & Framework yang Digunakan
<p align="center">
  <img src="https://github.com/user-attachments/assets/65f63d7f-1a97-4ea4-9c26-4f2c23006c0f" alt="Library Logo" width="380">
</p>

- **Java Swing / JavaFX** → GUI interaktif  
- **MySQL / SQLite** → Database utama  
- **JDBC** → Koneksi antara Java dan database  
- **iText / JasperReport** → Pembuatan laporan PDF  
- **FlatLaf / JTattoo** → Tampilan UI modern  

---
