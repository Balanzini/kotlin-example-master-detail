package com.balanza.android.harrypotter.mapper;

import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapper;
import com.balanza.android.harrypotter.data.character.retrofit.mapper.CharacterMapperImp;
import com.balanza.android.harrypotter.data.character.retrofit.model.CharacterBasicRetrofit;
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by balanza on 15/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterMapperTest {

  @Mock CharacterBasicRetrofit character;
  @Mock CharacterBasicRetrofit character1;
  @Mock CharacterBasicRetrofit character2;
  private List<CharacterBasicRetrofit> characterApiList;
  private CharacterMapper mapper;


  @Before
  public void setup(){
    when(character.getName()).thenReturn("character");
    when(character.getCharacterId()).thenReturn(0);
    when(character.getHouse()).thenReturn("house");
    when(character.getHouseId()).thenReturn(0);
    when(character.getImageUrl()).thenReturn("imageUrl");

    when(character1.getName()).thenReturn("character1");
    when(character1.getCharacterId()).thenReturn(0);
    when(character1.getHouse()).thenReturn("house");
    when(character1.getHouseId()).thenReturn(0);
    when(character1.getImageUrl()).thenReturn("imageUrl");

    when(character2.getName()).thenReturn("character2");
    when(character2.getCharacterId()).thenReturn(0);
    when(character2.getHouse()).thenReturn("house");
    when(character2.getHouseId()).thenReturn(0);
    when(character2.getImageUrl()).thenReturn("imageUrl");

    characterApiList = new ArrayList<>();
    characterApiList.add(character);
    characterApiList.add(character1);
    characterApiList.add(character2);
    mapper = new CharacterMapperImp();
  }

  @Test
  public void characterMapperTest(){
    List<CharacterBasic> characterBasics =  mapper.charactersApiToCharactersModel(characterApiList);

    assertTrue(characterBasics.get(0).getName() == characterApiList.get(0).getName());
    assertTrue(characterBasics.get(1).getName() == characterApiList.get(1).getName());
  }
}
