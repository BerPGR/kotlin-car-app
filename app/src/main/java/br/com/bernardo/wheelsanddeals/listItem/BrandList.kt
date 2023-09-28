package br.com.bernardo.wheelsanddeals.listItem

import br.com.bernardo.wheelsanddeals.R
import br.com.bernardo.wheelsanddeals.model.Brand
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BrandList {

    private val _brandList = MutableStateFlow<MutableList<Brand>>(mutableListOf())
    private val brandListFlow: StateFlow<MutableList<Brand>> = _brandList

    fun getBrands(): Flow<MutableList<Brand>> {
        val brandList: MutableList<Brand> = mutableListOf(
            Brand(imgBrand = R.drawable.audi, name = "Audi"),
            Brand(imgBrand = R.drawable.dodge, name = "Dodge"),
            Brand(imgBrand = R.drawable.jaguar, name = "Jaguar"),
            Brand(imgBrand = R.drawable.bmw, name = "BMW"),
        )
        _brandList.value = brandList
        return brandListFlow
    }
}