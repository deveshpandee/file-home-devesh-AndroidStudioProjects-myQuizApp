package eu.tutorials.myquizappb

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar ?=null
    private var progress: TextView ?= null
    private var image: ImageView ?= null
    private var questionsList: ArrayList<Question> ?= null
    private var currentPosition: Int ?=1
    private var selectedPosition: Int ?= 0
    private var userName: String ?= null
    private var correctAnswer: Int =0

    private var optionOne: TextView ?=null
    private var optionTwo: TextView ?=null
    private var optionThree: TextView ?=null
    private var optionFour: TextView ?=null
    private var btnSubmit: Button ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        userName=intent.getStringExtra(Constants.name)
        progressBar= findViewById(R.id.progressBar)
        progress=findViewById(R.id.progress)
        image=findViewById(R.id.ivImage)
        optionOne=findViewById(R.id.one)
        optionTwo=findViewById(R.id.two)
        optionThree=findViewById(R.id.three)
        optionFour=findViewById(R.id.four)
        btnSubmit=findViewById((R.id.btnSubmit))
        questionsList=Constants.getQuestion()

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        makeQuestion()
        defaultOptionsView()


    }

    private fun makeQuestion() {
        defaultOptionsView()
        val question: Question = questionsList!![currentPosition!!-1]
        progressBar?.progress = currentPosition!!
        progress?.text = "$currentPosition/${progressBar?.max}"
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
        image?.setImageResource(question.image)

        if(currentPosition==questionsList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text=="SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,R.drawable.default_bg)
        }
    }

    private fun optionSelect(tv: TextView, selectedOpt:Int){
        defaultOptionsView()
        selectedPosition=selectedOpt
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.select_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.one->{
                optionOne?.let{
                    optionSelect(it,1)
                }
            }
            R.id.two->{
                optionTwo?.let{
                    optionSelect(it,2)
                }
            }
            R.id.three->{
                optionThree?.let{
                    optionSelect(it,3)
                }
            }
            R.id.four->{
                optionFour?.let{
                    optionSelect(it,4)
                }
            }
            R.id.btnSubmit->{
                if(selectedPosition==0){
                    currentPosition = currentPosition?.plus(1)
                    when{
                        currentPosition!! <= questionsList!!.size ->{
                            makeQuestion()
                        }
                        else->{
                            val intent=Intent(this,Result::class.java)
                            intent.putExtra(Constants.name,userName)
                            intent.putExtra(Constants.correctQuestions,correctAnswer)
                            intent.putExtra(Constants.totalQuestions,questionsList?.size)
                            startActivity(intent)
                        }
                    }
                }
                else{
                    val question = questionsList?.get(currentPosition!! -1)
                    if(question?.correctOption!=selectedPosition){
                        selectedPosition?.let { answerCheck(it,R.drawable.incorrect_bg) }
                    }
                    else{
                        correctAnswer++
                    }
                    answerCheck(question!!.correctOption,R.drawable.correct_bg)
                    if(currentPosition==questionsList!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    selectedPosition=0
                }
            }
        }
    }
    private fun answerCheck(answer: Int, drawable: Int){
        when (answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(this,drawable)
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(this,drawable)
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(this,drawable)
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(this,drawable)
            }

        }
    }
}