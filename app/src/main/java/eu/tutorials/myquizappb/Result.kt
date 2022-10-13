package eu.tutorials.myquizappb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView =findViewById(R.id.editText)
        val btn: Button = findViewById(R.id.submit_btn)
        val score: TextView =findViewById(R.id.score)

        tvName.text=intent.getStringExtra(Constants.name)

        val totalQuestions=intent.getIntExtra(Constants.totalQuestions,0)
        val correctAnswer=intent.getIntExtra(Constants.correctQuestions,0)

        score.text="You have scored $correctAnswer out of $totalQuestions"

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}