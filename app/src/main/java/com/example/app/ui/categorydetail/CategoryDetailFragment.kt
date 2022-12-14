package com.example.app.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.app.R
import com.example.app.common.KEY_CATEGORY_LABEL
import com.example.app.common.KEY_PRODUCT_ID
import com.example.app.databinding.FragmentCategoryDetailBinding
import com.example.app.ui.common.ProductClickListener
import com.example.app.ui.common.ProductPromotionAdapter
import com.example.app.ui.common.TitleSectionTitleAdapter
import com.example.app.ui.common.ViewModelFactory

class CategoryDetailFragment : Fragment(),ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel :CategoryDetailViewModel by viewModels{ ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()
        setNavigation()
    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }
    private fun setListAdapter() {
        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = TitleSectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)
        binding.rvCategoryDetail.adapter = ConcatAdapter(topSellingSectionAdapter,titleAdapter, promotionAdapter)
        viewModel.topSelling.observe(viewLifecycleOwner){topSelling->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }

        viewModel.promotion.observe(viewLifecycleOwner){ promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }

    }
    private fun setNavigation(){
        binding.toolbarCategoryDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onProductClick(productId: String) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(KEY_PRODUCT_ID to "desk-1"))
    }
}
