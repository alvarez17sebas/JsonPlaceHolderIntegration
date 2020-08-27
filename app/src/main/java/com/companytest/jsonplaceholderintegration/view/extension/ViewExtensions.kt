package com.companytest.jsonplaceholderintegration.view.extension

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.companytest.jsonplaceholderintegration.R

@BindingAdapter("visible")
fun bindVisible(view: View,visible: Boolean){
    view.visibility = if(visible) View.VISIBLE else View.GONE
}

@BindingAdapter("todoStatusIcon")
fun bindStateTodoIcon(imageView: ImageView, todoStatus: Boolean){
    if(todoStatus){
        imageView.setImageResource(R.drawable.ic_complete)
    }else{
        imageView.setImageResource(R.drawable.ic_incomplete)
    }
}

@BindingAdapter("todoStatusImage")
fun bindStateTodoImage(bigImageView: ImageView, todoStatus: Boolean){
    if(todoStatus){
        bigImageView.setImageResource(R.drawable.ic_complete_152dp)
    }else{
        bigImageView.setImageResource(R.drawable.ic_incomplete_152dp)
    }
}

@BindingAdapter("booleanToText")
fun bindTodoStatus(textView: TextView, todoStatus: Boolean){
    if(todoStatus) textView.text = "Todo complete! =D" else textView.text = "Todo Incomplete =("
}