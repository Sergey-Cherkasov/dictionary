package pt.svcdev.dictionary.mvvm.view.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history_recyclerview_item.view.*
import pt.svcdev.dictionary.R
import pt.svcdev.dictionary.mvvm.model.data.DataModel

class HistoryRvAdapter : RecyclerView.Adapter<HistoryRvAdapter.ItemViewHolder>() {

    private var data: List<DataModel> = listOf()

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_history_recyclerview_item, parent, false) as View
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: DataModel) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.header_history_textview_recycler_item.text = data.text
                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context, "on click: ${data.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}