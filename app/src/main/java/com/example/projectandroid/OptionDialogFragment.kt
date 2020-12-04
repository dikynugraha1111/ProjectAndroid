package com.example.projectandroid


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.fragment_option_dialog.*
import kotlinx.android.synthetic.main.fragment_option_dialog.*
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class OptionDialogFragment : DialogFragment(), View.OnClickListener {
    private lateinit var btnDialog : Button
    private lateinit var btnCancel : Button
    private lateinit var tvTitle : TextView
    private var optionDialogListener: OnOptionDialogListener? = null
    private var title : String ?= null

    companion object{
        const val DATA: String = "DATA"
        fun newInstance(namaTitle : String) : OptionDialogFragment{
            val myFragment = OptionDialogFragment()
            val bundle = Bundle().apply {
                putString(DATA,namaTitle)
            }
            myFragment.arguments = bundle
            return myFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        title = arguments?.getString(DATA)
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDialog = view.findViewById(R.id.btn_dialog)
        btnDialog.setOnClickListener(this)
        btnCancel = view.findViewById(R.id.btn_cancel)
        btnCancel.setOnClickListener(this)
        tvTitle = view.findViewById(R.id.tv_title)
        tvTitle.text = title
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_cancel -> {
                dialog?.cancel()
            }
            R.id.btn_dialog ->{
                val intentMain = Intent(activity,MainActivity::class.java)
                startActivity(intentMain)
            }
        }
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}
