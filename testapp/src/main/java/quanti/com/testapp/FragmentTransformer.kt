package quanti.com.testapp

import android.support.v4.view.ViewPager
import android.view.View


class FragmentTransformer : ViewPager.PageTransformer {


    //https://medium.com/@BashaChris/the-android-viewpager-has-become-a-fairly-popular-component-among-android-apps-its-simple-6bca403b16d4

    override fun transformPage(view: View, position: Float) {

        val pageWidth = view.width.toFloat()

        if (position < -1 || position > 1){
            view.alpha = 0F
            return
        }

        view.alpha = 1F
        view.findViewById<View>(R.id.image).translationX = position * (pageWidth * 0.05F)
        view.findViewById<View>(R.id.title).translationX = position * (pageWidth * 0.4F)
        view.findViewById<View>(R.id.subtitle).translationX = position * (pageWidth * 0.8F)
        view.findViewById<View>(R.id.got_it_button).translationX = position * (pageWidth * 0.05F)


        view.findViewById<View>(R.id.state).translationX = -position * (pageWidth)
        view.findViewById<View>(R.id.state_title).translationX = -position * (pageWidth)

        view.findViewById<View>(R.id.state).alpha = 1 - position.toAbs()* 6
        view.findViewById<View>(R.id.state_title).alpha = 1 - position.toAbs() * 6

    }

}

fun Float.toAbs() = Math.abs(this)

