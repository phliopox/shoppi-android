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

## Result


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
