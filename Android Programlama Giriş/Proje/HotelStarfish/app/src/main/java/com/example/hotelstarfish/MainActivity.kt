package com.example.hotelstarfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.starfishhotel.IntroSlide
import com.example.starfishhotel.IntroSliderAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Üstün Lezzet Kalitesi",
                "Otelimizde alanında üst düzey aşçılarla sizlere hizmet sunmaktayız..",
                R.drawable.dinner
            ),
            IntroSlide(
                "Uzak Doğu Mutfağı",
                "Uzak Doğu yemeklerine bayılan ziyaretçilerimiz için Uzak Doğu yemeklerimizi hizmetinize sunmaktayız..",
                R.drawable.ramen
            ),

            IntroSlide(
                "Online Rezervasyon Seçeneği",
                "Dilerseniz tek tıkla internetten ödeme şeçeneklerimizle odalarımız dolmadan rezervasyon yaptırabilirsiniz..",
                R.drawable.onlinepay
            ),
            IntroSlide(
                "Eğlenceli Vakitler",
                "Karaoke, canlı müzik ve daha fazla eğlence aktivitelerimizle hizmet vermekteyiz..",
                R.drawable.musician
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        introSliderViewpager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSliderViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        }
        )
        buttonNext.setOnClickListener {
            if (introSliderViewpager.currentItem + 1 < introSliderAdapter.itemCount) {
                introSliderViewpager.currentItem += 1
            } else {
                Intent(applicationContext, GridView::class.java).also {
                    startActivity(it)
                }

            }
        }
        textSkipIntro.setOnClickListener {
            Intent(applicationContext, GridView::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams=layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer[i] as ImageView
            if (i==index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}
