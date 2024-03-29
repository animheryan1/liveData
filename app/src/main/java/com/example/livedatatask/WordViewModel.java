package com.example.livedatatask;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        wordRepository.insert(word);
    }

}
