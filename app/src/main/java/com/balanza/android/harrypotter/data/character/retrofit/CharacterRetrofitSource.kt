package com.balanza.android.harrypotter.data.character.retrofit

import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import retrofit2.*

/**
 * Created by balanza on 14/02/17.
 */
class CharacterRetrofitSource(val characterMapper: CharacterMapper) : CharacterDataSource {

  private val characterService: RetrofitCharacterService

  init {
    val retrofit = Retrofit.Builder()
        .baseUrl(RetrofitConstants.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    characterService = retrofit.create(RetrofitCharacterService::class.java)
  }

  override fun getAllCharacter(onCharacterAvailable: CharacterDataSource.OnCharacterAvailable) {
    var call = characterService.getAllCharacter()

    call.enqueue(object : Callback<List<CharacterBasicRetrofit>> {
      override fun onResponse(call: Call<List<CharacterBasicRetrofit>>,
                              response: Response<List<CharacterBasicRetrofit>>) {

        if (response.isSuccessful) {
          onCharacterAvailable.onCharacterAvailable(
              characterMapper.charactersApiToCharactersModel(response.body()))
        } else {
          onCharacterAvailable.onError(response.errorBody().string())
        }


      }

      override fun onFailure(call: Call<List<CharacterBasicRetrofit>>?, t: Throwable?) {
        onCharacterAvailable.onError(t?.message)
      }
    })
  }
}
