package com.balanza.android.harrypotter.app.navigator

import android.app.Activity
import android.content.Intent
import com.balanza.android.harrypotter.ui.characterdetail.view.CharacterDetailActivity
import com.balanza.android.harrypotter.ui.characterdetail.view.CharacterDetailView

/**
 * Created by balanza on 13/02/17.
 */
class DefaultNavigator : Navigator {
    override var activity: Activity? = null
        set(value) {
            field = value
        }

    override fun goToDetails(characterId: Int) {
        val intent = Intent(activity, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailView.CHARACTER_ID, characterId)
        activity?.startActivity(intent)
    }

    override fun finish() {
        activity?.finish()
    }

}