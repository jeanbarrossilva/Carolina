package com.jeanbarrossilva.carolina.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.AmbientClipboardManager
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeanbarrossilva.carolina.data.TransformationGroup
import com.jeanbarrossilva.carolina.ui.component.TransformationVisualizer
import com.jeanbarrossilva.carolina.ui.constants.TransformationVisualizerConstants
import com.jeanbarrossilva.carolina.ui.default.CarolinaTheme

@Composable
@Preview
fun TransformationsUI() {
    val context = AmbientContext.current
    val clipboardManager = AmbientClipboardManager.current
    var originalText by remember { mutableStateOf("Hello, world!") }
    val inputFieldPadding = 20.dp

    CarolinaTheme.Fill {
        ConstraintLayout(
            ConstraintSet {
                constrain(createRefFor("input")) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            }
        ) {
            LazyColumn(
                Modifier
                    .padding(bottom = inputFieldPadding + 65.dp)
            ) {
                items(TransformationGroup.values) { group ->
                    if (group.hasTitle)
                        Text(
                            group.title,
                            Modifier
                                .padding(vertical = 30.dp)
                                .padding(top = 10.dp)
                                .padding(start = TransformationVisualizerConstants.verticalPadding),
                            fontWeight = FontWeight.ExtraBold
                        )

                    Column {
                        group.getFormats().forEach { format ->
                            TransformationVisualizer(
                                format,
                                originalText,
                                onClick = {
                                    clipboardManager.setText(AnnotatedString(it))
                                    Toast.makeText(context, "Copied!", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
            }

            OutlinedTextField(
                originalText,
                onValueChange = { originalText = it },
                Modifier
                    .layoutId("input")
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background, RoundedCornerShape(15.dp))
                    .padding(horizontal = inputFieldPadding)
                    .padding(bottom = inputFieldPadding),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                onImeActionPerformed = { _, keyboardController ->
                    keyboardController?.hideSoftwareKeyboard()
                }
            )
        }
    }
}