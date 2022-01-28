package com.ir.ussdapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ir.ussdapp.ClassItemView
import com.ir.ussdapp.R
import kotlinx.android.synthetic.main.item_mb_min_sms_tarif.view.*

class MyAdapter(val context: Context, private val arrayList: ArrayList<ClassItemView> , val myOnClick: MyOnClick) :
    RecyclerView.Adapter<MyAdapter.VH>() {

    inner class VH(var itemRV: View) : RecyclerView.ViewHolder(itemRV) {
        fun onBind(stringName: String , stringPrice: String) {
            itemRV.tv_tarif_sms_mb_yangilik_ussd.text = stringName
            itemRV.tv_narx_vaqt_ussdKod.text = stringPrice

            itemRV.setOnClickListener {
                myOnClick.onClick(stringName)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_mb_min_sms_tarif, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayList[position].stringName , arrayList[position].stringPrice)
    }

    override fun getItemCount(): Int = arrayList.size

    interface MyOnClick{
        fun onClick(stringName: String) {

        }
    }

}