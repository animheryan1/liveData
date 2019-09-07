package com.example.livedatatask;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDAO wordDAO;
    private LiveData<List<Word>> listLiveData;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDAO = db.wordDAO();
        listLiveData = wordDAO.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return listLiveData;
    }

    public void insert(Word word) {
        new insertAsyncTask(wordDAO).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDAO mAsyncTaskDao;

        insertAsyncTask(WordDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
