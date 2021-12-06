package com.example.imc.repository

import android.content.Context
import com.example.imc.model.Pesagem

class PesagemRepository(var context: Context){

    fun getListPesagem(): List<Pesagem>{
        val listaPesagem = listOf<Pesagem>()

        //**Preencher a lista de pesagem
        val dados =
                context
                .getSharedPreferences(
                        "usuario",
                        Context.MODE_PRIVATE)

        val pesosString = dados.getString("pesagem", "")
        //81;79;90;80;71

        val pesos = pesosString!!.split(";").toTypedArray()

        val dataString = dados.getString("data pesagem", "")
        //2021-11-29;2021-11-29;2021-11-29;2021-11-29;2021-11-29
        val datas = dataString!!.split(";").toTypedArray()


        //Criar lista de pesagem
        for(i in 0 until pesos.size){
            val pesagem = Pesagem(datas[i], pesos[i].toInt())
            listaPesagem.add(pesagem)

        }

        return listaPesagem
    }
}