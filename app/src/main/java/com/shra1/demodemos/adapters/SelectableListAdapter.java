package com.shra1.demodemos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.shra1.demodemos.R;
import com.shra1.demodemos.dtos.MyString;
import com.shra1.demodemos.fragments.LVContextualActionModeDemoFragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectableListAdapter extends BaseAdapter {
    Context mCtx;
    List<MyString> names;

    public SelectableListAdapter(Context mCtx, List<MyString> names) {
        this.names = names;
        this.mCtx = mCtx;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {
        SLAViewHolder h;
        if (v == null) {
            v = LayoutInflater.from(mCtx).inflate(R.layout.selectable_list_item_layout, parent, false);
            h = new SLAViewHolder(v);
            v.setTag(h);
        } else {
            h = (SLAViewHolder) v.getTag();
        }

        MyString name = (MyString) getItem(position);
        h.tvSLILText.setText(name.getName());

        if (LVContextualActionModeDemoFragment.isInActionMode) {
            h.cbSLILCheckBox.setVisibility(View.VISIBLE);
        } else {
            h.cbSLILCheckBox.setVisibility(View.GONE);
        }

        h.cbSLILCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox c = (CheckBox) v;
                if (c.isChecked()) {
                    names.get(position).setSelected(true);
                } else {
                    names.get(position).setSelected(false);
                }
            }
        });


        return v;
    }

    public List<MyString> getSelectedNames() {
        List<MyString> newlist = new ArrayList<>();
        for (MyString s : names) {
            if (s.isSelected()) {
                newlist.add(s);
            }
        }
        return newlist;
    }

    public void removeSelectedItems() {
        for (Iterator<MyString> it = names.iterator(); it.hasNext(); ) {
            MyString s = it.next();
            if (s.isSelected()) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    static class SLAViewHolder {
        private TextView tvSLILText;
        private CheckBox cbSLILCheckBox;

        public SLAViewHolder(View v) {
            tvSLILText = (TextView) v.findViewById(R.id.tvSLILText);
            cbSLILCheckBox = (CheckBox) v.findViewById(R.id.cbSLILCheckBox);
        }
    }


}
