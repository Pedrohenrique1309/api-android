package com.example.myapplication.teste

import com.example.myapplication.model.Cliente
import com.example.myapplication.service.RetrofitFactory

fun main() {

    val c1 = Cliente(
        nome = "Pelé",
        email = "pele@santosfc.com.br"
    )

    val retrofit = RetrofitFactory().getClienteService()
    val cliente = retrofit.gravar(c1)

}