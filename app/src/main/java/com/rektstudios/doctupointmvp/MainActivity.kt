package com.rektstudios.doctupointmvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rektstudios.doctupointmvp.ui.theme.DoctupointMVPTheme
import com.rektstudios.doctupointmvp.views.navigation.NavigationComposable

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DoctupointMVPTheme {
				// A surface container using the 'background' color from the theme
				NavigationComposable()
			}
		}
	}
}
