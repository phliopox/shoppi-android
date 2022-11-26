package com.example.app.ui.productsDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.app.common.KEY_PRODUCT_ID
import com.example.app.databinding.FragmentProductDetailBinding
import com.example.app.ui.common.ViewModelFactory

class ProductsDetailFragment : Fragment() {
    private lateinit var binding : FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        val productId = requireArguments().getString(KEY_PRODUCT_ID)
        Log.d("ProductDetailFragment", "productId=$productId")
        val viewModel : ProductDetailViewModel by viewModels{ViewModelFactory(requireContext(), productId)}

        val productDetailAdapter = ProductDetailAdapter()
        binding.rvProductDetail.adapter = productDetailAdapter
        //TODO 현재 adapter 1개, id 일치 검사 x
        //home banner에서 넘겨받은 ㅇ

        viewModel.products.observe(viewLifecycleOwner){
                    products -> binding.product = products
        }
    }

  /*  viewModel.products.observe(viewLifecycleOwner){ products->
            productDetailAdapter.submitList(products)
        }
    }*/

}