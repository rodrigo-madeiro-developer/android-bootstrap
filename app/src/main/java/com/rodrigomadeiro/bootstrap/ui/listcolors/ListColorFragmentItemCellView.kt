package com.rodrigomadeiro.bootstrap.ui.listcolors

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.rodrigomadeiro.bootstrap.R
import com.rodrigomadeiro.bootstrap.domain.entity.MtgColor

class ListColorFragmentItemCellView@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    //region Properties
    private lateinit var imgColor: ImageView
    private lateinit var lblName: TextView
    //endregion

    //region Lifecycle
    override fun onFinishInflate() {
        super.onFinishInflate()

        setupView()
    }
    //endregion

    //region Misc
    private fun setupView(){
        imgColor = findViewById(R.id.lblName)
        lblName = findViewById(R.id.lblName)
    }

    open fun bind(color: MtgColor){

        lblName.text = color.text
        Glide.with(imgColor).load(color.icon).into(imgColor)
    }
    //endregion
}