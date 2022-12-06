# 안드로이드 쇼핑몰 앱 : shoppi-android
#### 클론 코딩을 통한 안드로이드 아키텍쳐 패턴의 이해

## Description
* shoppi-android 앱의 주기능 : 쇼핑몰 어플리케이션

## Environment
OS : window 10   
Ram : 8GB   
**Language** : Kotlin 1.6.10   
IDE : Android Studio   
**Database** : Firebase, Room  
**Implementation** :   
Room, Glide, Gson, Retrofit, Firebase, ViewPager, ViewModel, Navigation(androidx)...   
**targetSdk** : 32 
minSdk : 23

## Layout


* **Splash Activity**
<p align="center">
  <img src="https://user-images.githubusercontent.com/91457591/205796580-da5bbb88-d455-4b38-a4f1-2006e782d92b.png" alt="splash image"/>
 </p>
   sdk 30 이하에서도 동일하게 동작할 수 있도록 splashActivity를 생성해두었습니다.<br>
 (31 이상에서는 manifest,theme 의 수정으로 반영)<br>
 <br><br><br><br>
 
 
 * **Home**
<p align="center">
   <img src="https://user-images.githubusercontent.com/91457591/205797311-c7125852-2f28-4c78-8c00-768b302d7b18.png"/>
   <img src="https://user-images.githubusercontent.com/91457591/205797316-63584cfd-b879-40de-a486-477fabda4db5.png" alt="splash image"/>
</p>
BottomNavigationView를 사용하여 생성한 네비게이션바의 Home 페이지입니다.<br>
Home layout은 NestedScrollView과 AppBarLayout을 함께 사용하여 스크롤 방향에 따라 상단의 Appbar가 접히도록 하였습니다.<br>
AppBar 하위에는 ViewPager2를 이용해 좌, 우로 배너를 넘겨 볼 수 있는 home banner를 만들어 기획전 상품 등을 배치했습니다.<br>
banner 하위에는 RecyclerView에 layoutManager를 LinearKayoutManager로 할당하여 상 하위로 스크롤 되도록 promotion 상품들을 배치했습니다.
<br><br><br><br>
 
 
* **Categories**
 <p align="center">
   <img src="https://user-images.githubusercontent.com/91457591/205797319-6807b7cf-bc56-4b47-8c67-80a2d5bc9412.png" alt="splash image"/>
   <img src="https://user-images.githubusercontent.com/91457591/205797321-3caecb91-9118-438a-bbf3-7fdd1d4dbaf5.png" alt="splash image"/>
</p>
Category 페이지에서는 RecyclerView에 GridLayoutManager를 할당하여, 이미지 형태의 카테고리를 구성했습니다
카테고리 이미지를 클릭할 시, bundle에 보관해둔 카테고리 id를 꺼내 해당 카테고리 상세 페이지로 이동한다. 
<br><br><br><br>
 

* **Product Detail**
<p align="center">
   <img src="https://user-images.githubusercontent.com/91457591/205798227-8a9b01ae-baab-4307-8ebd-021e0e027136.png"/>
   <img src="https://user-images.githubusercontent.com/91457591/205798237-82f80681-ff9d-46f8-99d1-edb292bf320f.png"/><br>  
   <img src="https://user-images.githubusercontent.com/91457591/205798240-f094a9e2-bbc5-44af-97d5-58e0d36f5846.png" alt="splash image"/>
   <img src="https://user-images.githubusercontent.com/91457591/205798243-6c3a8d03-55b7-48f0-b799-4f0030190999.png" alt="splash image"/>
</p>
Category 상세 페이지에서 상품을 클릭할 경우/Home Banner&Promotion 의 상품을 클릭할 경우 해당 상품의 상세페이지로 이동합니다.
layout은 Home Page와 동일하게 NestedScrollView과 AppBarLayout을 함께 사용하여 스크롤 방향에 따라 상단의 Appbar가 접히도록 하였습니다.<br>
추가로 NestedScrollView 바깥에 View를 위치시켜 어떤 위치에 있더라도 최하단에 고정된 뷰를 만들었습니다.
ProductDetail에서 최하단의 장바구니 담기를 클릭 시, Room DB에 상품 정보를 저장합니다.
<br><br><br><br>


* **Cart**
<p align="center">
  <img src="https://user-images.githubusercontent.com/91457591/205798247-6e8a5454-fb8c-4926-b475-59b1782fbcb2.png" alt="splash image"/>
</p>
Room local Db에 상품 정보가 존재할 시, 이를 브랜드별로 header를 두고 배치했습니다.

