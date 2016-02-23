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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.akexorcist.cloudvision.CVRequest;
import com.akexorcist.cloudvision.CVResponse;
import com.akexorcist.cloudvision.CloudVision;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity implements CloudVision.Callback {
    private final static String apiKey = "your_api_key";

    private ListView lvLabel;
    private ProgressBar pbLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLabel = (ListView) findViewById(R.id.lv_label);
        pbLabel = (ProgressBar) findViewById(R.id.pb_label);

        showLoading();
        startDetect();
    }

    private void startDetect() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.sample);
        String data = CloudVision.convertBitmapToBase64String(bitmap);
        CVRequest request = createCVRequest(data);
        CloudVision.runImageDetection(apiKey, request, this);
    }

    private CVRequest createCVRequest(String data) {
        CVRequest.Image image = new CVRequest.Image(data);
        CVRequest.Feature feature = new CVRequest.Feature(CVRequest.FeatureType.LABEL_DETECTION, 5);
        List<CVRequest.Feature> featureList = new ArrayList<>();
        featureList.add(feature);
        List<CVRequest.Request> requestList = new ArrayList<>();
        requestList.add(new CVRequest.Request(image, featureList));
        return new CVRequest(requestList);
    }

    private void setCVResponse(CVResponse cvResponse) {
        if (cvResponse != null && cvResponse.isResponsesAvailable()) {
            CVResponse.Response response = cvResponse.getResponse(0);
            if (response.isLabelAvailable()) {
                LabelAdapter adapter = new LabelAdapter(response.getLabels());
                lvLabel.setAdapter(adapter);
                hideLoading();
            }
        }
    }

    public void showLoading() {
        lvLabel.setVisibility(View.GONE);
        pbLabel.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        lvLabel.setVisibility(View.VISIBLE);
        pbLabel.setVisibility(View.GONE);
    }

    @Override
    public void onImageDetectionSuccess(boolean isSuccess, int statusCode, Headers headers, CVResponse cvResponse) {
        setCVResponse(cvResponse);
    }

    @Override
    public void onImageDetectionFailure(Throwable t) {
        // Do something
    }
}
