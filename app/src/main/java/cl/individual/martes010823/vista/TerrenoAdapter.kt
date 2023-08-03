package cl.individual.martes010823.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.martes010823.data.remote.Terreno
import cl.individual.martes010823.databinding.ItemLayoutBinding
import coil.load

class TerrenoAdapter: RecyclerView.Adapter<TerrenoAdapter.MyViewHolder>() {
    private lateinit var binding: ItemLayoutBinding
    private val terrenoList = mutableListOf<Terreno>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val terreno = terrenoList[position]
        holder.bind(terreno)
    }

    override fun getItemCount(): Int = terrenoList.size

    fun setData(terreno: List<Terreno>) {
        this.terrenoList.clear()
        this.terrenoList.addAll(terreno)
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(terreno: Terreno) {
            binding.imgTerreno.load(terreno.imgSrc)

        }

    }
}