## Files
* 디렉토리 구조
```
📦app
 ┣ 📂common
 ┃ ┗ 📜Constants.kt         
 ┣ 📂database
 ┃ ┣ 📜AppDataBase.kt          //Room Database
 ┃ ┗ 📜CartItemDao.kt
 ┣ 📂model
 ┃ ┣ 📜Banner.kt
 ┃ ┣ 📜CartProduct.kt
 ┃ ┣ 📜category.kt
 ┃ ┣ 📜CategoryDetail.kt
 ┃ ┣ 📜HomeData.kt
 ┃ ┣ 📜Product.kt
 ┃ ┗ 📜Title.kt
 ┣ 📂network
 ┃ ┗ 📜ApiClient.kt            //Retrofit - Firebase
 ┣ 📂repository
 ┃ ┣ 📂cart
 ┃ ┃ ┣ 📜CartItemDataSource.kt
 ┃ ┃ ┣ 📜CartItemLocalDataSource.kt
 ┃ ┃ ┗ 📜CartRepository.kt
 ┃ ┣ 📂category
 ┃ ┃ ┣ 📜CategoryDataSource.kt
 ┃ ┃ ┣ 📜CategoryRemoteDataSource.kt
 ┃ ┃ ┗ 📜CategoryRepository.kt
 ┃ ┣ 📂categorydetail
 ┃ ┃ ┣ 📜CategoryDetailDataSource.kt
 ┃ ┃ ┣ 📜CategoryDetailRemoteDataSource.kt
 ┃ ┃ ┗ 📜CategoryDetailRepository.kt
 ┃ ┣ 📂home
 ┃ ┃ ┣ 📜HomeAssetDataSource.kt
 ┃ ┃ ┣ 📜HomeDataSource.kt
 ┃ ┃ ┗ 📜HomeRepository.kt
 ┃ ┗ 📂productsDetail
 ┃ ┃ ┣ 📜ProductDetailDataSource.kt
 ┃ ┃ ┣ 📜ProductDetailRemoteDataSource.kt
 ┃ ┃ ┗ 📜ProductDetailRepository.kt
 ┣ 📂ui
 ┃ ┣ 📂cart
 ┃ ┃ ┣ 📜CartAdapter.kt
 ┃ ┃ ┣ 📜CartFragment.kt
 ┃ ┃ ┗ 📜CartViewModel.kt
 ┃ ┣ 📂category
 ┃ ┃ ┣ 📜CategoryAdapter.kt
 ┃ ┃ ┣ 📜CategoryFragment.kt
 ┃ ┃ ┗ 📜CategoryViewModel.kt
 ┃ ┣ 📂categorydetail
 ┃ ┃ ┣ 📜CategoryDetailFragment.kt
 ┃ ┃ ┣ 📜CategoryDetailViewModel.kt
 ┃ ┃ ┣ 📜CategoryTopSellingItemAdapter.kt
 ┃ ┃ ┗ 📜CategoryTopSellingSectionAdapter.kt
 ┃ ┣ 📂common
 ┃ ┃ ┣ 📜BindingConversions.kt
 ┃ ┃ ┣ 📜CategoryDiffCallBack.kt
 ┃ ┃ ┣ 📜Event.kt
 ┃ ┃ ┣ 📜ImageBindingAdapters.kt
 ┃ ┃ ┣ 📜ProductClickListent.kt
 ┃ ┃ ┣ 📜ProductPromotionAdapter.kt
 ┃ ┃ ┣ 📜TextBindingAdapters.kt
 ┃ ┃ ┣ 📜TitleSectionTitleAdapter.kt
 ┃ ┃ ┣ 📜ViewBindingAdapters.kt
 ┃ ┃ ┗ 📜ViewModelFactory.kt                // ViewModelProvider.Factory 상속, 커스텀 Factory 생성
 ┃ ┣ 📂home
 ┃ ┃ ┣ 📜HomeBannerAdapter.kt
 ┃ ┃ ┣ 📜HomeFragment.kt
 ┃ ┃ ┗ 📜HomeViewModel.kt
 ┃ ┣ 📂productsDetail
 ┃ ┃ ┣ 📜ProductDetailDescriptionAdapter.kt
 ┃ ┃ ┣ 📜ProductDetailViewModel.kt
 ┃ ┃ ┗ 📜ProductsDetailFragment.kt
 ┃ ┣ 📜MainActivity.kt
 ┃ ┗ 📜SplashActivity.kt
 ┣ 📜AssetLoader.kt               
 ┣ 📜GlideModule.kt            
 ┗ 📜ServiceLocator.kt
```


## License Info
https://www.udemy.com/course/learn-android-development-with-kotlin/<br>
해당 프로젝트는 위의 강의에서 클론 코딩 학습을 진행한 프로젝트입니다.

강의를 통해    
Activity 와 Fragment의 활용법,    
Fragment - Viewmodel - Adatper의 연결과 역할   
Repository api 들의 종류와 활용법 등을 배울 수 있었습니다.
