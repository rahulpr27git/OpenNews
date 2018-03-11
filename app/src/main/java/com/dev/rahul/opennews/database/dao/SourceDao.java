package com.dev.rahul.opennews.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dev.rahul.opennews.pojo.Sources;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by rahul on 11/3/18.
 */

@Dao
public interface SourceDao {

    @Insert
    int insert(Sources... sources);

    @Insert
    int insert(List<Sources> list);

    @Query("SELECT * FROM sources")
    Single<List<Sources>> getAllSources();

    @Query(
            "SELECT * FROM sources " +
            "where country = :country " +
            "OR language = :language " +
            "OR category = :category"
    )
    Single<List<Sources>> getSourcesByCountryOrLanguageOrCategory(String country, String language, String category);

    @Query(
            "SELECT * FROM sources " +
            "where country = :country " +
            "AND language = :language " +
            "AND category = :category"
    )
    Single<List<Sources>> getSourcesByCountryAndLanguageAndCategory(String country, String language, String category);
}
