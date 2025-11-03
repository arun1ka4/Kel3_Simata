<div align="center">

# 🦁 SISTEM MONITORING SATWA DAN HABITAT  
<p align="center">
  <img width="300" height="300" alt="SIMATA" src="https://github.com/user-attachments/assets/045f0887-1249-4f76-8c51-757213125d6c" />
</p>

### **<ins>SIMATA — Smart Integrated Monitoring of Animals and Their Habitat</ins>**

> Aplikasi berbasis desktop/web untuk mendata dan memantau satwa serta habitatnya secara digital dan terintegrasi.

---

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![CRUD](https://img.shields.io/badge/CRUD-Create%20Read%20Update%20Delete-blue?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Object%20Oriented%20Programming-green?style=for-the-badge)
![MVC](https://img.shields.io/badge/MVC-Model%20View%20Controller-orange?style=for-the-badge)
![JDBC](https://img.shields.io/badge/JDBC-Java%20Database%20Connectivity-007396?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

📍 **Developer:** Tim SIMATA Kelompok 3  
🗓️ **Versi Terakhir:** v1.0.0  
🖥️ **Platform:** Desktop / Web  
📦 **Bahasa Pemrograman:** Java  
🧩 **Database:** MySQL  

</div>

---

## 🧑‍💻 Tim SIMATA

Kontribusi dilakukan secara kolaboratif dengan pembagian peran yang jelas untuk memastikan kualitas dan efisiensi pengembangan sistem **SIMATA**.

| Nama | Peran | Tanggung Jawab Utama | Kontak |
|------|--------|-----------------------|--------|
| 🦁 **[Husaini Iyastama]** | **Full-Stack Developer (Lead)** | Tugas | [GitHub](https://github.com) |
| 🐘 **[Anggota 2]** | **Database Engineer** | Tugas | — |
| 🐿️ **[Anggota 3]** | **UI/UX Designer** | Tugas | — |
| 🦅 **[Anggota 4]** | **Quality Assurance (QA) Tester** | Tugas | — |

---

## 🧭 Gambaran Umum

**SIMATA (Sistem Monitoring Satwa dan Habitat)** adalah aplikasi untuk mendukung kegiatan **konservasi satwa liar** dengan sistem pendataan dan pemantauan berbasis digital.  
Melalui platform ini, pengguna seperti **Admin**, **Petugas Lapangan**, dan **Petugas Pemeliharaan** dapat mencatat, mengelola, serta memverifikasi data satwa dan habitat dengan mudah dan efisien.

**ERD:**

<p align="center">
  <img width="862" height="477" alt="image" src="https://github.com/user-attachments/assets/3fa5f2cd-8cc1-44e9-b77d-2e09acf03e8b" />
</p>

---

## 🧩 **Flowchart & Use Case Diagra**

> Menjelaskan alur utama sistem serta interaksi antara aktor dan fungsionalitas dalam aplikasi **SIMATA**.

📂 **Lihat Diagram Lengkap di Google Drive:**  
🔗 [Klik di sini untuk membuka Flowchart & Use Case Diagram](https://drive.google.com/file/d/1H33Z1jynKNq7nwCeRZ5pPgNIaBAGc5aD/view)

---

### 🧭 **Penjelasan Singkat**
- 🔹 **Flowchart** menggambarkan alur proses mulai dari login, pengelolaan data, hingga verifikasi laporan.  
- 🔹 **Use Case Diagram** menampilkan hubungan antara aktor (**Admin**, **Petugas Lapangan**, dan **Petugas Pemeliharaan**) dengan fitur utama sistem.  
- 🔹 Diagram ini berfungsi sebagai **panduan visual pengembangan sistem**, membantu memahami logika kerja serta tanggung jawab setiap peran pengguna.  

---

## 🌟 Fitur Utama

| 💠 Peran | 🧰 Fitur Utama | 🔍 Deskripsi Singkat |
|----------|----------------|----------------------|
| **👤 Admin** | Kelola Akun, Satwa, Habitat, Laporan Lapangan, Laporan Pemeliharaan | Akses penuh terhadap seluruh data sistem |
| **🌿 Petugas Lapangan** | Buat & kelola laporan observasi | Melakukan pendataan hasil pengamatan satwa di lapangan |
| **🧰 Petugas Pemeliharaan** | Buat & kelola laporan pemeliharaan | Mencatat kondisi satwa dan habitat yang dirawat |

---

### 🛡️ Login & Keamanan
🔐 Sistem autentikasi berbasis **username dan password**, memastikan hanya pengguna terdaftar yang dapat mengakses aplikasi.

---

### ⚙️ Fitur Admin (Full Control)
- 👥 **Kelola Akun Pengguna** — Buat, ubah, dan hapus akun.  
- 🐾 **Kelola Satwa** — Tambah/edit/hapus data satwa & tampilkan foto.  
- 🌲 **Kelola Habitat** — Atur informasi habitat tiap satwa.  
- 📋 **Laporan Lapangan** — Verifikasi laporan pengamatan dari petugas lapangan.  
- 🧾 **Laporan Pemeliharaan** — Verifikasi laporan dari petugas pemeliharaan.

---

### 🌿 Fitur Petugas Lapangan
- 🕒 **Filter Berdasarkan Tanggal Pengamatan**
- ➕ **Buat Laporan Baru**
- ✏️ **Edit & Hapus Laporan**
- 🔍 **Lihat Detail Laporan**

---

### 🧰 Fitur Petugas Pemeliharaan
- 🕒 **Filter Berdasarkan Tanggal Pemeliharaan**
- ➕ **Tambah Laporan Baru**
- ✏️ **Edit / Hapus Laporan**
- 🔍 **Lihat Detail Laporan**

---

## 💡 Penerapan Konsep OOP

| Konsep | Implementasi di SIMATA |
|--------|-------------------------|
| **Encapsulation** | Atribut dibuat privat dalam setiap class untuk keamanan data. |
| **Inheritance** | Class `User` diwariskan ke `Admin`, `PetugasLapangan`, dan `PetugasPemeliharaan`. |
| **Polymorphism** | Method yang sama berperilaku berbeda sesuai dengan role pengguna. |
| **Abstraction** | Penggunaan class abstrak seperti `Satwa` dan `Habitat` untuk menyederhanakan kompleksitas. |

Contoh penerapan
1. **Encapsulation**

   <img width="710" height="322" alt="image" src="https://github.com/user-attachments/assets/6a8f4c3d-eaca-4ba9-a5b2-f602814dfcc3" />

2. **Inheritance**

   <img width="522" height="32" alt="image" src="https://github.com/user-attachments/assets/b3b21571-39e2-4dea-b4da-5d78c00da0a4" />

3. **Polymorphism**

   <img width="723" height="215" alt="image" src="https://github.com/user-attachments/assets/5b5c6960-1187-42e0-8f6c-9ea25edeb952" />

4. **Abstraction**
   
---

## 🗂️ Struktur Folder / Package (Contoh)


---

## 🧰 Teknologi & Library

<div align="center">

| Library / Framework | Fungsi |
|----------------------|--------|
| 🪟 **Java Swing / JavaFX** | GUI interaktif dan dinamis |
| 🗄️ **MySQL / SQLite** | Database utama |
| 🔗 **JDBC** | Koneksi antara aplikasi Java dan database |
| 📅 **JCalendar** | Komponen kalender untuk memilih tanggal pada form laporan |

<p align="center">
  <img src="https://github.com/user-attachments/assets/65f63d7f-1a97-4ea4-9c26-4f2c23006c0f" width="420" alt="SIMATA UI">
</p>

</div>

---

## 🧾 Tampilan Antarmuka (Preview)
<p align="center">
  <img width="1024" height="768" alt="UI SIMATA" src="https://github.com/user-attachments/assets/c2f56d7b-8167-47b5-b071-e42dec0b7299" />
  <br>
  <em>Contoh tampilan login form — modern, menarik kurasa</em>
</p>

---

## 🚀 Cara Menjalankan Program

1. **Clone repository:**
   ```bash
   git clone https://github.com/username/simata.git

---

## 🚀 Proses Penggunaan Program

### 👑 **Admin**

#### 1️⃣ Login
Admin memulai dengan melakukan login ke sistem menggunakan akun yang telah terdaftar.  
Setelah login berhasil, admin akan langsung diarahkan menuju **Dashboard Admin**.

<p align="center">
  <img width="580" height="337" alt="image" src="https://github.com/user-attachments/assets/2c26e742-6a2e-493c-a801-b4fdca939385" />
</p>

#### 2️⃣ Dashboard Admin
Halaman utama setelah login berhasil.  
Di sini admin dapat mengakses seluruh fitur utama seperti kelola akun, data satwa, data habitat, dan laporan.

<p align="center">
  <img width="580" height="341" alt="image" src="https://github.com/user-attachments/assets/b70f2c66-f400-477f-9aa3-e83ad0246c11" />
</p>

#### 3️⃣ Menu Kelola Akun 👥
Menu ini memungkinkan admin untuk **mengelola akun pengguna**, termasuk fitur:
- ➕ Tambah akun baru  
- 📝 Edit data pengguna  
- ❌ Hapus akun  
- 🔍 Cari akun berdasarkan nama atau peran  

<p align="center">
  <img width="586" height="332" alt="image" src="https://github.com/user-attachments/assets/6b349c93-8533-4240-b98e-08e7de7d0903" />
</p>

> 💡 **Fitur unggulan:** CRUD (Create, Read, Update, Delete), tampilan data yang rapi, dan pencarian cepat.

#### 4️⃣ Menu Data Satwa 🦁
Menampilkan daftar satwa beserta informasi dan foto masing-masing.  
Admin dapat melakukan pengelolaan data satwa secara lengkap.

<p align="center">
  <img width="578" height="332" alt="image" src="https://github.com/user-attachments/assets/a4372bde-1cf0-47b4-9143-5efa15b99d48" /><br/>
  <img width="582" height="341" alt="image" src="https://github.com/user-attachments/assets/ceb96930-8b0d-4fae-b622-3e8f766ee1ec" />
</p>

> 📸 **Fitur:** CRUD data satwa + preview foto satwa langsung di aplikasi.

#### 5️⃣ Menu Data Habitat 🌿
Menu ini digunakan untuk mengelola data habitat satwa.  
Admin dapat menambah, mengedit, atau menghapus habitat sesuai dengan kebutuhan.

<p align="center">
  <img width="580" height="340" alt="image" src="https://github.com/user-attachments/assets/c78ecd60-61b4-4df8-a663-575ea6f48a0a" />
</p>

> ✅ **Fitur:** CRUD lengkap dan tampilan data yang mudah dibaca.

#### 6️⃣ Laporan Lapangan 📋
Fitur untuk mencatat dan menyimpan laporan hasil kegiatan di lapangan.  
Admin dapat melihat seluruh laporan yang dikirimkan oleh petugas.

<p align="center">
  <img width="572" height="336" alt="image" src="https://github.com/user-attachments/assets/049c022b-965a-40df-9243-2d423d6ea284" />
</p>

> 🗂️ **Fitur:** Simpan, kelola, dan cetak laporan lapangan dengan mudah.

#### 7️⃣ Laporan Pemeliharaan 🧹
Menu ini digunakan untuk mencatat laporan pemeliharaan habitat maupun satwa.  
Data laporan dapat disimpan langsung ke dalam sistem.

<p align="center">
<img width="1002" height="762" alt="image" src="https://github.com/user-attachments/assets/28ad1ae5-4f50-48ff-aa54-67c5fe3ef4a0" />
</p>

> 💾 **Fitur:** Simpan laporan pemeliharaan dan arsip otomatis di database.

### 👷‍♂️ **Petugas Lapangan**
Petugas lapangan memiliki peran untuk menginput laporan kegiatan di lapangan serta melihat data satwa dan habitat.  
Antarmuka petugas dibuat sederhana dan responsif agar mudah digunakan di berbagai perangkat.

✨ _Dengan sistem ini, pengelolaan satwa dan habitat menjadi lebih efisien, terstruktur, dan modern._ ✨
