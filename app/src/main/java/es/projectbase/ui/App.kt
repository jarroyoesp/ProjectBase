package es.projectbase.ui

import androidx.multidex.MultiDexApplication
import es.projectbase.app.di.component.ApplicationComponent
import es.projectbase.app.di.component.DaggerApplicationComponent
import es.projectbase.app.di.module.ApplicationModule


open class App :  MultiDexApplication() {
    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return graph
    }
}