package com.boss.myrubelapp.quiz.model_soal

import com.boss.myrubelapp.model.Question

object ConstTime {

    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_NAME : String = "quiz_name"

    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "A day after Monday is _______",
                "Tuesday",
                "Thursday",
                "Wednesday",
                "Sunday",
                1)

        questionList.add(que1)

        val que2 = Question(2, "Two months before November is _____",
                "October",
                "September",
                "December",
                "January",
                2)

        questionList.add(que2)

        val que3 = Question(3, "How you say 07.30 a.m",
                "It is seven past thirty in the morning",
                "It is seven past hal in the morning",
                "It is half past seven in the avening",
                "It is half past seven in the morning",
                4)

        questionList.add(que3)

        val que4 = Question(4, "Edo : When is your birthday\n Dayu : _________( May 5th )",
                "My birthday is on the five of May",
                "My birthday is on the fifth of May",
                "My birthday is on the 5 of May",
                "My birthday is on the fifteenth of May",
                2)

        questionList.add(que4)

        val que5 = Question(5, "12th December. \n What date is this ?",
                "December the twelve",
                "The twentieth of December",
                "The twelfth of December",
                "December second",
                3)

        questionList.add(que5)

        val que6 = Question(6, "She ____ her dog everyday.",
                "to feed",
                "feeding",
                "feed",
                "feeds",
                4)

        questionList.add(que6)

        val que7 = Question(7, "After Saturday, students have holiday. It is on _______",
                "Sunday",
                "Monday",
                "Tuesday",
                "Thursday",
                1)

        questionList.add(que7)

        val que8 = Question(8, "Today is Thursday. Tomorrow is _______",
                "Wednesday",
                "Monday",
                "Sunday",
                "Friday",
                4)

        questionList.add(que8)

        val que9 = Question(9, "How you say 04.15 p.m",
                "It is four past quarter",
                "It is quarter past four",
                "It is quarter to four",
                "It is fifteen to four",
                2)

        questionList.add(que9)

        val que10 = Question(10, "23rd = _______",
                "Twenty three",
                "Twenty third",
                "Twentieth",
                "Twenty threeth",
                2)

        questionList.add(que10)

        return questionList
    }
}