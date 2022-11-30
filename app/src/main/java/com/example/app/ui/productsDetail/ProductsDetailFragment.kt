package com.example.app.ui.productsDetail

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.app.common.KEY_PRODUCT_ID
import com.example.app.databinding.FragmentProductDetailBinding
import com.example.app.ui.common.EventObserver
import com.example.app.ui.common.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProductsDetailFragment : Fragment() {
    private lateinit var binding : FragmentProductDetailBinding
    val viewModel : ProductDetailViewModel by viewModels{ViewModelFactory(requireContext())}

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
        binding.viewModel = viewModel

        val productId = requireArguments().getString(KEY_PRODUCT_ID)
        productId?.let {viewModel.loadProductDetail(productId)}

        setLayout()
        setNavigation()
        setAddCart()
    }

    private fun setAddCart() {
        viewModel.addCartEvent.observe(viewLifecycleOwner,EventObserver{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("장바구니에 상품이 담겼습니다")
                .setPositiveButton("확인") { dialog, which ->

                }
                .show()
        })
    }

    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setLayout() {
        val descriptionAdapter = DescriptionAdapter()
        binding.rvProductDetail.adapter = descriptionAdapter
        viewModel.products.observe(viewLifecycleOwner) { product ->
            binding.product = product // product는 fragment에서 바로 binding
            descriptionAdapter.submitList(product.descriptions) //description imgae 는 adatper 로 submit!
        }
    }

    /*  viewModel.products.observe(viewLifecycleOwner){ products->
              productDetailAdapter.submitList(products)
          }
      }*/

}