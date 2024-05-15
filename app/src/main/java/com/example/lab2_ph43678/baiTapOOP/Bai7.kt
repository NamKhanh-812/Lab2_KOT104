package com.example.lab2_ph43678.baiTapOOP


fun main() {
    var gv1 = CBGVnew("Nguyen Van Long", 30, "HCM", "002231", 500f, 50f, 10f)
    var gv2 = CBGVnew("Nguyen Van Khánh", 30, "HCM", "002232", 500f, 50f, 10f)

    val danhSachGV = mutableListOf<CBGVnew>()
    danhSachGV.add(gv1)
    danhSachGV.add(gv2)
    var tiepTuc: Boolean
    do {
        println("------------------------")
        println("Menu quản lý giáo viên")
        println("1. Thêm giáo viên")
        println("2. Hiển thị danh sách GV")
        println("3. Xoá GV")
        println("4. Cập nhật thông tin GV")
        println("5. Thoát chương trình")


        try {
            print("Nhập lựa chọn chủa bạn: ")
            val options: Int = readLine()!!.toInt()
            when (options) {
                1 -> {
                    println("Thêm giáo viên")
                    println("--------------------------")
                    themGV(danhSachGV)
                }


                2 -> {
                    hienThiDSGV(danhSachGV)
                }

                3 -> {
                    println("Xoá giáo viên")
                    println("--------------------------")
                    xoaGV(danhSachGV)
                }

                4 -> {
                    println("Cập nhật thông tin GV")
                    capNhatGV(danhSachGV)
                }

                5 -> {
                    println("Kết thúc chương trình")
                    tiepTuc = false
                }

                else -> {
                    println("Nhập sai, vui lòng nhập lại")
                }
            }
            println("Bạn có muốn tiếp tục? (c/k): ")
            val s = readLine()
            tiepTuc = s == "c"
        } catch (e: Exception) {
            println("Nhập sai, vui lòng nhập lại")
            tiepTuc = true
        }

    } while (tiepTuc)
}


fun themGV(danhSachGV: MutableList<CBGVnew>) {
    print("Nhập tên: ")
    val hoten = readLine()!!
    print("Nhập tuổi: ")
    val tuoi = readLine()!!.toInt()
    print("Nhập quê quán: ")
    val quequan = readLine()!!
    print("Nhập MSGV: ")
    val msgv = readLine()!!
    print("Nhập lương cứng: ")
    val luongCung = readLine()!!.toFloat()
    print("Nhập lương thưởng: ")
    val luongThuong = readLine()!!.toFloatOrNull()
    print("Nhập lương phạt: ")
    val luongPhat = readLine()!!.toFloatOrNull()

    val newTeacher = CBGVnew(hoten, tuoi, quequan, msgv, luongCung, luongThuong, luongPhat)
    danhSachGV.add(newTeacher)
    println("Thêm giáo viên thành công!")
}

fun hienThiDSGV(danhSachGV: MutableList<CBGVnew>) {
    println("Danh sách giáo viên")
    println("--------------------------")
    for (teacher in danhSachGV) {
        println(teacher.getTT())
    }
}

fun xoaGV(danhSachGV: MutableList<CBGVnew>) {
    print("Nhập MSGV cần xoá: ")
    val msgv = readLine()!!
    val iterator = danhSachGV.iterator()
    var found = false
    while (iterator.hasNext()) {
        val teacher = iterator.next()
        if (teacher.msgv == msgv) {
            iterator.remove()
            println("Xoá giáo viên thành công!")
            found = true
            break
        }
    }
    if (!found) {
        println("Không tìm thấy MSGV!")
    }
}

fun capNhatGV(danhSachGV: MutableList<CBGVnew>) {
    print("Nhập MSGV cần cập nhật: ")
    val msgv = readLine()!!
    var found = false
    for (teacher in danhSachGV) {
        if (teacher.msgv == msgv) {
            print("Nhập tên mới: ")
            teacher.hoten = readLine()!!
            print("Nhập tuổi mới: ")
            teacher.tuoi = readLine()!!.toInt()
            print("Nhập quê quán mới: ")
            teacher.quequan = readLine()!!
            print("Nhập lương cứng mới: ")
            teacher.luongCung = readLine()!!.toFloat()
            print("Nhập lương thưởng mới: ")
            teacher.luongThuong = readLine()!!.toFloatOrNull()
            print("Nhập lương phạt mới: ")
            teacher.luongPhat = readLine()!!.toFloatOrNull()
            teacher.luongThucLinh =
                teacher.luongCung + (teacher.luongThuong ?: 0f) - (teacher.luongPhat ?: 0f)
            println("Cập nhật giáo viên thành công!")
            found = true
            break
        }
    }
    if (!found) {
        println("Không tìm thấy MSGV!")
    }
}