package com.example.lab2_ph43678



fun main() {
    var listThe = mutableListOf<TheMuon>()

    val tm1 = TheMuon("Sằm Nam Khánh", 20, "MD18302", "PM01", 10, 30, "Sach01")

    listThe.add(tm1)

    do {
        println("------ Quản lý thẻ mượn -------")
        println("1. Xem danh sách thẻ mượn")
        println("2. Thêm thẻ mượn")
        println("3. Xóa thẻ mượn")

        print("Chọn chức năng: ")
        var s = readLine()!!.toInt()

        when (s) {
            1 -> getThongTin(listThe)
            2 -> addTheMuon(listThe)
            3 -> deleteTheMuon(listThe)
            else->{
                println("Không tồn tại chức năng này")
            }
        }

        print("Bạn có muốn tiếp tục không? (y/n): ")
        var check = readLine()
        if (check.equals("n"))
            break
    } while (true)
}

fun getThongTin(listThe: MutableList<TheMuon>) {
    println("\tThông tin các thẻ mượn!")
    for (tm in listThe) {
        println("Mã thẻ: ${tm.mapm}, Họ tên: ${tm.hoten}, Tuổi: ${tm.tuoi}, Lớp: ${tm.lop}, Ngày mượn: ${tm.ngaymuon}, Hạn trả: ${tm.hantra}, Số hiệu sách: ${tm.sohieusach}")
    }
}

fun addTheMuon(listThe: MutableList<TheMuon>) {
    print("Nhập họ tên: ")
    var hoten = readLine()
    print("Nhập tuổi: ")
    var tuoi = readLine()!!.toInt()
    print("Nhập lớp: ")
    var lop = readLine()
    print("Nhập mã thẻ mượn: ")
    var matm = readLine()
    print("Ngày mượn: ")
    var ngaymuon = readLine()!!.toInt()
    print("Hạn trả: ")
    var hantra = readLine()!!.toInt()
    print("Số hiệu sách: ")
    var sohieusach = readLine()

    val tm = TheMuon(hoten!!, tuoi, lop!!, matm!!, ngaymuon, hantra, sohieusach!!)

    listThe.add(tm)

    getThongTin(listThe)
}

fun deleteTheMuon(listThe: MutableList<TheMuon>) {
    print("Nhập mã thẻ cần xóa: ")
    var matm = readLine()
    var check = false
    for (tm in listThe) {
        if (tm.mapm.equals(matm)) {
            listThe.remove(tm)
            check = true
            break
        }
    }
    if (check == false)
        println("Không tồn tại thẻ $matm")
    getThongTin(listThe)
}