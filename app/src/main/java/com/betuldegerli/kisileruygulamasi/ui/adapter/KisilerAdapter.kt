package com.betuldegerli.kisileruygulamasi.ui.adapter

import android.app.ProgressDialog.show
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.betuldegerli.kisileruygulamasi.data.entity.Kisiler
import com.betuldegerli.kisileruygulamasi.databinding.CardTasarimBinding
import com.betuldegerli.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext: Context, var kisilerList: List<Kisiler>)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return kisilerList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
val kisi=kisilerList.get(position)
        val t=holder.tasarim
        t.textViewKisiAd.text=kisi.kisi_ad
        t.textViewKisiTel.text=kisi.kisi_tel


        //KART SATIRLARINA TIKLAYINCA KİŞİ BİLGİLERİNİ GETİRME VE SAYFA GEÇİŞİ
        t.cardViewSatir.setOnClickListener {
            val gecis=AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)

        }

        //ÇARPI İŞARETİNİ BASINCA KİŞİ SİLİNMESİ
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinmesini istiyor musunuz?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                sil(kisi.kisi_id)
                }
                .show()
        }
    }
    fun sil(kisiId:Int){
        Log.e("Kisi sil", kisiId.toString())
    }





}