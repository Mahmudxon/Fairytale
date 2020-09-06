package uz.mahmudxon.fairy.repository

import java.lang.Exception

sealed class FairytaleResponse<out T:Any> {
    data class Success<out T:Any>(val data:T): FairytaleResponse<T>()
    data class Error(val exception: Exception): FairytaleResponse<Nothing>()
}