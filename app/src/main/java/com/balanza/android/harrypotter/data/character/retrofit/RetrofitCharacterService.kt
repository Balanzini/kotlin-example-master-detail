package com.balanza.android.harrypotter.data.character.retrofit

import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by balanza on 14/02/17.
 */
interface RetrofitCharacterService {
  @GET(RetrofitConstants.API_ALL_CHARACTER)
  fun getAllCharacter(): Call<List<CharacterBasicRetrofit>>

}