package co.zsmb.rainbowcake.ninetysixpoems.ui.linelist

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import co.zsmb.rainbowcake.ninetysixpoems.domain.Line
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class LineListViewModel @Inject constructor() : RainbowCakeViewModel<LineListViewState>(Loading) {

    private var linesCollection = Firebase.firestore.collection("lines")

    init {
        execute {
            loadLines()
        }
    }

    private fun loadLines() {
        viewState = Loading
        linesCollection
            .get()
            .addOnSuccessListener { result ->
                val lines = ArrayList<Line>()
                for (document in result) {
                    lines.add(document.toObject<Line>())
                }
                viewState = LineListReady(lines)
            }
            .addOnFailureListener { exception ->
                viewState = NetworkError
            }
    }

    private fun addLine() {
        val line = hashMapOf(
            "line" to "Los Angeles"
        )

        linesCollection.document(UUID.randomUUID().toString()).set(line)
    }

}
