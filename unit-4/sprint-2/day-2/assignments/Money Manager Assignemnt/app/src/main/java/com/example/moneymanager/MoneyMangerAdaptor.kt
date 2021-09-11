package com.example.moneymanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add.view.*

class MoneyMangerAdaptor(
    val context: Context,
    val moneylist: MutableList<Money>,
    val listener: OnitemClickListener
) :
    RecyclerView.Adapter<MoneyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_row, parent, false)
        return MoneyHolder(view)

    }

    override fun onBindViewHolder(holder: MoneyHolder, position: Int) {

        val money = moneylist.get(position)
        holder.title.text = money.mTvDescription
        holder.desc.text = money.amount.toString()


        holder.tvAmount.setOnClickListener {
            listener.OnEdit(money)
        }

        holder.deleteTask.setOnClickListener {
            listener.onDelete(money)
        }
    }

    override fun getItemCount(): Int {
        return moneylist.size

    }
}

class MoneyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView
    var desc: TextView
    var tvAmount: TextView
    var deleteTask: TextView

    init {
        title = itemView.findViewById(R.id.tvAmount)
        desc = itemView.findViewById(R.id.tvDesc)
        tvAmount = itemView.findViewById(R.id.tvAmount)
        deleteTask = itemView.findViewById(R.id.deleteTask)


    }

}

//package com.masai.taskmanagerapp.adapter
//
//        import android.content.Context
//        import android.view.LayoutInflater
//        import android.view.View
//        import android.view.ViewGroup
//        import android.widget.EditText
//        import android.widget.ImageView
//        import android.widget.TextView
//        import androidx.recyclerview.widget.RecyclerView
//        import com.masai.taskmanagerapp.R
//        import com.masai.taskmanagerapp.`interface`.OnCLickListener
//        import com.masai.taskmanagerapp.models.Task
//
//class TasksAdapter(
//        val context: Context,
//        val tasksList: MutableList<Task>,
//        val listener: OnCLickListener
//) : RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val inflater = LayoutInflater.from(context)
//        val view1: View = inflater.inflate(R.layout.task_item_row, parent, false)
//        return TaskViewHolder(view1)
//
//        }
//
//        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        val task = tasksList.get(position)
//        holder.title.text = task.tittle
//        holder.desc.text = task.desc
//
//        holder.edittv.setOnClickListener {
//        listener.onEditClicked(task)
//        }
//
//        holder.deletetv.setOnClickListener {
//        listener.OnDeleteClicked(task)
//        }
//        }
//
//        override fun getItemCount(): Int {
//        return tasksList.size
//        }
//
//
//class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var title: TextView
//        var desc: TextView
//        var edittv: TextView
//        var deletetv: TextView
//
//        init {
//        title = itemView.findViewById(R.id.tvTaskTitle)
//        desc = itemView.findViewById(R.id.tvDesc)
//        edittv = itemView.findViewById(R.id.editTv)
//        deletetv = itemView.findViewById(R.id.deleteTv)
//
//
//        }
//        }
//        }