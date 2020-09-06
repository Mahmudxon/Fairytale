package uz.mahmudxon.fairy.list

import uz.mahmudxon.fairy.model.Fairytale

interface IAdapterCallBack {
    fun onItemClick(data : Fairytale)
}