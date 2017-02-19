package com.balanza.android.harrypotter.ui.characterlist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.domain.model.character.CharacterBasic
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_list_item.view.*
import java.util.*

/**
 * Created by balanza on 15/02/17.
 */
class CharacterAdapter(
    val listener: (CharacterBasic) -> Unit) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

  private var characterList = ArrayList<CharacterBasic>()
  private var context: Context? = null
  private var positionSelected: Int = -1
  private var clicked: Boolean = false

  override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
    val characterInstance = characterList[position]
    holder.bind(characterInstance, clicked, positionSelected, position) {
      clicked = true
      positionSelected = position
      listener(it)
      notifyDataSetChanged()
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

  fun reset() {
    clicked = false
    notifyDataSetChanged()
  }

  class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun ImageView.loadUrl(url: String) {
      Glide.with(context).load(url).centerCrop().into(iv_item_image)
    }

    fun bind(item: CharacterBasic, clicked: Boolean, positionSelected: Int, position: Int,
             listener: (CharacterBasic) -> Unit) = with(itemView) {

      tv_item_name.text = item.name
      tv_item_house.text = item.house.name
      iv_item_image.loadUrl(item.imageUrl)

      rl_item_background.setBackgroundResource(item.house.background)

      if (clicked) {
        v_shadow.visibility = View.VISIBLE
        val color: Int
        if (positionSelected === position) {
          color = context?.resources?.getColor(R.color.item_selected_shadow) ?: -1
        } else {
          color = context?.resources?.getColor(R.color.item_shadow) ?: -1

        }
        v_shadow.setBackgroundColor(color)
      } else {
        v_shadow.visibility = View.GONE
      }

      setOnClickListener { listener(item) }
    }

  }
}