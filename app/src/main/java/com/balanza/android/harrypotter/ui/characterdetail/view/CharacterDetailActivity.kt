package com.balanza.android.harrypotter.ui.characterdetail.view

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.os.Bundle
import com.balanza.android.harrypotter.R
import com.balanza.android.harrypotter.app.base.BaseActivity
import com.balanza.android.harrypotter.app.base.BaseApp
import com.balanza.android.harrypotter.app.di.component.DaggerActivityComponent
import com.balanza.android.harrypotter.ui.characterdetail.presenter.CharacterDetailPresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.character_details_layout.*
import javax.inject.Inject
import android.util.Log
import android.view.View
import android.view.DragEvent
import android.widget.ImageView
import org.jetbrains.anko.toast


/**
 * Created by balanza on 17/02/17.
 */
class CharacterDetailActivity : BaseActivity(), CharacterDetailView {

  @Inject lateinit var presenter: CharacterDetailPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.character_details_layout)

    presenter.view = this
    presenter.getCharacter()
    setImageDrag()
  }

  override fun onCharacterAvailable(name: String, lastName: String, birth: String, gender: String,
                                    house: String, wandDescription: String, patronus: String,
                                    urlImage: String, background: Int, primary: Int) {
    tv_detail_name.text = "$name $lastName"
    tv_detail_birth.text = birth
    tv_detail_gender.text = gender
    tv_detail_house.text = house
    tv_detail_wand_desc.text = wandDescription
    tv_detail_patronus.text = patronus
    Glide.with(this).load(urlImage).centerCrop().into(iv_detail_image_profile)
    Glide.with(this).load(background).centerCrop().into(iv_details_background)

    if (Build.VERSION.SDK_INT >= 21) {
      window.statusBarColor = resources.getColor(primary)
    }

    iv_detail_image_profile.setOnDragListener(myDragEventListener())
  }

  override fun doInjection() {
    val activityComponent = DaggerActivityComponent.builder()
        .applicationComponent(BaseApp.applicationComponent)
        .build()
    activityComponent.inject(this)
  }

  private fun setImageDrag() {

    ivAlbus.setOnDragListener { view, dragEvent ->
      val action = dragEvent.action

      // Handles each of the expected events
      when (action) {
        DragEvent.ACTION_DRAG_STARTED -> {
          view.visibility = View.INVISIBLE
          true
        }
        DragEvent.ACTION_DRAG_ENDED -> {
          view.visibility = View.VISIBLE
          true
        }
        else -> false
      }
    }

    // Sets the tag
    ivAlbus.tag = "icon bitmap"

    ivAlbus.setOnLongClickListener {

      val item = ClipData.Item(it.tag.toString())

      val dragData = ClipData(it.tag.toString(), arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
          item)

      val myShadow = View.DragShadowBuilder(ivAlbus)

      it.startDrag(dragData, myShadow, null, 0)
    }
  }

  private inner class myDragEventListener : View.OnDragListener {

    override fun onDrag(v: View, event: DragEvent): Boolean {

      val action = event.action

      when (action) {

        DragEvent.ACTION_DRAG_STARTED -> {

          if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

            if (v is ImageView) {
              v.clearColorFilter()
            }
            v.invalidate()

            return true
          }

          // Returns false. During the current drag and drop operation, this View will
          // not receive events again until ACTION_DRAG_ENDED is sent.
          return false
        }

        DragEvent.ACTION_DRAG_ENTERED -> {
          if (v is ImageView) {
            v.setColorFilter(resources.getColor(R.color.detail_shadow))
          }
          v.invalidate()

          return true
        }

        DragEvent.ACTION_DRAG_EXITED -> {
          if (v is ImageView) {
            v.clearColorFilter()
          }
          v.invalidate()
          return true
        }

        DragEvent.ACTION_DROP -> {
          presenter.assignmentOfPoints { points, house ->
            toast("$points points to $house!")
          }
          if (v is ImageView) {
            v.clearColorFilter()
          }
          v.invalidate()

          // Returns true. DragEvent.getResult() will return true.
          return true
        }

        DragEvent.ACTION_DRAG_ENDED -> {
          if (v is ImageView) {
            v.clearColorFilter()
          }
          v.invalidate()

          if (!event.result) {
            toast(resources.getString(R.string.drag_albus))
          }
          return true
        }
      }
      return false
    }
  }
}