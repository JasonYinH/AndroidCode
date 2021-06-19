package com.base.myapplication

import java.io.Serializable

class User(userName: String, userId: Int) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }
}