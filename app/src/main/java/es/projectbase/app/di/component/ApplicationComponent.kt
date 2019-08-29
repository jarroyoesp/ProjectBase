package es.projectbase.app.di.component


import dagger.Component
import es.projectbase.app.di.module.ApplicationModule
import es.projectbase.app.di.viewModel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class,
        ViewModelModule::class]
)
interface ApplicationComponent {
    /**
     * UI - ACTIVITY
     */
    //fun plus(module: MainActivityModule): MainActivityComponent
}