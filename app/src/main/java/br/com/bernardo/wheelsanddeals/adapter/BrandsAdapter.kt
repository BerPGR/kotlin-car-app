package br.com.bernardo.wheelsanddeals.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.bernardo.wheelsanddeals.databinding.TopBrandLayoutBinding
import br.com.bernardo.wheelsanddeals.model.Brand

class BrandsAdapter(
    private val context: Context,
    private val brands: MutableList<Brand>
): RecyclerView.Adapter<BrandsAdapter.BrandViewHolder>() {

    class BrandViewHolder(
        binding: TopBrandLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {
        val brandImg = binding.brandPicture
        val name = binding.brandName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val listBrands = TopBrandLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return BrandViewHolder(listBrands)
    }

    override fun getItemCount(): Int = brands.size

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.brandImg.setBackgroundResource(brands[position].imgBrand)
        holder.name.text = brands[position].name
    }
}