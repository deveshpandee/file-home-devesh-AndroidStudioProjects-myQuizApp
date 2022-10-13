package eu.tutorials.myquizappb

object Constants {

    const val name: String="name"
    const val totalQuestions: String="total question"
    const val correctQuestions: String="correct answer"

    fun getQuestion():ArrayList<Question>{
        val questionsList= arrayListOf<Question>()

        val qsn1=Question(1,R.drawable.ic_flag_of_argentina,"Which country does this flag belongs to?",2,
        "Netherlands","Argentina","Sweden","Iceland")

        val qsn2=Question(1,R.drawable.ic_flag_of_australia,"Which country does this flag belongs to?",1,
            "Australia","Argentina","Georgia","Hungary")

        val qsn3=Question(1,R.drawable.ic_flag_of_belgium,"Which country does this flag belongs to?",4,
            "Poland","Italy","Ireland","Belgium")

        val qsn4=Question(1,R.drawable.ic_flag_of_brazil,"Which country does this flag belongs to?",2,
            "Israel","Brazil","Spain","Greece")

        val qsn5=Question(1,R.drawable.ic_flag_of_denmark,"Which country does this flag belongs to?",4,
            "Finland","France","Ghana","Denmark")

        val qsn6=Question(1,R.drawable.ic_flag_of_fiji,"Which country does this flag belongs to?",3,
            "Austria","Czechoslovakia","Fiji","Brazil")

        val qsn7=Question(1,R.drawable.ic_flag_of_germany,"Which country does this flag belongs to?",1,
            "Germany","Portugal","Armenia","Austria")

        val qsn8=Question(1,R.drawable.ic_flag_of_india,"Which country does this flag belongs to?",2,
            "Bangladesh","India","Nepal","Bhutan")

        val qsn9=Question(1,R.drawable.ic_flag_of_new_zealand,"Which country does this flag belongs to?",4,
            "Australia","Srilanka","South Africa","Newzland")

        questionsList.add(qsn1)
        questionsList.add(qsn2)
        questionsList.add(qsn3)
        questionsList.add(qsn4)
        questionsList.add(qsn5)
        questionsList.add(qsn6)
        questionsList.add(qsn7)
        questionsList.add(qsn8)
        questionsList.add(qsn9)
        return questionsList

    }

}