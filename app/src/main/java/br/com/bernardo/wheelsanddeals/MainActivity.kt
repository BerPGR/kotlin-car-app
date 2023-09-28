package br.com.bernardo.wheelsanddeals

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.bernardo.wheelsanddeals.adapter.BrandsAdapter
import br.com.bernardo.wheelsanddeals.databinding.ActivityMainLayoutBinding
import br.com.bernardo.wheelsanddeals.listItem.BrandList
import br.com.bernardo.wheelsanddeals.model.Brand
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainLayoutBinding
    private lateinit var brandAdapter: BrandsAdapter
    private val brands = BrandList()
    private val brandList: MutableList<Brand> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            brands.getBrands().collectIndexed { index, value ->
                for (b in value) {
                    brandList.add(b)
                }
            }
        }

        val recyclerViewBrands = binding.recyclerViewBrands
        recyclerViewBrands.layoutManager = LinearLayoutManager(this)
        recyclerViewBrands.setHasFixedSize(true)
        brandAdapter = BrandsAdapter(this, brandList)
        recyclerViewBrands.adapter = brandAdapter
    }
}