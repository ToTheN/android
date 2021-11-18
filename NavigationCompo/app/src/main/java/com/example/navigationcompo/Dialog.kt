package com.example.navigationcompo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.NonCancellable.cancel
import java.util.zip.Inflater


open class Dialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return view
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var title:String = DialogArgs.fromBundle(requireArguments()).title


        val alertDialog = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater

        val view:View = inflater.inflate(R.layout.fragment_dialog,null)

        alertDialog.setView(view)
            .setTitle("Add Description")
            .setPositiveButton(R.string.save,DialogInterface.OnClickListener { dialogInterface, i ->

                var description:EditText = view.findViewById(R.id.edit_decription)
                var change = description.text.toString()

                var myViewModel = MyViewModel()
                myViewModel.Update(change)

            })
            .setNegativeButton(R.string.cancel,DialogInterface.OnClickListener { dialogInterface, i ->

            })
        var titleText:TextView = view.findViewById(R.id.title_text)
        titleText.text = title

      return alertDialog.create()

    }

}