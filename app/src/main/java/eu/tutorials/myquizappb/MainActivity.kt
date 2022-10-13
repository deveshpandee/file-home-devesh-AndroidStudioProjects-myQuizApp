package eu.tutorials.myquizappb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start: Button = findViewById(R.id.btnStart)
        val name: EditText = findViewById(R.id.editText)

        start.setOnClickListener{
            if(name.text.isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent= Intent(this,QuestionActivity::class.java)
                intent.putExtra(Constants.name,name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}