package br.com.bernardo.wheelsanddeals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.bernardo.wheelsanddeals.databinding.MainTypesLayoutBinding
import br.com.bernardo.wheelsanddeals.databinding.TopBrandLayoutBinding
import br.com.bernardo.wheelsanddeals.model.Type

class TypeAdapter(
    private val context: Context,
    private val types: MutableList<Type>
): RecyclerView.Adapter<TypeAdapter.TypeViewHolder>() {

    class TypeViewHolder(
        binding: MainTypesLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {
        val typeImage = binding.typePicture
        val typeName = binding.typeName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val listTypes = MainTypesLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return TypeViewHolder(listTypes)
    }

    override fun getItemCount(): Int = types.size

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.typeImage.setBackgroundResource(types[position].imgType)
        holder.typeName.text = types[position].typeName
    }
}