package cl.individual.martes010823.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.individual.martes010823.databinding.FragmentDetalleBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "param2"


class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val viewModel : TerrenoVM by activityViewModels()

    // TODO: Rename and change types of parameters
    private var terrenoId: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            terrenoId = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        getSelectedItemDetails()
        return binding.root
    }

    private fun getSelectedItemDetails() {
        viewModel.getSelectedTerreno(terrenoId.toString()).observe(viewLifecycleOwner) {
            binding.txtId.text = "Id: ${it.id}"
            binding.txtPrice.text = "$ ${it.price}"
            binding.txtType.text = "Tipo: ${it.type}"
            binding.imgDetail.load(it.imgSrc)
        }
    }

}