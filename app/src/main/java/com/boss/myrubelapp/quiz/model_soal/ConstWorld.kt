package com.boss.myrubelapp.quiz.model_soal

import com.boss.myrubelapp.model.Question

object ConstWorld {

    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_NAME : String = "quiz_name"

    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "Thing in classroom is ______",
            "Whiteboard",
            "Car",
            "Sink",
            "Pan",
            1)

        questionList.add(que1)

        val que2 = Question(2, "Things in kitchen, except _____",
            "Stove",
            "Bed",
            "Pan",
            "Sink",
            2)

        questionList.add(que2)

        val que3 = Question(3, "All these words are articles, except",
            "a",
            "an",
            "the",
            "and",
            4)

        questionList.add(que3)

        val que4 = Question(4, "There is ___ shop near my house",
            "an",
            "a",
            "the",
            "-",
            2)

        questionList.add(que4)

        val que5 = Question(5, "The plural of bus is _____",
            "Bus",
            "Buss",
            "Buses",
            "Bus's",
            3)

        questionList.add(que5)

        val que6 = Question(6, "The plural of child is ______",
            "Childes",
            "Childrens",
            "Childs",
            "Children",
            4)

        questionList.add(que6)

        val que7 = Question(7, "______ are my books. (near)",
            "These",
            "Those",
            "This",
            "That",
            1)

        questionList.add(que7)

        val que8 = Question(8, "_____ is a yellow pencil. (far)",
            "These",
            "This",
            "Those",
            "That",
            4)

        questionList.add(que8)

        val que9 = Question(9, "______ is my father. (far)",
            "These",
            "That",
            "Those",
            "This",
            2)

        questionList.add(que9)

        val que10 = Question(10, "_____ is my car. (near)",
            "These",
            "This",
            "Those",
            "That",
            2)

        questionList.add(que10)

        return questionList
    }
}