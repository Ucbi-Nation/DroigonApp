package com.example.droigon

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = colorHead as TextView
        val WordtoSpan: Spannable = SpannableString(textView.text)
        WordtoSpan.setSpan(
            ForegroundColorSpan(R.color.droi),
            4,
            7,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        colorHead.text = WordtoSpan
        button.setOnClickListener {
            Intent(this,)
        }







    }

    var selectedEmailIndec = 0

    fun showclickme (view: View){
        val emails = arrayOf("None","Droigon Logo","Chairman Droigon", "Unknown Droigon","Face Of Droigon","Model Droigon" )

        var selectedEmail = emails[selectedEmailIndec]

        MaterialAlertDialogBuilder(this)
            .setTitle("Select The Picture")

            .setSingleChoiceItems(emails,selectedEmailIndec){
                    dialog,which ->
                selectedEmailIndec = which
                selectedEmail = emails[which]
            }

                .setItems(emails){dialog, which ->
                when(which){
                    0 -> {showSnackbar("${emails[0]} Selected")
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                    1 -> {changeImage.setImageResource(R.drawable.asse)
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                    2 -> {changeImage.setImageResource(R.drawable.droigon)
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                    3 -> {changeImage.setImageResource(R.drawable.unknown)
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                    4 -> {changeImage.setImageResource(R.drawable.face)
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                    5 -> {changeImage.setImageResource(R.drawable.model)
                        selectedEmailIndec = which
                        selectedEmail = emails[which]}
                }
            }
            .setPositiveButton("ok"){dialog, which ->
                showSnackbar("$selectedEmail Selected")
            }
            .setNeutralButton("Cancel"){dialog, which ->

            }
            .show()

    }





    fun showSnackbar(msg:String){
        Snackbar.make(changeImage, msg , Snackbar.LENGTH_SHORT).show()
    }
    fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}