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
public class CVResponse {
    List<Response> responses;

    public List<Response> getResponses() {
        return responses;
    }

    public Response getResponse(int index) {
        return responses.get(index);
    }

    public boolean isResponsesAvailable() {
        return responses != null && responses.size() > 0;
    }

    public int getRequestCount() {
        return isResponsesAvailable() ? responses.size() : 0;
    }

    public static class Response {
        List<FaceAnnotation> faceAnnotations;
        List<EntityAnnotation> landmarkAnnotations;
        List<EntityAnnotation> logoAnnotations;
        List<EntityAnnotation> labelAnnotations;
        List<EntityAnnotation> textAnnotations;
        SafeSearchAnnotation safeSearchAnnotation;
        Error error;

        public List<FaceAnnotation> getFaces() {
            return faceAnnotations;
        }

        public List<EntityAnnotation> getLandmarks() {
            return landmarkAnnotations;
        }

        public List<EntityAnnotation> getLogos() {
            return logoAnnotations;
        }

        public List<EntityAnnotation> getLabels() {
            return labelAnnotations;
        }

        public List<EntityAnnotation> getTexts() {
            return textAnnotations;
        }

        public SafeSearchAnnotation getSafeSearch() {
            return safeSearchAnnotation;
        }

        public Error getError() {
            return error;
        }

        public int getFaceCount() {
            return faceAnnotations != null ? faceAnnotations.size() : 0;
        }

        public int getLandmarkCount() {
            return landmarkAnnotations != null ? landmarkAnnotations.size() : 0;
        }

        public int getLabelCount() {
            return labelAnnotations != null ? labelAnnotations.size() : 0;
        }

        public int getTextCount() {
            return textAnnotations != null ? textAnnotations.size() : 0;
        }

        public int getLogoCount() {
            return logoAnnotations != null ? logoAnnotations.size() : 0;
        }

        public FaceAnnotation getFace(int index) {
            return faceAnnotations.get(index);
        }

        public EntityAnnotation getLandmark(int index) {
            return landmarkAnnotations.get(index);
        }

        public EntityAnnotation getLabelCount(int index) {
            return labelAnnotations.get(index);
        }

        public EntityAnnotation getTextCount(int index) {
            return textAnnotations.get(index);
        }

        public EntityAnnotation getLogoCount(int index) {
            return logoAnnotations.get(index);
        }

        public boolean isFaceAvailable() {
            return faceAnnotations != null;
        }

        public boolean isLandmarkAvailable() {
            return landmarkAnnotations != null;
        }

        public boolean isLogoAvailable() {
            return logoAnnotations != null;
        }

        public boolean isLabelAvailable() {
            return labelAnnotations != null;
        }

        public boolean isTextAvailable() {
            return textAnnotations != null;
        }

        public boolean isSafeSearchAvailable() {
            return safeSearchAnnotation != null;
        }

        public boolean isError() {
            return error != null;
        }
    }

    public static class FaceAnnotation {
        BoundingPoly boundingPoly;
        BoundingPoly fdBoundingPoly;
        List<Landmark> landmarks;
        float rollAngle;
        float panAngle;
        float tiltAngle;
        float detectionConfidence;
        float landmarkingConfidence;
        String joyLikelihood;
        String sorrowLikelihood;
        String angerLikelihood;
        String surpriseLikelihood;
        String underExposedLikelihood;
        String blurredLikelihood;
        String headwearLikelihood;

        public BoundingPoly getBoundingPoly() {
            return boundingPoly;
        }

        public BoundingPoly getFdBoundingPoly() {
            return fdBoundingPoly;
        }

        public List<Landmark> getLandmarks() {
            return landmarks;
        }

        public float getRollAngle() {
            return rollAngle;
        }

        public float getPanAngle() {
            return panAngle;
        }

        public float getTiltAngle() {
            return tiltAngle;
        }

        public float getDetectionConfidence() {
            return detectionConfidence;
        }

        public float getLandmarkingConfidence() {
            return landmarkingConfidence;
        }

        public String getJoyLikelihood() {
            return joyLikelihood;
        }

        public String getSorrowLikelihood() {
            return sorrowLikelihood;
        }

        public String getAngerLikelihood() {
            return angerLikelihood;
        }

        public String getSurpriseLikelihood() {
            return surpriseLikelihood;
        }

        public String getUnderExposedLikelihood() {
            return underExposedLikelihood;
        }

        public String getBlurredLikelihood() {
            return blurredLikelihood;
        }

        public String getHeadwearLikelihood() {
            return headwearLikelihood;
        }
    }

    public static class EntityAnnotation {
        String mid;
        String locale;
        String description;
        float score;
        float confidence;
        float topicality;
        BoundingPoly boundingPoly;
        List<LocationInfo> locations;
        List<Property> properties;

        public String getMid() {
            return mid;
        }

        public String getLocale() {
            return locale;
        }

        public String getDescription() {
            return description;
        }

        public float getScore() {
            return score;
        }

        public float getConfidence() {
            return confidence;
        }

        public float getTopicality() {
            return topicality;
        }

        public BoundingPoly getBoundingPoly() {
            return boundingPoly;
        }

        public List<LocationInfo> getLocations() {
            return locations;
        }

        public List<Property> getProperties() {
            return properties;
        }
    }

    public static class SafeSearchAnnotation {
        String adult;
        String spoof;
        String medical;
        String violence;

        public String getAdult() {
            return adult;
        }

        public String getSpoof() {
            return spoof;
        }

        public String getMedical() {
            return medical;
        }

        public String getViolence() {
            return violence;
        }
    }

    public static class BoundingPoly {
        List<Vertex> vertices;

        public List<Vertex> getVertices() {
            return vertices;
        }

        public static class Vertex {
            float x;
            float y;

            public float getX() {
                return x;
            }

            public float getY() {
                return y;
            }
        }
    }

    public static class Landmark {
        String type;
        Position position;

        public String getType() {
            return type;
        }

        public Position getPosition() {
            return position;
        }

        public static class Position {
            float x;
            float y;
            float z;

            public float getX() {
                return x;
            }

            public float getY() {
                return y;
            }

            public float getZ() {
                return z;
            }
        }
    }

    public static class LocationInfo {
        LatLng latLng;

        public LatLng getLatLng() {
            return latLng;
        }

        public static class LatLng {
            double latitude;
            double longitude;

            public double getLatitude() {
                return latitude;
            }

            public double getLongitude() {
                return longitude;
            }
        }
    }

    public static class Property {
        String name;
        String value;

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Error {
        int code;
        String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
