package com.example.lab2_ph43678.baiTapOOP

open class PersonModel {
    var hoten: String
    var tuoi: Int?
    var quequan: String?

    constructor(hoten: String, tuoi: Int?, quequan: String?) {
        this.hoten = hoten
        this.tuoi = tuoi
        this.quequan = quequan
    }

    open fun getTT(): String {
        return "$hoten - $tuoi - $quequan"
    }
}