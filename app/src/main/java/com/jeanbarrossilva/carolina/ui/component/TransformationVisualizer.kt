package com.jeanbarrossilva.carolina.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.carolina.data.textformat.StandardTransformation
import com.jeanbarrossilva.carolina.data.textformat.Transformation
import com.jeanbarrossilva.carolina.ui.constants.TransformationVisualizerConstants
import com.jeanbarrossilva.carolina.ui.default.CarolinaTheme

@Composable
@Preview
fun TransformationVisualizer(
    format: Transformation = StandardTransformation.NORMAL,
    originalText: String = "",
    onClick: (String) -> Unit = { }
) {
    val convertedText = format.convert(originalText)

    CarolinaTheme.Wrap {
        Card(
            Modifier
                .fillMaxWidth()
                .clickable { onClick(convertedText) },
            shape = RectangleShape
        ) {
            Column(
                Modifier
                    .padding(vertical = TransformationVisualizerConstants.verticalPadding, horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    format.title,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )

                Text(convertedText)
            }
        }
    }
}