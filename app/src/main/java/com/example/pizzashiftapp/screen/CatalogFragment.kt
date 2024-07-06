package com.example.pizzashiftapp.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzashiftapp.databinding.CatalogPageBinding
import com.example.pizzashiftapp.presentation.CatalogViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class CatalogFragment : Fragment(), KoinComponent {

    private lateinit var catalogAdapter: CatalogAdapter
    private val catalogViewModel: CatalogViewModel by viewModel()
    private lateinit var binding: CatalogPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CatalogPageBinding.inflate(layoutInflater)
        catalogAdapter = CatalogAdapter()

        binding.pizzaCatalog.layoutManager = LinearLayoutManager(requireContext())
        binding.pizzaCatalog.adapter = catalogAdapter

        catalogViewModel.pizzas.observe(viewLifecycleOwner) { pizzas ->
            Log.d("CatalogFragment", "Pizzas observed: $pizzas")
            catalogAdapter.setCatalog(pizzas)
        }

        catalogViewModel.load()

        return binding.root
    }
}