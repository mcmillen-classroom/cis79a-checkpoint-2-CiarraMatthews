package admin.quizapp;

import admin.quizapp.R;

public class Question
{
    private int mTextResId;
    private boolean mAnswer;
    private String wmAnswer;

    private String mHint;
    private int hmTextResId;

    public Question(int mTextResId, boolean mAnswer, int hmTextResId) {
        this.mTextResId = mTextResId;
        this.mAnswer = mAnswer;
        this.hmTextResId = hmTextResId;
    }
    public Question(int mTextResId, String wmAnswer) {
        this.mTextResId = mTextResId;
        this.wmAnswer = wmAnswer;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

    public int getHmTextResId() {
        return hmTextResId;
    }

    public void setHmTextResId(int mTextResId) {
        hmTextResId = mTextResId;
    }

    public String getmHint() {
        return mHint;
    }
    public void setmHint(String mHint) {
        this.mHint = mHint;
    }
}
