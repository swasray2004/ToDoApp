package com.example.todo.utils.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.EachTodoItemBinding
import com.example.todo.utils.model.ToDoData



class ToDoAdapter(private val list: MutableList<ToDoData>) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private var listener:ToDoAdapterClicksInterface? =null
    fun setListener(listener:ToDoAdapterClicksInterface){
        this.listener = listener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding=EachTodoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding)
    }
    inner class ToDoViewHolder(val binding:EachTodoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
       with(holder){
            with(list[position]){
                binding.todoTask.text=this.task

                binding.deleteTask.setOnClickListener{
                    listener?.onDeleteTaskBtnClicked(this)

                }


                binding.editTask.setOnClickListener{
                    listener?.onEditTaskBtnClicked(this)

                }
            }
        }
    }



    override fun getItemCount(): Int {
        return list.size
    }



    interface ToDoAdapterClicksInterface{
        fun onDeleteTaskBtnClicked(toDoData: ToDoData)
        fun onEditTaskBtnClicked(toDoData: ToDoData)
    }
}