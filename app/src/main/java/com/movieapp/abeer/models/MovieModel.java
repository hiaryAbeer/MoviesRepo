package com.movieapp.abeer.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovieModel implements Serializable {

//    "id": 703745,
//            "original_language": "en",
//            "original_title": "Deep Blue Sea 3",
//            "overview": "Dr. Emma Collins and her team are spending their third summer on the island of Little Happy studying the effect of climate change on the great white sharks who come to the nearby nursery every year to give birth. Along with the last two inhabitants of this former fishing village, their peaceful life is disrupted when a \"scientific\" team led by her ex-boyfriend and marine biologist Richard show up looking for three bull sharks who we soon learn aren't just any bull sharks.",
//            "poster_path": "/bKthjUmxjHjvJK8FktFfQdmwP12.jpg",
//            "release_date": "2020-07-28",
//            "title": "Deep Blue Sea 3",
//            "video": false,
//            "vote_average": 5.6,
//            "vote_count": 19,
//            "popularity": 25.133,
//            "media_type": "movie"

    @SerializedName("id")
    private long id;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("title")
    private String title;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("media_type")
    private String mediaType;

    public long getId() {
        return id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }
}
