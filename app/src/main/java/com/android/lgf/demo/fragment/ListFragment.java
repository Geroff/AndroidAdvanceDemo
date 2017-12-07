package com.android.lgf.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lgf.demo.R;
import com.android.lgf.demo.adapter.HomeAdapter;
import com.android.lgf.demo.conf.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgf on 17-12-6.
 */

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    List<String> contentList = new ArrayList<>();
    private String title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(Constant.BUNDLE_KEY_FRAGMENT_ARGUMENT_TITLE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = inflateView.findViewById(R.id.fragment_recycler_view);
        return inflateView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        for (int i = 0; i < 5; i++) {
            contentList.add(title + "[" + i + "]");
        }
        recyclerView.setAdapter(new HomeAdapter(contentList));
    }
}
