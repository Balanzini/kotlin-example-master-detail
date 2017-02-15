package com.balanza.android.harrypotter.interactor

import org.mockito.ArgumentMatchers.anyList
import android.os.AsyncTask.execute
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


/**
 * Created by balanza on 15/02/17.
 */
class GetCharactersInteractorTestkt {

  @Test
  fun getComicInteractorShouldCallTheCallbackOnSuccess() {

//    val mockedList = mock(List<CharacterBasic>::class) as List<CharacterBasic>
//
//    val mockedComicRepository = mock(ComicRepository::class.java)
//    `when`(mockedComicRepository.fetch(anyInt())).thenReturn(mockedList)
//
//    val mockedCallback = mock(GetComicsInteractor.ComicsInteractorCallback::class.java)
//
//    val getComicsInteractor = GetComicsInteractor(StubMainThreadExecutor(),
//        NoThreadInteractorExecutor(),
//        mockedComicRepository)
//    getComicsInteractor.execute(mockedCallback)
//
//    verify(mockedCallback).onComicsFetch(anyList<Any>())
  }
}
