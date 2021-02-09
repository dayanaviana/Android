package com.android_training.class10

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_button.view.*


class ButtonFragment : Fragment() {

    interface OnFragmentInteraction{
        fun onButtonClicked(name: String,id: Int,email: String)
        fun onButtonClicked(bundle: Bundle)
    }
    private var listener: OnFragmentInteraction? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_button, container, false)
        init(view)
        return view
    }

    private fun init(view: View){
        view.button_send101.setOnClickListener {

            var name = view.edt_name101.text.toString()
            var id = view.edt_id101.text.toString().toInt()
            var email = view.edt_email101.text.toString()

            var bundle = Bundle()
            bundle.putString("NAME",name)
            bundle.putInt("ID", id)
            bundle.putString("EMAIL",email)

            //listener?.onButtonClicked(name,id,email)
            listener?.onButtonClicked(bundle)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        listener = context as DataFromFragmentToActivity
        listener = context as FragmentoToFragmentDataActivity
    }
}