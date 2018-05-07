package edu.miracosta.cs134.workoutapprefactored;

public class DiaryEntry
{
    private String title;
    private String content;
    private String difficulty;

    public DiaryEntry()
    {

    }

    public DiaryEntry(String title, String content, String difficulty)
    {
        this.title = title;
        this.content = content;
        this.difficulty = difficulty;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public String getDifficulty()
    {
        return difficulty;
    }


    public String displayEntry()
    {
        return "Title: " + title + "\nDifficulty: " + difficulty + "\n    " + content;
    }

    public String toString()
    {
        return "Title: " + title + "\nDifficulty: " + difficulty + "\n    " + content;
    }
}
