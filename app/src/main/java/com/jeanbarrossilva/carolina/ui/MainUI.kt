package com.jeanbarrossilva.carolina.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jeanbarrossilva.carolina.R
import com.jeanbarrossilva.carolina.ui.default.CarolinaTheme

@Composable
@Preview(showSystemUi = true)
fun MainUI() {
    CarolinaTheme.Fill {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                )
            }
        ) {
            TransformationsUI()
        }
    }
}