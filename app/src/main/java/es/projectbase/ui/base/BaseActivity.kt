package es.projectbase.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import es.projectbase.app.di.component.ApplicationComponent
import es.projectbase.app.navigator.Navigator
import es.projectbase.ui.App
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    abstract var layoutId: Int

    abstract fun setupInjection(applicationComponent: ApplicationComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection(App.graph)
        initView()
    }

    override fun onResume() {
        super.onResume()
        navigator.currentActivity = this
    }

    private fun initView() {
        setContentView(layoutInflater.inflate(layoutId, null))
        ButterKnife.bind(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun cleanFragmentBackStack(){
        val fm = supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }

    override fun onPause() {
        super.onPause()
        navigator.currentActivity = null
    }
}