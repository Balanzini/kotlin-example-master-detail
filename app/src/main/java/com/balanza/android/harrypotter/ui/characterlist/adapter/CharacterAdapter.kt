package com.balanza.android.harrypotter.ui.characterlist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.bumptech.glide.Glide
import java.util.*

/**
 * Created by balanza on 15/02/17.
 */
class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

  internal var characterList = ArrayList<CharacterBasic>()
  internal var context: Context? = null

  override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
    holder.tvName.text = characterList[position].name
    holder.tvHouse.text = characterList[position].house
    Glide.with(context).load(characterList[position].imageUrl).centerCrop().into(holder.ivPicture)

    when (characterList[position].houseId) {
      0 -> holder.rlBackgroundItem.setBackgroundResource(R.drawable.gryffindor_background)
      1 -> holder.rlBackgroundItem.setBackgroundResource(R.drawable.hufflepuff_background)
      2 -> holder.rlBackgroundItem.setBackgroundResource(R.drawable.ravenclaw_background)
      3 -> holder.rlBackgroundItem.setBackgroundResource(R.drawable.slytherin_background)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
    context = parent.context
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

    var tvName = itemView.findViewById(R.id.tv_item_name) as TextView
    var tvHouse = itemView.findViewById(R.id.tv_item_house) as TextView
    var ivPicture = itemView.findViewById(R.id.iv_item_image) as ImageView
    var rlBackgroundItem = itemView.findViewById(R.id.rl_item_background) as RelativeLayout

  }
}