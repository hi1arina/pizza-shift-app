package com.example.pizzashiftapp.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzashiftapp.databinding.CatalogPageBinding
import com.example.pizzashiftapp.presentation.CatalogViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class CatalogFragment : Fragment(), KoinComponent {

    private lateinit var catalogAdapter: CatalogAdapter
    private val catalogViewModel: CatalogViewModel by viewModel()
    private var _binding: CatalogPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CatalogPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catalogAdapter = CatalogAdapter()
        binding.pizzaCatalog.adapter = catalogAdapter

        catalogViewModel.pizzas.observe(viewLifecycleOwner) { pizzas ->
            catalogAdapter.setCatalog(pizzas)
        }
        catalogViewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        catalogAdapter.setCatalog(emptyList())
    }
}