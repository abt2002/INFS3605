package com.example.infs3605;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.adapter.HistoryAdapter;
import com.example.infs3605.adapter.MessageAdapter;
import com.example.infs3605.database.HistoryDatabaseSQLite;
import com.example.infs3605.database.HistoryMsg;
import com.example.infs3605.databinding.FragmentHistoryBinding;
import com.example.infs3605.model.Message;
import com.example.infs3605.model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryFragment extends Fragment {


    RecyclerView recyclerView;
    HistoryAdapter historyAdapter;
    List<Message> messageList = new ArrayList<>();
    private EditText searchEt;

    private ImageView searchImg;

    HistoryDatabaseSQLite lite;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_history, container, false);

        lite = new HistoryDatabaseSQLite(getContext());

        searchEt = root.findViewById(R.id.searchEt);
        searchImg = root.findViewById(R.id.searchImg);
        recyclerView = root.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        historyAdapter = new HistoryAdapter(messageList);
        recyclerView.setAdapter(historyAdapter);

        List<HistoryMsg> historyMsgs = lite.selectHistoryByUsername(Session.getCurrent());

        List<Message> messages = historyMsgs.stream().map(x -> new Message(x.getMsg(), x.getSendfrom())).collect(Collectors.toList());
        addToChat(messages);


        searchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTxt = searchEt.getText().toString();
                List<HistoryMsg> historyMsgs = lite.selectHistoryByUsername(Session.getCurrent());
                if (!searchTxt.trim().equals("")) {
                    List<HistoryMsg>  filtered =  historyMsgs.stream().filter(x -> x.getMsg().contains(searchTxt)).collect(Collectors.toList());
                    if ( !filtered.isEmpty()) {
                        HistoryMsg historyMsg = filtered.get(0);
                        int index = historyMsgs.indexOf(historyMsg);
                        historyMsgs = historyMsgs.subList(index, historyMsgs.size());
                    }
                }
                List<Message> messages = historyMsgs.stream().map(x -> new Message(x.getMsg(), x.getSendfrom())).collect(Collectors.toList());
                messageList.clear();
                addToChat(messages);
            }
        });

        return root;
    }


    void addToChat (List<Message> msg){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.addAll(msg);
                historyAdapter.notifyDataSetChanged();
            }
        });
    }
}
