package com.boss.myrubelapp.quiz.model_soal

import com.boss.myrubelapp.model.Question

object ConstIntro {

    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"
    const val QUIZ_NAME : String = "quiz_name"

    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "A: Hello, I am Anna. What is your name ? \n B: ________",
                "My name is Lisa",
                "I am a student",
                "I am 13 years old",
                "I am the youngest daughter",
                1)

        questionList.add(que1)

        val que2 = Question(2, "Ani : ________ ?\n Ana : I am 9 years old.",
                "what do you do ?",
                "How old are you ?",
                "Where are you from ?",
                "How many brother do you have ?",
                2)

        questionList.add(que2)

        val que3 = Question(3, "Older sister = _____",
                "Adik perempuan",
                "Kakak laki-laki",
                "Adik laki-laki",
                "Kakak perempuan",
                4)

        questionList.add(que3)

        val que4 = Question(4, "I am Gina. I have a family. There are father, mother, brother, and sister. My parents are Mr. and Mrs. Bayu. My brother is Anto and my sister is Selvi.\n"
                + "Mr. Bayu is gina's ____?",
                "Brother",
                "Father",
                "Mother",
                "Sister",
                2)

        questionList.add(que4)

        val que5 = Question(5, "Where do you live ?",
                "I'm from Padang",
                 "I go to Payakumbuh",
                "I live in Batusangkar",
                "I live with my parents",
                3)

        questionList.add(que5)

        val que6 = Question(6, "She ____ her dog everyday.",
                "to feed",
                "feeding",
                "feed",
                "feeds",
                4)

        questionList.add(que6)

        val que7 = Question(7, "_____ to Masjid everyday?",
                "Do you go",
                "Are you go",
                "Does you go",
                "Is you go",
                1)

        questionList.add(que7)

        val que8 = Question(8, "A :_____ do you study English ? \n B : On Monday",
                "What",
                "Where",
                "Who",
                "When",
                4)

        questionList.add(que8)

        val que9 = Question(9, "A :_______ do you buy the bread ? \n B : In the bakery.",
                "Who",
                "Where",
                "When",
                "What",
                2)

        questionList.add(que9)

        val que10 = Question(10, "She = _______",
                "Dia (laki-laki",
                "Dia (perempuan)",
                "Mereka",
                "Kami",
                2)

        questionList.add(que10)

        return questionList
    }
}
