package es.projectbase.app.di.module

import dagger.Module
import dagger.Provides
import es.projectbase.app.navigator.Navigator
import es.projectbase.ui.App
import javax.inject.Singleton

@Module
class ApplicationModule(val app: App) {
    @Provides @Singleton
    fun provideApp(): App = app

    @Provides @Singleton
    fun provideNavigator(): Navigator = Navigator()
}