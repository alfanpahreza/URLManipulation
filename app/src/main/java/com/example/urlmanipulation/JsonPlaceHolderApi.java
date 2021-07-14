package com.example.urlmanipulation;

import org.w3c.dom.Comment;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

//API untuk interface method pengambilan data dari URL
public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId, //menggunakan beberapa userId dalam primitif Integer sehingga bisa null
            @Query("_sort") String sort,
            @Query("_order") String order
    );
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
    @GET
    Call<List<com.example.urlmanipulation.Comment>> getComments(@Url String url);
}
