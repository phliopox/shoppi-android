package com.example.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.app.*
import com.example.app.common.KEY_PRODUCT_ID
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.ui.common.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(),ProductClickListener {

    //뷰모델 생성시 뷰모델 팩토리 create 메소드에서 의존관계로인해 바로 db 1 회 호출
    private val viewModel : HomeViewModel by viewModels{ ViewModelFactory(requireContext()) }
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
       // return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        setNavigation()
        setTopBanners()
        setPromotions()
    }


    //외부 db 연동 x, 제이슨 파일에서 가져오는 데이터.
    //viewModel 을 사용해서 데이터를 로드 -> 뷰모델의 생명주기는 길고 state하기 때문에 데이터의 변경이 있는지의 여부를 관찰 가능하다.
    //observe 메소드를 통해서, 데이터 변경시 로직을 구현가능
    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title
        }
    }
    private fun setNavigation(){
        viewModel.openProductEvent.observe(viewLifecycleOwner,EventObserver{ productId->
            findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(KEY_PRODUCT_ID to productId))
        })
    }
    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter(viewModel).apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }

            val screenWidth = resources.displayMetrics.widthPixels
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            //페이지당 크기 312dp , 페이지당 간격 16dp -> 픽셀로 단위 변경
            val offset = screenWidth - pageWidth - pageMargin
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            offscreenPageLimit = 3
            TabLayoutMediator(
                binding.viewpagerHomeBannerIndicator,
                this
            ) { tab, position -> }.attach()
        }
    }

    private fun setPromotions() {

        val titleSectionTitleAdapter = TitleSectionTitleAdapter()
        val productPromotionAdapter = ProductPromotionAdapter(this)

        binding.homeCategoryPromotions.adapter =
            ConcatAdapter(titleSectionTitleAdapter, productPromotionAdapter)
        viewModel.promotion.observe(viewLifecycleOwner) { promotion ->
            titleSectionTitleAdapter.submitList(listOf(promotion.title))
            productPromotionAdapter.submitList(promotion.items)
        }
    }

    //ProductClickListener.kt
    override fun onProductClick(productId: String) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(KEY_PRODUCT_ID to "desk-1"))
    }

    /* inner class NavigateByProductId{
         fun navigateByProductId(productId : String){
             // productId 에 맞는 detail 데이터가 부족. -> desk-1으로 하드코딩
             findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(KEY_PRODUCT_ID to "desk-1"))
         }
     }*/

}