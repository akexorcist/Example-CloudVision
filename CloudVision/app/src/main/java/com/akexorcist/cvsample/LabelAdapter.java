/*
Copyright 2016 Akexorcist
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package com.akexorcist.cvsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.akexorcist.cloudvision.CVResponse;

import java.util.List;

/**
 * Created by Akexorcist on 2/21/2016 AD.
 */
public class LabelAdapter extends BaseAdapter {
    private List<CVResponse.EntityAnnotation> labelList;

    public LabelAdapter(List<CVResponse.EntityAnnotation> labelList) {
        this.labelList = labelList;
    }

    @Override
    public int getCount() {
        return labelList.size();
    }

    @Override
    public Object getItem(int position) {
        return labelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_label_item, parent, false);
        }
        TextView tvDescription = (TextView) convertView.findViewById(R.id.tv_description);
        tvDescription.setText(labelList.get(position).getDescription());

        TextView tvScore = (TextView) convertView.findViewById(R.id.tv_score);
        tvScore.setText(String.valueOf(labelList.get(position).getScore()));

        return convertView;
    }
}
