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

import java.util.List;

/**
 * Created by Akexorcist on 2/20/2016 AD.
 */
public class CVRequest {
    public enum FeatureType {
        TYPE_UNSPECIFIED, FACE_DETECTION, LANDMARK_DETECTION, LOGO_DETECTION, LABEL_DETECTION, TEXT_DETECTION, SAFE_SEARCH_DETECTION, IMAGE_PROPERTIES
    }

    List<Request> requests;

    public CVRequest(List<Request> requests) {
        this.requests = requests;
    }

    public static class Request {
        Image image;
        List<Feature> features;
        ImageContext imageContext;

        public Request(Image image, List<Feature> features) {
            this.image = image;
            this.features = features;
        }
    }

    public static class Image {
        String content;
        ImageSource source;

        public Image(String content) {
            this.content = content;
        }

        public Image(ImageSource source) {
            this.source = source;
        }

        public static class ImageSource {
            String gcsImageUri;

            public ImageSource(String gcsImageUri) {
                this.gcsImageUri = gcsImageUri;
            }
        }
    }

    public static class Feature {
        FeatureType type;
        int maxResults;

        public Feature(FeatureType type, int maxResults) {
            this.type = type;
            this.maxResults = maxResults;
        }
    }

    public static class ImageContext {
        List<String> languageHints;
        LatLongRect latLongRect;

        public ImageContext(List<String> languageHints, LatLongRect latLongRect) {
            this.languageHints = languageHints;
            this.latLongRect = latLongRect;
        }

        public List<String> getLanguageHints() {
            return languageHints;
        }

        public LatLongRect getLatLongRect() {
            return latLongRect;
        }

        public static class LatLongRect {
            LatLng minLatLng;
            LatLng maxLatLng;

            public LatLongRect(LatLng minLatLng, LatLng maxLatLng) {
                this.minLatLng = minLatLng;
                this.maxLatLng = maxLatLng;
            }

            public LatLng getMinLatLng() {
                return minLatLng;
            }

            public LatLng getMaxLatLng() {
                return maxLatLng;
            }
        }
    }

    public static class LatLng {
        double latitude;
        double longitude;

        public LatLng(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}
