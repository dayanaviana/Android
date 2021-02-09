package com.android_training.class10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val KEY_NAME = "NAME"
private const val KEY_ID = "ID"
private const val KEY_EMAIL = "EMAIL"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = ""
    private var id: Int? = 0
    private var email: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            name = it.getString(KEY_NAME)
            email = it.getString(KEY_EMAIL)
            id = it.getInt(KEY_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_blank, container, false)
        view.text_view_name.text = " $id \n $name \n $email"
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(id:Int, name: String, email: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, name)
                    id?.let { putInt(KEY_ID, it) }
                    putString(KEY_EMAIL, email)
                }
            }
        fun newInstance(bundle: Bundle) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, bundle.getString("KEY_NAME"))
                    putInt(KEY_ID, bundle.getInt("ID"))
                    putString(KEY_EMAIL, bundle.getString("EMAIL"))
                }
            }
        fun newInstance(name: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, name)
                    putString(KEY_ID, id.toString())
                    putString(KEY_EMAIL, email)
                }
            }
    }
}