package co.zsmb.rainbowcake.ninetysixpoems.domain

import com.google.firebase.firestore.IgnoreExtraProperties

//
// Created by alican.korkmaz on 30.10.2020.
//
@IgnoreExtraProperties
data class Line(
    var line: String? = ""
)