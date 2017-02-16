package com.balanza.android.harrypotter.interactor;

import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharacters;
import com.balanza.android.harrypotter.domain.interactor.character.GetAllCharactersImp;
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic;
import com.balanza.android.harrypotter.domain.repository.character.CharacterRepository;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by balanza on 15/02/17.
 */

public class GetCharactersInteractorTest {

  @Test
  public void getComicInteractorShouldCallTheCallbackOnSuccess() {

    List<CharacterBasic> mockedList = (List<CharacterBasic>) mock(List.class);

    CharacterRepository.OnCharacterAvailable mockedRepositoryCallback =
        mock(CharacterRepository.OnCharacterAvailable.class);

    CharacterRepository mockedCharacterRepository = mock(CharacterRepository.class);
    mockedCharacterRepository.getAllCharacters(mockedRepositoryCallback);


    verify(mockedRepositoryCallback).onSuccess(ArgumentMatchers.<CharacterBasic>anyList());

    GetAllCharacters.OnCharactersAvailable mockedCallback =
        mock(GetAllCharacters.OnCharactersAvailable.class);

    GetAllCharacters getCharacterInteractor = new GetAllCharactersImp(mockedCharacterRepository);
    getCharacterInteractor.getAllCharacters(false, mockedCallback);

    verify(mockedCallback).onSuccess(ArgumentMatchers.<CharacterBasic>anyList());
  }
}
