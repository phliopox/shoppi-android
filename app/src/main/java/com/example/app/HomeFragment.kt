package com.example.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import org.json.JSONObject

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        toolbarIcon.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_product_detail)

        /*직접 이동 코드를 입력하는 것에서 네비게이션 이용으로 변경
            val transaction = parentFragmentManager.beginTransaction()
            transaction.add(R.id.container_main,ProductsDbtn_enter_product_detailetailFragment())
            transaction.commit()*/
        }
        val assetLoader = AssetLoader()
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
        if(!homeData.isNullOrEmpty()) {
            val jsonObject = JSONObject(homeData)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            //val titleValue = Title(text, iconUrl)

            view.findViewById<TextView>(R.id.toolbar_home_title).text=text
            GlideApp.with(this)
                .load(iconUrl)
                .into(toolbarIcon)



            val topBanners = jsonObject.getJSONArray("top_banners")
            val firstBanner = topBanners.getJSONObject(0)
            val label = firstBanner.getString("label")
            val productDetail = firstBanner.getJSONObject("product_detail")
            val price = productDetail.getInt("price")
            val bannerUrl = firstBanner.getString("background_image_url")

            val banner01 = view.findViewById<ImageView>(R.id.banner)
            Glide.with(this)
                .load(bannerUrl.toUri())
                .into(banner01)

            Log.d("title","text=${text} , iconUrl=${iconUrl}")
            Log.d("firstBanner" ,"label=${label},price=${price}")
        }
    }
}