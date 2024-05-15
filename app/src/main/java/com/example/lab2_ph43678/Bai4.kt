package com.example.lab2_ph43678


data class SinhVien(
    val tenSV: String,
    val mssv: String,
    val diemTB: Float,
    val daTotNghiep: Boolean?,
    val tuoi: Int?
)

class QuanLySinhVien {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun themSinhVien(sinhVien: SinhVien) {
        danhSachSinhVien.add(sinhVien)
        println("\tThêm sinh viên thành công.")
    }

    fun xoaSinhVien(mssv: String) {
        var found = false
        for (i in danhSachSinhVien.indices) {
            if (danhSachSinhVien[i].mssv == mssv) {
                danhSachSinhVien.removeAt(i)
                found = true
                break
            }
        }
        if (found) {
            println("\tXóa sinh viên thành công.")
        } else {
            println("\tKhông tìm thấy sinh viên có MSSV $mssv.")
        }
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSinhVien.isNotEmpty()) {
            println("\tDanh sách sinh viên:")
            var xDaTN:String
            for (sinhVien in danhSachSinhVien) {
                if(sinhVien.daTotNghiep == true){
                    xDaTN="Đã tốt nghiệp"
                }
                else{
                    xDaTN="Chưa tốt nghiệp"

                }
                println("Tên: ${sinhVien.tenSV}, MSSV: ${sinhVien.mssv}, Điểm TB: ${sinhVien.diemTB}, ${xDaTN}, Tuổi: ${sinhVien.tuoi}")
            }
        } else {
            println("\tDanh sách sinh viên trống.")
        }
    }
}

fun main() {
    val qlsv = QuanLySinhVien()

    var choice: Int
    do {
        println("----- Chương trình quản lý sinh viên -----")
        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Xem danh sách sinh viên")
        println("0. Thoát")
        print("Vui lòng chọn chức năng: ")
        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> {
                println("----- Thêm sinh viên -----")
                print("Tên sinh viên: ")
                val tenSV = readLine() ?: ""
                print("MSSV: ")
                val mssv = readLine() ?: ""
                print("Điểm TB: ")
                val diemTB = readLine()?.toFloatOrNull() ?: 0.0F
                print("Đã tốt nghiệp (true/false): ")
                val daTotNghiep = readLine()?.toBoolean()
                print("Tuổi: ")
                val tuoi = readLine()?.toIntOrNull()
                val sinhVien = SinhVien(tenSV, mssv, diemTB, daTotNghiep, tuoi)
                qlsv.themSinhVien(sinhVien)
                println()
            }
            2 -> {
                println("----- Xóa sinh viên -----")
                print("Nhập MSSV của sinh viên cần xóa: ")
                val mssv = readLine() ?: ""
                qlsv.xoaSinhVien(mssv)
                println()
            }
            3 -> {
                println("----- Xem danh sách sinh viên -----")
                qlsv.xemDanhSachSinhVien()
                println()
            }
            0 -> {
                println("----- Kết thúc chương trình -----")
            }
            else -> {
                println("Lựa chọn không hợp lệ.")
                println()
            }
        }
    } while (choice != 0)
}