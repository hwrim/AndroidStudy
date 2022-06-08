package com.hyun.dietmemo

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf <DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainList)

        val adapterList = ListViewAdapter(dataModelList)

        listView.adapter =  adapterList

        Log.d("DataModel------", dataModelList.toString())

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("point", dataModelList.toString())
                dataModelList.clear()
                Log.d("point", dataModelList.toString())

                for (dataModel in snapshot.children) {
                    Log.d("Data", dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)

                }
                adapterList .notifyDataSetChanged()
                Log.d("DataModel", dataModelList.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val writeBtn = findViewById<ImageView>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setTitle("메모 다이얼로그")
            val mAlter = mBuilder.show()

            var dateText = ""
            val dateSelect = mAlter.findViewById<Button>(R.id.dateBtn)
            dateSelect?.setOnClickListener {
                val today = GregorianCalendar()
                val year : Int = today.get(Calendar.YEAR)
                val month : Int = today.get(Calendar.MONTH)
                val date : Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int
                    ) {
                        Log.d("MAIN", "${year}, ${month + 1}, ${dayOfMonth}")
                        dateSelect.setText("${year}, ${month + 1}, ${dayOfMonth}")

                        dateText = "${year}, ${month + 1}, ${dayOfMonth}"
                    }

                }, year, month, date)
                dlg.show()
            }

            val saveBtn = mAlter.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {

                val memoItem = mAlter.findViewById<EditText>(R.id.memoItem)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference( "myMemo").child(Firebase.auth.currentUser!!.uid)

                val model = DataModel(dateText, memoItem)

                myRef.push().setValue(model)

                mAlter.dismiss()

            }
        }


    }

} 