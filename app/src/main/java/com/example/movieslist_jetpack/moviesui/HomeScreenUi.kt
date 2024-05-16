package com.example.movieslist_jetpack.moviesui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.movieslist_jetpack.MoviesData


@Composable
fun moviesItem(moviesData: MoviesData) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),

        shape = RoundedCornerShape(8.dp)
    )
    {
        Surface() {
            Row(
                modifier =
                Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(data = moviesData.imageUrl,
                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())
                        }), contentDescription = moviesData.desc,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = moviesData.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = moviesData.category,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )

                    Text(
                        text = moviesData.desc,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

            }
        }
    }
}