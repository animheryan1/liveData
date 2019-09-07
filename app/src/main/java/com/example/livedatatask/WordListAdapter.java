package com.example.livedatatask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    private LayoutInflater mInflater;
    private List<Word> cachedWords;

    public WordListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (cachedWords != null) {
            Word current = cachedWords.get(position);
            holder.wordTextView.setText(current.getWord());
        } else {
            holder.wordTextView.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(cachedWords != null){
            return cachedWords.size();
        }
        return 0;
    }

    void setWords(List<Word> wordList){
        cachedWords = wordList;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        private TextView wordTextView;
        private WordViewHolder(View itemView){
            super(itemView);
            wordTextView = itemView.findViewById(R.id.textView);
        }

    }
}
