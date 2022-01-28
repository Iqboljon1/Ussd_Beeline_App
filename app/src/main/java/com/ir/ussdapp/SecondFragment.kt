package com.ir.ussdapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ir.ussdapp.Adapter.MyAdapter
import com.ir.ussdapp.MyShare.ClassData
import com.ir.ussdapp.MyShare.MyShare
import com.ir.ussdapp.Object.Object
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {
    lateinit var rootSecond: View
    lateinit var dataListSecond: ArrayList<ClassData>
    lateinit var arrayListItemSecond: ArrayList<ClassItemView>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        rootSecond = inflater.inflate(R.layout.fragment_second, container, false)
        rootSecond.tv_type.text = Object.stringTypeName
        this.context?.let { MyShare.init(it) }
        dataListSecond = ArrayList()
        arrayListItemSecond = ArrayList()
        dataListSecond.addAll(MyShare.dataList!!)

        for (i in 0 until  dataListSecond.size) {
            if (dataListSecond[i].stringType == Object.stringType){
                arrayListItemSecond.add(ClassItemView(dataListSecond[i].stringName , dataListSecond[i].stringPrice))
            }
        }

        val myAdapter = this.activity?.let { MyAdapter(it, arrayListItemSecond , object  : MyAdapter.MyOnClick{
            override fun onClick(stringName: String) {
                Object.stringName = stringName
                findNavController().navigate(R.id.thridFragment)
            }
        }) }
        rootSecond.recyclerViewItem.adapter = myAdapter

        return rootSecond
    }

}