package com.example.todo.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.constraintlayout.core.motion.utils.Utils
import androidx.fragment.app.DialogFragment
import com.example.todo.R
import com.example.todo.databinding.FragmentAddTodoPopupBinding
import com.example.todo.utils.model.ToDoData
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.combine
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import kotlin.jvm.JvmStatic


class AddTodoPopupFragment : DialogFragment() {

    private lateinit var binding:FragmentAddTodoPopupBinding
    private lateinit var listener: DialogNextBtnClickListener
    private var toDoData:ToDoData?=null
    private var priority= "1"


    fun setListener(listener: DialogNextBtnClickListener){
        this.listener=listener
    }

    companion object {
        const val TAG = "AddTodoPopupFragment"


        @JvmStatic
        fun newInstance(taskId: String, task: String) = AddTodoPopupFragment().apply {
            arguments = Bundle().apply {
                putString("taskId", taskId)
                putString("task", task)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {




        // Inflate the layout for this fragment
        binding=FragmentAddTodoPopupBinding.inflate(inflater,container,false)
        return binding.root
    }

    private enum class Priority {
        LOW, MEDIUM, HIGH
    }

    private var taskPriority = Priority.LOW
    private fun setPriority() {
        binding.apply {
            greenOval.setOnClickListener {
                taskPriority = Priority.LOW
                Toast.makeText(binding.root.context, "Priority: Low", Toast.LENGTH_SHORT).show()
                updatePriorityIndicators(taskPriority)
            }
            yellowOval.setOnClickListener {
                taskPriority = Priority.MEDIUM
                Toast.makeText(binding.root.context, "Priority: Medium", Toast.LENGTH_SHORT).show()
                updatePriorityIndicators(taskPriority)
            }
            redOval.setOnClickListener {
                taskPriority = Priority.HIGH
                Toast.makeText(binding.root.context, "Priority: High", Toast.LENGTH_SHORT).show()
                updatePriorityIndicators(taskPriority)
            }
            // ... similar logic for yellowOval and redOval, updating taskPriority accordingly
        }
    }

    private fun updatePriorityIndicators(selectedPriority: Priority) {
        val greenResource = if (selectedPriority == Priority.LOW) R.drawable.baseline_done_all_24 else 0
        val yellowResource = if (selectedPriority == Priority.MEDIUM) R.drawable.baseline_done_all_24 else 0
        val redResource = if (selectedPriority == Priority.HIGH) R.drawable.baseline_done_all_24 else 0

        binding.greenOval.setImageResource(greenResource)
        binding.yellowOval.setImageResource(yellowResource)
        binding.redOval.setImageResource(redResource)
    }

    private fun setDate() {
        val myCalender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalender.apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, month)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLable(myCalender)
            }
        }
        binding.datePicker.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                datePicker,
                myCalender.get(Calendar.YEAR),
                myCalender.get(Calendar.MONTH),
                myCalender.get(
                    Calendar.DAY_OF_MONTH
                )
            ).show()
        }
    }
        private fun updateLable(myCalendar: Calendar){
            val myFormat="dd-MM-yyyy"
            val sdf=SimpleDateFormat(myFormat, Locale.UK)
            binding.tvDate.text=sdf.format(myCalendar.time)

        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!= null){
            toDoData=ToDoData(
                arguments?.getString("taskId").toString(),
                arguments?.getString("task").toString()
            )

            binding.todoEt.setText(toDoData?.task)
        }
            setDate()

            setPriority()
        registerEvents()
    }

    private fun registerEvents(){
        binding.todoNextBtn.setOnClickListener {
            val  todoTask=binding.todoEt.text.toString()
            if(todoTask.isNotEmpty()){
                if(toDoData==null){
                    listener.onSaveTask(todoTask, binding.todoEt)
                }else{
                    toDoData?.task =todoTask
                    listener.onUpdateTask(toDoData!!, binding.todoEt)
                }

            } else {
                Toast.makeText(context, "Please type some task", Toast.LENGTH_SHORT).show()
            }
        }
        binding.todoClose.setOnClickListener {
            dismiss( )
        }
    }
    interface DialogNextBtnClickListener{
        fun onSaveTask(todo:String, todoEt: TextInputEditText)
        fun onUpdateTask(toDoData: ToDoData, todoEt: TextInputEditText)
    }


}