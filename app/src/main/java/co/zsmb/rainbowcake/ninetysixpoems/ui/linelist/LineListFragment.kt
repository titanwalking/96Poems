package co.zsmb.rainbowcake.ninetysixpoems.ui.linelist

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import co.zsmb.rainbowcake.ninetysixpoems.R
import co.zsmb.rainbowcake.ninetysixpoems.ui.saved.SavedFragment
import kotlinx.android.synthetic.main.fragment_linelist.*

class LineListFragment : RainbowCakeFragment<LineListViewState, LineListViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_linelist

    private lateinit var linesAdapter: LinesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linesAdapter = LinesAdapter()
        linesList.adapter = linesAdapter
        linesList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        toolbar.inflateMenu(R.menu.menu_list)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_view_saved -> {
                    navigator?.add(SavedFragment())
                }
            }
            true
        }
    }

    override fun render(viewState: LineListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                loadingIndicator.isVisible = true
                linesList.isVisible = false
                errorGroup.isVisible = false
            }
            is LineListReady -> {
                linesAdapter.submitList(viewState.news)
                loadingIndicator.isVisible = false
                linesList.isVisible = true
                errorGroup.isVisible = false
            }
            NetworkError -> {
                linesAdapter.submitList(null)
                loadingIndicator.isVisible = false
                linesList.isVisible = false
                errorGroup.isVisible = true
            }
        }.exhaustive
    }

}
