package com.movieapp.abeer.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetailsModel {

    @SerializedName("original_title")
    private String name;

    @SerializedName("poster_path")
    private String movieImage;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("overview")
    private String overview;

    @SerializedName("vote_average")
    private double vote_average;

    @SerializedName("genres")
    private List<GenresModel> genresModelList;

    public String getName() {
        return name;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getOverview() {
        return overview;
    }

    public double getVote_average() {
        return vote_average;
    }

    public List<GenresModel> getGenresModelList() {
        return genresModelList;
    }

    //
//    {
//        "adult": false,
//            "backdrop_path": "/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
//            "belongs_to_collection": null,
//            "budget": 50300000,
//            "genres": [
//        {
//            "id": 10752,
//                "name": "War"
//        },
//        {
//            "id": 28,
//                "name": "Action"
//        },
//        {
//            "id": 18,
//                "name": "Drama"
//        }
//    ],
//        "homepage": "https://tv.apple.com/movie/greyhound/umc.cmc.o5z5ztufuu3uv8lx7m0jcega",
//            "id": 516486,
//            "imdb_id": "tt6048922",
//            "original_language": "en",
//            "original_title": "Greyhound",
//            "overview": "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
//            "popularity": 148.716,
//            "poster_path": "/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
//            "production_companies": [
//        {
//            "id": 4171,
//                "logo_path": "/ip8rzankhLLhJGGkvfCirfUM26d.png",
//                "name": "Playtone",
//                "origin_country": "US"
//        },
//        {
//            "id": 13240,
//                "logo_path": "/aTc07YaNHo8WNgkQSnvLmG6w4nW.png",
//                "name": "Bron Studios",
//                "origin_country": "CA"
//        },
//        {
//            "id": 7493,
//                "logo_path": "/452FO4LcI6lA6bfgl6w1kQYRBlr.png",
//                "name": "FilmNation Entertainment",
//                "origin_country": "US"
//        },
//        {
//            "id": 14319,
//                "logo_path": "/z5jJhK1AMbr47CLVqsB4HpIBtHd.png",
//                "name": "Sycamore Pictures",
//                "origin_country": "US"
//        },
//        {
//            "id": 5,
//                "logo_path": "/71BqEFAF4V3qjjMPCpLuyJFB9A.png",
//                "name": "Columbia Pictures",
//                "origin_country": "US"
//        },
//        {
//            "id": 34,
//                "logo_path": "/GagSvqWlyPdkFHMfQ3pNq6ix9P.png",
//                "name": "Sony Pictures",
//                "origin_country": "US"
//        },
//        {
//            "id": 14801,
//                "logo_path": "/bnlD5KJ5oSzBYbEpDkwi6w8SoBO.png",
//                "name": "Apple Inc.",
//                "origin_country": "US"
//        }
//    ],
//        "production_countries": [
//        {
//            "iso_3166_1": "US",
//                "name": "United States of America"
//        }
//    ],
//        "release_date": "2020-07-10",
//            "revenue": 0,
//            "runtime": 91,
//            "spoken_languages": [
//        {
//            "iso_639_1": "en",
//                "name": "English"
//        }
//    ],
//        "status": "Released",
//            "tagline": "The only thing more dangerous than the front lines was the fight to get there.",
//            "title": "Greyhound",
//            "video": false,
//            "vote_average": 7.6,
//            "vote_count": 730
//    }
}
