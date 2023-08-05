package cl.individual.martes010823.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.individual.martes010823.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel: TerrenoVM by activityViewModels()

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initListener()
        initRecycler()
        return binding.root
    }

    private fun initRecycler() {

        val terrenoAdapter = TerrenoAdapter()
        binding.recTerrenoList.adapter = terrenoAdapter
        viewModel.terrenosLiveData().observe(viewLifecycleOwner) {
            terrenoAdapter.setData(it)
        }
    }

    private fun initListener() {
        binding.btnLoad.setOnClickListener {
            viewModel.getAllInfo()
        }
    }


}