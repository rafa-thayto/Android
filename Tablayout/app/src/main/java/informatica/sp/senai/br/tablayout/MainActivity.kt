package informatica.sp.senai.br.tablayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var slidingTabLayout: SlidingTabLayout = findViewById<SlidingTabLayout>()
    }
}
