package es.projectbase.app.di.viewModel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import dagger.Module
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    //@Binds
    //@IntoMap
    //@ViewModelKey(AlarmViewModel::class)
    //abstract fun bindAlarmViewModel(viewModel: AlarmViewModel): ViewModel
}