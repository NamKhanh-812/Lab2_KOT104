package com.example.lab2_ph43678.baiTapOOP

class CBGVnew: PersonModel {
    var msgv: String
    var luongCung: Float
    var luongThuong:Float?
    var luongPhat:Float?
    var luongThucLinh: Float

    constructor(
        hoten: String,
        tuoi: Int?,
        quequan: String?,
        msgv: String,
        luongCung: Float,
        luongThuong: Float?,
        luongPhat: Float?
    ) : super(hoten, tuoi, quequan) {
        this.msgv = msgv
        this.luongCung = luongCung
        this.luongThuong = luongThuong
        this.luongPhat = luongPhat
        this.luongThucLinh = luongCung+ (luongThuong?:0f) - (luongPhat?:0f)
    }
    override fun getTT(): String{
        return "CBGV: " + super.getTT() +", MSGV: $msgv, "+"Lương thực lĩnh: $luongThucLinh"
    }

}