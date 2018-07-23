package com.shra1.demodemos.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.shra1.demodemos.MainActivity;
import com.shra1.demodemos.R;
import com.shra1.demodemos.adapters.SelectableListAdapter;
import com.shra1.demodemos.dtos.MyString;

import java.util.ArrayList;
import java.util.List;

public class LVContextualActionModeDemoFragment extends Fragment {


    public static boolean isInActionMode = false;
    private static LVContextualActionModeDemoFragment INSTANCE = null;
    ListView lvLFList;
    AbsListView.MultiChoiceModeListener multiChoiceModeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.contextual_menu, menu);
            isInActionMode = true;
            MainActivity.getInstance().tbToolbar.setVisibility(View.INVISIBLE);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mnuDelete:
                    adapter.removeSelectedItems();
                    break;
                case R.id.mnuShare:
                    break;
            }
            return true;

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            isInActionMode = false;
            MainActivity.getInstance().tbToolbar.setVisibility(View.VISIBLE);
        }
    };
    private Context mCtx;

    public static Fragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LVContextualActionModeDemoFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCtx = container.getContext();
        View v = inflater.inflate(R.layout.lvcamd_fragment, container, false);
        initViews(v);

        List<MyString> names = new ArrayList<>();

        names.add(new MyString("Shrawan", false));
        names.add(new MyString("Ishwar", false));
        names.add(new MyString("Swanand", false));
        names.add(new MyString("Sagar", false));
        names.add(new MyString("Shashank", false));
        names.add(new MyString("Abc", false));
        names.add(new MyString("Def", false));
        names.add(new MyString("Ghi", false));

        adapter = new SelectableListAdapter(mCtx, names);
        lvLFList.setAdapter(adapter);

        lvLFList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvLFList.setMultiChoiceModeListener(multiChoiceModeListener);

        return v;
    }

    private void initViews(View v) {
        lvLFList = v.findViewById(R.id.lvLFList);
    }
    SelectableListAdapter adapter;

}
