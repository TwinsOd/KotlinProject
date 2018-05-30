package clabr.twins.od.clabysh.ui.mainPage

import android.support.v7.widget.RecyclerView
import android.util.Log

import android.view.View
import clabr.twins.od.clabysh.R

class ItemClickSupport private constructor(private val recyclerView: RecyclerView) {
    companion object {
        fun addTo(view: RecyclerView) =
                view.getTag(R.id.item_click_support) as? ItemClickSupport ?: ItemClickSupport(view)

        fun removeFrom(view: RecyclerView): ItemClickSupport? {
            val support = view.getTag(R.id.item_click_support) as? ItemClickSupport
            support?.detach(view)
            return support
        }
    }

    interface ItemClickListener {
        fun onClick(recyclerView: RecyclerView, position: Int, view: View)
    }

    interface ItemLongClickListener {
        fun onLongClick(recyclerView: RecyclerView, position: Int, view: View): Boolean
    }

    private var itemClickListener: ItemClickListener? = null
    private var itemLongClickListener: ItemLongClickListener? = null
    private val onClickListener = View.OnClickListener {
        val holder = recyclerView.getChildViewHolder(it)
        itemClickListener?.onClick(recyclerView, holder.adapterPosition, it)
    }
    private val onLongClickListener = View.OnLongClickListener listener@{
        val position = recyclerView.getChildViewHolder(it).adapterPosition
        return@listener itemLongClickListener?.onLongClick(recyclerView, position, it) ?: false
    }
    private val attachListener = object : RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewAttachedToWindow(view: View) {
            if (itemClickListener != null) {
                view.setOnClickListener(onClickListener)
            }

            if (itemLongClickListener != null) {
                view.setOnLongClickListener(onLongClickListener)
            }
        }

        override fun onChildViewDetachedFromWindow(view: View) = Unit
    }

    init {
        recyclerView.setTag(R.id.item_click_support, this)
        recyclerView.addOnChildAttachStateChangeListener(attachListener)
    }

    fun setOnItemClickListener(listener: ItemClickListener): ItemClickSupport {
        itemClickListener = listener
        return this
    }

    fun setOnItemClickListener(listener: (RecyclerView) -> Unit) =
            setOnItemClickListener(object : ItemClickListener {
                override fun onClick(recyclerView: RecyclerView, position: Int, view: View) {
                    Log.e("ItemClickSupport", "onClick:position " + position)
                    listener(recyclerView)
                }
            })

    fun setOnItemLongClickListener(listener: ItemLongClickListener): ItemClickSupport {
        itemLongClickListener = listener
        return this
    }

    fun setOnItemLongClickListener(block: (RecyclerView) -> Boolean): ItemClickSupport =
            setOnItemLongClickListener(object : ItemLongClickListener {
                override fun onLongClick(recyclerView: RecyclerView, position: Int, view: View): Boolean {
                    Log.e("ItemClickSupport", "onLongClick:position " + position)
                    return block(recyclerView)
                }
            })

    private fun detach(view: RecyclerView) {
        view.removeOnChildAttachStateChangeListener(attachListener)
        view.setTag(R.id.item_click_support, null)
    }
}