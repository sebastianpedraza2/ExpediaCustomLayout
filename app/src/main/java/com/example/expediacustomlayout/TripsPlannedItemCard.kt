package com.example.expediacustomlayout

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp

@Composable
fun PlannedItemCardLayout(
    image: @Composable () -> Unit,
    menu: @Composable () -> Unit,
    content: @Composable () -> Unit,
    price: @Composable () -> Unit,
    votesAndComments: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Layout(
        contents = listOf(image, menu, price, content, votesAndComments),
        modifier = modifier.padding(all = 25.dp)
    ) {
            (imageMeasurables, menuMeasurables, priceMeasurables, contentMeasurables, votesAndCommentsMeasurables),
            constraints,
        ->
        require(
            imageMeasurables.size == 1 && priceMeasurables.size == 1 && contentMeasurables.size == 1 && votesAndCommentsMeasurables.size == 1
        ) {
            "should only emit one composable"
        }

        // Fixed measurements
        val imagePlaceable = imageMeasurables.first().measure(constraints)
        val menuPlaceable = menuMeasurables.first().measure(constraints)
        val votesPlaceable = votesAndCommentsMeasurables.first().measure(constraints)

        // Dependent measurements
        val priceWidth = constraints.maxWidth - imagePlaceable.width - votesPlaceable.width
        val pricePlaceable = priceMeasurables.first().measure(
            constraints.copy(
                maxWidth = priceWidth,
                minWidth = 0
            )
        )
        val contentWidth = constraints.maxWidth - imagePlaceable.width - menuPlaceable.width
        val contentPlaceable = contentMeasurables.first().measure(
            constraints.copy(
                minWidth = contentWidth,
                maxWidth = contentWidth
            )
        )

        val totalWidth = imagePlaceable.width + contentPlaceable.width + menuPlaceable.width

        layout(width = constraints.maxWidth, height = constraints.maxHeight) {
            var xPosition = 0
            var yPosition = 0
            imagePlaceable.place(xPosition, yPosition)

            menuPlaceable.place(constraints.maxWidth - menuPlaceable.width, yPosition)
            pricePlaceable.place(
                constraints.maxWidth - pricePlaceable.width,
                constraints.maxHeight - pricePlaceable.height
            )
            contentPlaceable.place(xPosition + imagePlaceable.width, yPosition)
            votesPlaceable.place(
                xPosition + imagePlaceable.width,
                constraints.maxHeight - votesPlaceable.height
            )

        }


    }

}


