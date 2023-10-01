package br.com.bernardo.wheelsanddeals

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.bernardo.wheelsanddeals.adapter.BrandsAdapter
import br.com.bernardo.wheelsanddeals.adapter.TypeAdapter
import br.com.bernardo.wheelsanddeals.databinding.ActivityMainLayoutBinding
import br.com.bernardo.wheelsanddeals.listItem.BrandList
import br.com.bernardo.wheelsanddeals.listItem.TypeList
import br.com.bernardo.wheelsanddeals.model.Brand
import br.com.bernardo.wheelsanddeals.model.Type
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainLayoutBinding
    private lateinit var brandAdapter: BrandsAdapter
    private lateinit var typeAdapter: TypeAdapter
    private val brands = BrandList()
    private val types = TypeList()
    private val brandList: MutableList<Brand> = mutableListOf()
    private val typeList: MutableList<Type> = mutableListOf()
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

        CoroutineScope(Dispatchers.IO).launch {
            types.getTypes().collectIndexed { index, value ->
                for (t in value) {
                    typeList.add(t)
                }
            }
        }

        configBrandRecyclerView()
        configTypesRecyclerView()
    }

    private fun configBrandRecyclerView() {
        val recyclerViewBrands = binding.recyclerViewBrands
        recyclerViewBrands.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewBrands.setHasFixedSize(false)
        brandAdapter = BrandsAdapter(this, brandList)
        recyclerViewBrands.adapter = brandAdapter
    }

    private fun configTypesRecyclerView() {
        val recyclerViewTypes = binding.recyclerViewTypes
        recyclerViewTypes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        typeAdapter = TypeAdapter(this, typeList)
        recyclerViewTypes.adapter = typeAdapter
    }
}