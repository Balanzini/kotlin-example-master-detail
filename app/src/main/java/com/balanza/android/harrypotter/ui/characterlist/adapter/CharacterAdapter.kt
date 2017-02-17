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
  private var onItemClick: OnItemClick? = null

  override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
    val characterInstance = characterList[position]
    holder.tvName.text = characterInstance.name
    holder.tvHouse.text = characterInstance.house.name
    Glide.with(context).load(characterInstance.imageUrl).centerCrop().into(holder.ivPicture)

    holder.rlBackgroundItem.setBackgroundResource(characterInstance.house.background)

    holder.rlBackgroundItem.setOnClickListener({
        onItemClick?.onClick(position)

    })

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

  fun setOnItemClick(onItemClick: OnItemClick) {
    this.onItemClick = onItemClick
  }

  class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tvName = itemView.findViewById(R.id.tv_item_name) as TextView
    var tvHouse = itemView.findViewById(R.id.tv_item_house) as TextView
    var ivPicture = itemView.findViewById(R.id.iv_item_image) as ImageView
    var rlBackgroundItem = itemView.findViewById(R.id.rl_item_background) as RelativeLayout

  }

  interface OnItemClick {
    fun onClick(position: Int)
  }
}