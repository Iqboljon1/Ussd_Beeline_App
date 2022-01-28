package com.ir.ussdapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ir.ussdapp.MyShare.ClassData
import com.ir.ussdapp.MyShare.MyShare
import com.ir.ussdapp.Object.Object
import kotlinx.android.synthetic.main.fragment_thrid.view.*

class ThridFragment : Fragment() {
    lateinit var rootThird: View
    lateinit var dataList: ArrayList<ClassData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        rootThird = inflater.inflate(R.layout.fragment_thrid, container, false)
        rootThird.tv_name.text = Object.stringTypeName
        rootThird.tv_tarif_sms_mb_yangilik_ussd.text = Object.stringName
        dataList = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        for (i in 0 until  dataList.size) {
            if (dataList[i].stringName == Object.stringName){
                rootThird.tv_description.text = dataList[i].stringDescription
            }
        }


        return rootThird
    }
}