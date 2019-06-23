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

import androidx.appcompat.app.AppCompatActivity
import com.github.jonathanmerritt.motionlayout_multipletransitions.R.id.*
import com.github.jonathanmerritt.motionlayout_multipletransitions.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(activity_main) {
  override fun onBackPressed() = activityMain_motion.run {
    when (currentState) {
      constraint_set_expand,
      constraint_set_collapse,
      constraint_set_drawer,
      constraint_set_sheet -> transitionToState(constraint_set_main)

      constraint_set_drawer_expand,
      constraint_set_sheet_expand -> transitionToState(constraint_set_expand)

      constraint_set_drawer_collapse,
      constraint_set_sheet_collapse -> transitionToState(constraint_set_collapse)

      -1 -> transitionToStart()

      else -> super.onBackPressed()
    }
  }
}
