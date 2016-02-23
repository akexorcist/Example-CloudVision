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

package com.akexorcist.cloudvision;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Akexorcist on 2/21/2016 AD.
 */
public class CloudVision {
    public static void runImageDetection(String apiKey, CVRequest request, final Callback callback) {
        CVConnection.getConnection().runImageDetection(apiKey, request).enqueue(new retrofit2.Callback<CVResponse>() {
            @Override
            public void onResponse(Call<CVResponse> call, Response<CVResponse> response) {
                if (callback != null) {
                    callback.onImageDetectionSuccess(response.isSuccess(), response.code(), response.headers(), response.body());
                }
            }

            @Override
            public void onFailure(Call<CVResponse> call, Throwable t) {
                if (callback != null) {
                    callback.onImageDetectionFailure(t);
                }
            }
        });
    }

    public interface Callback {
        void onImageDetectionSuccess(boolean isSuccess, int statusCode, Headers headers, CVResponse cvResponse);

        void onImageDetectionFailure(Throwable t);
    }

    public static String convertBitmapToBase64String(Bitmap bitmap) {
        return convertByteArrayToBase64String(convertBitmapToByteArray(bitmap));
    }

    private static byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream); //bm is the bitmap object
        return byteArrayOutputStream.toByteArray();
    }

    private static String convertByteArrayToBase64String(byte[] data) {
        return Base64.encodeToString(data, Base64.DEFAULT);
    }
}
