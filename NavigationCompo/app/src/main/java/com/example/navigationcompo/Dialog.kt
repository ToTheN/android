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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_dialog,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        withEditText(view)
    }
    fun withEditText(view: View) {
        val myViewModel:MyViewModel = MyViewModel()

        val builder = AlertDialog.Builder(activity)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.fragment_dialog, null)
        var editDesc = dialogLayout.findViewById<EditText>(R.id.edit_decription)
        var descChange = editDesc.text.toString()
        var title:String = DialogArgs.fromBundle(requireArguments()).title
        builder.setView(dialogLayout)
        builder.setTitle("Add Description")
        builder.setMessage(title)
        builder.setPositiveButton("OK")
        {
                dialogInterface, i -> myViewModel.Update(descChange)
            fragmentManager?.popBackStackImmediate()

        }
        builder.setNegativeButton("Cancel")
        {
            dialogInterface , i-> fragmentManager?.popBackStackImmediate()
        }
        builder.show()
    }




}