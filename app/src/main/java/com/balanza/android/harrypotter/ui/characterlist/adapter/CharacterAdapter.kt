package com.balanza.android.harrypotter.ui.characterlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import java.util.*

/**
 * Created by balanza on 15/02/17.
 */
class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

  internal var characterList = ArrayList<CharacterBasic>()

  override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
    holder.tvName.text = characterList[position].name
    holder.tvHouse.text = characterList[position].house
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item,
        parent, false)
    return CharacterHolder(view)
  }

  override fun getItemCount() = characterList.size

  fun setCharacters(charactersList: List<CharacterBasic>) {
    this.characterList.clear()
    this.characterList.addAll(charactersList)
    notifyDataSetChanged()
  }

  class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tvName: TextView
    var tvHouse: TextView

    init {
      tvName = itemView.findViewById(R.id.tv_item_name) as TextView
      tvHouse = itemView.findViewById(R.id.tv_item_house) as TextView
    }
  }
}