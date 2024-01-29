package com.free.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.free.newsapp.ui.theme.BlueGray

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {

//    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
//        repeat(pageSize) { page ->
//            Box(
//                modifier = modifier.size(IndicatorSize).clip( CircleShape)
//                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
//            ) {
//
//            }
//        }
//    }

    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(5.dp)
    ) {

        items(pageSize) { index ->
            if (index == selectedPage) {  //highlight the dots if current index
                // is selected
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                        .padding(horizontal = 5.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(unselectedColor)
                        .padding(horizontal = 5.dp)
                )
            }

            if (index != pageSize - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}