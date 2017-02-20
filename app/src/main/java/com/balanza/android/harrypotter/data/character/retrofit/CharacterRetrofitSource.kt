package com.balanza.android.harrypotter.data.character.retrofit

import com.balanza.android.harrypotter.data.character.CharacterDataSource
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetail
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterDetailApi
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
    val call = characterService.getAllCharacter()

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

  override fun getCharacter(characterId: Int, onSuccess: (CharacterDetail) -> Unit,
                            onError: (String?) -> Unit) {
    val call = characterService.getCharacter(characterId)

    call.enqueue(object : Callback<CharacterDetailApi> {
      override fun onResponse(call: Call<CharacterDetailApi>?,
                              response: Response<CharacterDetailApi>) {
        if (response.isSuccessful) {
          onSuccess(characterMapper.characterApiToCharacterModel(response.body()))
        }
        else{
          onError(response.errorBody().string())
        }
      }

      override fun onFailure(call: Call<CharacterDetailApi>?, t: Throwable?) {
        onError(t?.message)
      }

    })
  }
}
