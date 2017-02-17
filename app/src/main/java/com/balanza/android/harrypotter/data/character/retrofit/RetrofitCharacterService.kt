package com.balanza.android.harrypotter.data.character.retrofit

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetailApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by balanza on 14/02/17.
 */
interface RetrofitCharacterService {
  @GET(RetrofitConstants.API_ALL_CHARACTER)
  fun getAllCharacter(): Call<List<CharacterBasicRetrofit>>

  @GET(RetrofitConstants.API_GET_CHARACTER + "/{id}")
  fun getCharacter(@Path("id") characterId : Int): Call<CharacterDetailApi>
}