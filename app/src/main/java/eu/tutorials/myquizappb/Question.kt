package eu.tutorials.myquizappb

data class Question(
    val id: Int,
    val image: Int,
    val question: String= "Which country does this flag belongs to?",
    val correctOption: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,


)
