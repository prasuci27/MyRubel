package com.boss.myrubelapp.quiz.model_soal

import com.boss.myrubelapp.model.Question


object Constants {

    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_NAME : String = "quiz_name"

    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "You meet a friend on the way to school. What do you say ?",
            "Good Morning",
            "Good Night",
            "Good evening",
            "Nice to meet you",
            1)

        questionList.add(que1)

        val que2 = Question(2, "Ani : Hello, Ana. ....?\n Ana : Hi I'm fine. Thank you",
            "Good Morning",
            "How are you ?",
            "See you later",
            "Nice to meet you",
            2)

        questionList.add(que2)

        val que3 = Question(3, "Yuki : Wow, your house is very beautiful! \n Zahra : _______",
            "It's okay",
            "I apologize",
            "I'm sorry",
            "Thanks a lot",
            4)

        questionList.add(que3)

        val que4 = Question(4, "The following are the expressions of gratitude, except ...",
            "Thank you",
            "That's okay",
            "Thanks a lot",
            "Thank you very much",
            2)

        questionList.add(que4)

        val que5 = Question(5, "When someone says 'good morning', we say _____",
            "Goodbye",
            "Good night",
            "Good morning",
            "Nice to meet you too",
            3)

        questionList.add(que5)

        val que6 = Question(6, "What do you say when you make mistake?",
            "Thank you",
            "Never mind",
            "I am happy",
            "I am really sorry",
            4)

        questionList.add(que6)

        val que7 = Question(7, "A :I'm sorry for breaking your pencil. \n B : ________",
            "Never mind",
            "You are right",
            "That's good",
            "It's glad",
            1)

        questionList.add(que7)

         val que8 = Question(8, "A :I'm sorry, I broke your rule. \n B : ________",
            "Forget it",
            "You are right",
            "That's good",
            "Thank you",
            1)

        questionList.add(que8)

        val que9 = Question(9, "A :_______, I have lost your book. \n B : It's okay",
            "Thanks a lot",
            "Please apology me",
            "That's good",
            "Thank you",
            2)

        questionList.add(que9)

        val que10 = Question(10, "A :_______, I have lost your book. \n B : It's okay",
            "Thanks a lot",
            "Please apology me",
            "That's good",
            "Thank you",
            2)

        questionList.add(que10)

        return questionList
    }
}