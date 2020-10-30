package co.zsmb.rainbowcake.ninetysixpoems.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import co.zsmb.rainbowcake.ninetysixpoems.ui.detail.DetailViewModel
import co.zsmb.rainbowcake.ninetysixpoems.ui.linelist.LineListViewModel
import co.zsmb.rainbowcake.ninetysixpoems.ui.list.ListViewModel
import co.zsmb.rainbowcake.ninetysixpoems.ui.saved.SavedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedViewModel::class)
    abstract fun bindSavedViewModel(savedViewModel: SavedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LineListViewModel::class)
    abstract fun bindLineListViewModel(lineListViewModel: LineListViewModel): ViewModel

}
