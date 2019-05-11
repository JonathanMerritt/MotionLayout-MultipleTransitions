/*
 *     Copyright 2018 Jonathan Merritt
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.github.jonathanmerritt.motionlayout_multipletransitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.jonathanmerritt.motionlayout_multipletransitions.R.id.*
import com.github.jonathanmerritt.motionlayout_multipletransitions.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(activity_main) {
  override fun onPostCreate(bundle: Bundle?) {
    super.onPostCreate(bundle)
    var isFirst = true

    activityMain_to_first.setOnClickListener {
      activityMain_motion.transitionToState(constraintSet_first)
      isFirst = true
    }

    activityMain_to_second.setOnClickListener {
      activityMain_motion.transitionToState(constraintSet_second)
      isFirst = false
    }

    activityMain_to_drawer.setOnClickListener {
      val drawer = if (isFirst) constraintSet_first_drawer else constraintSet_second_drawer
      activityMain_motion.transitionToState(drawer)
    }

    activityMain_to_sheet.setOnClickListener {
      val sheet = if (isFirst) constraintSet_first_sheet else constraintSet_second_sheet
      activityMain_motion.transitionToState(sheet)
    }
  }

  override fun onBackPressed() {
    when (activityMain_motion.currentState) {
      constraintSet_first_drawer,
      constraintSet_first_sheet,
      constraintSet_second -> activityMain_to_first.callOnClick()

      constraintSet_second_drawer,
      constraintSet_second_sheet -> activityMain_to_second.callOnClick()

      else -> super.onBackPressed()
    }
  }
}
