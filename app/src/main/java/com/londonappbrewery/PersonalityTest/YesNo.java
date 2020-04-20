package com.londonappbrewery.PersonalityTest;

// This is the model class that represents a single quiz question.
public class YesNo {

    // These are the placeholders for the question resource id and the correct answer
    private int QuestionID;


    // This is the constructor that will be called when a new quiz question is created.
    public YesNo(int questionResourceID) {
        QuestionID = questionResourceID;

    }

    // This method gives us access to info stored in the (private) question id.
    public int getQuestionID() {
        return QuestionID;
    }



}
