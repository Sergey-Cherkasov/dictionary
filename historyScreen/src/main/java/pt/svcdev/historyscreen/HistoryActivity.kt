package pt.svcdev.historyscreen

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import org.koin.android.viewmodel.ext.android.viewModel
import pt.svcdev.core.BaseActivity
import pt.svcdev.historyscreen.di.injectDependencies
import pt.svcdev.model.AppState

class HistoryActivity : BaseActivity<AppState, HistoryInteractor>() {

    override lateinit var viewModel: HistoryViewModel
    private val adapter: HistoryRvAdapter by lazy { HistoryRvAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        initViewModel()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData("", false)
    }

    override fun setDataToAdapter(data: List<pt.svcdev.model.DataModel>) {
        adapter.setData(data)
    }

    private fun initViewModel() {
        if (history_activity_recyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        injectDependencies()
        val model: HistoryViewModel by viewModel()
        viewModel = model
        viewModel.subscribe().observe(this@HistoryActivity, { renderData(it) })
    }

    private fun initViews() {
        history_activity_recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        history_activity_recyclerview.adapter = adapter
    }
}