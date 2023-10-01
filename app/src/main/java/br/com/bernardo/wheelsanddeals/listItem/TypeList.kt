package br.com.bernardo.wheelsanddeals.listItem

import br.com.bernardo.wheelsanddeals.R
import br.com.bernardo.wheelsanddeals.model.Type
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TypeList {

    private val _typeList = MutableStateFlow<MutableList<Type>>(mutableListOf())
    private val typeListFlow: StateFlow<MutableList<Type>> = _typeList

    fun getTypes(): Flow<MutableList<Type>> {
        val typeList: MutableList<Type> = mutableListOf(
            Type(imgType = R.drawable.hatchback, typeName = "Hatchback"),
            Type(imgType = R.drawable.sedan, typeName = "Sedan"),
            Type(imgType = R.drawable.suv, typeName = "SUV"),
            Type(imgType = R.drawable.sports, typeName = "Sports"),
            Type(imgType = R.drawable.muscle, typeName = "Muscle"),
            Type(imgType = R.drawable.coupe, typeName = "Coupe"),
        )
        _typeList.value = typeList
        return typeListFlow
    }
}