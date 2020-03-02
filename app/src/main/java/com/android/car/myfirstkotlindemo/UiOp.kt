package com.android.car.myfirstkotlindemo

import android.view.View

sealed class UiOp {
    object Show : UiOp()
    object Hide : UiOp()
    class TranslateX(val px: Float) : UiOp()
    class TranslateY(val px: Float) : UiOp()
}

fun execute(view: View, op: UiOp) = when (op) {
    UiOp.Show -> view.visibility = View.VISIBLE
    UiOp.Hide -> view.visibility = View.GONE

    is UiOp.TranslateX -> view.translationX = op.px
    is UiOp.TranslateY -> view.translationY = op.px
}