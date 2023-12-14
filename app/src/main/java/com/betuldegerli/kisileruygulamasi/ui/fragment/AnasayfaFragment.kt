package com.betuldegerli.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.betuldegerli.kisileruygulamasi.R
import com.betuldegerli.kisileruygulamasi.data.entity.Kisiler
import com.betuldegerli.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.betuldegerli.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment() {
 private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        //RECYCLERVİEWE GÖRÜNTÜ ÇAĞIRMA YAPIYOZ

        //Alt satırdaki gibi ayarlama yaparsam kişiler epsonun uygulaması gibi kutu kutu görünüyo
        //binding.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rv.layoutManager=LinearLayoutManager(requireContext())
        var kisilerList= ArrayList<Kisiler>()
        var k1=Kisiler(0, "Betül","111")
        var k2=Kisiler(1, "Ali","222")
        var k3=Kisiler(2, "Veli","333")
        kisilerList.add(k1)
        kisilerList.add(k2)
        kisilerList.add(k3)
        val kisilerAdapter=KisilerAdapter(requireContext(), kisilerList)
        binding.rv.adapter=kisilerAdapter






        //FAB BUTON YANİ KİŞİ EKLEME BUTONU; SAĞ ALTTAKİ
        binding.fab.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }


        //ARA BUTONU
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })


        return binding.root
    }


    //ARA BUTONU İÇİN GELİŞTİRİDĞİMİZ GEÇİCİ FONKSİYON: SONRA SİLCEM
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }

}